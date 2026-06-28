package br.pucrs.daniellegabriella.demo.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Moeda {

	@Id
	private String cod;

	private String nome;

	private String simbolo;

	@OneToMany(mappedBy = "moeda")
	private List<Jogo> jogos = new ArrayList<>();

	public Moeda() {
	}

	public Moeda(String cod, String nome, String simbolo) {
		this.cod = cod;
		this.nome = nome;
		this.simbolo = simbolo;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public List<Jogo> getJogos() {
		return jogos;
	}

	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}
}
