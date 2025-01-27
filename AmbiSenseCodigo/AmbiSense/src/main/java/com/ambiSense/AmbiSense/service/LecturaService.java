package com.ambiSense.AmbiSense.service;

import com.ambiSense.AmbiSense.model.Lectura;
import com.ambiSense.AmbiSense.repository.LecturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LecturaService {

    @Autowired
    private LecturaRepository lecturaRepository;

    public List<Lectura> findAll() {return lecturaRepository.findAll();}
}
