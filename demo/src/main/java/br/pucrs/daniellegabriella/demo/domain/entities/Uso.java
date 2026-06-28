package br.pucrs.daniellegabriella.demo.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity
public class Uso {

    @Id
    private Long numero;

    private Integer horarioInicio;

    private Integer horarioFim;

    private Date dataInicio;

    private Date dataFim;

    @ManyToOne
    private Contrato contrato;

    public Uso() {
    }

    public Uso(Long numero, Integer horarioInicio, Integer horarioFim, Date dataInicio, Date dataFim, Contrato contrato) {
        this.numero = numero;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.contrato = contrato;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Integer getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(Integer horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public Integer getHorarioFim() {
        return horarioFim;
    }

    public void setHorarioFim(Integer horarioFim) {
        this.horarioFim = horarioFim;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
}