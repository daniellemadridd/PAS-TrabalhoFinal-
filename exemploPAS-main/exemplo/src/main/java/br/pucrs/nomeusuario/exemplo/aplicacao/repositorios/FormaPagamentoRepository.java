package br.pucrs.nomeusuario.exemplo.aplicacao.repositorios;

import java.util.List;

import br.pucrs.nomeusuario.exemplo.dominio.FormaPagamento;

public interface FormaPagamentoRepository {
    FormaPagamento buscarPorNumero(long num);
    List<FormaPagamento> listarTodos();
    void salvar(FormaPagamento formaPagamento);
}