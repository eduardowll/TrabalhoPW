package com.trabalho.pw;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/carrinho")
public class ProdutosEmCarrinhoController {

//    @RequestMapping("/ANTIGO")
//    public void listar(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        HttpSession session = request.getSession(false);
//        ProdutosEmCarrinhoDAO produtosEmCarrinhoDAO = new ProdutosEmCarrinhoDAO();
//        List<Produto> itens = produtosEmCarrinhoDAO.listar((Long) session.getAttribute("id"));
//
//        response.setContentType("text/html");
//        response.getWriter().write("<html><body>");
//        response.getWriter().write("<h1 style='text-align: center;'>Lista de Itens no Carrinho</h1>");
//        response.getWriter().write("<center>");
//        response.getWriter().write("<table border='1' cellpadding='8' cellspacing='0' style='background-color: #fff;'>");
//        response.getWriter().write("<tr><th>Nome</th><th>Descrição</th><th>Preço</th><th>Quantidade</th></tr>");
//
//        int i = 0;
//
//        for (Produto item : itens) {
//
//            System.out.println("Iterando o for each de item pela " + i + "ª vez");
//            i++;
//
//
//            response.getWriter().write("<tr>");
//            response.getWriter().write("<td>" + item.getNome() + "</td>");
//            response.getWriter().write("<td>" + item.getDescricao() + "</td>");
//            response.getWriter().write("<td>R$" + item.getPreco() + "</td>");
//            response.getWriter().write("<td>" + item.getQntd() + "</td>");
//
//            if (item.getQntd() > 0) {
//                response.getWriter().write("<td><a href='/AdicionarProduto/2/" + item.getId().toString() + "' style='color: purple;'>Adicionar</a></td>");
//            } else {
//                response.getWriter().write("<td>Sem estoque</td>");
//            }
//
//            response.getWriter().write("</tr>");
//        }
//
//        response.getWriter().write("</table>");
//        response.getWriter().write("</center>");
//        response.getWriter().write("</body></html>");
//    }


    @RequestMapping("/v1")
    public void listar(HttpServletRequest request, HttpServletResponse response) throws IOException {


        HttpSession session = request.getSession(false);
        if (session.toString() != null && session.getAttribute("id").equals(-1)) { response.sendRedirect("/login/validarSessao"); }
        //O if acima valida a sessão !!!

        ProdutosEmCarrinhoDAO produtosEmCarrinhoDAO = new ProdutosEmCarrinhoDAO();
        long idCliente= (Long) session.getAttribute("id");






        List<Produto> produtosEmCarrinho = produtosEmCarrinhoDAO.listar(idCliente);








        response.setContentType("text/html");
        response.getWriter().write("<html><body>");
        response.getWriter().write("<h1 style='text-align: center;'> CARRINHO </h1>");
        response.getWriter().write("<center>");
        response.getWriter().write("<table border='1' cellpadding='8' cellspacing='0' style='background-color: #fff;'>");
        response.getWriter().write("<tr><th>Nome</th><th>Descrição</th><th>Preço</th><th>Quantidade</th></tr>");

        for (Produto produto : produtosEmCarrinho) {
            response.getWriter().write("<tr>");
            response.getWriter().write("<td>" + produto.getNome() + "</td>");
            response.getWriter().write("<td>" + produto.getDescricao() + "</td>");
            response.getWriter().write("<td>R$" + produto.getPreco() + "</td>");
            response.getWriter().write("<td>" + produto.getQntd() + "</td>");

            if (produto.getQntd() > 0) {
                response.getWriter().write("<td><a href='/AdicionarProduto/2/" + produto.getId().toString() + "' style='color: purple;'>Adicionar</a></td>");
            } else {
                response.getWriter().write("<td>Sem estoque</td>");
            }

            response.getWriter().write("</tr>");
        }

        response.getWriter().write("</table>");
        response.getWriter().write("<br><a href='/ListaProdutos/Produtos' style='color: red;'>Ver Loja</a>");
        response.getWriter().write("</center>");
        response.getWriter().write("</body></html>");
    }



}
