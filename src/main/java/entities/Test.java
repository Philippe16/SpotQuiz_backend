package entities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.*;
import facades.QuizFacade;
import facades.SpotifyFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        SpotifyFacade spotifyFacade = new SpotifyFacade();

        System.out.println(spotifyFacade.getBearerToken());
        // Oooki, jamen så lad os teste og se hvor slemt det står til xD

    }
}


