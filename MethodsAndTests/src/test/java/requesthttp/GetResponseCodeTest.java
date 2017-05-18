package requesthttp;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static requesthttp.GetResponseCode.getResponse;


/**
 * Created by renata on 17-May-17.
 */
public class GetResponseCodeTest {

    @Test
    void getGoogleResponse() throws Exception {
        getResponse("http://www.google.com");
    }

    @Test
    void getError404() throws Exception {
        getResponse("http://www.google.com/i-dont-exist-sam-tko-da-ves");
    }

    @Test
    void getIncompleteURLError() throws Exception {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> getResponse("www.google.com"));
        assertEquals("You have to enter URL with http://", ex.getMessage());
    }

    @Test
    void getIncompleteURLError2() throws Exception {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> getResponse(""));
        assertEquals("You have to enter URL", ex.getMessage());
    }
}