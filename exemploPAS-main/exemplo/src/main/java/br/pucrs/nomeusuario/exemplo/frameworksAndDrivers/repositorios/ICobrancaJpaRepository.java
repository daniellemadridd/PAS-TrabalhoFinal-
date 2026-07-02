package br.pucrs.nomeusuario.exemplo.frameworksAndDrivers.repositorios;

import org.springframework.data.repository.CrudRepository;

import br.pucrs.nomeusuario.exemplo.dominio.Cobranca;

public interface ICobrancaJpaRepository extends CrudRepository<Cobranca, Long> {
}