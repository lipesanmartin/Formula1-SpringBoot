package com.sanmartindev.formula1.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "piloto")
public class Piloto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String nacionalidade;
    @Column(name = "numero_carro", unique = true)
    private Integer numCarro;

    @JoinColumn(name = "id_equipe")
    private Long idEquipe;


    public Piloto() {
    }

    public Piloto(Long id, String nome, String nacionalidade, Integer numCarro) {
        this.id = id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.numCarro = numCarro;
    }


    public Long getId() {
        return id;
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

    public Integer getNumCarro() {
        return numCarro;
    }

    public void setNumCarro(Integer numCarro) {
        this.numCarro = numCarro;
    }

    public Long getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(Long idEquipe) {
        this.idEquipe = idEquipe;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piloto piloto = (Piloto) o;
        return Objects.equals(id, piloto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
