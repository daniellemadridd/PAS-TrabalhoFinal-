package br.pucrs.nomeusuario.exemplo.aplicacao.casosDeUso;

import org.springframework.stereotype.Service;

import br.pucrs.nomeusuario.exemplo.aplicacao.repositorios.ClienteRepository;
import br.pucrs.nomeusuario.exemplo.aplicacao.repositorios.ContratoRepository;
import br.pucrs.nomeusuario.exemplo.dominio.Cliente;
import br.pucrs.nomeusuario.exemplo.dominio.Contrato;
import br.pucrs.nomeusuario.exemplo.dominio.Jogo;
import br.pucrs.nomeusuario.exemplo.dominio.Uso;

@Service
public class ConsultarTotalClienteUseCase {

    private final ClienteRepository clienteRepository;
    private final ContratoRepository contratoRepository;

    public ConsultarTotalClienteUseCase(ClienteRepository clienteRepository,
                                        ContratoRepository contratoRepository) {
        this.clienteRepository = clienteRepository;
        this.contratoRepository = contratoRepository;
    }

    public double executar(String cpf) {
        Cliente cliente = clienteRepository.buscarPorCpf(cpf);

        if (cliente == null) {
            return 0;
        }

        double total = 0;

        for (Contrato contrato : contratoRepository.listarTodos()) {
            if (contrato.getCliente().getCpf().equals(cpf)) {

                for (Uso uso : contrato.getUsos()) {
                    Jogo jogo = contrato.getJogo();

                    double valorMinutoEmReais = jogo.getMoeda()
                            .converterParaReal(jogo.getValorMinuto());

                    double valorUso = jogo.getCategoria().getValorMinimo()
                            + uso.calcularMinutos() * valorMinutoEmReais;

                    total += valorUso;
                }
            }
        }

        if (total > 500) {
            total = total * 0.97;
        }

        return total;
    }
}