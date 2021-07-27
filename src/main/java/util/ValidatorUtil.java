package util;

import io.restassured.response.Response;
import util.validator.ResponseValidator;

public class ValidatorUtil {
    public ResponseValidator response(Response response) {
        return new ResponseValidator(response);
    }
}
