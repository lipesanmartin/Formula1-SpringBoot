package com.sanmartindev.formula1.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "corrida")
public class Corrida implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String circuito;
    private Integer voltas;

    @ManyToOne
    @JoinColumn(name = "vencedor_id")
    private Piloto vencedor;

    public Corrida() {
    }

    public Corrida(Long id, String nome, String circuito, Integer voltas) {
        this.id = id;
        this.nome = nome;
        this.circuito = circuito;
        this.voltas = voltas;
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

    public String getCircuito() {
        return circuito;
    }

    public void setCircuito(String circuito) {
        this.circuito = circuito;
    }

    public Integer getVoltas() {
        return voltas;
    }

    public void setVoltas(Integer voltas) {
        this.voltas = voltas;
    }

    public Piloto getVencedor() {
        return vencedor;
    }

    public void setVencedor(Piloto vencedor) {
        this.vencedor = vencedor;
    }

}
