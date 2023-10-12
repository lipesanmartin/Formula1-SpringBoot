package com.sanmartindev.formula1.models;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "piloto")
public class Piloto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "piloto_id")
    private Long id;

    private String nome;
    private String nacionalidade;
    private Integer numCarro;

    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;


    public Piloto() {
    }

    public Piloto(Long idPiloto, String nome, String nacionalidade, Integer numCarro) {
        this.id = idPiloto;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.numCarro = numCarro;
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

    public Integer getNumCarro() {
        return numCarro;
    }

    public void setNumCarro(Integer numCarro) {
        this.numCarro = numCarro;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
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
