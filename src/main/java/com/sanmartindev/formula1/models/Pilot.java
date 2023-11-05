package com.sanmartindev.formula1.models;


import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pilot")
public class Pilot implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String name;
    private String nationality;
    @Column(name = "car_number", unique = true)
    private Integer carNumber;

    @ManyToOne
    @JoinColumn(name = "id_team")
    private Team team;

    @OneToMany(mappedBy = "winner")
    private List<Race> racesWon = new ArrayList<>();

    public Pilot() {
    }

    public Pilot(Long id, String name, String nationality, Integer carNumber) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.carNumber = carNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(Integer carNumber) {
        this.carNumber = carNumber;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<Race> getRacesWon() {
        return racesWon;
    }

    public void setRacesWon(List<Race> racesWon) {
        this.racesWon = racesWon;
    }

}
