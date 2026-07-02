package br.pucrs.nomeusuario.exemplo.frameworksAndDrivers.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.pucrs.nomeusuario.exemplo.dominio.Jogo;
import br.pucrs.nomeusuario.exemplo.dominio.StatusJogo;

public interface IJogoJpaRepository extends CrudRepository<Jogo, Long> {

    List<Jogo> findByStatus(StatusJogo status);

}