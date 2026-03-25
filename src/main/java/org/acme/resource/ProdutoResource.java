package org.acme.resource;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import java.util.List;

import org.acme.model.Produto;
import org.acme.service.ProdutoService;

@Path("/produtos")
@Produces("application/json")
@Consumes("application/json")
public class ProdutoResource {

    @Inject
    ProdutoService service;

    @GET
    public List<Produto> listar() {
        return service.listar();
    }

    @POST
    public Produto criar(Produto produto) {
        return service.criar(produto);
    }

    @GET
    @Path("/{id}")
    public Produto buscar(@PathParam("id") Long id) {
        return service.buscar(id);
    }

    @PUT
    @Path("/{id}")
    public Produto atualizar(@PathParam("id") Long id, Produto produto) {
        return service.atualizar(id, produto);
    }

    @DELETE
    @Path("/{id}")
    public boolean deletar(@PathParam("id") Long id) {
        return service.deletar(id);
    }
}