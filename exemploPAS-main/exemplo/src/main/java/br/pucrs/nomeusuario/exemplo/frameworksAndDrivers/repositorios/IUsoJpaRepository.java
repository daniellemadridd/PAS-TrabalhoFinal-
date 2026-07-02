package br.pucrs.nomeusuario.exemplo.frameworksAndDrivers.repositorios;

import org.springframework.data.repository.CrudRepository;

import br.pucrs.nomeusuario.exemplo.dominio.Uso;

public interface IUsoJpaRepository extends CrudRepository<Uso, Long> {

}