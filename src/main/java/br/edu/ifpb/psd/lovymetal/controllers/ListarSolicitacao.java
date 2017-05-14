/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.psd.lovymetal.controllers;

import br.edu.ifpb.psd.lovymetal.facade.FacadeFactory;
import br.edu.ifpb.psd.lovymetal.facade.FacadeIF;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author natan
 */
public class ListarSolicitacao implements CommandIF {

    private final FacadeIF facade;
    
    public ListarSolicitacao() {
        this.facade = FacadeFactory.criarFacadeFactory();
    }
    
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        HttpSession session = req.getSession();
        int id_usuario = (int) session.getAttribute("idUsuario");
        
        // Map com dados de cada usuário que fez solicitação        
        List<Map<String, String>> lista_solicitacoes = facade.listarSolicitacao(id_usuario);
        
        req.setAttribute("listaSolicitacoes", lista_solicitacoes);
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("solicitacoes.jsp");
        dispatcher.forward(req, res);
    }
    
}
