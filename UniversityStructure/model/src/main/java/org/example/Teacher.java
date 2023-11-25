package org.example;

public class Teacher {
    private int teacher_id;
    private int university_id;
    private int faculti_id;
    private int department_id;
    private String name;
    private String surname;
    private String fatherName;
    private int age;


    public Teacher() {
    }

    public Teacher(int teacher_id, int university_id, int faculti_id, int department_id, String name, String surname, String fatherName, int age) {
        this.teacher_id = teacher_id;
        this.university_id = university_id;
        this.faculti_id = faculti_id;
        this.department_id = department_id;
        this.name = name;
        this.surname = surname;
        this.fatherName = fatherName;
        this.age = age;
    }

    public int getUniversity_id() {
        return university_id;
    }

    public void setUniversity_id(int university_id) {
        this.university_id = university_id;
    }

    public int getFaculti_id() {
        return faculti_id;
    }

    public void setFaculti_id(int faculti_id) {
        this.faculti_id = faculti_id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
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
}
