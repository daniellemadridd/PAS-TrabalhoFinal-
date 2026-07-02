package br.pucrs.nomeusuario.exemplo.aplicacao.casosDeUso;

import java.util.Date;

import br.pucrs.nomeusuario.exemplo.aplicacao.repositorios.ContratoRepository;
import br.pucrs.nomeusuario.exemplo.aplicacao.repositorios.JogoRepository;
import br.pucrs.nomeusuario.exemplo.dominio.Cliente;
import br.pucrs.nomeusuario.exemplo.dominio.Contrato;
import br.pucrs.nomeusuario.exemplo.dominio.Jogo;
import br.pucrs.nomeusuario.exemplo.dominio.StatusJogo;

public class CriarContratoUseCase {

    private final JogoRepository jogoRepository;
    private final ContratoRepository contratoRepository;

    public CriarContratoUseCase(JogoRepository jogoRepository,
                                ContratoRepository contratoRepository) {
        this.jogoRepository = jogoRepository;
        this.contratoRepository = contratoRepository;
    }

    public Contrato executar(long id, Date data, int periodo, Cliente cliente, long codigoJogo) {
        Jogo jogo = jogoRepository.buscarPorCodigo(codigoJogo);

        if (jogo.getStatus() != StatusJogo.DISPONIVEL) {
            throw new IllegalArgumentException("O jogo não está disponível para contratação.");
        }

        Contrato contrato = new Contrato(id, data, periodo, cliente, jogo, null);

        contratoRepository.salvar(contrato);
        jogoRepository.salvar(jogo);

        return contrato;
    }
}