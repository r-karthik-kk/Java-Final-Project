CREATE TABLE IF NOT EXISTS departments (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    department_id VARCHAR(20) NOT NULL UNIQUE,

    department_name VARCHAR(100) NOT NULL,

    email VARCHAR(150) NOT NULL UNIQUE,

    mobile_number VARCHAR(15),

    password VARCHAR(255) NOT NULL,

    status ENUM(
        'ACTIVE',
        'INACTIVE'
    ) DEFAULT 'ACTIVE',

    created_at TIMESTAMP
        DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP
        DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP

);