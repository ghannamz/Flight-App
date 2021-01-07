DROP TABLE IF EXISTS Airplane;

CREATE TABLE Airplane (
  id INT AUTO_INCREMENT PRIMARY KEY,
  model_name VARCHAR(250) NOT NULL,
  model_number VARCHAR(250) NOT NULL,
  capacity INT NOT NULL,
  manufacturer VARCHAR(250) NOT NULL
);

INSERT INTO Airplane (model_name, model_number, capacity, manufacturer) VALUES
  ('G-CIVY', '747-400', 200, 'British Airways'),
  ('C-GROV', 'A220-300', 300, 'GeminiJets Air Canada Airbus'),
  ('Boeing', '777-300ER', 250, 'Herpa Emirates');