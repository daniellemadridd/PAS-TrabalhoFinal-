package br.pucrs.nomeusuario.exemplo.aplicacao.repositorios;

import java.util.List;

import br.pucrs.nomeusuario.exemplo.dominio.Moeda;

public interface MoedaRepository {
    Moeda buscarPorCodigo(long cod);
    List<Moeda> listarTodos();
    void salvar(Moeda moeda);
}