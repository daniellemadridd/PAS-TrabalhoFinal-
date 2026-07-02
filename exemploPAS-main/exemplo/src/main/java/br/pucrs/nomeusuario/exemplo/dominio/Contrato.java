package br.pucrs.nomeusuario.exemplo.dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Contrato {

    @Id
    private long id;

    @Temporal(TemporalType.DATE)
    private Date data;

    private int periodo;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Jogo jogo;

    @ManyToOne
    private FormaPagamento formaPagamento;

    @OneToMany(mappedBy = "contrato")
    private List<Uso> usos = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private StatusContrato status;

    protected Contrato() {
    }

    public Contrato(long id, Date data, int periodo, Cliente cliente, Jogo jogo, FormaPagamento formaPagamento) {
        this.id = id;
        this.data = data;
        this.periodo = periodo;
        this.cliente = cliente;
        this.jogo = jogo;
        this.formaPagamento = formaPagamento;
        this.status = StatusContrato.ATIVO;
        this.jogo.contratar();
    }

    public void adicionarUso(Uso uso) {
        uso.setContrato(this);
        usos.add(uso);
    }

    public void cancelar() {
        this.status = StatusContrato.CANCELADO;
        this.jogo.disponibilizar();
    }

    public void expirar() {
        this.status = StatusContrato.EXPIRADO;
        this.jogo.disponibilizar();
    }

    public long getId() { return id; }
    public Date getData() { return data; }
    public int getPeriodo() { return periodo; }
    public Cliente getCliente() { return cliente; }
    public Jogo getJogo() { return jogo; }
    public FormaPagamento getFormaPagamento() { return formaPagamento; }
    public List<Uso> getUsos() { return usos; }
    public StatusContrato getStatus() { return status; }
}