package br.pucrs.nomeusuario.exemplo.adaptadores.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.pucrs.nomeusuario.exemplo.aplicacao.casosDeUso.ConsultarTotalClienteUseCase;
import br.pucrs.nomeusuario.exemplo.aplicacao.casosDeUso.ConsultarTotalContratoUseCase;

@RestController
@RequestMapping("/financeiro")
public class FinanceiroController {

    private final ConsultarTotalContratoUseCase consultarTotalContratoUseCase;
    private final ConsultarTotalClienteUseCase consultarTotalClienteUseCase;

    public FinanceiroController(ConsultarTotalContratoUseCase consultarTotalContratoUseCase,
                                ConsultarTotalClienteUseCase consultarTotalClienteUseCase) {
        this.consultarTotalContratoUseCase = consultarTotalContratoUseCase;
        this.consultarTotalClienteUseCase = consultarTotalClienteUseCase;
    }

    @GetMapping("/consultatotalcontrato")
    public double consultarTotalContrato(@RequestParam long id) {
        return consultarTotalContratoUseCase.executar(id);
    }

    @GetMapping("/consultatotalcliente")
    public double consultarTotalCliente(@RequestParam String cpf) {
        return consultarTotalClienteUseCase.executar(cpf);
    }
}