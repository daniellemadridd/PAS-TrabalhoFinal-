package br.pucrs.nomeusuario.exemplo.aplicacao.repositorios;

import java.util.List;

import br.pucrs.nomeusuario.exemplo.dominio.Contrato;

public interface ContratoRepository {
    Contrato buscarPorId(long id);
    List<Contrato> listarTodos();
    void salvar(Contrato contrato);
}