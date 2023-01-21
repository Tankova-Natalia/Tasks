import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Task3{
    public static JSONObject jsonTests;
    public static Map<Long, String> values;

    public static void fillArray(JSONArray jsonArray){
        for (Object object : jsonArray){
            JSONObject jsonObject = (JSONObject) object;
            fill(jsonObject);
        }
    }
    public static void fill(JSONObject jsonObject){
        Long id = (Long) jsonObject.get("id");
        jsonObject.put("value", values.get(id));
        if (jsonObject.get("values")!=null){
            fillArray((JSONArray) jsonObject.get("values"));
        }
    }
    public static void main(String[] args) {
        File fileTests = new File(args[0]);
        File fileValues= new File(args[1]);
        JSONParser parser = new JSONParser();
        try (FileReader readerTests = new FileReader(fileTests);
             FileReader readerValues = new FileReader(fileValues);
             FileWriter writer = new FileWriter("report.json")
        ){
            jsonTests = (JSONObject) parser.parse(readerTests);
            JSONArray arrayTests = (JSONArray) jsonTests.get("tests");
            JSONObject jsonValues = (JSONObject) parser.parse(readerValues);
            JSONArray arrayValues = (JSONArray) jsonValues.get("values");
            values = new HashMap<>();
            for (Object object: arrayValues){
                JSONObject jsonObject = (JSONObject) object;
                values.put((Long)jsonObject.get("id"), (String)jsonObject.get("value"));
            }
            for (Object object : arrayTests){
                fill((JSONObject) object);
            }
            writer.write(jsonTests.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}