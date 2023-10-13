package com.sanmartindev.formula1.init;

import com.sanmartindev.formula1.models.Equipe;
import com.sanmartindev.formula1.models.Piloto;
import com.sanmartindev.formula1.repositories.EquipeRepository;
import com.sanmartindev.formula1.repositories.PilotoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DatabaseInitializer {

    private final EquipeRepository equipeRepository;
    private final PilotoRepository pilotoRepository;

    @Autowired
    public DatabaseInitializer(EquipeRepository equipeRepository, PilotoRepository pilotoRepository) {
        this.equipeRepository = equipeRepository;
        this.pilotoRepository = pilotoRepository;
    }

    @PostConstruct
    public void init() {
        Equipe equipe1 = new Equipe(null, "Mercedes", "Alemanha", "Toto Wolff");
        Equipe equipe2 = new Equipe(null, "Red Bull", "Austria", "Christian Horner");
        Equipe equipe3 = new Equipe(null, "McLaren", "Inglaterra", "Zak Brown");
        Equipe equipe4 = new Equipe(null, "Ferrari", "Italia", "Mattia Binotto");
        equipeRepository.saveAll(Arrays.asList(equipe1, equipe2, equipe3, equipe4));

        Piloto piloto1 = new Piloto(null, "Lewis Hamilton", "Inglaterra", 44);
        Piloto piloto2 = new Piloto(null, "Max Verstappen", "Holanda", 33);
        Piloto piloto3 = new Piloto(null, "Lando Norris", "Inglaterra", 4);
        Piloto piloto4 = new Piloto(null, "Carlos Sainz", "Espanha", 55);
        Piloto piloto5 = new Piloto(null, "Charles Leclerc", "Monaco", 16);
        pilotoRepository.saveAll(Arrays.asList(piloto1, piloto2, piloto3, piloto4, piloto5));
    }
}
