package restassured;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonFileReaderUtil {

    /**
     * Reads JSON data from a file and returns it as a JSONObject.
     *
     * @param filePath The path to the JSON file.
     * @return JSONObject containing the parsed JSON data.
     * @throws IOException    If there is an issue reading the file.
     * @throws ParseException If there is an issue parsing the JSON data.
     */
    public static JSONObject readJsonFile(String filePath) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        try (FileReader fileReader = new FileReader(filePath)) {
            Object obj = parser.parse(fileReader);
            return (JSONObject) obj;
        }
    }

    /**
     * Displays the JSON content using a logger or any other desired output method.
     *
     * @param jsonData The JSONObject to be displayed.
     */
    public static void displayJsonContent(JSONObject jsonData) {
        System.out.println("JSON Content:");
        System.out.println(jsonData.toJSONString());
    }

    /**
     * Example usage in a main method.
     */
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Admin\\Desktop\\selenium\\restassured\\example_1.json";

        try {
            // Read JSON data from file
            JSONObject jsonData = readJsonFile(filePath);

            // Display JSON content
            displayJsonContent(jsonData);

            // Additional actions with the JSON data can be performed here
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
