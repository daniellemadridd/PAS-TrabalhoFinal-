package br.pucrs.nomeusuario.exemplo.aplicacao.repositorios;

import java.util.List;

import br.pucrs.nomeusuario.exemplo.dominio.Cliente;

public interface ClienteRepository {
    Cliente buscarPorCodigo(long cod);
    Cliente buscarPorCpf(String cpf);
    List<Cliente> listarTodos();
    void salvar(Cliente cliente);
}