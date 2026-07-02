package br.pucrs.nomeusuario.exemplo.aplicacao.casosDeUso;

import java.util.List;

import org.springframework.stereotype.Service;

import br.pucrs.nomeusuario.exemplo.aplicacao.repositorios.JogoRepository;
import br.pucrs.nomeusuario.exemplo.dominio.Jogo;
import br.pucrs.nomeusuario.exemplo.dominio.StatusJogo;

@Service
public class ConsultarJogosSituacaoUseCase {

    private final JogoRepository jogoRepository;

    public ConsultarJogosSituacaoUseCase(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    public List<Jogo> executar(String situacao) {
        StatusJogo status = StatusJogo.valueOf(situacao.toUpperCase());

        return jogoRepository.buscarPorStatus(status);
    }
}