package com.trabalho.pw;

import com.trabalho.pw.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    private static final String URL = "jdbc:postgresql://localhost:5432/trabalhopw";
    private static final String USER = "pwuser";
    private static final String PASSWORD = "1234";

    public Usuario buscarUsuario(String email) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "SELECT * FROM Usuario WHERE email = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                String senha = rs.getString("senha");
                String tipo = rs.getString("tipo");
                return new Usuario(nome, email, senha, tipo);
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

