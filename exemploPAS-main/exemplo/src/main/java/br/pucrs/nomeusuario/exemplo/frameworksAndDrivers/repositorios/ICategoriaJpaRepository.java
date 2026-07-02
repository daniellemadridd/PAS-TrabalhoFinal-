package br.pucrs.nomeusuario.exemplo.frameworksAndDrivers.repositorios;

import org.springframework.data.repository.CrudRepository;

import br.pucrs.nomeusuario.exemplo.dominio.Categoria;


public interface ICategoriaJpaRepository extends CrudRepository<Categoria, Long> {
}