package br.edu.ifpb.domain;

import java.sql.SQLException;
import java.util.List;

public interface ProdutoInterface {

    public List<Produto> listaProdutos() throws ClassNotFoundException, SQLException;

    public void insertProduto (Produto produto);

    public void updateProduto (Produto produto);

    public void deleteProduto (Produto produto);



}
