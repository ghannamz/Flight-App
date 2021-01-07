DROP TABLE IF EXISTS Ticket;

CREATE TABLE Ticket (
  id INT AUTO_INCREMENT PRIMARY KEY,
  passenger_id INT NOT NULL,
  flight_id INT NOT NULL,
  source_id INT NOT NULL,
  destination_id INT NOT NULL,
  price DOUBLE NOT NULL
);

INSERT INTO Ticket (passenger_id, flight_id, source_id, destination_id, price) VALUES
  (1, 1, 100, 101, 590.00),
  (2, 2, 200, 201, 720.00),
  (3, 3, 300, 301, 450.00);