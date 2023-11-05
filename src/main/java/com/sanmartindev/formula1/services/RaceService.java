package com.sanmartindev.formula1.services;

import com.sanmartindev.formula1.models.Race;
import com.sanmartindev.formula1.repositories.RaceRepository;
import com.sanmartindev.formula1.services.exceptions.DatabaseException;
import com.sanmartindev.formula1.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceService {

    private final RaceRepository repo;

    @Autowired
    public RaceService(RaceRepository repo) {
        this.repo = repo;
    }

    public List<Race> findAll() {
        return repo.findAll();
    }

    public Race findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Corrida não encontrada"));
    }

    public Race create(Race race) {
        return repo.save(race);
    }

    public Race update(Long id, Race obj) {
        Race entity = repo.getReferenceById(id);
        entity.setName(obj.getName());
        entity.setTrack(obj.getTrack());
        entity.setLaps(obj.getLaps());
        entity.setWinner(obj.getWinner());
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