package br.pucrs.nomeusuario.exemplo.aplicacao.casosDeUso;

import java.util.List;

import org.springframework.stereotype.Service;

import br.pucrs.nomeusuario.exemplo.aplicacao.repositorios.FormaPagamentoRepository;
import br.pucrs.nomeusuario.exemplo.dominio.FormaPagamento;

@Service
public class ConsultarListaFormasPagamentoUseCase {

    private final FormaPagamentoRepository formaPagamentoRepository;

    public ConsultarListaFormasPagamentoUseCase(FormaPagamentoRepository formaPagamentoRepository) {
        this.formaPagamentoRepository = formaPagamentoRepository;
    }

    public List<FormaPagamento> executar() {
        return formaPagamentoRepository.listarTodos();
    }
}