DROP TABLE IF EXISTS Boarding;

CREATE TABLE Boarding (
  id INT AUTO_INCREMENT PRIMARY KEY,
  flight_id INT NOT NULL,
  passenger_id INT NOT NULL,
  ticket_id INT NOT NULL,
  gate VARCHAR(250) NOT NULL,
  baggage_id VARCHAR(250) NOT NULL,
  has_checked_in BOOLEAN NOT NULL
);

INSERT INTO Boarding (flight_id, passenger_id, ticket_id, gate, baggage_id, has_checked_in) VALUES
  (1, 1, 1, 'A20', 'B1234', TRUE),
  (2, 2, 2, 'D45', 'B8520', TRUE),
  (3, 3, 3, 'C90', 'B7451', FALSE);