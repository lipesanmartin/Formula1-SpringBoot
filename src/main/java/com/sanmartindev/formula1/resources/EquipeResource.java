package com.sanmartindev.formula1.resources;

import com.sanmartindev.formula1.models.Equipe;
import com.sanmartindev.formula1.services.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/equipes")
public class EquipeResource {

    private final EquipeService service;

    @Autowired
    public EquipeResource(EquipeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Equipe>> findAll() {
        List<Equipe> equipes = service.findAll();
        return ResponseEntity.ok().body(equipes);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Equipe> findById(@PathVariable Long id) {
        Equipe equipe = service.findById(id);
        return ResponseEntity.ok().body(equipe);
    }

    @PostMapping
    public ResponseEntity<Equipe> create(@RequestBody Equipe equipe) {
        Equipe equipeCriada = service.create(equipe);
        return ResponseEntity.ok().body(equipeCriada);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Equipe> update(@PathVariable Long id, @RequestBody Equipe equipe) {
        equipe = service.update(id, equipe);
        return ResponseEntity.ok().body(equipe);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
