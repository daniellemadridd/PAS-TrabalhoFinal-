package br.pucrs.nomeusuario.exemplo.dominio;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Cliente {

    @Id
    private long cod;

    @Column(unique = true)
    private String cpf;

    private String nome;

    private String email;

    @Temporal(TemporalType.DATE)
    private Date nascimento;

    @ManyToOne
    private Categoria categoria;

    protected Cliente() {
    }

    public Cliente(long cod, String cpf, String nome, String email, Date nascimento, Categoria categoria) {
        this.cod = cod;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.nascimento = nascimento;
        this.categoria = categoria;
    }
    public long getCod() {
        return cod;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCod(long cod) {
        this.cod = cod;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
