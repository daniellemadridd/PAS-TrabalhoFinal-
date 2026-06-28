package br.pucrs.daniellegabriella.demo.domain.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PIX")
public class Pix extends FormaDePagamento {

	private String chave;

	public Pix() {
	}

	public Pix(Long num, Integer diaVencimento, String chave) {
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
