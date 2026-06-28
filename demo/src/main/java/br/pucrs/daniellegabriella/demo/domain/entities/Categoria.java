package br.pucrs.daniellegabriella.demo.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Categoria {

    @Id
    private Long num;

    private String nome;
    
    private Double valorMinimo;

    @OneToMany(mappedBy = "categoria")
    private List<Jogo> jogos = new ArrayList<>();

    public Categoria() {
    }

    public Categoria(Long num, String nome, Double valorMinimo) {
        this.num = num;
        this.nome = nome;
        this.valorMinimo = valorMinimo;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(Double valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }
}