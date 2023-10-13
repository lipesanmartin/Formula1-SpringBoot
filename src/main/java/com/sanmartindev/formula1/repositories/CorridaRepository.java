package com.sanmartindev.formula1.repositories;

import com.sanmartindev.formula1.models.Corrida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorridaRepository extends JpaRepository<Corrida, Long> {
}
