package br.pucrs.daniellegabriella.demo.domain.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@DiscriminatorValue("CARTAO")
public class CartaoDeCredito extends FormaDePagamento {

	@Column(nullable = false)
	private String numero;

	@Temporal(TemporalType.DATE)
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
