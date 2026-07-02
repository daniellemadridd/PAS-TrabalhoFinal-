package br.pucrs.nomeusuario.exemplo.aplicacao.casosDeUso;

import org.springframework.stereotype.Service;

import br.pucrs.nomeusuario.exemplo.aplicacao.repositorios.ContratoRepository;
import br.pucrs.nomeusuario.exemplo.dominio.Contrato;
import br.pucrs.nomeusuario.exemplo.dominio.StatusContrato;

@Service
public class CancelarContratoUseCase {

    private final ContratoRepository contratoRepository;

    public CancelarContratoUseCase(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
    }

    public boolean executar(long id) {

        Contrato contrato = contratoRepository.buscarPorId(id);

        if (contrato == null) {
            return false;
        }

        if (contrato.getStatus() == StatusContrato.CANCELADO) {
            return false;
        }

        contrato.cancelar();

        contratoRepository.salvar(contrato);

        return true;
    }
}