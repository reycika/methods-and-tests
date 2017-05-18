package rest.template;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static rest.template.GetResponseCodeWithRestTemplate.getResponseCodeWithRestTemplate;

/**
 * Created by renata on 18-May-17.
 */
public class GetResponseCodeWithRestTemplateTest {

    @Test
    void getGoogleResponse2() throws Exception {
        getResponseCodeWithRestTemplate("http://www.google.com");
    }

    @Test
    void getError404_2() throws Exception {
        getResponseCodeWithRestTemplate("http://www.google.com/i-dont-exist-sam-tko-da-ves");
    }

    @Test
    void getIncompleteURLError() throws Exception {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> getResponseCodeWithRestTemplate("www.google.com"));
        assertEquals("You have to enter URL with http://", ex.getMessage());
    }

    @Test
    void getEmptyURLError() throws Exception {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> getResponseCodeWithRestTemplate(""));
        assertEquals("You have to enter URL", ex.getMessage());
    }

    @Test
    void getRubbishError() throws Exception {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> getResponseCodeWithRestTemplate("fgdfgdfg"));
        assertEquals("You have to enter URL with http://", ex.getMessage());
    }
}