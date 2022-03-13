package br.edu.ifpb.controller;

import br.edu.ifpb.domain.Cliente;
import br.edu.ifpb.domain.Produto;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named("prodController")
@SessionScoped
public class ProdController implements Serializable {

    private List<Produto> produtos = new ArrayList<>();
    private Produto prodSelected = new Produto();
    private Boolean finalizado = false;
    private Long quantProduto;
    private Long codCliente;
    private List<Long> Venda = new ArrayList<>();

    private static Logger logger = Logger.getLogger(ProdController.class.getName());

    public ProdController() {

        }

    public List<Produto> listProd(){
        Produto produto = new Produto();

        //TODO chamar método de lista produtos

        this.produtos.add(produto);
        logger.log(Level.INFO, "Lista Produtos" + this.produtos);
        logger.log(Level.INFO, "Selec Produtos no list" + this.prodSelected);
        return this.produtos;
    }

    public List<Produto> carrinhoCompras(){
        logger.log(Level.INFO, "Selec Produtos" + this.prodSelected);
        return this.prodSelected;
    }

    public void historicoVenda(){

    }
    public void finalizar(){

        logger.log(Level.INFO, "Carrinho: produto" + this.prodSelected +"Carrinho: quantidade"+ this.quantProduto + "Carrinho: cliente"+this.codCliente);
        //TODO chamar método de delit passando a lista de produtos selecionados this.prodSelected
        FacesContext.getCurrentInstance().addMessage("mensagens", new FacesMessage(FacesMessage.SEVERITY_INFO, "Compra realizada com sucesso", "Compra realizada com sucesso"));
        finalizado = true;
    }


    public List<Produto> getProdSelected() {
        return prodSelected;
    }

    public void setProdSelected(List<Produto> prodSelected) {
        this.prodSelected = prodSelected;
    }

    public Boolean getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(Boolean finalizado) {
        this.finalizado = finalizado;
    }

    public Long getQuantProduto() {
        return quantProduto;
    }

    public void setQuantProduto(Long quantProduto) {
        this.quantProduto = quantProduto;
    }

    public Long getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Long codCliente) {
        this.codCliente = codCliente;
    }

    public List<Long> getVenda() {
        return Venda;
    }

    public void setVenda(List<Long> venda) {
        Venda = venda;
    }
}