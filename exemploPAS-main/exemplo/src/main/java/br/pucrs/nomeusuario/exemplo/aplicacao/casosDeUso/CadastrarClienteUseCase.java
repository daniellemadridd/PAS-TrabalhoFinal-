package br.pucrs.nomeusuario.exemplo.aplicacao.casosDeUso;

import br.pucrs.nomeusuario.exemplo.aplicacao.repositorios.ClienteRepository;
import br.pucrs.nomeusuario.exemplo.dominio.Cliente;

public class CadastrarClienteUseCase {

    private final ClienteRepository clienteRepository;

    public CadastrarClienteUseCase(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void executar(Cliente cliente) {
        if (clienteRepository.buscarPorCodigo(cliente.getCod()) != null) {
            throw new IllegalArgumentException("Já existe cliente com este código.");
        }

        clienteRepository.salvar(cliente);
    }
}