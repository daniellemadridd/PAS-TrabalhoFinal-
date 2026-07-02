package br.pucrs.nomeusuario.exemplo.aplicacao.repositorios;

import java.util.List;

import br.pucrs.nomeusuario.exemplo.dominio.Jogo;
import br.pucrs.nomeusuario.exemplo.dominio.StatusJogo;

public interface JogoRepository {
    Jogo buscarPorCodigo(long codigo);
    List<Jogo> listarTodos();
    List<Jogo> buscarPorStatus(StatusJogo status);
    void salvar(Jogo jogo);
}