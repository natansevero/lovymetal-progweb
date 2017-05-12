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
public class NovaGaleria implements CommandIF{
    /* Controlador responsável por criar uma nova Galeria */
    private final FacadeIF facade;
    
    public NovaGaleria(){
        facade = FacadeFactory.criarFacadeFactory();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        int galeria_id = Integer.getInteger(req.getParameter("galeria_id"));
        int id_usuario = Integer.getInteger(req.getParameter("id_usuario"));
        String nomegaleria = req.getParameter("nomegaleria");
        String foto = req.getParameter("foto");
        
        facade.novaGaleria(galeria_id, id_usuario, nomegaleria, foto);
        res.sendRedirect("home.jsp");
    }
}
