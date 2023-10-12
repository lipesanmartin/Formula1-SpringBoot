package com.sanmartindev.formula1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "equipe")
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "equipe_id")
    private Long id;
    private String nome;
    private String nacionalidade;
    @Column(name = "chefe_equipe")
    private String chefeEquipe;

    @JsonIgnore
    @OneToMany(mappedBy = "piloto_id")
    private List<Piloto> pilotos = new ArrayList<>();

    public Equipe() {
    }

    public Equipe(Long id, String nome, String nacionalidade, String chefeEquipe) {
        this.id = id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.chefeEquipe = chefeEquipe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getChefeEquipe() {
        return chefeEquipe;
    }

    public void setChefeEquipe(String chefeEquipe) {
        this.chefeEquipe = chefeEquipe;
    }

    public List<Piloto> getPilotos() {
        return pilotos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipe equipe = (Equipe) o;
        return Objects.equals(id, equipe.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
