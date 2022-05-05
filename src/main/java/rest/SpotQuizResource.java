package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.NewQuizDTO;
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
      System.out.println("Inside get");
      return "Hello, World!";
   }

   @POST
   @Path("/createQuiz")
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_JSON)
   public Response createQuiz(String jsonContext) {
      System.out.println(jsonContext);

      NewQuizDTO newQuizDTO = GSON.fromJson(jsonContext, NewQuizDTO.class);
      quizFacade.createQuiz(newQuizDTO);

      return Response
             .ok("SUCCESS")
             .entity("All good")
             .build();
   }
}