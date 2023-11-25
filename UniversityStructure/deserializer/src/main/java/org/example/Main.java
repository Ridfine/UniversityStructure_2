package org.example;

import java.io.IOException;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args){
        try {
            String filename = "ArrayUniv.json";
            Deserializer deserializer = new Deserializer();
            ArrayList<University> universiti = deserializer.deserializeFromFile(filename);

            for(int i = 0; i < universiti.size(); i++){
                System.out.println(universiti.get(i).getUniversityId());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}