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
import javax.servlet.http.HttpSession;

/**
 *
 * @author natan
 */
public class AceitarSolicitacao implements CommandIF {
    
    private final FacadeIF facade;
    
    public AceitarSolicitacao() {
        this.facade = FacadeFactory.criarFacadeFactory();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        HttpSession session = req.getSession();
        
        // Id de quem mandou a solicitação
        int id_solicitador = Integer.parseInt(req.getParameter("id_solicitador"));
        
        // O usuário da sessão é que recebe a solicitação
        int id_solicitante = (int) session.getAttribute("idUsuario");
        
        if(facade.aceitarSolicitacao(id_solicitador, id_solicitante) && facade.novaAmizade(id_solicitante, id_solicitador)) 
            res.sendRedirect("home.jsp");
        else 
            res.sendRedirect("home.jsp");
    }
    
    
}
