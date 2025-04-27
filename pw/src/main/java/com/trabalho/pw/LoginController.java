package com.trabalho.pw;

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
                        "<h1>Login</h1>" +
                        "<form method='POST' action='/ListaProdutos/Produtos'>" +
                        "Usuário: <input type='text' name='usuario'><br>" +
                        "Email: <input type='text' name='email'><br>" +
                        "Senha: <input type='password' name='senha'><br>" +
                        "<input type='submit' value='Entrar'>" +
                        "</form>" +
                        "</body>" +
                        "</html>"
        );
    }
}
