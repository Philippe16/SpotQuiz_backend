package rest;

import javax.ws.rs.*;

@Path("/SpotQuiz")
public class SpotQuizResource {
   @GET
   @Produces("text/plain")
   public String hello() {
      return "Hello, World!";
   }
}