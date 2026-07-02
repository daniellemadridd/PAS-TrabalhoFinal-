package br.pucrs.nomeusuario.exemplo.dominio;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Jogo {
@Id
private long codigo;

private String nome;

private int ano;

private double valorMinuto;

@ManyToOne
private Categoria categoria;

@ManyToOne
private Moeda moeda;

@Enumerated(EnumType.STRING)
private StatusJogo status;

@Temporal(TemporalType.DATE)
private Date dataObsoleto;

    protected Jogo() {
    }

    public Jogo(long codigo, String nome, int ano, double valorMinuto, Categoria categoria, Moeda moeda) {
        this.codigo = codigo;
        this.nome = nome;
        this.ano = ano;
        this.valorMinuto = valorMinuto;
        this.moeda = moeda;
        this.categoria = categoria;
        this.status = StatusJogo.DISPONIVEL;

    }

    public long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getAno() {
        return ano;
    }

    public double getValorMinuto() {
        return valorMinuto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Moeda getMoeda() {
        return moeda;
    }

    public StatusJogo getStatus() {
        return status;
    }

    public Date getDataObsoleto() {
        return dataObsoleto;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setValorMinuto(double valorMinuto) {
        this.valorMinuto = valorMinuto;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setMoeda(Moeda moeda) {
        this.moeda = moeda;
    }
    
    public void contratar() {
        this.status = StatusJogo.CONTRATADO;
    }

    public void disponibilizar() {
        this.status = StatusJogo.DISPONIVEL;
    }

    public void tornarObsoleto() {
        this.status = StatusJogo.OBSOLETO;
        this.dataObsoleto = new Date();
    }

    public void bloquear() {
    this.status = StatusJogo.BLOQUEADO;
}

    public void desbloquear() {
        this.status = StatusJogo.DISPONIVEL;
    }

    public void remover() {
        this.status = StatusJogo.REMOVIDO;
    }
}
