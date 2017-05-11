/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.psd.lovymetal.controllers;

import br.edu.ifpb.psd.lovymetal.entidades.Usuario;
import br.edu.ifpb.psd.lovymetal.facade.FacadeFactory;
import br.edu.ifpb.psd.lovymetal.facade.FacadeIF;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author natan
 */
public class PesquisarUsuario implements CommandIF {

    private final FacadeIF facade;
    
    public PesquisarUsuario() {
        facade = FacadeFactory.criarFacadeFactory();
    }
    
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String input_pesquisar = req.getParameter("pesquisar");
        
        if(input_pesquisar != null) {
            List<Map<String, String>> usuarios = facade.pesquisarUsuario(input_pesquisar);
//            System.out.println("usuarios: " + usuarios);
            
            req.setAttribute("resultadoPesquisa", usuarios);
            
            RequestDispatcher dispatcher = req.getRequestDispatcher("pesquisar.jsp");
            dispatcher.forward(req, res);
        } else {
            res.sendRedirect("home.jsp");
        }
    }
    
}
