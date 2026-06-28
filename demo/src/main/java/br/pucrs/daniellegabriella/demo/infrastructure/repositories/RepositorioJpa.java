package br.pucrs.daniellegabriella.demo.infrastructure.repositories;

import java.util.List;
import java.util.Optional;

public interface RepositorioJpa{

    <T> T salvar(T entidade);

    <T> List<T> listarTodos(Class<T> tipoEntidade);

    <T, ID> Optional<T> buscarPorId(Class<T> tipoEntidade, ID id);

    <T> void remover(T entidade);
}