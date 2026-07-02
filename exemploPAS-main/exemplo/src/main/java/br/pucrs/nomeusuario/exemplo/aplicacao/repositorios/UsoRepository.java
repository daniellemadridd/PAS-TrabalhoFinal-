package br.pucrs.nomeusuario.exemplo.aplicacao.repositorios;

import java.util.List;

import br.pucrs.nomeusuario.exemplo.dominio.Uso;

public interface UsoRepository {
    Uso buscarPorNumero(long numero);
    List<Uso> listarTodos();
    void salvar(Uso uso);
}