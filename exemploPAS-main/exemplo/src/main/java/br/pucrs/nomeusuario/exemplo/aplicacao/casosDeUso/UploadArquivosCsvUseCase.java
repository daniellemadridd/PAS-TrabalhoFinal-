package br.pucrs.nomeusuario.exemplo.aplicacao.casosDeUso;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import br.pucrs.nomeusuario.exemplo.aplicacao.repositorios.CategoriaRepository;
import br.pucrs.nomeusuario.exemplo.aplicacao.repositorios.ClienteRepository;
import br.pucrs.nomeusuario.exemplo.aplicacao.repositorios.ContratoRepository;
import br.pucrs.nomeusuario.exemplo.aplicacao.repositorios.FormaPagamentoRepository;
import br.pucrs.nomeusuario.exemplo.aplicacao.repositorios.JogoRepository;
import br.pucrs.nomeusuario.exemplo.aplicacao.repositorios.MoedaRepository;
import br.pucrs.nomeusuario.exemplo.aplicacao.repositorios.UsoRepository;
import br.pucrs.nomeusuario.exemplo.dominio.CartaoCredito;
import br.pucrs.nomeusuario.exemplo.dominio.Categoria;
import br.pucrs.nomeusuario.exemplo.dominio.Cliente;
import br.pucrs.nomeusuario.exemplo.dominio.Contrato;
import br.pucrs.nomeusuario.exemplo.dominio.FormaPagamento;
import br.pucrs.nomeusuario.exemplo.dominio.Jogo;
import br.pucrs.nomeusuario.exemplo.dominio.Moeda;
import br.pucrs.nomeusuario.exemplo.dominio.Pix;
import br.pucrs.nomeusuario.exemplo.dominio.Uso;

@Service
public class UploadArquivosCsvUseCase {

    private final MoedaRepository moedaRepository;
    private final CategoriaRepository categoriaRepository;
    private final ClienteRepository clienteRepository;
    private final JogoRepository jogoRepository;
    private final ContratoRepository contratoRepository;
    private final UsoRepository usoRepository;
    private final FormaPagamentoRepository formaPagamentoRepository;
    private final RestTemplate restTemplate = new RestTemplate();

    private final SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

    public UploadArquivosCsvUseCase(
            MoedaRepository moedaRepository,
            CategoriaRepository categoriaRepository,
            ClienteRepository clienteRepository,
            JogoRepository jogoRepository,
            ContratoRepository contratoRepository,
            UsoRepository usoRepository,
            FormaPagamentoRepository formaPagamentoRepository) {

        this.moedaRepository = moedaRepository;
        this.categoriaRepository = categoriaRepository;
        this.clienteRepository = clienteRepository;
        this.jogoRepository = jogoRepository;
        this.contratoRepository = contratoRepository;
        this.usoRepository = usoRepository;
        this.formaPagamentoRepository = formaPagamentoRepository;
    }

    public boolean executar(MultipartFile[] arquivos) {
        try {
            Map<String, MultipartFile> mapa = new HashMap<>();

            for (MultipartFile arquivo : arquivos) {
                if (arquivo.getOriginalFilename() != null) {
                    mapa.put(arquivo.getOriginalFilename().toUpperCase(), arquivo);
                }
            }

            importarMoedas(obterArquivoObrigatorio(mapa, "MOEDAS.CSV"));
            importarCategorias(obterArquivoObrigatorio(mapa, "CATEGORIAS.CSV"));
            importarClientes(obterArquivoObrigatorio(mapa, "CLIENTES.CSV"));
            importarFormasPagamento(obterArquivoObrigatorio(mapa, "FORMASPAGAMENTO.CSV"));
            importarJogos(obterArquivoObrigatorio(mapa, "JOGOS.CSV"));
            importarContratos(obterArquivoObrigatorio(mapa, "CONTRATOS.CSV"));
            importarUsos(obterArquivoObrigatorio(mapa, "USOS.CSV"));

            return true;

        } catch (Exception e) {
            e.printStackTrace();

            try {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            } catch (Exception ignored) {
            }

            return false;
        }
    }

    private MultipartFile obterArquivoObrigatorio(Map<String, MultipartFile> mapa, String nome) {
        MultipartFile arquivo = mapa.get(nome);

        if (arquivo == null) {
            throw new IllegalArgumentException("Arquivo obrigatório não enviado: " + nome);
        }

        return arquivo;
    }

    private void importarMoedas(MultipartFile arquivo) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(arquivo.getInputStream()))) {
            br.readLine();

            String linha;
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(";", -1);

                long cod = Long.parseLong(campos[0].trim());

                if (moedaRepository.buscarPorCodigo(cod) != null) {
                    throw new IllegalArgumentException("Moeda já cadastrada: " + cod);
                }

                String nome = campos[1].trim();
                String simbolo = campos[2].trim();
                double cotacao = obterCotacaoParaReal(simbolo);

                Moeda moeda = new Moeda(cod, nome, simbolo, cotacao);

                moedaRepository.salvar(moeda);
            }
        }
    }

    private void importarCategorias(MultipartFile arquivo) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(arquivo.getInputStream()))) {
            br.readLine();

            String linha;
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(";", -1);

                long num = Long.parseLong(campos[0].trim());

                if (categoriaRepository.buscarPorNumero(num) != null) {
                    throw new IllegalArgumentException("Categoria já cadastrada: " + num);
                }

                String nome = campos[1].trim();
                double valorMinimo = Double.parseDouble(campos[2].trim());

                Categoria categoria = new Categoria(num, nome, valorMinimo);

                categoriaRepository.salvar(categoria);
            }
        }
    }

    private void importarClientes(MultipartFile arquivo) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(arquivo.getInputStream()))) {
            br.readLine();

            String linha;
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(";", -1);

                long cod = Long.parseLong(campos[0].trim());

                if (clienteRepository.buscarPorCodigo(cod) != null) {
                    throw new IllegalArgumentException("Cliente já cadastrado: " + cod);
                }

                String cpf = campos[1].trim();

                if (clienteRepository.buscarPorCpf(cpf) != null) {
                    throw new IllegalArgumentException("CPF já cadastrado: " + cpf);
                }

                Cliente cliente = new Cliente(
                        cod,
                        cpf,
                        campos[2].trim(),
                        campos[3].trim(),
                        formatoData.parse(campos[4].trim()),
                        null
                );

                clienteRepository.salvar(cliente);
            }
        }
    }

    private void importarFormasPagamento(MultipartFile arquivo) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(arquivo.getInputStream()))) {
            br.readLine();

            String linha;
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(";", -1);

                long num = Long.parseLong(campos[0].trim());

                if (formaPagamentoRepository.buscarPorNumero(num) != null) {
                    throw new IllegalArgumentException("Forma de pagamento já cadastrada: " + num);
                }

                int diaVencimento = Integer.parseInt(campos[1].trim());
                int tipo = Integer.parseInt(campos[2].trim());
                String numeroChave = campos[3].trim();

                FormaPagamento formaPagamento;

                if (tipo == 1) {
                    Date validade = formatoData.parse(campos[4].trim());

                    formaPagamento = new CartaoCredito(
                            num,
                            diaVencimento,
                            numeroChave,
                            validade
                    );

                } else if (tipo == 2) {
                    formaPagamento = new Pix(
                            num,
                            diaVencimento,
                            numeroChave
                    );

                } else {
                    throw new IllegalArgumentException("Tipo de forma de pagamento inválido: " + tipo);
                }

                formaPagamentoRepository.salvar(formaPagamento);
            }
        }
    }

    private void importarJogos(MultipartFile arquivo) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(arquivo.getInputStream()))) {
            br.readLine();

            String linha;
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(";", -1);

                long codigo = Long.parseLong(campos[0].trim());

                if (jogoRepository.buscarPorCodigo(codigo) != null) {
                    throw new IllegalArgumentException("Jogo já cadastrado: " + codigo);
                }

                String nome = campos[1].trim();
                int ano = Integer.parseInt(campos[2].trim());
                double valorMinuto = Double.parseDouble(campos[3].trim());

                long numCategoria = Long.parseLong(campos[4].trim());
                long codMoeda = Long.parseLong(campos[5].trim());

                Categoria categoria = categoriaRepository.buscarPorNumero(numCategoria);
                Moeda moeda = moedaRepository.buscarPorCodigo(codMoeda);

                if (categoria == null || moeda == null) {
                    throw new IllegalArgumentException("Categoria ou moeda não encontrada para o jogo: " + codigo);
                }

                Jogo jogo = new Jogo(
                        codigo,
                        nome,
                        ano,
                        valorMinuto,
                        categoria,
                        moeda
                );

                jogoRepository.salvar(jogo);
            }
        }
    }

    private void importarContratos(MultipartFile arquivo) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(arquivo.getInputStream()))) {
            br.readLine();

            String linha;
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(";", -1);

                long id = Long.parseLong(campos[0].trim());

                if (contratoRepository.buscarPorId(id) != null) {
                    throw new IllegalArgumentException("Contrato já cadastrado: " + id);
                }

                Date data = formatoData.parse(campos[1].trim());
                int periodo = Integer.parseInt(campos[2].trim());

                long codCliente = Long.parseLong(campos[3].trim());
                long codigoJogo = Long.parseLong(campos[4].trim());
                long numFormaPagamento = Long.parseLong(campos[5].trim());

                Cliente cliente = clienteRepository.buscarPorCodigo(codCliente);
                Jogo jogo = jogoRepository.buscarPorCodigo(codigoJogo);
                FormaPagamento formaPagamento =
                        formaPagamentoRepository.buscarPorNumero(numFormaPagamento);

                if (cliente == null || jogo == null || formaPagamento == null) {
                    throw new IllegalArgumentException("Dados inválidos para o contrato: " + id);
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
                jogoRepository.salvar(jogo);
            }
        }
    }

    private void importarUsos(MultipartFile arquivo) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(arquivo.getInputStream()))) {
            br.readLine();

            String linha;
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(";", -1);

                long numero = Long.parseLong(campos[0].trim());

                if (usoRepository.buscarPorNumero(numero) != null) {
                    throw new IllegalArgumentException("Uso já cadastrado: " + numero);
                }

                Date dataInicio = formatoData.parse(campos[1].trim());
                Date dataFim = formatoData.parse(campos[2].trim());

                int horarioInicio = converterHorarioParaMinutos(campos[3].trim());
                int horarioFim = converterHorarioParaMinutos(campos[4].trim());

                long idContrato = Long.parseLong(campos[5].trim());

                Contrato contrato = contratoRepository.buscarPorId(idContrato);

                if (contrato == null) {
                    throw new IllegalArgumentException("Contrato não encontrado para o uso: " + numero);
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
            }
        }
    }

    private int converterHorarioParaMinutos(String horario) {
        String[] partes = horario.split(":");

        int horas = Integer.parseInt(partes[0].trim());
        int minutos = Integer.parseInt(partes[1].trim());

        return horas * 60 + minutos;
    }

    private double obterCotacaoParaReal(String simbolo) {

        String url = "http://localhost:8000/conversormonetario/converte/origem/"
                + simbolo.toUpperCase()
                + "/destino/BRL/quantidade/1";

        Double cotacao = restTemplate.getForObject(url, Double.class);

        if (cotacao == null) {
            throw new IllegalArgumentException("Não foi possível obter cotação para: " + simbolo);
        }

        return cotacao;
    }
}