package com.ambiSense.AmbiSense.service;

import com.ambiSense.AmbiSense.model.Lectura;
import com.ambiSense.AmbiSense.model.VariableLectura;
import com.ambiSense.AmbiSense.repository.LecturaRepository;
import com.ambiSense.AmbiSense.repository.VariableLecturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LecturaService {

    @Autowired
    private LecturaRepository lecturaRepository;

    public void saveLectura(Lectura lectura) {
        if (lectura.getVariables() != null) {
            for (VariableLectura variable : lectura.getVariables()) {
                variable.setLectura(lectura); // 🔹 Asociamos cada variable a la lectura
            }
        }
        lecturaRepository.save(lectura);
    }

    public List<Lectura> findAll() {
        return lecturaRepository.findAll();
    }
}