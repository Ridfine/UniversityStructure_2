package org.example;

import java.util.ArrayList;

public class Faculty {
    private int facultiId;
    private String facultiName;
    private ArrayList<Department> depertments;
    private ArrayList<Group> groups;
    private int university_id;


    public Faculty() {
    }

    public Faculty(int facultiId, String facultiName, ArrayList<Department> depertments, ArrayList<Group> groups, int university_id) {
        this.facultiId = facultiId;
        this.facultiName = facultiName;
        this.depertments = depertments;
        this.groups = groups;
        this.university_id = university_id;
    }

    public Faculty(int facultiId, String facultiName, int university_id) {
        this.facultiId = facultiId;
        this.facultiName = facultiName;
        this.university_id = university_id;
    }

    public String getFacultiName() {
        return facultiName;
    }

    public void setFacultiName(String facultiName) {
        this.facultiName = facultiName;
    }

    public ArrayList<Department> getDepertments() {
        return depertments;
    }

    public void setDepertments(ArrayList<Department> depertments) {
        this.depertments = depertments;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }

    public int getFacultiId() {
        return facultiId;
    }

    public void setFacultiId(int facultiId) {
        this.facultiId = facultiId;
    }

    public int getUniversity_id() {
        return university_id;
    }

    public void setUniversity_id(int university_id) {
        this.university_id = university_id;
    }
}
