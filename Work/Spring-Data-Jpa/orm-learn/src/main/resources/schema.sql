create table country( co_code varchar(2) primary key, co_name varchar(50));
 CREATE TABLE IF NOT EXISTS `ormlearn`.`stock` (
  `st_id` INT NOT NULL AUTO_INCREMENT,   `st_code` varchar(10),    `st_date` date,   `st_open` numeric(10,2),
  `st_close` numeric(10,2),    `st_volume` numeric,   PRIMARY KEY (`st_id`) );
CREATE TABLE department (
    dp_id INT AUTO_INCREMENT PRIMARY KEY,
    dp_name VARCHAR(45) NOT NULL
);

CREATE TABLE skill (
    sk_id INT AUTO_INCREMENT PRIMARY KEY,
    sk_name VARCHAR(45) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE employee (
    em_id INT AUTO_INCREMENT PRIMARY KEY,
    em_name VARCHAR(45) NOT NULL,
    em_salary DECIMAL(10,2),
    em_permanent TINYINT(1) NOT NULL,
    em_date_of_birth DATE,
    em_dp_id INT NOT NULL,

    CONSTRAINT fk_employee_department
        FOREIGN KEY (em_dp_id)
        REFERENCES department(dp_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
) ENGINE=InnoDB;

CREATE TABLE employee_skill (
    es_em_id INT NOT NULL,
    es_sk_id INT NOT NULL,

    PRIMARY KEY (es_em_id, es_sk_id),

    CONSTRAINT fk_employee_skill_employee
        FOREIGN KEY (es_em_id)
        REFERENCES employee(em_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    CONSTRAINT fk_employee_skill_skill
        FOREIGN KEY (es_sk_id)
        REFERENCES skill(sk_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
) ENGINE=InnoDB;

-- CREATE TABLE user(
--     us_id int PRIMARY KEY,
--     us_name VARCHAR(45),
--     us_email VARCHAR(45)
-- );

-- CREATE TABLE attempt(
--     at_id int PRIMARY KEY,
--     at_date DATE,
--     at_us_id 
-- );
-- ===============================
-- INSERT STATEMENTS FOR ALL TABLES
-- ===============================

-- -------------------------------
-- DEPARTMENT TABLE
-- -------------------------------
INSERT INTO department (dp_id, dp_name) VALUES (1, 'Engineering');
INSERT INTO department (dp_id, dp_name) VALUES (2, 'Human Resources');
INSERT INTO department (dp_id, dp_name) VALUES (3, 'Finance');

-- -------------------------------
-- EMPLOYEE TABLE
-- em_dp_id → FK to department.dp_id
-- -------------------------------
INSERT INTO employee (em_id, em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id)
VALUES (101, 'Amit Sharma', 75000.00, true, '1998-04-15', 1);

INSERT INTO employee (em_id, em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id)
VALUES (102, 'Neha Verma', 68000.00, false, '1999-08-21', 1);

INSERT INTO employee (em_id, em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id)
VALUES (103, 'Rahul Das', 62000.00, true, '1997-01-10', 2);

INSERT INTO employee (em_id, em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id)
VALUES (104, 'Sneha Roy', 70000.00, true, '1996-11-05', 3);

-- -------------------------------
-- SKILL TABLE
-- -------------------------------
INSERT INTO skill (sk_id, sk_name) VALUES (201, 'Java');
INSERT INTO skill (sk_id, sk_name) VALUES (202, 'Spring Boot');
INSERT INTO skill (sk_id, sk_name) VALUES (203, 'Hibernate');
INSERT INTO skill (sk_id, sk_name) VALUES (204, 'SQL');

-- -------------------------------
-- EMPLOYEE_SKILL JOIN TABLE
-- es_em_id → employee.em_id
-- es_sk_id → skill.sk_id
-- -------------------------------
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (101, 201);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (101, 202);

INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (102, 201);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (102, 204);

INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (103, 203);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (104, 201);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (104, 202);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (104, 203);
