package br.pucrs.daniellegabriella.demo.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public abstract class FormaDePagamento {

	@Id
	private Long num;

	private Integer diaVencimento;

	protected FormaDePagamento() {
	}

	protected FormaDePagamento(Long num, Integer diaVencimento) {
		this.num = num;
		this.diaVencimento = diaVencimento;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public Integer getDiaVencimento() {
		return diaVencimento;
	}

	public void setDiaVencimento(Integer diaVencimento) {
		this.diaVencimento = diaVencimento;
	}
}
