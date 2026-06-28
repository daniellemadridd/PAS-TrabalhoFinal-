package br.pucrs.daniellegabriella.demo.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
public class Contrato {

    @Id
    private Long id;

    private Date data;

    private Integer periodo;

    private Boolean ativo = true;

    private Cliente cliente;

    @ManyToOne
    private Jogo jogo;

    @ManyToOne
    private FormaDePagamento formaDePagamento;

    @OneToMany(mappedBy = "contrato")
    private List<Uso> usos = new ArrayList<>();

    public Contrato() {
    }

    public Contrato(Long id, Integer periodo, Date data, Jogo jogo, Cliente cliente) {
        this.id = id;
        this.periodo = periodo;
        this.data = data;
        this.jogo = jogo;
        this.cliente = cliente;
        this.ativo = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public FormaDePagamento getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(FormaDePagamento formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public List<Uso> getUsos() {
        return usos;
    }

    public void setUsos(List<Uso> usos) {
        this.usos = usos;
    }
}