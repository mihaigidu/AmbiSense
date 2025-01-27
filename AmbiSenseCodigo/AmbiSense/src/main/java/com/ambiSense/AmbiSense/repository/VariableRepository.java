package com.ambiSense.AmbiSense.repository;

import com.ambiSense.AmbiSense.model.Variable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariableRepository extends JpaRepository<Variable, Integer> {
}
