package com.ambiSense.AmbiSense.service;

import com.ambiSense.AmbiSense.model.Variable;
import com.ambiSense.AmbiSense.repository.VariableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VariableService {
    @Autowired
    private VariableRepository variableRepository;

    public List<Variable> findAll() {return variableRepository.findAll();}
}
