package br.pucrs.nomeusuario.exemplo.aplicacao.repositorios;

import java.util.List;

import br.pucrs.nomeusuario.exemplo.dominio.Categoria;

public interface CategoriaRepository {
    Categoria buscarPorNumero(long num);
    List<Categoria> listarTodos();
    void salvar(Categoria categoria);
}