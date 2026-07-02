package br.pucrs.nomeusuario.exemplo.frameworksAndDrivers.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.pucrs.nomeusuario.exemplo.aplicacao.repositorios.CategoriaRepository;
import br.pucrs.nomeusuario.exemplo.dominio.Categoria;
import br.pucrs.nomeusuario.exemplo.frameworksAndDrivers.repositorios.ICategoriaJpaRepository;

@Repository
public class CategoriaRepositoryJpaImpl implements CategoriaRepository {

    private final ICategoriaJpaRepository repository;

    public CategoriaRepositoryJpaImpl(ICategoriaJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Categoria buscarPorNumero(long num) {
        return repository.findById(num).orElse(null);
    }

    @Override
    public List<Categoria> listarTodos() {
        List<Categoria> categorias = new ArrayList<>();
        repository.findAll().forEach(categorias::add);
        return categorias;
    }

    @Override
    public void salvar(Categoria categoria) {
        repository.save(categoria);
    }
}