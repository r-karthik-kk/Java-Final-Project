CREATE TABLE students (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    student_id VARCHAR(20) NOT NULL UNIQUE,

    name VARCHAR(100) NOT NULL,

    email VARCHAR(150) NOT NULL UNIQUE,

    mobile_number VARCHAR(15),

    department_id VARCHAR(20) NOT NULL,

    passing_year INT NOT NULL,

    about TEXT,

    password VARCHAR(255) NOT NULL,

    status ENUM(
        'ACTIVE',
        'INACTIVE'
    ) DEFAULT 'ACTIVE',


    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    ON UPDATE CURRENT_TIMESTAMP,


    CONSTRAINT fk_student_department

    FOREIGN KEY(department_id)

    REFERENCES departments(department_id)

);