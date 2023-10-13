package com.sanmartindev.formula1.resources;

import com.sanmartindev.formula1.models.Piloto;
import com.sanmartindev.formula1.services.PilotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pilotos")
public class PilotoResource {

    public final PilotoService service;

    @Autowired
    public PilotoResource(PilotoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Piloto>> findAll() {
        List<Piloto> pilotos = service.findAll();
        return ResponseEntity.ok().body(pilotos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Piloto> findById(@PathVariable Long id) {
        Piloto piloto = service.findById(id);
        return ResponseEntity.ok().body(piloto);
    }

    @PostMapping
    public ResponseEntity<Piloto> create(@RequestBody Piloto piloto) {
        Piloto pilotoCriado = service.create(piloto);
        return ResponseEntity.ok().body(pilotoCriado);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Piloto> update(@PathVariable Long id, @RequestBody Piloto piloto) {
        piloto = service.update(id, piloto);
        return ResponseEntity.ok().body(piloto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
