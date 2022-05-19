package facades;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import entities.SpotifyConnector;
import org.apache.commons.codec.binary.Base64;


public class SpotifyFacade {

    public String getBearerToken(){
        String userInfo = "Basic " + SpotifyConnector.getClientID() + ":" + SpotifyConnector.getClientSecret();
        byte[] userInfoEncoded = Base64.encodeBase64(userInfo.getBytes());

        String jsonStr = "";

        try {
            URL url = new URL("https://accounts.spotify.com/api/token");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setRequestProperty("Authorization", new String(userInfoEncoded));

            con.setDoOutput(true);

            // Set request body
            try(OutputStream os = con.getOutputStream()) {
                byte[] input = "grant_type=client_credentials".getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            try (Scanner scan = new Scanner(con.getInputStream())) {
                while (scan.hasNext()) {
                    jsonStr += scan.nextLine();
                }
            }
        } catch (IOException ioex) {
            System.out.println("Error: " + ioex.getMessage());
        }
        return jsonStr;
    }

}
