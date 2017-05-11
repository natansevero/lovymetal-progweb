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
        String apelido = req.getParameter("apelido");
        
        if(apelido != null) {
            List<Usuario> usuarios = facade.pesquisarUsuario(apelido);
            req.setAttribute("resultPesquisa", usuarios);
            
            res.sendRedirect("pesquisa.jsp");
        } else {
            res.sendRedirect("home.jsp");
        }
    }
    
}
