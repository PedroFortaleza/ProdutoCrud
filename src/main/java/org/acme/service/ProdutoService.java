package org.acme.service;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

import org.acme.model.Produto;
import org.acme.repository.ProdutoRepository;

@ApplicationScoped
public class ProdutoService {

    @Inject
    ProdutoRepository repository;

    public List<Produto> listar() {
        return repository.listarTodos();
    }

    public Produto criar(Produto produto) {
        return repository.salvar(produto);
    }

    public Produto buscar(Long id) {
        return repository.buscarPorId(id);
    }

    public Produto atualizar(Long id, Produto produto) {
        return repository.atualizar(id, produto);
    }

    public boolean deletar(Long id) {
        return repository.deletar(id);
    }
}