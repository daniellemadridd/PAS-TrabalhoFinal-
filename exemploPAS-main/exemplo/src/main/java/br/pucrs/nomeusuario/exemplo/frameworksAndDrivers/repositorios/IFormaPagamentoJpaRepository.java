package br.pucrs.nomeusuario.exemplo.frameworksAndDrivers.repositorios;

import org.springframework.data.repository.CrudRepository;

import br.pucrs.nomeusuario.exemplo.dominio.FormaPagamento;

public interface IFormaPagamentoJpaRepository extends CrudRepository<FormaPagamento, Long> {

}