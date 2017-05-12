/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.controllers;

import br.edu.ifpb.psd.lovymetal.facade.FacadeFactory;
import br.edu.ifpb.psd.lovymetal.facade.FacadeIF;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julierme Heinstein
 */
public class NovaRelacao implements CommandIF{
    /* Controlador responsável por criar um novo Relacionamento */
    private final FacadeIF facade;
    
    public NovaRelacao(){
        facade = FacadeFactory.criarFacadeFactory();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        int id_usuario = Integer.getInteger(req.getParameter("id_usuario"));
        String tipo = req.getParameter("tipo");
        int par = Integer.getInteger(req.getParameter("par"));
        
        facade.novaRelacao(id_usuario, tipo, par);
        res.sendRedirect("home.jsp");
    }
}
