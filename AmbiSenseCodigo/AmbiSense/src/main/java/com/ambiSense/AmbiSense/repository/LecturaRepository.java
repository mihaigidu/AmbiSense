package com.ambiSense.AmbiSense.repository;

import com.ambiSense.AmbiSense.model.Lectura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LecturaRepository extends JpaRepository<Lectura, Integer> {

}
