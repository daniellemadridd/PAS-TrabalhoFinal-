package br.pucrs.daniellegabriella.demo.infrastructure.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Primary
public class RepositorioJpaImpl implements RepositorioJpa {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public <T> T salvar(T entidade) {
		return entityManager.merge(entidade);
	}

	@Override
	@Transactional(readOnly = true)
	public <T> java.util.List<T> listarTodos(Class<T> tipoEntidade) {
		return entityManager.createQuery("select e from " + tipoEntidade.getSimpleName() + " e", tipoEntidade)
				.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public <T, ID> java.util.Optional<T> buscarPorId(Class<T> tipoEntidade, ID id) {
		return java.util.Optional.ofNullable(entityManager.find(tipoEntidade, id));
	}

	@Override
	@Transactional
	public <T> void remover(T entidade) {
		T entidadeGerenciada = entityManager.contains(entidade) ? entidade : entityManager.merge(entidade);
		entityManager.remove(entidadeGerenciada);
	}

}