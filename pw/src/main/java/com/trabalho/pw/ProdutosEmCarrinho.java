package com.trabalho.pw;

public class ProdutosEmCarrinho {

    private int idCliente;
    private int idProduto;
    private int qntd;

    public ProdutosEmCarrinho(int idCliente, int idProduto, int qntd) {
        this.idCliente=idCliente;
        this.idProduto=idProduto;
        this.qntd=qntd;
    }

    //getters
    public int getIdCliente() {
        return idCliente;
    }
    public int getIdProduto() {
        return idProduto;
    }
    public int getQntd() {
        return qntd;
    }


}