package util.validator;

import io.restassured.response.Response;
import org.testng.Assert;
import util.JsonUtil;

public class ResponseValidator {
    private final Response response;

    public ResponseValidator(Response response) {
        this.response = response;
    }

    public <T> T getBodyObject(String path) {
        return new JsonUtil().retrieveJsonValue(response.asString(), path);
    }

    public String getBodyAttribute(String path) {
        return getBodyObject(path).toString();
    }

    public void valueEqual(String path, String expectedValue) {
        Assert.assertEquals(getBodyAttribute(path), expectedValue, String.format("%s has wrong value", path));
    }

    public void valueEqual(String path, int expectedValue) {
        this.valueEqual(path, String.valueOf(expectedValue));
    }

    public void statusEqual(int status) {
        Assert.assertEquals(response.getStatusCode(), status);
    }
}
