package br.pucrs.nomeusuario.exemplo.aplicacao.casosDeUso;

import java.util.List;

import org.springframework.stereotype.Service;

import br.pucrs.nomeusuario.exemplo.aplicacao.repositorios.ContratoRepository;
import br.pucrs.nomeusuario.exemplo.dominio.Contrato;

@Service
public class ConsultarListaContratosUseCase {

    private final ContratoRepository contratoRepository;

    public ConsultarListaContratosUseCase(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
    }

    public List<Contrato> executar() {
        return contratoRepository.listarTodos();
    }
}