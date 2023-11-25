package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        toDB(700000);
    }

    static void toDB(int numStudents) {
        Generator generator = new Generator();
        ArrayList<University> universities = generator.generate_universities(numStudents);
        CRUD.createAllDataOnDB(universities);
    }
    static void fromDB() {
        Generator generator = new Generator();
        ArrayList<University> universities = CRUD.readAllDataFromDB();
        for (University university: universities) {
            System.out.println(university);
        }
    }
}