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
public class ExcluiPostagem implements CommandIF{
    /* Controlador responsável por excluir postagens */
    private final FacadeIF facade;
    
    public ExcluiPostagem(){
        facade = FacadeFactory.criarFacadeFactory();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        int id_postagem = Integer.valueOf(req.getParameter("id_postagem"));
        int id_usuario = Integer.valueOf(req.getParameter("id_usuario"));
        
//        facade.excluiPostagem(id_postagem, id_usuario);
        res.sendRedirect("home.jsp");
    }
    
}
