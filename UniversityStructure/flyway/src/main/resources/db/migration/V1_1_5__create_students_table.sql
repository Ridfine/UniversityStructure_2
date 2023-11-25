CREATE TABLE IF NOT EXISTS students (
    student_id SERIAL PRIMARY KEY,
    university_id INT,
    FOREIGN KEY (university_id) REFERENCES universities(university_id),
    faculty_id INT,
    FOREIGN KEY (faculty_id) REFERENCES faculties(faculty_id),
    group_id INT,
    FOREIGN KEY (group_id) REFERENCES groups(group_id),
    name VARCHAR(100),
    surname VARCHAR(100),
    father_name VARCHAR(100),
    age INT
);