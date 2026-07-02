package br.pucrs.nomeusuario.exemplo.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Categoria {

    @Id
    private long num;

    private String nome;

    private double valorMinimo;

    protected Categoria() {
    }

    public Categoria(long num, String nome, double valorMinimo) {
        this.num = num;
        this.nome = nome;
        this.valorMinimo = valorMinimo;
    }

    public long getNum() {
        return num;
    }

    public String getNome() {
        return nome;
    }

    public double getValorMinimo() {
        return valorMinimo;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValorMinimo(double valorMinimo) {
        this.valorMinimo = valorMinimo;
    }
}