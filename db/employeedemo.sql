-- Etape 1.6 : schema + table employe + quelques lignes
CREATE DATABASE IF NOT EXISTS employeedemo;
USE employeedemo;

CREATE TABLE IF NOT EXISTS employe (
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age  INT
);

INSERT INTO employe (id, name, age) VALUES
    (1, 'Alaoui', 30),
    (2, 'Bennani', 28),
    (3, 'Tazi', 41),
    (10, 'Benali', 25);
