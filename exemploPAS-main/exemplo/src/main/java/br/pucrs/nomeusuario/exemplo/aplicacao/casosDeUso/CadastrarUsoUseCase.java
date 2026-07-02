package br.pucrs.nomeusuario.exemplo.aplicacao.casosDeUso;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.pucrs.nomeusuario.exemplo.aplicacao.repositorios.ContratoRepository;
import br.pucrs.nomeusuario.exemplo.aplicacao.repositorios.UsoRepository;
import br.pucrs.nomeusuario.exemplo.dominio.Contrato;
import br.pucrs.nomeusuario.exemplo.dominio.Uso;

@Service
public class CadastrarUsoUseCase {

    private final UsoRepository usoRepository;
    private final ContratoRepository contratoRepository;

    public CadastrarUsoUseCase(UsoRepository usoRepository,
                               ContratoRepository contratoRepository) {
        this.usoRepository = usoRepository;
        this.contratoRepository = contratoRepository;
    }

    public boolean executar(long idContrato,
                            long numero,
                            Date dataInicio,
                            Date dataFim,
                            int horarioInicio,
                            int horarioFim) {

        if (usoRepository.buscarPorNumero(numero) != null) {
            return false;
        }

        Contrato contrato = contratoRepository.buscarPorId(idContrato);

        if (contrato == null) {
            return false;
        }

        Uso uso = new Uso(
                numero,
                dataInicio,
                dataFim,
                horarioInicio,
                horarioFim,
                contrato
        );

        contrato.adicionarUso(uso);

        usoRepository.salvar(uso);
        contratoRepository.salvar(contrato);

        return true;
    }
}