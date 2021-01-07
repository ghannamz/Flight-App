DROP TABLE IF EXISTS Flight;

CREATE TABLE Flight (
  id INT AUTO_INCREMENT PRIMARY KEY,
  departure_date VARCHAR(250) NOT NULL,
  departure_time VARCHAR(250) NOT NULL,
  arrival_date VARCHAR(250) NOT NULL,
  arrival_time VARCHAR(250) NOT NULL,
  source_id INT NOT NULL,
  destination_id INT NOT NULL,
  plane_id INT NOT NULL
);

INSERT INTO Flight (departure_date, departure_time, arrival_date, arrival_time, source_id, destination_id, plane_id) VALUES
  ('2017-11-15', '15:30:14', '2017-11-15', '18:30:15', 100, 101, 1),
  ('2018-10-23', '10:30:14', '2018-10-23', '15:30:15', 200, 201, 2),
  ('2019-09-14', '08:30:14', '2019-09-14', '16:30:15', 300, 301, 3);