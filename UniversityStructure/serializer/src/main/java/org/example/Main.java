package org.example;

import java.io.IOException;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args){
        String filename = "ArrayUniv.json";
        Generator generator = new Generator();
        ArrayList<University> universities = generator.generate_universities(500000);
        try {
            Serializer serializer = new Serializer();
            serializer.serializeToFile(universities, filename);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}