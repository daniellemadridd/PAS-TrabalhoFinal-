package br.pucrs.nomeusuario.exemplo.aplicacao.casosDeUso;

import br.pucrs.nomeusuario.exemplo.aplicacao.repositorios.MoedaRepository;
import br.pucrs.nomeusuario.exemplo.dominio.Moeda;

public class CadastrarMoedaUseCase {

    private final MoedaRepository moedaRepository;

    public CadastrarMoedaUseCase(MoedaRepository moedaRepository) {
        this.moedaRepository = moedaRepository;
    }

    public void executar(Moeda moeda) {
        if (moedaRepository.buscarPorCodigo(moeda.getCod()) != null) {
            throw new IllegalArgumentException("Já existe moeda com este código.");
        }

        moedaRepository.salvar(moeda);
    }
}