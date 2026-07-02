package br.pucrs.nomeusuario.exemplo.frameworksAndDrivers.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.pucrs.nomeusuario.exemplo.aplicacao.repositorios.FormaPagamentoRepository;
import br.pucrs.nomeusuario.exemplo.dominio.FormaPagamento;
import br.pucrs.nomeusuario.exemplo.frameworksAndDrivers.repositorios.IFormaPagamentoJpaRepository;

@Repository
public class FormaPagamentoRepositoryJpaImpl implements FormaPagamentoRepository {

    private final IFormaPagamentoJpaRepository repository;

    public FormaPagamentoRepositoryJpaImpl(IFormaPagamentoJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public FormaPagamento buscarPorNumero(long num) {
        return repository.findById(num).orElse(null);
    }

    @Override
    public List<FormaPagamento> listarTodos() {
        List<FormaPagamento> formas = new ArrayList<>();
        repository.findAll().forEach(formas::add);
        return formas;
    }

    @Override
    public void salvar(FormaPagamento formaPagamento) {
        repository.save(formaPagamento);
    }
}