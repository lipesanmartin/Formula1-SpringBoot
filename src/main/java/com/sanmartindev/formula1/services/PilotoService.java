package com.sanmartindev.formula1.services;

import com.sanmartindev.formula1.models.Piloto;
import com.sanmartindev.formula1.repositories.PilotoRepository;
import com.sanmartindev.formula1.services.exceptions.DatabaseException;
import com.sanmartindev.formula1.services.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PilotoService {

    public final PilotoRepository repo;

    @Autowired
    public PilotoService(PilotoRepository repo) {
        this.repo = repo;
    }

    public List<Piloto> findAll() {
        return repo.findAll();
    }

    public Piloto findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Piloto não encontrado"));
    }

    public Piloto create(Piloto piloto) {
        return repo.save(piloto);
    }

    @Transactional
    public Piloto update(Long id, Piloto obj) {
        Piloto entity = repo.getReferenceById(id);
        entity.setNome(obj.getNome());
        entity.setNacionalidade(obj.getNacionalidade());
        entity.setNumCarro(obj.getNumCarro());
        entity.setEquipe(obj.getEquipe());
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
