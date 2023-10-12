package com.sanmartindev.formula1.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "corrida")
public class Corrida {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String circuito;
    private Integer voltas;
    @ManyToOne
    @JoinColumn(name = "vencedor_piloto_id")
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

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Corrida corrida = (Corrida) o;
        return Objects.equals(id, corrida.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
