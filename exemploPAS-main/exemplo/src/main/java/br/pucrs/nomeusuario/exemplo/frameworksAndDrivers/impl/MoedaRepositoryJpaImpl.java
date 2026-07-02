package br.pucrs.nomeusuario.exemplo.frameworksAndDrivers.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.pucrs.nomeusuario.exemplo.aplicacao.repositorios.MoedaRepository;
import br.pucrs.nomeusuario.exemplo.dominio.Moeda;
import br.pucrs.nomeusuario.exemplo.frameworksAndDrivers.repositorios.IMoedaJpaRepository;

@Repository
public class MoedaRepositoryJpaImpl implements MoedaRepository {

    private final IMoedaJpaRepository repository;

    public MoedaRepositoryJpaImpl(IMoedaJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Moeda buscarPorCodigo(long cod) {
        return repository.findById(cod).orElse(null);
    }

    @Override
    public List<Moeda> listarTodos() {
        List<Moeda> moedas = new ArrayList<>();
        repository.findAll().forEach(moedas::add);
        return moedas;
    }

    @Override
    public void salvar(Moeda moeda) {
        repository.save(moeda);
    }
}