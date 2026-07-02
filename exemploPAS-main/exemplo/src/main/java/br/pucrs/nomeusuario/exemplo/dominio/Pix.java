package br.pucrs.nomeusuario.exemplo.dominio;

import jakarta.persistence.Entity;

@Entity
public class Pix extends FormaPagamento {

    private String chave;

    protected Pix() {
        super();
    }

    public Pix(long num,
               int diaVencimento,
               String chave) {
        super(num, diaVencimento);
        this.chave = chave;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }
}