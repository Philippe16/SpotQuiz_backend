package entities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.*;
import facades.QuizFacade;
import facades.SpotifyFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.IOException;
import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        SpotifyFacade spotifyFacade = new SpotifyFacade();

        try{
            System.out.println(spotifyFacade.getBearerToken());
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }

    }
}


