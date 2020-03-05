DROP TABLE IF EXISTS employee;
 
CREATE TABLE employee(
  id INT AUTO_INCREMENT  PRIMARY KEY,
  fname VARCHAR(250) NOT NULL,
  lname VARCHAR(250) NOT NULL,
  gender VARCHAR(20),
  dob VARCHAR(20),
  department VARCHAR(50)
);
 
--INSERT INTO employee (fname, lname, salary) VALUES
  --('Aliko', 'Dangote', 20000),
  --('Bill', 'Gates', 30000),
  --('Folrunsho', 'Alakija', 40000);