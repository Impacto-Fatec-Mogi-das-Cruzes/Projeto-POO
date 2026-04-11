package com.example;

import java.io.InputStream;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

// TODO: use strategy pattern to define if json parsing is of a setting or filetree item
public class JsonParser {
    private static JsonParser instance;
    
    private JsonParser() {}
    
    public static JsonParser getInstance() {
        if (JsonParser.instance == null) {
            instance = new JsonParser();
        }
        return instance;
    }

    // TODO: Define return to a class 
    public JsonNode parse(String resourceFile) {
        JsonNode data = null;
        ObjectMapper mapper = new ObjectMapper();

        try {
            InputStream is = getClass().getResourceAsStream(resourceFile);
            if (is == null) {
               throw new RuntimeException("File not found");
            }
            data = mapper.readTree(is);
        } catch (Exception e) {
            System.err.println(e);
        }
        return data;
    }
    
}
