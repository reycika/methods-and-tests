package rest.template;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

/**
 * Created by renata on 18-May-17.
 */
public class MyResponseErrorHandler implements ResponseErrorHandler {

    //private static final Log logger = LogFactory.getLog(MyResponseErrorHandler.class);

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {

        /*if (response.getStatusCode() != HttpStatus.OK) {
            logger.debug("Status code: " + response.getStatusCode());
            logger.debug("Response: " + response.getStatusText());
            logger.debug(response.getBody());

            *//*if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
                logger.debug("Call returned an error 404 not found...");
                return false;
            }*//*
        }*/
        return false;
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {

        //logger.debug(HttpStatus.NOT_FOUND + "Page not found: 404");
        /*if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
            throw new IOException();
        }*/
    }
}
