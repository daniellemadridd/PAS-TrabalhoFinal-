package br.pucrs.nomeusuario.exemplo.adaptadores.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucrs.nomeusuario.exemplo.aplicacao.casosDeUso.ConsultarJogosSituacaoUseCase;
import br.pucrs.nomeusuario.exemplo.aplicacao.casosDeUso.ConsultarListaClientesUseCase;
import br.pucrs.nomeusuario.exemplo.aplicacao.casosDeUso.ConsultarListaContratosUseCase;
import br.pucrs.nomeusuario.exemplo.aplicacao.casosDeUso.ConsultarListaFormasPagamentoUseCase;
import br.pucrs.nomeusuario.exemplo.aplicacao.casosDeUso.ConsultarListaJogosUseCase;
import br.pucrs.nomeusuario.exemplo.dominio.Cliente;
import br.pucrs.nomeusuario.exemplo.dominio.Contrato;
import br.pucrs.nomeusuario.exemplo.dominio.FormaPagamento;
import br.pucrs.nomeusuario.exemplo.dominio.Jogo;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    private final ConsultarListaClientesUseCase consultarListaClientesUseCase;
    private final ConsultarListaJogosUseCase consultarListaJogosUseCase;
    private final ConsultarListaFormasPagamentoUseCase consultarListaFormasPagamentoUseCase;
    private final ConsultarListaContratosUseCase consultarListaContratosUseCase;
    private final ConsultarJogosSituacaoUseCase consultarJogosSituacaoUseCase;

    public ConsultaController(
            ConsultarListaClientesUseCase consultarListaClientesUseCase,
            ConsultarListaJogosUseCase consultarListaJogosUseCase,
            ConsultarListaFormasPagamentoUseCase consultarListaFormasPagamentoUseCase,
            ConsultarListaContratosUseCase consultarListaContratosUseCase,
            ConsultarJogosSituacaoUseCase consultarJogosSituacaoUseCase) {

        this.consultarListaClientesUseCase = consultarListaClientesUseCase;
        this.consultarListaJogosUseCase = consultarListaJogosUseCase;
        this.consultarListaFormasPagamentoUseCase = consultarListaFormasPagamentoUseCase;
        this.consultarListaContratosUseCase = consultarListaContratosUseCase;
        this.consultarJogosSituacaoUseCase = consultarJogosSituacaoUseCase;
    }

    @GetMapping("/listaclientes")
    public List<Cliente> listarClientes() {
        return consultarListaClientesUseCase.executar();
    }

    @GetMapping("/listajogos")
    public List<Jogo> listarJogos() {
        return consultarListaJogosUseCase.executar();
    }

    @GetMapping("/listaformaspagamentos")
    public List<FormaPagamento> listarFormasPagamento() {
        return consultarListaFormasPagamentoUseCase.executar();
    }

    @GetMapping("/listacontratos")
    public List<Contrato> listarContratos() {
        return consultarListaContratosUseCase.executar();
    }

    @GetMapping("/jogossituacao/{situacao}")
    public List<Jogo> buscarJogosPorSituacao(@PathVariable String situacao) {
        return consultarJogosSituacaoUseCase.executar(situacao);
    }
}