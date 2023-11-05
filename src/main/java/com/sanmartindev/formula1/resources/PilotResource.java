package com.sanmartindev.formula1.resources;

import com.sanmartindev.formula1.models.Pilot;
import com.sanmartindev.formula1.services.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pilotos")
public class PilotResource {

    public final PilotService service;

    @Autowired
    public PilotResource(PilotService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Pilot>> findAll() {
        List<Pilot> pilots = service.findAll();
        return ResponseEntity.ok().body(pilots);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pilot> findById(@PathVariable Long id) {
        Pilot pilot = service.findById(id);
        return ResponseEntity.ok().body(pilot);
    }

    @PostMapping
    public ResponseEntity<Pilot> create(@RequestBody Pilot pilot) {
        Pilot pilotCriado = service.create(pilot);
        return ResponseEntity.ok().body(pilotCriado);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Pilot> update(@PathVariable Long id, @RequestBody Pilot pilot) {
        pilot = service.update(id, pilot);
        return ResponseEntity.ok().body(pilot);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
