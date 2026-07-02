package br.pucrs.nomeusuario.exemplo.frameworksAndDrivers.repositorios;

import org.springframework.data.repository.CrudRepository;

import br.pucrs.nomeusuario.exemplo.dominio.Contrato;

public interface IContratoJpaRepository extends CrudRepository<Contrato, Long> {
}