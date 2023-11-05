package com.sanmartindev.formula1.services;

import com.sanmartindev.formula1.models.Pilot;
import com.sanmartindev.formula1.repositories.PilotRepository;
import com.sanmartindev.formula1.services.exceptions.DatabaseException;
import com.sanmartindev.formula1.services.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PilotService {

    public final PilotRepository repo;

    @Autowired
    public PilotService(PilotRepository repo) {
        this.repo = repo;
    }

    public List<Pilot> findAll() {
        return repo.findAll();
    }

    public Pilot findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Piloto não encontrado"));
    }

    public Pilot create(Pilot pilot) {
        return repo.save(pilot);
    }

    @Transactional
    public Pilot update(Long id, Pilot obj) {
        Pilot entity = repo.getReferenceById(id);
        entity.setName(obj.getName());
        entity.setNationality(obj.getNationality());
        entity.setCarNumber(obj.getCarNumber());
        entity.setTeam(obj.getTeam());
        return repo.save(entity);
    }

    public void delete(Long id) {
        try {
            repo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
