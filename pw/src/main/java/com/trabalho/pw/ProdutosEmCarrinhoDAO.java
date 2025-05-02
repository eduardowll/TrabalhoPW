package com.trabalho.pw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class ProdutosEmCarrinhoDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/trabalhopw";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public List<Produto> listar(long idCliente) {
        List<Produto> itens = new ArrayList<>();


        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "SELECT DISTINCT p.id, p.nome, p.descricao, p.preco, c.qntd FROM produto as p, usuario as u, carrinho as c " +
                         "WHERE c.idCliente = ? AND u.id = c.idCliente AND p.id = c.idProduto;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, idCliente);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Long id = rs.getLong("id");
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                double preco = rs.getDouble("preco");
                int qntd = rs.getInt("qntd");
                itens.add(new Produto(id, nome, descricao, preco, qntd));
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return itens;
    }


    public static Integer adicionar(Long idCliente, Long idProduto) {


        System.out.println("idCliente:" + idCliente);


        Integer resultado = -10;


        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "UPDATE carrinho SET qntd = qntd + 1 WHERE idCliente = ? AND idProduto = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, idCliente);
            stmt.setLong(2, idProduto);
            resultado = stmt.executeUpdate();


            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;

    }

    public static void novoCarrinho(long idCliente, long idProduto) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "INSERT INTO carrinho(idCliente, idProduto,qntd) VALUES (?,?,1);";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, idCliente);
            stmt.setLong(2, idProduto);
            stmt.execute();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //INSERT INTO carrinho(idCliente, idProduto, qntd) VALUES(0,0,0);




}
