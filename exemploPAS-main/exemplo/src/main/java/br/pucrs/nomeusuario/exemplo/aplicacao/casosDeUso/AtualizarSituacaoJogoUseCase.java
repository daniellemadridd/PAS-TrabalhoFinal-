package br.pucrs.nomeusuario.exemplo.aplicacao.casosDeUso;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.pucrs.nomeusuario.exemplo.aplicacao.repositorios.JogoRepository;
import br.pucrs.nomeusuario.exemplo.dominio.Jogo;

@Service
@Transactional
public class AtualizarSituacaoJogoUseCase {

    private final JogoRepository jogoRepository;

    public AtualizarSituacaoJogoUseCase(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    public Jogo executar(long codigo, String status) {

        Jogo jogo = jogoRepository.buscarPorCodigo(codigo);

        if (jogo == null) {
            return null;
        }

        switch (status.toLowerCase()) {

            case "disponivel":
                jogo.disponibilizar();
                break;

            case "contratado":
                jogo.contratar();
                break;

            case "bloqueado":
                jogo.bloquear();
                break;

            case "obsoleto":
                jogo.tornarObsoleto();
                break;

            case "removido":
                jogo.remover();
                break;

            default:
                throw new IllegalArgumentException("Situação inválida.");
        }

        jogoRepository.salvar(jogo);

        return jogo;
    }
}