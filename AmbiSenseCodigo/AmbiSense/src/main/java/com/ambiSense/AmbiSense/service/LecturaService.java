package com.ambiSense.AmbiSense.service;

import com.ambiSense.AmbiSense.model.Lectura;
import com.ambiSense.AmbiSense.model.Sensor;
import com.ambiSense.AmbiSense.model.VariableLectura;
import com.ambiSense.AmbiSense.repository.LecturaRepository;
import com.ambiSense.AmbiSense.repository.SensorRepository;
import com.ambiSense.AmbiSense.repository.VariableLecturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LecturaService {

    @Autowired
    private LecturaRepository lecturaRepository;

    @Autowired
    private SensorRepository sensorRepository;

    public void saveLecturaConId(Lectura lectura, Long sensorId) {
        Sensor sensor = sensorRepository.findById(sensorId).orElseThrow(() ->
                new RuntimeException("Sensor con ID " + sensorId + " no encontrado"));

        lectura.setSensor(sensor);

        if (lectura.getVariables() != null) {
            for (VariableLectura variable : lectura.getVariables()) {
                variable.setLectura(lectura);
            }
        }
        lecturaRepository.save(lectura);
    }
    public List<Lectura> findBySensorAndDay(Long sensorId, LocalDate date) {
        return lecturaRepository.findAll().stream()
                .filter(lectura -> lectura.getSensor().getId() == sensorId &&
                        lectura.getDateLectura().toLocalDate().equals(date))
                .collect(Collectors.toList());
    }


    public void saveLectura(Lectura lectura) {
        if (lectura.getVariables() != null) {
            for (VariableLectura variable : lectura.getVariables()) {
                variable.setLectura(lectura); //Asociamos cada variable a la lectura
            }
        }
        lecturaRepository.save(lectura);
    }

    public List<Lectura> findAll() {
        return lecturaRepository.findAll();
    }

}