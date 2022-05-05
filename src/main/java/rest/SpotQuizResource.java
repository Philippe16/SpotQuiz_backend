package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facades.QuizFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/SpotQuiz")
public class SpotQuizResource {
   private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
   private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

   // Facades
   private static final QuizFacade quizFacade = QuizFacade.getQuizFacade(EMF);

   @GET
   @Produces("text/plain")
   public String hello() {
      return "Hello, World!";
   }

   @POST
   @Path("/createQuiz")
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_JSON)
   public Response createQuiz(String jsonContext) {
      EntityManager em = EMF.createEntityManager();

      // todo: Before uncommenting, create the User_NewQuizDTO. The class should contain a User and a Quiz property.
      // todo: From there extract a UserDTO and QuizDTO and call createQuiz from the facade
//      User_NewQuizDTO user_newQuizDTO = GSON.fromJson(jsonContext, User_NewQuizDTO.class);

      return Response
             .ok("SUCCESS")
             .build();
   }
}