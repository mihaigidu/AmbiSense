package com.ambiSense.AmbiSense.service;

import com.ambiSense.AmbiSense.model.Sensor;
import com.ambiSense.AmbiSense.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    public List<Sensor> findAll(){return sensorRepository.findAll();}
}
