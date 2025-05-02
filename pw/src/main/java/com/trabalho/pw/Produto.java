package com.trabalho.pw;

public class Produto {

    private Long id;
    private String nome;
    private String descricao;
    private double preco;
    private int qntd;

    public Produto(Long id, String nome, String descricao, double preco, int qntd) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.qntd = qntd;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public int getQntd() {
        return qntd;
    }

    public void incrementaQntd() {
        this.qntd++;
    }

    public void diminuiQntd() {
        this.qntd--;
    }
}
