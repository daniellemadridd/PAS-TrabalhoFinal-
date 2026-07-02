package br.pucrs.nomeusuario.exemplo.frameworksAndDrivers.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.pucrs.nomeusuario.exemplo.aplicacao.repositorios.UsoRepository;
import br.pucrs.nomeusuario.exemplo.dominio.Uso;
import br.pucrs.nomeusuario.exemplo.frameworksAndDrivers.repositorios.IUsoJpaRepository;

@Repository
public class UsoRepositoryJpaImpl implements UsoRepository {

    private final IUsoJpaRepository repository;

    public UsoRepositoryJpaImpl(IUsoJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Uso buscarPorNumero(long numero) {
        return repository.findById(numero).orElse(null);
    }

    @Override
    public List<Uso> listarTodos() {
        List<Uso> usos = new ArrayList<>();
        repository.findAll().forEach(usos::add);
        return usos;
    }

    @Override
    public void salvar(Uso uso) {
        repository.save(uso);
    }
}