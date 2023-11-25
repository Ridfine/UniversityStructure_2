CREATE TABLE IF NOT EXISTS groups (
    group_id SERIAL PRIMARY KEY,
    faculty_id INT,
    FOREIGN KEY (faculty_id) REFERENCES faculties(faculty_id),
    headman_student_id INT
);
