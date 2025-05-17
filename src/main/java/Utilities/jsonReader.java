package Utilities;

import java.io.*;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class jsonReader {
    public static String getValueFromJson(String fileName, String key) {
        try {
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(new FileReader(fileName));
            return (String) jsonObject.get(key);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}