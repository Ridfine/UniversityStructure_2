package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CRUD {
    private static String INSERT_UNIVERSITY = "INSERT INTO universities (university_id, university_name) VALUES (?, ?)";
    private static String INSERT_FACULTY = "INSERT INTO faculties (faculty_id, faculty_name, university_id) VALUES (?, ?, ?)";
    private static String INSERT_DEPARTMENT = "INSERT INTO departments (department_id, department_name, faculty_id) VALUES (?, ?, ?)";
    private static String INSERT_GROUP = "INSERT INTO groups (group_id, faculty_id, headman_student_id) VALUES (?, ?, ?)";
    private static String INSERT_STUDENT = "INSERT INTO students (student_id, university_id, faculty_id, group_id, name, surname, father_name, age) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static String INSERT_TEACHER = "INSERT INTO teachers (teacher_id, university_id, faculty_id, department_id, name, surname, father_name, age) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static String UPDATE_UNIVERSITY = "UPDATE universities SET university_name = ? WHERE university_id = ? VALUES (?, ?)";
    private static String UPDATE_FACULTY = "UPDATE faculties SET faculty_name = ?, university_id = ? WHERE faculty_id = ? VALUES (?, ?, ?)";
    private static String UPDATE_DEPARTMENT = "UPDATE departments SET department_name = ?, faculty_id = ? WHERE department_id = ? VALUES (?, ?, ?)";
    private static String UPDATE_GROUP = "UPDATE groups SET faculty_id = ?, headman_student_id = ? WHERE group_id = ? VALUES (?, ?, ?)";
    private static String UPDATE_STUDENT = "UPDATE students SET university_id = ?, faculty_id = ?, group_id = ?, name = ?, surname = ?, father_name = ?, age = ? WHERE student_id = ? VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static String UPDATE_TEACHER = "UPDATE teachers SET university_id = ?, faculty_id = ?, department_id = ?, name = ?, surname = ?, father_name = ?, age = ? WHERE teacher_id = ? VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static String DELETE_UNIVERSITY = "DELETE FROM universities WHERE university_id = ? VALUES (?)";
    private static String DELETE_FACULTY = "DELETE FROM faculties WHERE faculty_id = ? VALUES (?)";
    private static String DELETE_DEPARTMENT = "DELETE FROM departments WHERE department_id = ? VALUES (?)";
    private static String DELETE_GROUP = "DELETE FROM groups WHERE group_id = ? VALUES (?)";
    private static String DELETE_STUDENT = "DELETE FROM students WHERE student_id = ? VALUES (?)";
    private static String DELETE_TEACHER = "DELETE FROM teachers WHERE teacher_id = ? VALUES (?)";

    public static void createAllDataOnDB(ArrayList<University> universities){
        try {
            Connection connection = DBUtils.getConnection();
            for (University university: universities)
            {
                createUniversity(connection, university);
                for (Faculty faculty: university.getFaculties())
                {
                    createFaculty(connection, faculty);
                    for (Group group: faculty.getGroups())
                    {
                        createGroup(connection, group);
                        for (Student student: group.getStudents())
                        {
                            createStudent(connection, student);
                        }
                    }
                    for (Department department: faculty.getDepertments())
                    {
                        createDepartment(connection, department);
                        for (Teacher teacher: department.getTeachers())
                        {
                            createTeacher(connection, teacher);
                        }
                    }
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<University> readAllDataFromDB(){
        try {
            Connection connection = DBUtils.getConnection();
            ArrayList<University> universities = readUniversitiesData(connection, "SELECT * FROM universities");
            for (University university: universities)
            {
                university.setFaculties(readFacultiesData(connection, "SELECT * FROM faculties WHERE university_id = " + university.getUniversityId()));
                for (Faculty faculty: university.getFaculties())
                {
                    faculty.setGroups(readGroupsData(connection, "SELECT * FROM groups WHERE faculty_id = " + faculty.getFacultiId()));
                    for (Group group: faculty.getGroups())
                    {
                        group.setStudents(readStudentsData(connection, "SELECT * FROM students WHERE group_id = " + group.getGroup_id()));
                    }
                    faculty.setDepertments(readDepartmentsitiesData(connection, "SELECT * FROM departments WHERE faculty_id = " + faculty.getFacultiId()));
                    for (Department department: faculty.getDepertments())
                    {
                        department.setTeachers(readTeachersData(connection, "SELECT * FROM teachers WHERE department_id = " + department.getDepartment_id()));
                    }
                }
            }
        return universities;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createUniversity(Connection connection, University university) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_UNIVERSITY);
        preparedStatement.setInt(1, university.getUniversityId());
        preparedStatement.setString(2, university.getUniversityName());
        preparedStatement.executeUpdate();
    }

    public static void createUniversity(University university) throws SQLException {
        try {
            Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_UNIVERSITY);
            preparedStatement.setInt(1, university.getUniversityId());
            preparedStatement.setString(2, university.getUniversityName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createFaculty(Connection connection, Faculty faculty) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FACULTY);
        preparedStatement.setInt(1, faculty.getFacultiId());
        preparedStatement.setString(2, faculty.getFacultiName());
        preparedStatement.setInt(3, faculty.getUniversity_id());
        preparedStatement.executeUpdate();
    }
    public static void createFaculty(Faculty faculty) throws SQLException {
        try {
            Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FACULTY);
            preparedStatement.setInt(1, faculty.getFacultiId());
            preparedStatement.setString(2, faculty.getFacultiName());
            preparedStatement.setInt(3, faculty.getUniversity_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createDepartment(Connection connection, Department department) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DEPARTMENT);
        preparedStatement.setInt(1, department.getDepartment_id());
        preparedStatement.setString(2, department.getDepartmentName());
        preparedStatement.setInt(3, department.getFaculti_id());
        preparedStatement.executeUpdate();
    }
    public static void createDepartment(Department department) throws SQLException {
        try {
            Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DEPARTMENT);
            preparedStatement.setInt(1, department.getDepartment_id());
            preparedStatement.setString(2, department.getDepartmentName());
            preparedStatement.setInt(3, department.getFaculti_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static void createGroup(Connection connection, Group group) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_GROUP);
        preparedStatement.setInt(1, group.getGroup_id());
        preparedStatement.setInt(2, group.getFaculti_id());
        preparedStatement.setInt(3, group.getHeadman_student_id());
        preparedStatement.executeUpdate();
    }
    public static void createGroup(Group group) throws SQLException {
        try {
            Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_GROUP);
            preparedStatement.setInt(1, group.getGroup_id());
            preparedStatement.setInt(2, group.getFaculti_id());
            preparedStatement.setInt(3, group.getHeadman_student_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createStudent(Connection connection, Student student) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT);
        preparedStatement.setInt(1, student.getStudent_id());
        preparedStatement.setInt(2, student.getUniversity_id());
        preparedStatement.setInt(3, student.getFaculti_id());
        preparedStatement.setInt(4, student.getGroup_id());
        preparedStatement.setString(5, student.getName());
        preparedStatement.setString(6, student.getSurname());
        preparedStatement.setString(7, student.getFatherName());
        preparedStatement.setInt(8, student.getAge());
        preparedStatement.executeUpdate();
    }
    public static void createStudent(Student student) throws SQLException {
        try {
            Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT);
            preparedStatement.setInt(1, student.getStudent_id());
            preparedStatement.setInt(2, student.getUniversity_id());
            preparedStatement.setInt(3, student.getFaculti_id());
            preparedStatement.setInt(4, student.getGroup_id());
            preparedStatement.setString(5, student.getName());
            preparedStatement.setString(6, student.getSurname());
            preparedStatement.setString(7, student.getFatherName());
            preparedStatement.setInt(8, student.getAge());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createTeacher(Connection connection, Teacher teacher) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TEACHER);
        preparedStatement.setInt(1, teacher.getTeacher_id());
        preparedStatement.setInt(2, teacher.getUniversity_id());
        preparedStatement.setInt(3, teacher.getFaculti_id());
        preparedStatement.setInt(4, teacher.getDepartment_id());
        preparedStatement.setString(5, teacher.getName());
        preparedStatement.setString(6, teacher.getSurname());
        preparedStatement.setString(7, teacher.getFatherName());
        preparedStatement.setInt(8, teacher.getAge());
        preparedStatement.executeUpdate();
    }
    public static void createTeacher(Teacher teacher) throws SQLException {
        try {
            Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TEACHER);
            preparedStatement.setInt(1, teacher.getTeacher_id());
            preparedStatement.setInt(2, teacher.getUniversity_id());
            preparedStatement.setInt(3, teacher.getFaculti_id());
            preparedStatement.setInt(4, teacher.getDepartment_id());
            preparedStatement.setString(5, teacher.getName());
            preparedStatement.setString(6, teacher.getSurname());
            preparedStatement.setString(7, teacher.getFatherName());
            preparedStatement.setInt(8, teacher.getAge());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //============================================================================================
    //============================================================================================
    //============================================================================================

    public static ArrayList<University> readUniversitiesData(String query){
        ArrayList<University> universities = new ArrayList<>();

        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int universityId = rs.getInt("university_id");
                String universityName = rs.getString("university_name");

                universities.add(new University(universityId, universityName));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return universities;
    }

    public static ArrayList<Faculty> readFacultiesData(String query){
        ArrayList<Faculty> faculties = new ArrayList<>();

        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int facultiId = rs.getInt("faculty_id");
                String facultiName = rs.getString("faculty_name");
                int university_id = rs.getInt("university_id");
                faculties.add(new Faculty(facultiId, facultiName, university_id));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return faculties;
    }

    public static ArrayList<Group> readGroupsData(String query){
        ArrayList<Group> groups = new ArrayList<>();

        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int group_id = rs.getInt("group_id");
                int faculti_id = rs.getInt("faculty_id");
                int headman_student_id = rs.getInt("headman_student_id");

                groups.add(new Group(group_id, faculti_id, headman_student_id));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return groups;
    }

    public static ArrayList<Department> readDepartmentsitiesData(String query){
        ArrayList<Department> departments = new ArrayList<>();

        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int department_id = rs.getInt("department_id");
                String departmentName = rs.getString("department_name");
                int faculti_id = rs.getInt("faculty_id");

                departments.add(new Department(department_id, departmentName, faculti_id));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return departments;
    }

    public static ArrayList<Student> readStudentsData(String query){
        ArrayList<Student> students = new ArrayList<>();

        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int student_id = rs.getInt("student_id");
                int university_id = rs.getInt("university_id");
                int faculti_id = rs.getInt("faculty_id");
                int group_id = rs.getInt("group_id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String fatherName = rs.getString("father_name");
                int age = rs.getInt("age");

                students.add(new Student(student_id, university_id, faculti_id, group_id, name, surname, fatherName, age));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    public static ArrayList<Teacher> readTeachersData(String query){
        ArrayList<Teacher> teachers = new ArrayList<>();

        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int teacher_id = rs.getInt("teacher_id");
                int university_id = rs.getInt("university_id");
                int faculti_id = rs.getInt("faculty_id");
                int department_id = rs.getInt("department_id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String fatherName = rs.getString("father_name");
                int age = rs.getInt("age");

                teachers.add(new Teacher(teacher_id, university_id, faculti_id, department_id, name, surname, fatherName, age));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return teachers;
    }



    private static ArrayList<University> readUniversitiesData(Connection connection, String query) throws SQLException {
        ArrayList<University> universities = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            int universityId = rs.getInt("university_id");
            String universityName = rs.getString("university_name");
            universities.add(new University(universityId, universityName));
        }
        return universities;
    }

    private static ArrayList<Faculty> readFacultiesData(Connection connection, String query) throws SQLException {
        ArrayList<Faculty> faculties = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            int facultiId = rs.getInt("faculty_id");
            String facultiName = rs.getString("faculty_name");
            int university_id = rs.getInt("university_id");
            faculties.add(new Faculty(facultiId, facultiName, university_id));
        }
        return faculties;
    }

    private static ArrayList<Group> readGroupsData(Connection connection, String query) throws SQLException {
        ArrayList<Group> groups = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            int group_id = rs.getInt("group_id");
            int faculti_id = rs.getInt("faculty_id");
            int headman_student_id = rs.getInt("headman_student_id");
            groups.add(new Group(group_id, faculti_id, headman_student_id));
        }
        return groups;
    }

    private static ArrayList<Department> readDepartmentsitiesData(Connection connection, String query) throws SQLException {
        ArrayList<Department> departments = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            int department_id = rs.getInt("department_id");
            String departmentName = rs.getString("department_name");
            int faculti_id = rs.getInt("faculty_id");
            departments.add(new Department(department_id, departmentName, faculti_id));
        }
        return departments;
    }

    private static ArrayList<Student> readStudentsData(Connection connection, String query) throws SQLException {
        ArrayList<Student> students = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            int student_id = rs.getInt("student_id");
            int university_id = rs.getInt("university_id");
            int faculti_id = rs.getInt("faculty_id");
            int group_id = rs.getInt("group_id");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String fatherName = rs.getString("father_name");
            int age = rs.getInt("age");
            students.add(new Student(student_id, university_id, faculti_id, group_id, name, surname, fatherName, age));
        }
        return students;
    }

    private static ArrayList<Teacher> readTeachersData(Connection connection, String query) throws SQLException {
        ArrayList<Teacher> teachers = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            int teacher_id = rs.getInt("teacher_id");
            int university_id = rs.getInt("university_id");
            int faculti_id = rs.getInt("faculty_id");
            int department_id = rs.getInt("department_id");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String fatherName = rs.getString("father_name");
            int age = rs.getInt("age");

            teachers.add(new Teacher(teacher_id, university_id, faculti_id, department_id, name, surname, fatherName, age));
        }

        return teachers;
    }


    //============================================================================================
    //============================================================================================
    //============================================================================================


    public static void updateUniversity(University university){
        try {
            Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_UNIVERSITY);
            preparedStatement.setString(1, university.getUniversityName());
            preparedStatement.setInt(2, university.getUniversityId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void updateFaculty(Faculty faculty){
        try {
            Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_FACULTY);
            preparedStatement.setString(1, faculty.getFacultiName());
            preparedStatement.setInt(2, faculty.getUniversity_id());
            preparedStatement.setInt(3, faculty.getFacultiId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void updateDepartment(Department department){
        try {
            Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DEPARTMENT);
            preparedStatement.setString(1, department.getDepartmentName());
            preparedStatement.setInt(2, department.getFaculti_id());
            preparedStatement.setInt(3, department.getDepartment_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void updateGroup(Group group){
        try {
            Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_GROUP);
            preparedStatement.setInt(1, group.getFaculti_id());
            preparedStatement.setInt(2, group.getHeadman_student_id());
            preparedStatement.setInt(3, group.getGroup_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateStudent(Student student){
        try {
            Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT);
            preparedStatement.setInt(1, student.getUniversity_id());
            preparedStatement.setInt(2, student.getFaculti_id());
            preparedStatement.setInt(3, student.getGroup_id());
            preparedStatement.setString(4, student.getName());
            preparedStatement.setString(5, student.getSurname());
            preparedStatement.setString(6, student.getFatherName());
            preparedStatement.setInt(7, student.getAge());
            preparedStatement.setInt(8, student.getStudent_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateTeacher(Teacher teacher){
        try {
            Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TEACHER);
            preparedStatement.setInt(1, teacher.getUniversity_id());
            preparedStatement.setInt(2, teacher.getFaculti_id());
            preparedStatement.setInt(3, teacher.getDepartment_id());
            preparedStatement.setString(4, teacher.getName());
            preparedStatement.setString(5, teacher.getSurname());
            preparedStatement.setString(6, teacher.getFatherName());
            preparedStatement.setInt(7, teacher.getAge());
            preparedStatement.setInt(8, teacher.getTeacher_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //============================================================================================
    //============================================================================================
    //============================================================================================



    public static void deleteUniversity(int university_id){
        try {
            Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_UNIVERSITY);
            preparedStatement.setInt(1, university_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void deleteFaculty(int faculty_id){
        try {
            Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FACULTY);
            preparedStatement.setInt(1, faculty_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void deleteDepartment(int department_id){
        try {
            Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_DEPARTMENT);
            preparedStatement.setInt(1, department_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void deleteGroup(int group_id){
        try {
            Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_GROUP);
            preparedStatement.setInt(1, group_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteStudent(int student_id){
        try {
            Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT);
            preparedStatement.setInt(1, student_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteTeacher(int teacher_id){
        try {
            Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TEACHER);
            preparedStatement.setInt(1, teacher_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
