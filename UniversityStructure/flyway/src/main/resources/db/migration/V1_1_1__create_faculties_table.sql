CREATE TABLE IF NOT EXISTS faculties (
    faculty_id SERIAL PRIMARY KEY,
    faculty_name VARCHAR(100) NOT NULL,
    university_id INT,
    FOREIGN KEY (university_id) REFERENCES universities(university_id)
);
