package facades;

import dtos.MusicDTO;
import dtos.NewQuestionDTO;
import dtos.NewQuizDTO;
import entities.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@Disabled
class QuizFacadeTest {
    private static EntityManagerFactory emf = EMF_Creator.createEntityManagerFactoryForTest();
    private static QuizFacade quizFacade = QuizFacade.getQuizFacade(emf);

    Role userRole;
    User user;

    private void resetDB(EntityManager em){
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

    @BeforeEach
    void setUp() {
        EntityManager em = emf.createEntityManager();

        try{
            userRole = new Role("user");
            user = new User("User123", "user@gmail.com", "123", userRole);

            em.getTransaction().begin();
            em.persist(userRole);
            em.persist(user);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
    }

    @AfterEach
    void tearDown() {
        EntityManager em = emf.createEntityManager();

        try{
            resetDB(em);
        }finally{
            em.close();
        }
    }

    @Test
    public void createQuizTest(){
        EntityManager em = emf.createEntityManager();

        try{
            TypedQuery<User> query = em.createQuery("SELECT user FROM User AS user WHERE user.email = :email", User.class);
            query.setParameter("email", "user@gmail.com");
            User userFromDB = query.getSingleResult();

            List<NewQuestionDTO> questionDTOList = new ArrayList<>();
            NewQuizDTO quizDTO = new NewQuizDTO(userFromDB.getUserID(),"TestQuizTitle", questionDTOList);
            Music music = new Music("1","TestTitle", "TestArtist", "TestCoverImg", "TestSnippet");
            MusicDTO musicDTO = new MusicDTO(music);
            NewQuestionDTO question1 = new NewQuestionDTO("TestQuestion", "Answer1", "Answer2", "Answer3", "CorrectAnswer", musicDTO);
            NewQuestionDTO question2 = new NewQuestionDTO("TestQuestion", "Answer1", "Answer2", "Answer3", "CorrectAnswer", musicDTO);
            NewQuestionDTO question3 = new NewQuestionDTO("TestQuestion", "Answer1", "Answer2", "Answer3", "CorrectAnswer", musicDTO);

            questionDTOList.add(question1);
            questionDTOList.add(question2);
            questionDTOList.add(question3);

            quizFacade.createQuiz(quizDTO);

            TypedQuery<Quiz> query2 = em.createQuery(
                   "SELECT quiz FROM Quiz AS quiz", Quiz.class
            );

            List<Quiz> quizzes = query2.getResultList();
            assertEquals(1, quizzes.size());
        }finally {
            em.close();
        }
    }

}
