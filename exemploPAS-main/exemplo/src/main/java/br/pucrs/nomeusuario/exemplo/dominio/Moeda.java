package br.pucrs.nomeusuario.exemplo.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Moeda {
    @Id
    private long cod;
    private String nome;
    private String simbolo;
    private double cotacaoParaReal;
    
    protected Moeda() {
    }
    
    public Moeda(long cod, String nome, String simbolo, double cotacaoParaReal) {
        this.cod = cod;
        this.nome = nome;
        this.simbolo = simbolo;
        this.cotacaoParaReal = cotacaoParaReal;
    }

    public long getCod() {
        return cod;
    }

    public String getNome() {
        return nome;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public double getCotacaoParaReal() {
        return cotacaoParaReal;
    }
    
    public void setCod(long cod) {
        this.cod = cod;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public void setCotacaoParaReal(double cotacaoParaReal) {
        this.cotacaoParaReal = cotacaoParaReal;
    }

    public double converterParaReal(double valor) {
        return valor * cotacaoParaReal;
    }
}
