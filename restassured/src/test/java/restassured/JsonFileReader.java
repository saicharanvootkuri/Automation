package restassured;

import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonFileReader {
    private static final Logger log = Logger.getLogger(JsonFileReader.class.getName());

    public static JSONObject readJsonFile(String filePath) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(filePath));
        return (JSONObject) obj;
    }

    public static void displayJsonContent(JSONObject jsonData) {
        log.info("JSON Content:");
        log.info(jsonData.toJSONString());
    }

    public static void main(String[] args) throws IOException, ParseException {
        String filePath = "C:\\Users\\Admin\\Desktop\\selenium\\restassured\\example_1.json";

        JSONObject jsonData = readJsonFile(filePath);

        displayJsonContent(jsonData);
    }
}
