package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.NewQuizDTO;
import dtos.NewUserDTO;
import dtos.UserDTO;
import facades.QuizFacade;
import facades.UserFacade;
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
   private static final UserFacade userFacade = UserFacade.getUserFacade(EMF);

   @GET // Todo delete later
   @Produces("text/plain")
   public String hello() {
      return "Hello, World!";
   }

   @POST
   @Path("createAccount")
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_JSON)
   public Response createAccount(String jsonContext) {

      NewUserDTO newUserDTO = GSON.fromJson(jsonContext, NewUserDTO.class);
      UserDTO userDTO = userFacade.createAccount(newUserDTO);

      if (userDTO == null) {
         return Response
                 .status(409)
                 .entity(GSON.toJson(new Exception("Email is already registered")))
                 .build();
      }

      return Response
              .ok("SUCCESS")
              .entity(GSON.toJson(userDTO))
              .build();
   }

   @POST
   @Path("/createQuiz")
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_JSON)
   public Response createQuiz(String jsonContext) {

      NewQuizDTO newQuizDTO = GSON.fromJson(jsonContext, NewQuizDTO.class);

      if (!quizFacade.createQuiz(newQuizDTO)) {
         return Response
        .status(500)
        .entity("{\"msg\": \"The quiz was not created\"}")
        .build();
      }

      return Response
        .ok("SUCCESS")
        .entity("{\"msg\": \"All good\"}")
        .build();
   }

}
