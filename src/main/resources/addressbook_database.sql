DROP DATABASE IF EXISTS addressbook;

CREATE DATABASE addressbook CHARSET = utf8 COLLATE = utf8_general_ci;
USE addressbook;


CREATE TABLE person (
  id INT NOT NULL AUTO_INCREMENT,
  name varchar(128) NOT NULL,
  PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE contact (
  id INT NOT NULL AUTO_INCREMENT,
  person_id INT NOT NULL,
  phone varchar(128) NOT NULL,
  email varchar(128) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_person_id FOREIGN KEY (person_id) REFERENCES person (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;



INSERT INTO person (name)
VALUES
    ("Janez Novak"),
    ("Nina Zupan"),
    ("Ana Petek");
    
INSERT INTO contact (person_id, phone, email)
VALUES
	(1, "+38641700700", "janez.novak@gmail.com"),
	(2, "+38631999666", "nina.zupan@gmail.com");