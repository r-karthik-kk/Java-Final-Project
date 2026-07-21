CREATE TABLE IF NOT EXISTS client_types (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,


    type_name VARCHAR(50) NOT NULL UNIQUE,


    badge_color VARCHAR(20) NOT NULL,


    status ENUM(
        'ACTIVE',
        'INACTIVE'
    ) DEFAULT 'ACTIVE',


    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,


    updated_at TIMESTAMP 
    DEFAULT CURRENT_TIMESTAMP
    ON UPDATE CURRENT_TIMESTAMP

);





CREATE TABLE IF NOT EXISTS clients (


    id BIGINT AUTO_INCREMENT PRIMARY KEY,


    client_id VARCHAR(30) NOT NULL UNIQUE,


    name VARCHAR(150) NOT NULL,


    email VARCHAR(150) NOT NULL UNIQUE,


    password VARCHAR(255) NOT NULL,


    mobile_number VARCHAR(15),



    client_type_id BIGINT NOT NULL,


    status ENUM(
        'ACTIVE',
        'INACTIVE'
    ) DEFAULT 'ACTIVE',



    about TEXT,



    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,


    updated_at TIMESTAMP 
    DEFAULT CURRENT_TIMESTAMP
    ON UPDATE CURRENT_TIMESTAMP,



    CONSTRAINT fk_client_type

    FOREIGN KEY(client_type_id)

    REFERENCES client_types(id)

);