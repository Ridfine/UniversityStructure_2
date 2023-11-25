package org.example;

import java.util.ArrayList;

public class Group {
    private int group_id;
    private ArrayList<Student>students;
    private int faculti_id;
    private int headman_student_id;

    public Group() {
    }

    public Group(int group_id, ArrayList<Student> students, int faculti_id, int headman_student_id) {
        this.group_id = group_id;
        this.students = students;
        this.faculti_id = faculti_id;
        this.headman_student_id = headman_student_id;
    }

    public Group(int group_id, int faculti_id) {
        this.group_id = group_id;
        this.faculti_id = faculti_id;
    }

    public Group(int group_id, int faculti_id, int headman_student_id) {
        this.group_id = group_id;
        this.faculti_id = faculti_id;
        this.headman_student_id = headman_student_id;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public int getFaculti_id() {
        return faculti_id;
    }

    public void setFaculti_id(int faculti_id) {
        this.faculti_id = faculti_id;
    }

    public int getHeadman_student_id() {
        return headman_student_id;
    }

    public void setHeadman_student_id(int headman_student_id) {
        this.headman_student_id = headman_student_id;
    }

}
