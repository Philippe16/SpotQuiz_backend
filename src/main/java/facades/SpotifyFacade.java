package facades;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import entities.SpotifyConnector;
import org.apache.commons.codec.binary.Base64;


public class SpotifyFacade {

    public String getBearerToken() throws IOException {
        URL url = new URL("https://accounts.spotify.com/api/token");
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod("POST");
        http.setDoOutput(true);
        http.setRequestProperty("content-type", "application/x-www-form-urlencoded");

        String data = "grant_type=client_credentials&client_id=" + SpotifyConnector.getClientID() + "&client_secret=" + SpotifyConnector.getClientSecret() + "";

        byte[] out = data.getBytes(StandardCharsets.UTF_8);

        OutputStream stream = http.getOutputStream();
        stream.write(out);

        String jsonStr = "";

        try (Scanner scan = new Scanner(http.getInputStream())) {
            while (scan.hasNext()) {
                jsonStr += scan.nextLine();
            }
        }

        http.disconnect();

        return jsonStr;
    }

}
