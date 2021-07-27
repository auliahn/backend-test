package util;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestUtil {
    private RequestSpecification request;

    public RestUtil(String baseURI) {
        RestAssured.baseURI = baseURI;
        request = RestAssured.given();
    }

    public Response get(String path) {
        Response response = request.get(path);
        System.out.println("Response: " + response.getBody().asString());
        return response;
    }

    public Response post(String path, Object body) {
        request.header("Content-Type", "application/json");
        request.header("accept", "application/json");
        request.body(body);
        return request.post(path);
    }

    public Response put(String path, Object body) {
        request.header("Content-Type", "application/json");
        request.header("accept", "application/json");
        request.body(body);
        return request.put(path);
    }
}
