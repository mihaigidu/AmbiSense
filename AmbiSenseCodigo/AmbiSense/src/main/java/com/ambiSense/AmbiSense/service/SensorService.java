package com.ambiSense.AmbiSense.service;

import com.ambiSense.AmbiSense.model.Sensor;
import com.ambiSense.AmbiSense.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    // Obtener todos los sensores
    public List<Sensor> findAll() {
        return sensorRepository.findAll();
    }

    // Buscar sensor por ID
    public Optional<Sensor> findById(Long id) {
        return sensorRepository.findById(id);
    }

    // Guardar un nuevo sensor
    public Sensor save(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    // Eliminar sensor por ID
    public void deleteById(Long id) {
        sensorRepository.deleteById(id);
    }
}
