package com.trabalho.pw;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class ProdutoDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/trabalhopw";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public List<Produto> listarProdutos() {
        List<Produto> produtos = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "SELECT * FROM produto";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Long id = rs.getLong("id");
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                String valorPreco = String.valueOf(rs.getBigDecimal("preco"));
                double preco = Double.valueOf(valorPreco);
                int qntd = rs.getInt("qntd");
                produtos.add(new Produto(id, nome, descricao, preco, qntd));
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return produtos;
    }
}
