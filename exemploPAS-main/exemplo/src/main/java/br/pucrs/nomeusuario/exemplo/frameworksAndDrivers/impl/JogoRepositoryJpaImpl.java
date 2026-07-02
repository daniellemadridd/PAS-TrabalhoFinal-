package br.pucrs.nomeusuario.exemplo.frameworksAndDrivers.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.pucrs.nomeusuario.exemplo.aplicacao.repositorios.JogoRepository;
import br.pucrs.nomeusuario.exemplo.dominio.Jogo;
import br.pucrs.nomeusuario.exemplo.dominio.StatusJogo;
import br.pucrs.nomeusuario.exemplo.frameworksAndDrivers.repositorios.IJogoJpaRepository;

@Repository
public class JogoRepositoryJpaImpl implements JogoRepository {

    private final IJogoJpaRepository repository;

    public JogoRepositoryJpaImpl(IJogoJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Jogo buscarPorCodigo(long codigo) {
        return repository.findById(codigo).orElse(null);
    }

    @Override
    public List<Jogo> listarTodos() {
        List<Jogo> jogos = new ArrayList<>();
        repository.findAll().forEach(jogos::add);
        return jogos;
    }

    @Override
    public List<Jogo> buscarPorStatus(StatusJogo status) {
        return repository.findByStatus(status);
    }

    @Override
    public void salvar(Jogo jogo) {
        repository.save(jogo);
    }
}