package br.pucrs.nomeusuario.exemplo.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class FormaPagamento {

    @Id
    private long num;

    private int diaVencimento;

    protected FormaPagamento() {
    }

    public FormaPagamento(long num, int diaVencimento) {
        this.num = num;
        this.diaVencimento = diaVencimento;
    }

    public long getNum() {
        return num;
    }

    public int getDiaVencimento() {
        return diaVencimento;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public void setDiaVencimento(int diaVencimento) {
        this.diaVencimento = diaVencimento;
    }
}