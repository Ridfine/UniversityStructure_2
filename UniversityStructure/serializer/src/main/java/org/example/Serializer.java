package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Serializer {
    private ObjectMapper objectMapper;

    public Serializer() {
        this.objectMapper = new ObjectMapper();
    }

    public void serializeToFile(ArrayList<University> personList, String filePath) throws IOException {
        objectMapper.writeValue(new File(filePath), personList);
    }
}
