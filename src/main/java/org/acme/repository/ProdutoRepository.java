package org.acme.repository;

import org.acme.model.Produto;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ProdutoRepository {

    private List<org.acme.model.Produto> produtos = new ArrayList<>();
    private Long idCounter = 1L;

    public List<org.acme.model.Produto> listarTodos() {
        return produtos;
    }

    public Produto salvar(Produto produto) {
        produto.id = idCounter++;
        produtos.add(produto);
        return produto;
    }

    public org.acme.model.Produto buscarPorId(Long id) {
        return produtos.stream()
                .filter(p -> p.id.equals(id))
                .findFirst()
                .orElse(null);
    }

    public Produto atualizar(Long id, Produto novoProduto) {
        Produto produto = buscarPorId(id);

        if (produto != null) {
            produto.nome = novoProduto.nome;
            produto.preco = novoProduto.preco;
            produto.estoque = novoProduto.estoque;
        }

        return produto;
    }

    public boolean deletar(Long id) {
        return produtos.removeIf(p -> p.id.equals(id));
    }
}