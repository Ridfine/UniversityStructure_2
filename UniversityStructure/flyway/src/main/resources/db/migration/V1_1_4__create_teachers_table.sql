CREATE TABLE IF NOT EXISTS teachers (
    teacher_id SERIAL PRIMARY KEY,
    university_id INT,
    FOREIGN KEY (university_id) REFERENCES universities(university_id),
    faculty_id INT,
    FOREIGN KEY (faculty_id) REFERENCES faculties(faculty_id),
    department_id INT,
    FOREIGN KEY (department_id) REFERENCES departments(department_id),
    name VARCHAR(100),
    surname VARCHAR(100),
    father_name VARCHAR(100),
    age INT
);