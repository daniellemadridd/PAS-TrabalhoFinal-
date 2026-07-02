package br.pucrs.nomeusuario.exemplo.frameworksAndDrivers.repositorios;

import org.springframework.data.repository.CrudRepository;

import br.pucrs.nomeusuario.exemplo.dominio.Moeda;

public interface IMoedaJpaRepository extends CrudRepository<Moeda, Long> {
}