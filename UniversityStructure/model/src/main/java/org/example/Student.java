package org.example;

public class Student {
    private int student_id;
    private int university_id;
    private int faculti_id;
    private int group_id;
    private String name;
    private String surname;
    private String fatherName;
    private int age;

    public Student() {
    }

    public Student(int student_id, int university_id, int faculti_id, int group_id, String name, String surname, String fatherName, int age) {
        this.student_id = student_id;
        this.university_id = university_id;
        this.faculti_id = faculti_id;
        this.group_id = group_id;
        this.name = name;
        this.surname = surname;
        this.fatherName = fatherName;
        this.age = age;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getFaculti_id() {
        return faculti_id;
    }

    public void setFaculti_id(int faculti_id) {
        this.faculti_id = faculti_id;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getUniversity_id() {
        return university_id;
    }

    public void setUniversity_id(int university_id) {
        this.university_id = university_id;
    }
}
