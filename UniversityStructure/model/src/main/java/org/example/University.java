package org.example;

import java.util.ArrayList;

public class University {
    private int universityId;
    private String universityName;
    private ArrayList<Faculty> faculties;

    public University() {
    }
    public University(int universityId, String universityName) {
        this.universityId = universityId;
        this.universityName = universityName;
    }

    public University(int universityId, String universityName, ArrayList<Faculty> faculties) {
        this.universityId = universityId;
        this.universityName = universityName;
        this.faculties = faculties;
    }

    @Override
    public String toString(){
        return "University id: " + this.universityId + ", university name: " + universityName + ".\n";
    }
    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public ArrayList<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(ArrayList<Faculty> faculties) {
        this.faculties = faculties;
    }

    public int getUniversityId() {
        return universityId;
    }

    public void setUniversityId(int universityId) {
        this.universityId = universityId;
    }
}
