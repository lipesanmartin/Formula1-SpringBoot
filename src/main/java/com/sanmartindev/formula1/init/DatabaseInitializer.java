package com.sanmartindev.formula1.init;

import com.sanmartindev.formula1.models.Team;
import com.sanmartindev.formula1.models.Pilot;
import com.sanmartindev.formula1.repositories.TeamRepository;
import com.sanmartindev.formula1.repositories.PilotRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DatabaseInitializer {

    private final TeamRepository teamRepository;
    private final PilotRepository pilotRepository;

    @Autowired
    public DatabaseInitializer(TeamRepository teamRepository, PilotRepository pilotRepository) {
        this.teamRepository = teamRepository;
        this.pilotRepository = pilotRepository;
    }

    @PostConstruct
    public void init() {
        Team team1 = new Team(null, "Mercedes", "Alemanha", "Toto Wolff");
        Team team2 = new Team(null, "Red Bull", "Austria", "Christian Horner");
        Team team3 = new Team(null, "McLaren", "Inglaterra", "Zak Brown");
        Team team4 = new Team(null, "Ferrari", "Italia", "Mattia Binotto");
        teamRepository.saveAll(Arrays.asList(team1, team2, team3, team4));

        Pilot pilot1 = new Pilot(null, "Lewis Hamilton", "Inglaterra", 44);
        Pilot pilot2 = new Pilot(null, "Max Verstappen", "Holanda", 33);
        Pilot pilot3 = new Pilot(null, "Lando Norris", "Inglaterra", 4);
        Pilot pilot4 = new Pilot(null, "Carlos Sainz", "Espanha", 55);
        Pilot pilot5 = new Pilot(null, "Charles Leclerc", "Monaco", 16);
        pilotRepository.saveAll(Arrays.asList(pilot1, pilot2, pilot3, pilot4, pilot5));
    }
}
