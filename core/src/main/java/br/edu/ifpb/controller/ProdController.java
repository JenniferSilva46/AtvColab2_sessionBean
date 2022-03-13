package br.edu.ifpb.controller;

import br.edu.ifpb.domain.Produto;

import javax.enterprise.context.SessionScoped;
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
    private Produto prodSelected;
    private static Logger logger = Logger.getLogger(ProdController.class.getName());

public ProdController() {

    }

    public List<Produto> listProd(){
        BigDecimal valor = BigDecimal.valueOf(3050);
        Produto produto = new Produto();

        this.produtos.add(produto);
        logger.log(Level.INFO, "Lista Produtos" + this.produtos);

        return this.produtos;
    }

    public Produto getProdSelected() {
        return prodSelected;
    }

    public void setProdSelected(Produto prodSelected) {
        this.prodSelected = prodSelected;
    }
}