package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Deserializer {
    private ObjectMapper objectMapper;

    public Deserializer() {
        this.objectMapper = new ObjectMapper();
    }

    public ArrayList<University> deserializeFromFile(String filePath) throws IOException {
        return objectMapper.readValue(new File(filePath), new TypeReference<>(){});
    }
}
