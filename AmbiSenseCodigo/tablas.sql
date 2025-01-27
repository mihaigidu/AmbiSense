-- Inserción de datos en la tabla variable
--INSERT INTO variable (name, unity) VALUES
--('Temperatura', 'Celsius'),
--('Humedad', 'Porcentaje'),
--('Presión', 'hPa');

-- Inserción de datos en la tabla lectura con relación a la tabla variable
INSERT INTO lectura (valor, date, id_variable) VALUES
(28.5, '2025-06-15 09:30:00', 1),
(30.5, '2025-06-15 10:30:00', 1),
(28.5, '2025-06-15 11:30:00', 1),
(32.5, '2025-06-15 12:30:00', 1);
