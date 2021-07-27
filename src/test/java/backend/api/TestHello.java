package backend.api;

import backend.TestInstruments;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

public class TestHello extends TestInstruments {
    @Test
    public void successGetUser() {
        Response response = requestAPI().get("/users/3");
        validate().response(response).statusEqual(HttpStatus.SC_OK);
        validate().response(response).valueEqual("$.data.id", 3);
    }
}
