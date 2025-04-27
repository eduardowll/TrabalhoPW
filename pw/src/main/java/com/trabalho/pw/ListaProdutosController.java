package com.trabalho.pw;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/ListaProdutos")
public class ListaProdutosController{

    @RequestMapping("/Produtos")
    public void ListaProdutos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.getWriter().write(
                "<html>" +
                        "<body>" +
                        "<h1>OI<h1>" +
                        "<body>" +
                   "<html>"
        );
    }
}