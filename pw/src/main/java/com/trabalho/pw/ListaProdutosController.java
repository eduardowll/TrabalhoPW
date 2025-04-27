package com.trabalho.pw;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/ListaProdutos")
public class ListaProdutosController{

    @RequestMapping("/Produtos")
    public void listar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<Produto> produtos = produtoDAO.listarProdutos();

        response.setContentType("text/html");
        response.getWriter().write("<html><body>");
        response.getWriter().write("<h1 style='text-align: center;'>Lista de Produtos</h1>");
        response.getWriter().write("<center>");
        response.getWriter().write("<table border='1' cellpadding='8' cellspacing='0' style='background-color: #fff;'>");
        response.getWriter().write("<tr><th>Nome</th><th>Descrição</th><th>Preço</th><th>Quantidade</th><th>Carrinho</th></tr>");

        for (Produto produto : produtos) {
            response.getWriter().write("<tr>");
            response.getWriter().write("<td>" + produto.getNome() + "</td>");
            response.getWriter().write("<td>" + produto.getDescricao() + "</td>");
            response.getWriter().write("<td>R$" + produto.getPreco() + "</td>");
            response.getWriter().write("<td>" + produto.getQntd() + "</td>");

            if (produto.getQntd() > 0) {
                response.getWriter().write("<td><a href='#' style='color: purple;'>Adicionar</a></td>");
            } else {
                response.getWriter().write("<td>Sem estoque</td>");
            }

            response.getWriter().write("</tr>");
        }

        response.getWriter().write("</table>");
        response.getWriter().write("<br><a href='#' style='color: red;'>Ver Carrinho</a>");
        response.getWriter().write("</center>");
        response.getWriter().write("</body></html>");
    }
}
