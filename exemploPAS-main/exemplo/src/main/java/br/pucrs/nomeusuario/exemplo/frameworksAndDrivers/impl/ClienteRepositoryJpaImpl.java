package br.pucrs.nomeusuario.exemplo.frameworksAndDrivers.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.pucrs.nomeusuario.exemplo.aplicacao.repositorios.ClienteRepository;
import br.pucrs.nomeusuario.exemplo.dominio.Cliente;
import br.pucrs.nomeusuario.exemplo.frameworksAndDrivers.repositorios.IClienteJpaRepository;

@Repository
public class ClienteRepositoryJpaImpl implements ClienteRepository {

    private final IClienteJpaRepository repository;

    public ClienteRepositoryJpaImpl(IClienteJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cliente buscarPorCodigo(long cod) {
        return repository.findById(cod).orElse(null);
    }

    @Override
    public Cliente buscarPorCpf(String cpf) {
        return repository.findByCpf(cpf);
    }

    @Override
    public List<Cliente> listarTodos() {
        List<Cliente> clientes = new ArrayList<>();
        repository.findAll().forEach(clientes::add);
        return clientes;
    }

    @Override
    public void salvar(Cliente cliente) {
        repository.save(cliente);
    }
}