package com.sanmartindev.formula1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "equipe")
public class Equipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipe")
    private Long idEquipe;
    private String nome;
    private String nacionalidade;
    private String chefe;

    @JsonIgnore
    @OneToMany(mappedBy = "equipe")
    private List<Piloto> pilotos = new ArrayList<>();


    public Equipe() {
    }

    public Equipe(Long idEquipe, String nome, String nacionalidade, String chefe) {
        this.idEquipe = idEquipe;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.chefe = chefe;
    }

    public Long getId() {
        return idEquipe;
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

    public String getChefe() {
        return chefe;
    }

    public void setChefe(String chefe) {
        this.chefe = chefe;
    }

    public List<Piloto> getPilotos() {
        return pilotos;
    }

    public void addPilotos(Piloto piloto) {
        pilotos.add(piloto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipe equipe = (Equipe) o;
        return Objects.equals(idEquipe, equipe.idEquipe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEquipe);
    }

    @Override
    public String toString() {
        return "Equipe{" +
                "idEquipe=" + idEquipe +
                ", nome='" + nome + '\'' +
                ", nacionalidade='" + nacionalidade + '\'' +
                ", chefe='" + chefe + '\'' +
                '}';
    }
}
