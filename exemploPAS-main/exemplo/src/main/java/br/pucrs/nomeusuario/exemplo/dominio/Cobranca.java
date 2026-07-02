package br.pucrs.nomeusuario.exemplo.dominio;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Cobranca {

    @Id
    private long id;

    @Temporal(TemporalType.DATE)
    private Date data;

    @ManyToOne
    private Cliente cliente;

    private double valorTotal;

    protected Cobranca() {
    }

    public Cobranca(long id, Date data, Cliente cliente, double valorTotal) {
        this.id = id;
        this.data = data;
        this.cliente = cliente;
        this.valorTotal = valorTotal;
    }

    public long getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}