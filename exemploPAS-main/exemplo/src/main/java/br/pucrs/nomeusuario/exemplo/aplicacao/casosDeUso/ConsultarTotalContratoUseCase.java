package br.pucrs.nomeusuario.exemplo.aplicacao.casosDeUso;

import org.springframework.stereotype.Service;

import br.pucrs.nomeusuario.exemplo.aplicacao.repositorios.ContratoRepository;
import br.pucrs.nomeusuario.exemplo.dominio.Contrato;
import br.pucrs.nomeusuario.exemplo.dominio.Jogo;
import br.pucrs.nomeusuario.exemplo.dominio.Uso;

@Service
public class ConsultarTotalContratoUseCase {

    private final ContratoRepository contratoRepository;

    public ConsultarTotalContratoUseCase(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
    }

    public double executar(long id) {
        Contrato contrato = contratoRepository.buscarPorId(id);

        if (contrato == null) {
            return 0;
        }

        double total = 0;

        for (Uso uso : contrato.getUsos()) {
            Jogo jogo = contrato.getJogo();

            double valorMinutoEmReais = jogo.getMoeda()
                    .converterParaReal(jogo.getValorMinuto());

            double valorUso = jogo.getCategoria().getValorMinimo()
                    + uso.calcularMinutos() * valorMinutoEmReais;

            total += valorUso;
        }

        if (total > 500) {
            total = total * 0.97;
        }

        return total;
    }
}