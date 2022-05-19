package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nimbusds.jose.shaded.json.JSONObject;
import dtos.MusicDTO;
import dtos.NewQuestionDTO;
import dtos.NewQuizDTO;
import entities.Music;
import entities.Role;
import entities.User;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.*;
import utils.EMF_Creator;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import io.restassured.parsing.Parser;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

// Si, den har brug for at blive pushet og commitet :D
// 
@Disabled
class SpotQuizResourceTest {

    private static final int SERVER_PORT = 7777;
    private static final String SERVER_URL = "http://localhost/api";

    static final URI BASE_URI = UriBuilder.fromUri(SERVER_URL).port(SERVER_PORT).build();
    private static HttpServer httpServer;
    private static EntityManagerFactory emf;

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private static User user;
    private static Role userRole;

    static HttpServer startServer() {
        ResourceConfig rc = ResourceConfig.forApplication(new ApplicationConfig());
        return GrizzlyHttpServerFactory.createHttpServer(BASE_URI, rc);
    }

    private void resetDB(EntityManager em) {
        em.getTransaction().begin();
        user = em.find(User.class, 1);

        user.setCreatedQuizzes(new ArrayList<>());
        em.merge(user);

        em.createQuery("DELETE FROM Question").executeUpdate();
        em.createQuery("DELETE FROM Music").executeUpdate();
        em.createQuery("DELETE FROM Quiz").executeUpdate();
        em.createQuery("DELETE FROM User").executeUpdate();
        em.createQuery("DELETE FROM Role").executeUpdate();

        em.createNativeQuery("ALTER TABLE roles AUTO_INCREMENT = 1").executeUpdate();
        em.createNativeQuery("ALTER TABLE users AUTO_INCREMENT = 1").executeUpdate();
        em.createNativeQuery("ALTER TABLE quizzes AUTO_INCREMENT = 1").executeUpdate();
        em.createNativeQuery("ALTER TABLE questions AUTO_INCREMENT = 1").executeUpdate();

        em.getTransaction().commit();
    }

    @BeforeAll
    public static void setUpClass() {
        //This method must be called before you request the EntityManagerFactory
        EMF_Creator.startREST_TestWithDB();
        emf = EMF_Creator.createEntityManagerFactoryForTest();

        httpServer = startServer();
        //Setup RestAssured
        RestAssured.baseURI = SERVER_URL;
        RestAssured.port = SERVER_PORT;
        RestAssured.defaultParser = Parser.JSON;
    }

    @AfterAll
    public static void closeTestServer() {
        //System.in.read();

        //Don't forget this, if you called its counterpart in @BeforeAll
        EMF_Creator.endREST_TestWithDB();
        httpServer.shutdownNow();
    }

    @BeforeEach
    void setUp() {
        EntityManager em = emf.createEntityManager();

        try {
            userRole = new Role("user");
            user = new User("User123", "user@gmail.com", "123", userRole);

            em.getTransaction().begin();
            em.persist(userRole);
            em.persist(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    void tearDown() {
        EntityManager em = emf.createEntityManager();

        try {
            resetDB(em);
        } finally {
            em.close();
        }
    }

    @Test
    public void testServerIsUp() {
        given().when().get("/SpotQuiz").then().statusCode(200);
    }

    @Test
    public void testLogin() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("email", "user@gmail.com");
        requestParams.put("password", "123");

        ValidatableResponse securityToken = given()
                .contentType("application/json")
                .body(requestParams)
                .when().post("/login")
                .then()
                .body("token", notNullValue());

        System.out.println("TOKEN ---> " + securityToken);
    }

    @Test
    public void testWrongLogin() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("email", "user@mail.com");
        requestParams.put("password", "1234");

        ValidatableResponse securityToken = given()
                .contentType("application/json")
                .body(requestParams)
                .when().post("/login")
                .then()
                .body("token", nullValue());

        System.out.println("TOKEN ---> " + securityToken);
    }

    @Test
    public void testCreateQuiz() {
        EntityManager em = emf.createEntityManager();

        List<NewQuestionDTO> questionDTOList = new ArrayList<>();
        NewQuizDTO quizDTO = new NewQuizDTO(user.getUserID(), "TestQuizTitle", questionDTOList);
        Music music = new Music("1", "TestTitle", "TestArtist", "TestCoverImg", "TestSnippet");
        MusicDTO musicDTO = new MusicDTO(music);
        NewQuestionDTO question1 = new NewQuestionDTO("TestQuestion", "Answer1", "Answer2", "Answer3", "CorrectAnswer", musicDTO);
        NewQuestionDTO question2 = new NewQuestionDTO("TestQuestion", "Answer1", "Answer2", "Answer3", "CorrectAnswer", musicDTO);
        NewQuestionDTO question3 = new NewQuestionDTO("TestQuestion", "Answer1", "Answer2", "Answer3", "CorrectAnswer", musicDTO);

        questionDTOList.add(question1);
        questionDTOList.add(question2);
        questionDTOList.add(question3);

        ValidatableResponse resp = given()
                .contentType("application/json")
                .body(GSON.toJson(quizDTO))
                .when().post("/SpotQuiz/createQuiz")
                .then()
                .statusCode(200);

    }

    @Test
    public void testCreateQuizFail() {
        List<NewQuestionDTO> questionDTOList = new ArrayList<>();
        NewQuizDTO quizDTO = new NewQuizDTO(2, "TestQuizTitle", questionDTOList);
        Music music = new Music("1", "TestTitle", "TestArtist", "TestCoverImg", "TestSnippet");
        MusicDTO musicDTO = new MusicDTO(music);
        NewQuestionDTO question1 = new NewQuestionDTO("TestQuestion", "Answer1", "Answer2", "Answer3", "CorrectAnswer", musicDTO);
        NewQuestionDTO question2 = new NewQuestionDTO("TestQuestion", "Answer1", "Answer2", "Answer3", "CorrectAnswer", musicDTO);
        NewQuestionDTO question3 = new NewQuestionDTO("TestQuestion", "Answer1", "Answer2", "Answer3", "CorrectAnswer", musicDTO);

        questionDTOList.add(question1);
        questionDTOList.add(question2);
        questionDTOList.add(question3);

        ValidatableResponse resp = given()
        .contentType("application/json")
        .body(GSON.toJson(quizDTO))
        .when().post("/SpotQuiz/createQuiz")
        .then()
        .statusCode(500);
    }

}
