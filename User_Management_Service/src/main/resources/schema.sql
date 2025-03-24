CREATE TABLE UMS_USER_INFO (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(45) NOT NULL,
    last_name VARCHAR(45) NOT NULL,
    email VARCHAR(45) NOT NULL,
    username VARCHAR(45) NOT NULL,
    is_active BOOLEAN NOT NULL,
    address MEDIUMTEXT NOT NULL,
    pincode INT NOT NULL,
    CONSTRAINT unique_email UNIQUE (email),
    CONSTRAINT unique_username UNIQUE (username)
);
