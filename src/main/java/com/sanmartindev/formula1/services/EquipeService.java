package com.sanmartindev.formula1.services;

import com.sanmartindev.formula1.models.Equipe;
import com.sanmartindev.formula1.repositories.EquipeRepository;
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
public class EquipeService {

    private final EquipeRepository repo;

    @Autowired
    public EquipeService(EquipeRepository repo) {
        this.repo = repo;
    }

    public List<Equipe> findAll() {
        return repo.findAll();
    }

    public Equipe findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Equipe não encontrada"));
    }

    public Equipe criarEquipe(Equipe equipe) {
        return repo.save(equipe);
    }

    @Transactional
    public Equipe atualizarEquipe(Long id, Equipe obj) {
        try {
            Equipe entity = repo.getReferenceById(id);
            entity.setNome(obj.getNome());
            entity.setNacionalidade(obj.getNacionalidade());
            entity.setChefe(obj.getChefe());
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
