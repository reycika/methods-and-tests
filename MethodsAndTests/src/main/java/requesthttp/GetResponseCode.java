package requesthttp;

import java.net.HttpURLConnection;
import java.net.URL;

public class GetResponseCode {

    public static void getResponse(String webAddress) throws Exception {

        if (webAddress.equals("")) {
            throw new IllegalArgumentException("You have to enter URL");
        }
        else if (webAddress.equals(" ")) {
            throw new IllegalArgumentException("URL cannot be empty string");
        }
        else if (! webAddress.contains("http://")) {
            throw new IllegalArgumentException("You have to enter URL with http://");
        }

        URL url = new URL(webAddress);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        // // Gets the status code from an HTTP response message.
        int responseCode = connection.getResponseCode();
        System.out.println("Code from an HTTP response message for webpage " + url + " is " + responseCode);
    }

    public static void main(String[] args) throws Exception {
        GetResponseCode myObj = new GetResponseCode();
        myObj.getResponse("http://www.google.com");
    }
}