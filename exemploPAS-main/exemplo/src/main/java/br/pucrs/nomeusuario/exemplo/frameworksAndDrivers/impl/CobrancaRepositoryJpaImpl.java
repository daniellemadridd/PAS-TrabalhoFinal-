package br.pucrs.nomeusuario.exemplo.frameworksAndDrivers.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.pucrs.nomeusuario.exemplo.aplicacao.repositorios.CobrancaRepository;
import br.pucrs.nomeusuario.exemplo.dominio.Cobranca;
import br.pucrs.nomeusuario.exemplo.frameworksAndDrivers.repositorios.ICobrancaJpaRepository;

@Repository
public class CobrancaRepositoryJpaImpl implements CobrancaRepository {

    private final ICobrancaJpaRepository repository;

    public CobrancaRepositoryJpaImpl(ICobrancaJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cobranca buscarPorId(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Cobranca> listarTodos() {
        List<Cobranca> cobrancas = new ArrayList<>();
        repository.findAll().forEach(cobrancas::add);
        return cobrancas;
    }

    @Override
    public void salvar(Cobranca cobranca) {
        repository.save(cobranca);
    }
}