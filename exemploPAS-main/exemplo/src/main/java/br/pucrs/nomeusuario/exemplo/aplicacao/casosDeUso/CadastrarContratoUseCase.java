package br.pucrs.nomeusuario.exemplo.aplicacao.casosDeUso;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.pucrs.nomeusuario.exemplo.aplicacao.repositorios.ClienteRepository;
import br.pucrs.nomeusuario.exemplo.aplicacao.repositorios.ContratoRepository;
import br.pucrs.nomeusuario.exemplo.aplicacao.repositorios.FormaPagamentoRepository;
import br.pucrs.nomeusuario.exemplo.aplicacao.repositorios.JogoRepository;
import br.pucrs.nomeusuario.exemplo.dominio.Cliente;
import br.pucrs.nomeusuario.exemplo.dominio.Contrato;
import br.pucrs.nomeusuario.exemplo.dominio.FormaPagamento;
import br.pucrs.nomeusuario.exemplo.dominio.Jogo;
import br.pucrs.nomeusuario.exemplo.dominio.StatusJogo;

@Service
public class CadastrarContratoUseCase {

    private final ContratoRepository contratoRepository;
    private final ClienteRepository clienteRepository;
    private final JogoRepository jogoRepository;
    private final FormaPagamentoRepository formaPagamentoRepository;

    public CadastrarContratoUseCase(
            ContratoRepository contratoRepository,
            ClienteRepository clienteRepository,
            JogoRepository jogoRepository,
            FormaPagamentoRepository formaPagamentoRepository) {

        this.contratoRepository = contratoRepository;
        this.clienteRepository = clienteRepository;
        this.jogoRepository = jogoRepository;
        this.formaPagamentoRepository = formaPagamentoRepository;
    }

    public boolean executar(long id,
                            Date data,
                            int periodo,
                            String cpf,
                            long codigo,
                            long num) {

        if (contratoRepository.buscarPorId(id) != null) {
            return false;
        }

        Cliente cliente = clienteRepository.buscarPorCpf(cpf);
        Jogo jogo = jogoRepository.buscarPorCodigo(codigo);
        FormaPagamento formaPagamento = formaPagamentoRepository.buscarPorNumero(num);

        if (cliente == null || jogo == null || formaPagamento == null) {
            return false;
        }

        if (jogo.getStatus() != StatusJogo.DISPONIVEL) {
            return false;
        }

        Contrato contrato = new Contrato(
                id,
                data,
                periodo,
                cliente,
                jogo,
                formaPagamento
        );

        contratoRepository.salvar(contrato);

        return true;
    }
}