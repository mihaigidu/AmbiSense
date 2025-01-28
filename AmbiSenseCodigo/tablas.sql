CREATE TABLE alerta (
    id SERIAL PRIMARY KEY,
    sensor_id BIGINT NOT NULL,
    variable_id BIGINT NOT NULL,
    valor DOUBLE PRECISION NOT NULL,
    umbral DOUBLE PRECISION NOT NULL,
    fecha_hora TIMESTAMP NOT NULL,
    estado VARCHAR(255),
    observaciones VARCHAR(255),
    CONSTRAINT fk_alerta_sensor FOREIGN KEY (sensor_id) REFERENCES sensor(id) ON DELETE CASCADE,
    CONSTRAINT fk_alerta_variable FOREIGN KEY (variable_id) REFERENCES variable(id) ON DELETE CASCADE
);
