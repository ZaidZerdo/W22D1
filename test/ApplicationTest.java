import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.*;

import play.Logger;
import play.mvc.*;
import play.test.*;
import play.data.DynamicForm;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.F.*;
import play.twirl.api.Content;

import static play.test.Helpers.*;
import static org.junit.Assert.*;


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ApplicationTest {

    @Test
    public void testBestCasePlanetList() {
        running(fakeApplication(), new Runnable() {
            @Override
            public void run() {
                Map<String, String> data = new HashMap<>();
                data.put("page", "1");

                Result result = route(fakeRequest("POST", "/").bodyForm(data));

                Logger.info(result.status() + "");
                assertTrue(result.status() == OK);
            }
        });
    }

    @Test
    public void testWorstCasePlanetList() {
        running(fakeApplication(), new Runnable() {
            @Override
            public void run() {
                Map<String, String> data = new HashMap<>();
                data.put("jaskdasld", "asdasd");

                Result result = route(fakeRequest("POST", "/").bodyForm(data));

                Logger.info(result.status() + "");
                assertTrue(result.status() == BAD_REQUEST);
            }
        });
    }

}
