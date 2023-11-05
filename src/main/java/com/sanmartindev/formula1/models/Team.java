package com.sanmartindev.formula1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "team")
public class Team implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;
    private String name;
    private String nationality;
    private String teamPrincipal;

    @JsonIgnore
    @OneToMany(mappedBy = "team")
    private List<Pilot> pilots = new ArrayList<>();


    public Team() {
    }

    public Team(Long id, String name, String nationality, String teamPrincipal) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.teamPrincipal = teamPrincipal;
    }

    public Long getId() {
        return id;
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

    public String getTeamPrincipal() {
        return teamPrincipal;
    }

    public void setTeamPrincipal(String teamPrincipal) {
        this.teamPrincipal = teamPrincipal;
    }

    public List<Pilot> getPilots() {
        return pilots;
    }

    public void addPilots(Pilot pilot) {
        pilots.add(pilot);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(id, team.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
