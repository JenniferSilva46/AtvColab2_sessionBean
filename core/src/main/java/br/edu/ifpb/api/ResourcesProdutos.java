package br.edu.ifpb.api;

import br.edu.ifpb.domain.Cliente;
import br.edu.ifpb.service.Produto.ListaProduto;
import br.edu.ifpb.service.Produto.SearchProduto;
import br.edu.ifpb.domain.Produto;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.sql.SQLException;
import java.util.List;


@Stateless
@Path("Produtos")
public class ResourcesProdutos {
    @EJB
    private ListaProduto lista;
    private SearchProduto busca;

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Produto> listarTodosProd() throws SQLException, ClassNotFoundException {
        return this.lista.listarTodosProd();
    }


    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{descricao}")
    public List<Produto> buscarDescricao(@PathParam("descricao") String descricao){
        return this.busca.buscarDescricao(descricao);
    }

}
