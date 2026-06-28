package br.pucrs.daniellegabriella.demo.domain.entities;

import java.util.Date;

import jakarta.persistence.Entity;

@Entity
public class CartaoDeCredito extends FormaDePagamento {

	private String numero;

	private Date validade;

	public CartaoDeCredito() {
	}

	public CartaoDeCredito(Long num, Integer diaVencimento, String numero, Date validade) {
		super(num, diaVencimento);
		this.numero = numero;
		this.validade = validade;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}
}
