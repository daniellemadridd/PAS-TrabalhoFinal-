package br.pucrs.nomeusuario.exemplo.frameworksAndDrivers.repositorios;

import org.springframework.data.repository.CrudRepository;

import br.pucrs.nomeusuario.exemplo.dominio.Cliente;

public interface IClienteJpaRepository extends CrudRepository<Cliente, Long> {

    Cliente findByCpf(String cpf);

}