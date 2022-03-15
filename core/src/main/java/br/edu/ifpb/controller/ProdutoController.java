package br.edu.ifpb.controller;

import br.edu.ifpb.domain.CarrinhoCompras;
import br.edu.ifpb.domain.Cliente;
import br.edu.ifpb.domain.Produto;
import br.edu.ifpb.service.Produto.DeleteProduto;
import br.edu.ifpb.service.Produto.ListaProduto;
import br.edu.ifpb.service.Produto.AddProduto;
import br.edu.ifpb.service.Produto.UpdateProduto;
import br.edu.ifpb.service.Produto.SearchProduto;


import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named("produtoControllar")
@SessionScoped
public class ProdutoController implements Serializable {

    @Inject
    private ListaProduto listaProduto;
    @Inject
    private AddProduto addProduto;
    @Inject
    private UpdateProduto  updateProduto;
    @Inject
    private DeleteProduto deleteProduto;
    @Inject
    private SearchProduto searchProduto;

    private List<Produto> produtos = new ArrayList<>();
    private Produto produto = new Produto();
    private String descricao;


    private static Logger logger = Logger.getLogger(ProdController.class.getName());

    public List<Produto> listProd() throws SQLException, ClassNotFoundException {
        List<Produto> prods = this.listaProduto.listarTodosProd();
        logger.log(Level.INFO, "Lista Produtos" + prods);
        return prods;
    }
    public String setAddProduto(){

        if(this.produto.getId() > 0){
            this.updateProduto.atualizarProduto(this.produto);
        } else{
            this.addProduto.adicionarProduto(this.produto);
        }
        this.produto = new Produto();

        return "/Produto/list?faces-redirect=true";
    }

    public String setUpdateProduto(Produto produto){
        this.produto = produto;
        return "/Produto/edit?faces-redirect=true";
    }

//    public String setDeleteProduto(Produto produto){
//
//        this.deleteProduto.removeProduto(produto); "está esperando o id do produto, um inteiro"
//        return "/Produto/list?faces-redirect=true";
//    }

    public List<Produto> setSearchProduto(){
        return this.searchProduto.buscarDescricao(this.descricao);
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }



}


