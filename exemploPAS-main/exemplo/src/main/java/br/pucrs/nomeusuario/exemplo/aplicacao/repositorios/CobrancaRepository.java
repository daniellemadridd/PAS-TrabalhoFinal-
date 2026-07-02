package br.pucrs.nomeusuario.exemplo.aplicacao.repositorios;

import java.util.List;

import br.pucrs.nomeusuario.exemplo.dominio.Cobranca;

public interface CobrancaRepository {
    Cobranca buscarPorId(long id);
    List<Cobranca> listarTodos();
    void salvar(Cobranca cobranca);
}