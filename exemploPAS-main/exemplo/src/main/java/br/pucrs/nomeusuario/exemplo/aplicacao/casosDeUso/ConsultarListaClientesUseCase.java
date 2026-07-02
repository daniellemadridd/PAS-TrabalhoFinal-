package br.pucrs.nomeusuario.exemplo.aplicacao.casosDeUso;

import java.util.List;

import org.springframework.stereotype.Service;

import br.pucrs.nomeusuario.exemplo.aplicacao.repositorios.ClienteRepository;
import br.pucrs.nomeusuario.exemplo.dominio.Cliente;

@Service
public class ConsultarListaClientesUseCase {

    private final ClienteRepository clienteRepository;

    public ConsultarListaClientesUseCase(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> executar() {
        return clienteRepository.listarTodos();
    }
}