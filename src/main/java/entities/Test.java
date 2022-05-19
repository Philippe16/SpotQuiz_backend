package entities;

import com.google.gson.*;
import com.nimbusds.jose.shaded.json.JSONObject;
import facades.SpotifyFacade;
import java.io.IOException;

public class Test {

    public static void main(String[] args) {
        final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

        SpotifyFacade spotifyFacade = SpotifyFacade.getSpotifyFacade();

        try{
            String token = spotifyFacade.getBearerToken();

            System.out.println(token);
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }

    }
}


