package backend;

import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import util.JsonUtil;
import util.RestUtil;
import util.ValidatorUtil;

public class TestInstruments {
    public static final Dotenv dotenv = Dotenv.load();

    @BeforeSuite
    public void BeforeSuite() {
        System.out.println("before suite");
    }

    public RestUtil requestAPI() {
        return new RestUtil(dotenv.get("API_BASE_URL"));
    }

    public JsonUtil jsonUtil() {
        return new JsonUtil();
    }

    public ValidatorUtil validate() {
        return new ValidatorUtil();
    }
}