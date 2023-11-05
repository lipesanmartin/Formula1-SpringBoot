package com.sanmartindev.formula1.resources;

import com.sanmartindev.formula1.models.Team;
import com.sanmartindev.formula1.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/equipes")
public class TeamResource {

    private final TeamService service;

    @Autowired
    public TeamResource(TeamService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Team>> findAll() {
        List<Team> teams = service.findAll();
        return ResponseEntity.ok().body(teams);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Team> findById(@PathVariable Long id) {
        Team team = service.findById(id);
        return ResponseEntity.ok().body(team);
    }

    @PostMapping
    public ResponseEntity<Team> create(@RequestBody Team team) {
        Team teamCriada = service.create(team);
        return ResponseEntity.ok().body(teamCriada);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Team> update(@PathVariable Long id, @RequestBody Team team) {
        team = service.update(id, team);
        return ResponseEntity.ok().body(team);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
