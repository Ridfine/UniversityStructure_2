package org.example;

import java.util.ArrayList;

public class Department {
    private int department_id;
    private String departmentName;
    private int faculti_id;
    private ArrayList<Teacher> teachers;

    public Department() {
    }

    public Department(int department_id, String departmentName, int faculti_id, ArrayList<Teacher> teachers) {
        this.department_id = department_id;
        this.departmentName = departmentName;
        this.faculti_id = faculti_id;
        this.teachers = teachers;
    }

    public Department(int department_id, String departmentName, int faculti_id) {
        this.department_id = department_id;
        this.departmentName = departmentName;
        this.faculti_id = faculti_id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getFaculti_id() {
        return faculti_id;
    }

    public void setFaculti_id(int faculti_id) {
        this.faculti_id = faculti_id;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }
}
