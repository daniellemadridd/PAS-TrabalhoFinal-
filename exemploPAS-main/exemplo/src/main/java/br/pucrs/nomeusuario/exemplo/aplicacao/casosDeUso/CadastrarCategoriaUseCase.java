package br.pucrs.nomeusuario.exemplo.aplicacao.casosDeUso;

import br.pucrs.nomeusuario.exemplo.aplicacao.repositorios.CategoriaRepository;
import br.pucrs.nomeusuario.exemplo.dominio.Categoria;

public class CadastrarCategoriaUseCase {

    private final CategoriaRepository categoriaRepository;

    public CadastrarCategoriaUseCase(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public void executar(Categoria categoria) {
        if (categoriaRepository.buscarPorNumero(categoria.getNum()) != null) {
            throw new IllegalArgumentException("Já existe categoria com este número.");
        }

        categoriaRepository.salvar(categoria);
    }
}