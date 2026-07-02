package br.pucrs.nomeusuario.exemplo.aplicacao.casosDeUso;

import br.pucrs.nomeusuario.exemplo.aplicacao.repositorios.CobrancaRepository;
import br.pucrs.nomeusuario.exemplo.dominio.*;

import java.util.Date;
import java.util.List;

public class GerarCobrancaUseCase {

    private final CobrancaRepository cobrancaRepository;

    public GerarCobrancaUseCase(CobrancaRepository cobrancaRepository) {
        this.cobrancaRepository = cobrancaRepository;
    }

    public Cobranca executar(long id, Cliente cliente, List<Uso> usos) {
        double valorTotal = 0;

        for (Uso uso : usos) {
            Contrato contrato = uso.getContrato();
            Jogo jogo = contrato.getJogo();

            double valorMinutoEmReal = jogo.getMoeda()
                    .converterParaReal(jogo.getValorMinuto());

            double valorUso = cliente.getCategoria().getValorMinimo()
                    + uso.calcularMinutos() * valorMinutoEmReal;

            valorTotal += valorUso;
        }

        if (valorTotal > 500) {
            valorTotal = valorTotal * 0.97;
        }

        Cobranca cobranca = new Cobranca(id, new Date(), cliente, valorTotal);

        cobrancaRepository.salvar(cobranca);

        return cobranca;
    }
}   