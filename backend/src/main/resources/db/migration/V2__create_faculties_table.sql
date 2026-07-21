CREATE TABLE IF NOT EXISTS faculty (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    faculty_id VARCHAR(20) NOT NULL UNIQUE,

    name VARCHAR(100) NOT NULL,

    email VARCHAR(150) NOT NULL UNIQUE,

    mobile_number VARCHAR(15),

    password VARCHAR(255) NOT NULL,

    department_id BIGINT NOT NULL,

    status ENUM(
        'ACTIVE',
        'INACTIVE'
    ) DEFAULT 'ACTIVE',

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    ON UPDATE CURRENT_TIMESTAMP,


    CONSTRAINT fk_faculty_department

    FOREIGN KEY(department_id)

    REFERENCES departments(id)

    ON DELETE RESTRICT

);