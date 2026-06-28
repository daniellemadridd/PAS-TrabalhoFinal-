package br.pucrs.daniellegabriella.demo.domain.entities;

import br.pucrs.daniellegabriella.demo.domain.enums.SituacaoJogo;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Jogo {

    @Id
    private Long codigo;

    private String nome;

    private Integer ano;

    private Double valorMinuto;

    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Moeda moeda;

    private SituacaoJogo situacao = SituacaoJogo.DISPONIVEL;

    @OneToMany(mappedBy = "jogo")
    private List<Contrato> contratos = new ArrayList<>();

    public Jogo() {
    }

    public Jogo(Long codigo, String nome, Integer ano, Double valorMinuto, Categoria categoria, Moeda moeda) {
        this.codigo = codigo;
        this.nome = nome;
        this.ano = ano;
        this.valorMinuto = valorMinuto;
        this.categoria = categoria;
        this.moeda = moeda;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Double getValorMinuto() {
        return valorMinuto;
    }

    public void setValorMinuto(Double valorMinuto) {
        this.valorMinuto = valorMinuto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Moeda getMoeda() {
        return moeda;
    }

    public void setMoeda(Moeda moeda) {
        this.moeda = moeda;
    }

    public SituacaoJogo getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoJogo situacao) {
        this.situacao = situacao;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }
}