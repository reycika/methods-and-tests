package rest.template;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by renata on 17-May-17.
 */
public class GetResponseCodeWithRestTemplate {

    /*private static void getResponseCodeWithRestTemplate(String url) {

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        System.out.println("Code from an HTTP response message for webpage " + url + " is " + response);
    }*/

    public static void getResponseCodeWithRestTemplate(String url) {

        if (url.equals("")) {
            throw new IllegalArgumentException("You have to enter URL");
        }
        else if (url.equals(" ")) {
            throw new IllegalArgumentException("URL cannot be empty string");
        }
        else if (! url.contains("http://")) {
            throw new IllegalArgumentException("You have to enter URL with http://");
        }

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new MyResponseErrorHandler());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> entity = new HttpEntity<>(headers);

        ResponseEntity<String> out = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        //System.out.println(out.getBody());
        System.out.println("Success: Code from an HTTP response message for webpage " + url + " is " + out.getStatusCode());
    }

    public static void main(String[] args) throws Exception {
        GetResponseCodeWithRestTemplate myObj = new GetResponseCodeWithRestTemplate();
        myObj.getResponseCodeWithRestTemplate("http://www.google.com/fdskfjdksfjdklsfjdklsfjdkls");
    }

}
