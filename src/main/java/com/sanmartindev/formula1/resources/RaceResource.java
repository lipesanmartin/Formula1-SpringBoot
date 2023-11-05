package com.sanmartindev.formula1.resources;

import com.sanmartindev.formula1.models.Race;
import com.sanmartindev.formula1.services.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/corridas")
public class RaceResource {

    private final RaceService service;

    @Autowired
    public RaceResource(RaceService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Race>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Race> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Race> create(@RequestBody Race race) {
        return ResponseEntity.ok().body(service.create(race));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Race> update(@PathVariable Long id, @RequestBody Race race) {
        return ResponseEntity.ok().body(service.update(id, race));
    }
}
