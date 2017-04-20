/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.psd.lovymetal.controllers;

import br.edu.ifpb.psd.lovymetal.facade.FacadeFactory;
import br.edu.ifpb.psd.lovymetal.facade.FacadeIF;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author natan
 */
public class AdicionarUsuario implements CommandIF {

    private final FacadeIF facade;
    
    public AdicionarUsuario() {
        this.facade = FacadeFactory.criarFacadeFactory();
    }
    
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        // request getParameter's
        // Temporario <=> Simbolico
        facade.adicionarUsuario(0, null, null, null, null, null, null, null, null, null, 0, 0, null, null);
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("login.jsp");
        dispatcher.forward(req, res);
    }
    
}
