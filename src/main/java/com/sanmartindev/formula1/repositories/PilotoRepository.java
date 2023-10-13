package com.sanmartindev.formula1.repositories;

import com.sanmartindev.formula1.models.Piloto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PilotoRepository extends JpaRepository<Piloto, Long> {
}
