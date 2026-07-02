package br.pucrs.nomeusuario.exemplo.adaptadores.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucrs.nomeusuario.exemplo.aplicacao.casosDeUso.AtualizarSituacaoJogoUseCase;
import br.pucrs.nomeusuario.exemplo.aplicacao.casosDeUso.CadastrarContratoUseCase;
import br.pucrs.nomeusuario.exemplo.aplicacao.casosDeUso.CadastrarUsoUseCase;
import br.pucrs.nomeusuario.exemplo.aplicacao.casosDeUso.CancelarContratoUseCase;
import br.pucrs.nomeusuario.exemplo.dominio.Jogo;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {

    private final CadastrarContratoUseCase cadastrarContratoUseCase;
    private final CadastrarUsoUseCase cadastrarUsoUseCase;
    private final AtualizarSituacaoJogoUseCase atualizarSituacaoJogoUseCase;
    private final CancelarContratoUseCase cancelarContratoUseCase;

    public CadastroController(CadastrarContratoUseCase cadastrarContratoUseCase,
                              CadastrarUsoUseCase cadastrarUsoUseCase,
                              AtualizarSituacaoJogoUseCase atualizarSituacaoJogoUseCase,
                              CancelarContratoUseCase cancelarContratoUseCase) {

        this.cadastrarContratoUseCase = cadastrarContratoUseCase;
        this.cadastrarUsoUseCase = cadastrarUsoUseCase;
        this.atualizarSituacaoJogoUseCase = atualizarSituacaoJogoUseCase;
        this.cancelarContratoUseCase = cancelarContratoUseCase;
    }

    @PostMapping("/cadcontrato")
    public boolean cadastrarContrato(@RequestBody Map<String, Object> body) {
        try {
            long id = Long.parseLong(body.get("id").toString());

            Date data = new SimpleDateFormat("dd/MM/yyyy")
                    .parse(body.get("data").toString());

            int periodo = Integer.parseInt(body.get("periodo").toString());
            String cpf = body.get("cpf").toString();
            long codigo = Long.parseLong(body.get("codigo").toString());
            long num = Long.parseLong(body.get("num").toString());

            return cadastrarContratoUseCase.executar(
                    id,
                    data,
                    periodo,
                    cpf,
                    codigo,
                    num
            );

        } catch (Exception e) {
            return false;
        }
    }

    @PostMapping("/caduso")
    public boolean cadastrarUso(@RequestBody Map<String, Object> body) {
        try {
            long idContrato = Long.parseLong(body.get("id").toString());
            long numero = Long.parseLong(body.get("numero").toString());

            Date dataInicio = new SimpleDateFormat("dd/MM/yyyy")
                    .parse(body.get("dataInicio").toString());

            Date dataFim = new SimpleDateFormat("dd/MM/yyyy")
                    .parse(body.get("dataFim").toString());

            int horarioInicio = converterHorarioParaMinutos(
                    body.get("horarioInicio").toString());

            int horarioFim = converterHorarioParaMinutos(
                    body.get("horarioFim").toString());

            return cadastrarUsoUseCase.executar(
                    idContrato,
                    numero,
                    dataInicio,
                    dataFim,
                    horarioInicio,
                    horarioFim
            );

        } catch (Exception e) {
            return false;
        }
    }

    @PutMapping("/atualizajogo/{codigo}/situacao/{status}")
    public Jogo atualizarSituacao(@PathVariable long codigo,
                                  @PathVariable String status) {

        return atualizarSituacaoJogoUseCase.executar(codigo, status);
    }

    @DeleteMapping("/cancelacontrato")
    public boolean cancelarContrato(@RequestBody Map<String, Object> body) {
        try {
            long id = Long.parseLong(body.get("id").toString());
            return cancelarContratoUseCase.executar(id);

        } catch (Exception e) {
            return false;
        }
    }

    private int converterHorarioParaMinutos(String horario) {
        String[] partes = horario.split(":");

        int horas = Integer.parseInt(partes[0].trim());
        int minutos = Integer.parseInt(partes[1].trim());

        return horas * 60 + minutos;
    }
}