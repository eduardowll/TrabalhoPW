package com.trabalho.pw;

import com.trabalho.pw.UsuarioDAO;
import com.trabalho.pw.Usuario;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/form")
    public void loginForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.getWriter().write(
                "<html>" +
                        "<body>" +
                        "<h1>Login e Cadastro</h1>" +
                        "<form method='POST' action='/login/cadastro'>" +
                        "Nome: <input type='text' name='nome'><br><br>" +
                        "Email: <input type='text' name='usuario'><br><br>" +
                        "Senha: <input type='password' name='senha'><br><br>" +
                        "<button type='submit' name='acao' value='login'>Login</button>" +
                        "<button type='submit' name='acao' value='cadastrar'>Cadastrar</button>" +
                        "</form>" +
                        "</body>" +
                        "</html>"
        );
    }

    @RequestMapping("/cadastro")
    public void processarLoginCadastro(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        String acao = request.getParameter("acao"); // saber se clicou em Login ou Cadastrar

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioExistente = usuarioDAO.buscarUsuario(email);

        response.setContentType("text/html");

        if ("login".equals(acao)) {
            if (usuarioExistente != null && usuarioExistente.getSenha().equals(senha)) {
                response.sendRedirect("/ListaProdutos/Produtos");
            } else {
                response.getWriter().write("<h1>Email ou senha inválidos.</h1>");
            }
        } else if ("cadastrar".equals(acao)) {
            if (usuarioExistente != null) {
                response.getWriter().write("<h1>Erro: Email já cadastrado!</h1>");
            } else {
                usuarioDAO.inserirUsuario(new Usuario(nome, email, senha, "cliente")); // Cadastra como cliente
                response.getWriter().write("<h1>Cadastro realizado com sucesso! Agora faça login.</h1>");
            }
        } else {
            response.getWriter().write("<h1>Ação inválida.</h1>");
        }
    }
}
