package br.pucrs.nomeusuario.exemplo.aplicacao.casosDeUso;

import java.util.List;

import org.springframework.stereotype.Service;

import br.pucrs.nomeusuario.exemplo.aplicacao.repositorios.JogoRepository;
import br.pucrs.nomeusuario.exemplo.dominio.Jogo;

@Service
public class ConsultarListaJogosUseCase {

    private final JogoRepository jogoRepository;

    public ConsultarListaJogosUseCase(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    public List<Jogo> executar() {
        return jogoRepository.listarTodos();
    }
}