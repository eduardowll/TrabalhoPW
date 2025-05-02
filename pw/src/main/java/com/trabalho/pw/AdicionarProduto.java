package com.trabalho.pw;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/AdicionarProduto")
public class AdicionarProduto {

    @RequestMapping("/1/{idProduto}") //,
    public void AddProduto1(@PathVariable("idProduto") long idProduto, HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession(false);
        long idCliente = (Long) session.getAttribute("id");

        Integer isIn = ProdutosEmCarrinhoDAO.adicionar(idCliente, idProduto);

        System.out.println("isIn:" + isIn);

        if(isIn.equals(0)){
            ProdutosEmCarrinhoDAO.novoCarrinho(idCliente, idProduto);
        }





        response.sendRedirect("/ListaProdutos/Produtos");
    }

    @RequestMapping("/2/{idProduto}")
    public void AddProduto2(@PathVariable("idProduto") long idProduto, HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession(false);
        long idCliente = (Long) session.getAttribute("id");

        System.out.println(ProdutosEmCarrinhoDAO.adicionar(idCliente, idProduto));


        response.sendRedirect("/carrinho/v1");
    }

}

