package com.sanmartindev.formula1.services;

import com.sanmartindev.formula1.models.Team;
import com.sanmartindev.formula1.repositories.TeamRepository;
import com.sanmartindev.formula1.services.exceptions.DatabaseException;
import com.sanmartindev.formula1.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final TeamRepository repo;

    @Autowired
    public TeamService(TeamRepository repo) {
        this.repo = repo;
    }

    public List<Team> findAll() {
        return repo.findAll();
    }

    public Team findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Equipe não encontrada"));
    }

    public Team create(Team team) {
        return repo.save(team);
    }

    @Transactional
    public Team update(Long id, Team obj) {
        try {
            Team entity = repo.getReferenceById(id);
            entity.setName(obj.getName());
            entity.setNationality(obj.getNationality());
            entity.setTeamPrincipal(obj.getTeamPrincipal());
            return repo.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }

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
