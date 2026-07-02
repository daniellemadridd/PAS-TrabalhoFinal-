package br.pucrs.nomeusuario.exemplo.aplicacao.casosDeUso;

import br.pucrs.nomeusuario.exemplo.aplicacao.repositorios.JogoRepository;
import br.pucrs.nomeusuario.exemplo.dominio.Jogo;

public class CadastrarJogoUseCase {

    private final JogoRepository jogoRepository;

    public CadastrarJogoUseCase(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    public void executar(Jogo jogo) {
        if (jogoRepository.buscarPorCodigo(jogo.getCodigo()) != null) {
            throw new IllegalArgumentException("Já existe jogo com este código.");
        }

        jogoRepository.salvar(jogo);
    }
}