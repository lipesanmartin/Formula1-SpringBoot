package com.sanmartindev.formula1.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "race")
public class Race implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String track;
    private Integer laps;

    @ManyToOne
    @JoinColumn(name = "winner_id")
    private Pilot winner;

    public Race() {
    }

    public Race(Long id, String name, String track, Integer laps) {
        this.id = id;
        this.name = name;
        this.track = track;
        this.laps = laps;
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

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public Integer getLaps() {
        return laps;
    }

    public void setLaps(Integer laps) {
        this.laps = laps;
    }

    public Pilot getWinner() {
        return winner;
    }

    public void setWinner(Pilot winner) {
        this.winner = winner;
    }

}
