--CREATE DATABASE dbappDB; (これは最初だけ行うから本来ならif分岐で存在チェックしてスキップできるといいかも)
USE dbappDB;

CREATE TABLE product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    count INT
);

INSERT INTO product (id, name, count) VALUES (2, 'second', 1);
