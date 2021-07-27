package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class JsonUtil {
    public final String jsonPathFile = "src/test/resources/data";

    public <T> T retrieveJsonValue(String jsonString, String jsonPath) {
        return JsonPath.read(jsonString, jsonPath);
    }

    public String readJsonFile(String jsonFileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(jsonPathFile + "/json/" + jsonFileName)), StandardCharsets.UTF_8);
    }

    public Map<String, Object> jsonStringToMap(String jsonString) throws IOException {
        return (new ObjectMapper()).readValue(jsonString, new TypeReference<Map<String, Object>>() {});
    }

    public Map<String, Object> jsonFileToMap(String jsonFileName) throws IOException {
        return jsonStringToMap(readJsonFile(jsonFileName));
    }

    public Object jsonFileToObject(String jsonFileName, Class classType) throws IOException {
        return new ObjectMapper().readValue(readJsonFile(jsonFileName), classType);
    }

    public Object jsonStringToObject(String jsonString, Class classType) throws JsonProcessingException {
        return new ObjectMapper().readValue(jsonString, classType);
    }
}
