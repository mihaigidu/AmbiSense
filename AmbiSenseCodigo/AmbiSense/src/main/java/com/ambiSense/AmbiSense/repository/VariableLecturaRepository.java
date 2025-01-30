package com.ambiSense.AmbiSense.repository;

import com.ambiSense.AmbiSense.model.Lectura;
import com.ambiSense.AmbiSense.model.VariableLectura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariableLecturaRepository extends JpaRepository<VariableLectura, Integer> {
}
