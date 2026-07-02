package br.pucrs.nomeusuario.exemplo.dominio;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class CartaoCredito extends FormaPagamento {

    private String numero;
    @Temporal(TemporalType.DATE)
    private Date validade;

    protected CartaoCredito() {
        super();
    }

    public CartaoCredito(long num,
                         int diaVencimento,
                         String numero,
                         Date validade) {
        super(num, diaVencimento);
        this.numero = numero;
        this.validade = validade;
    }

    public String getNumero() {
        return numero;
    }

    public Date getValidade() {
        return validade;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }
}