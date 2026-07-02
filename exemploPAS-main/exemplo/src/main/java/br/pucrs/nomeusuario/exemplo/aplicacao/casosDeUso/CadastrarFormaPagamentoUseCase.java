package br.pucrs.nomeusuario.exemplo.aplicacao.casosDeUso;

import org.springframework.stereotype.Service;

import br.pucrs.nomeusuario.exemplo.aplicacao.repositorios.FormaPagamentoRepository;
import br.pucrs.nomeusuario.exemplo.dominio.FormaPagamento;

@Service
public class CadastrarFormaPagamentoUseCase {

    private final FormaPagamentoRepository formaPagamentoRepository;

    public CadastrarFormaPagamentoUseCase(FormaPagamentoRepository formaPagamentoRepository) {
        this.formaPagamentoRepository = formaPagamentoRepository;
    }

    public boolean executar(FormaPagamento formaPagamento) {

        if (formaPagamentoRepository.buscarPorNumero(formaPagamento.getNum()) != null) {
            return false;
        }

        formaPagamentoRepository.salvar(formaPagamento);

        return true;
    }
}