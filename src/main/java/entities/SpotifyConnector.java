package entities;

public class SpotifyConnector {

    private static String clientID = "f91126e901014a63a8d7adc33b5a4358";
    private static String clientSecret = "79643a90c5474599bc70027280c78e74";
    private static String bearerToken = "";


    public static String getClientID() {
        return clientID;
    }

    public static void setClientID(String clientID) {
        SpotifyConnector.clientID = clientID;
    }

    public static String getClientSecret() {
        return clientSecret;
    }

    public static void setClientSecret(String clientSecret) {
        SpotifyConnector.clientSecret = clientSecret;
    }

    public static String getBearerToken() {
        return bearerToken;
    }

    public static void setBearerToken(String bearerToken) {
        SpotifyConnector.bearerToken = bearerToken;
    }
}

/*
    Oki :D
    Så skal vi over til vores resource igen
*/
