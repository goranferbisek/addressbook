CREATE DATABASE IF NOT EXISTS addressbook;
USE addressbook;


CREATE TABLE person (
  id INT NOT NULL AUTO_INCREMENT,
  name varchar(128) NOT NULL,
  PRIMARY KEY (id)
);



INSERT INTO person (name)
VALUES
    ("Janez Novak"),
    ("Nina Zupan"),
    ("Ana Petek");