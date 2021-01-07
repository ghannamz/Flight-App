DROP TABLE IF EXISTS Passenger;

CREATE TABLE Passenger (
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email_address VARCHAR(250) NOT NULL,
  phone_number VARCHAR(250) NOT NULL
);

INSERT INTO Passenger (first_name, last_name, email_address, phone_number) VALUES
  ('Adam', 'Dangote', 'adam.dangote@gmail.com', '12334536'),
  ('Bill', 'Gates', 'bill.gates@gmail.com', '986582635'),
  ('Albert', 'Alakija', 'albert.alakija@gmail.com', '098355561');