package br.edu.ifpb.controller;

import br.edu.ifpb.domain.Produto;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

    @Named
    @SessionScoped
    public class ProdController implements Serializable {

        private List<Produto> produtos = new ArrayList<>();
        private Produto prodSelected;
        public ProdController() {
        }

        public List<Produto> listProd(){
            BigDecimal valor = BigDecimal.valueOf(3050);
            Produto produto = new Produto();
            produto.setId(1);
            produto.setDescricao("Notebbok");
            produto.setValor(valor);
            this.produtos.add(1,produto);
            this.produtos.add(2, produto);
            return this.produtos;
        }

        public Produto getProdSelected() {
            return prodSelected;
        }

        public void setProdSelected(Produto prodSelected) {
            this.prodSelected = prodSelected;
        }
    }