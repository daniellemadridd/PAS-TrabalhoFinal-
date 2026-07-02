package br.pucrs.nomeusuario.exemplo.dominio;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Uso {
    @Id
    private long numero;
    @Temporal(TemporalType.DATE)
    private Date dataInicio;

    @Temporal(TemporalType.DATE)
    private Date dataFim;
    private int horarioInicio;
    private int horarioFim;
    @ManyToOne
    private Contrato contrato;

    protected Uso() {
    }
    
    public Uso(long numero, Date dataInicio, Date dataFim, int horarioInicio, int horarioFim, Contrato contrato) {
        this.numero = numero;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.contrato = contrato;
    }

    public long getNumero() {
        return numero;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public int getHorarioInicio() {
        return horarioInicio;
    }

    public int getHorarioFim() {
        return horarioFim;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public void setHorarioInicio(int horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public void setHorarioFim(int horarioFim) {
        this.horarioFim = horarioFim;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public int calcularMinutos() {
        return horarioFim - horarioInicio;
    }
}
