package org.example;

import java.util.*;

public class Generator {
    private final String[] faculties = {
            "Mediko-biologicheskiy",
            "Geologicheskiy fakultet",
            "Istoricheskiy fakultet",
            "Fakultet kompyuternykh nauk",
            "Matematicheskiy fakultet",
            "Fakultet mezhdunarodnykh otnosheniy",
            "Fakultet prikladnoy matematiki, informatiki i mekhaniki",
            "Fakultet romano-germanskoy filologii",
            "Farmatsevticheskiy fakultet",
            "Fizicheskiy fakultet"
    };

    private Integer freeUniversityId = 0;
    private Integer freeFacultyId = 0;
    private Integer freeGroupId = 0;
    private Integer freeDepartmentId = 0;
    private Integer freeTeacherId = 0;
    private Integer freeStudentId = 0;


    public ArrayList<String> generateUniversityNames(int numNames){
        Set<String> universityNames = new HashSet<>();
        Random random = new Random();
        while(universityNames.size() < numNames){
            String name = generateRandomName(random);
            universityNames.add(name);
        }
        return new ArrayList<>(universityNames);
    }
    private String generateRandomName(Random random) {
        StringBuilder sb = new StringBuilder();
        int length = random.nextInt(7) + 3; // Генерируем рандомную длину от 5 до 14 символов

        for (int i = 0; i < length; i++) {
            int randomChar = random.nextInt(26) + 65; // Генерируем рандомную заглавную букву от A до Z
            sb.append((char) randomChar);
        }

        return sb.toString();
    }
    public ArrayList<Student> generate_students(Map<String, Integer> nameId){
        int numStudents = (int) (Math.random() * 2) + 1;
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < numStudents; i++){
            String name = "StudentName" + i;
            String surname = "StudentSurname" + i;
            String fatherName = "StudentFatherName" + i;
            int age = (int) (Math.random() * 5) + 20;
            Student newStudents = new Student(this.freeStudentId++, nameId.get("universityId"), nameId.get("facultiId"),nameId.get("groupId"), name, surname, fatherName, age);
            students.add(newStudents);
        }

        return students;
    }
    public ArrayList<Group> generate_groups(Map<String, Integer> nameId){
        int numGroups = (int) (Math.random() * 2) + 1;
        ArrayList<Group> groups = new ArrayList<>();
        for (int i = 0; i < numGroups; i++){
            Group newGroup = new Group(this.freeGroupId++, nameId.get("facultiId"));
            nameId.put("groupId", newGroup.getGroup_id());
            ArrayList<Student> students = generate_students(nameId);
            newGroup.setStudents(students);
            newGroup.setHeadman_student_id(students.get((int) (Math.random() * students.size())).getStudent_id());
            groups.add(newGroup);
        }
        return groups;
    }

    public ArrayList<Teacher> generate_teatchers(Map<String, Integer> nameId){
        int numTeatchers = (int) (Math.random() * 2) + 1;
        ArrayList<Teacher> teatchers = new ArrayList<>();
        for (int i = 0; i < numTeatchers; i++){
            String name = "TeacherName" + i;
            String surname = "TeacherSurname" + i;
            String fatherName = "TeacherFatherName" + i;
            int age = (int) (Math.random() * 40) + 30;
            Teacher newTeatchers = new Teacher(this.freeTeacherId++, nameId.get("universityId"), nameId.get("facultiId"), nameId.get("departmentId"), name, surname, fatherName, age);
            teatchers.add(newTeatchers);
        }
        return teatchers;
    }

    public ArrayList<Department> generate_departments(Map<String, Integer> nameId){
        int numDepartments = (int) (Math.random() * 2) + 1;
        ArrayList<Department> departments = new ArrayList<>();
        for (int i = 0; i < numDepartments; i++){
            String departmantName = "departmantName" + i;
            Department newDepartment = new Department(this.freeDepartmentId++, departmantName, nameId.get("facultiId"));
            nameId.put("departmentId", newDepartment.getDepartment_id());
            newDepartment.setTeachers(generate_teatchers(nameId));

            departments.add(newDepartment);
        }

        return departments;
    }
    public ArrayList<Faculty> generate_faculties(Map<String, Integer> nameId){
        int numFaculti = (int) (Math.random() * 2) + 1;
        ArrayList<Faculty> faculties = new ArrayList<>();
        for (int i = 0; i < numFaculti; i++){
            Faculty newFaculty = new Faculty(this.freeFacultyId++, this.faculties[i], nameId.get("universityId"));
            nameId.put("facultiId", newFaculty.getFacultiId());
            newFaculty.setGroups(generate_groups(nameId));
            newFaculty.setDepertments(generate_departments(nameId));
            faculties.add(newFaculty);
        }
        return faculties;
    }

    public ArrayList<University> generate_universities(int numUniversity){
        ArrayList<String> universityNames = generateUniversityNames(numUniversity);
        ArrayList<University> universities = new ArrayList<>();
        for (int i = 0; i < numUniversity; i++){
            Map<String, Integer> nameId = new HashMap<>();
            University newUnivesity = new University(this.freeUniversityId++, universityNames.get(i));
            nameId.put("universityId", newUnivesity.getUniversityId());
            System.out.println(newUnivesity.getUniversityId());
            newUnivesity.setFaculties(generate_faculties(nameId));
            universities.add(newUnivesity);
        }
        return universities;
    }
}
