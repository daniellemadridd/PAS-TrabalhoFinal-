package br.pucrs.nomeusuario.exemplo.frameworksAndDrivers.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.pucrs.nomeusuario.exemplo.aplicacao.repositorios.ContratoRepository;
import br.pucrs.nomeusuario.exemplo.dominio.Contrato;
import br.pucrs.nomeusuario.exemplo.frameworksAndDrivers.repositorios.IContratoJpaRepository;

@Repository
public class ContratoRepositoryJpaImpl implements ContratoRepository {

    private final IContratoJpaRepository repository;

    public ContratoRepositoryJpaImpl(IContratoJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Contrato buscarPorId(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Contrato> listarTodos() {
        List<Contrato> contratos = new ArrayList<>();
        repository.findAll().forEach(contratos::add);
        return contratos;
    }

    @Override
    public void salvar(Contrato contrato) {
        repository.save(contrato);
    }
}