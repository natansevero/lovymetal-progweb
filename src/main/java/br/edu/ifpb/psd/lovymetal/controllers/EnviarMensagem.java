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
public class EnviarMensagem implements CommandIF{
    /* Controlador responsável por enviar uma nova Mensagem */
    private final FacadeIF facade;
    
    public EnviarMensagem(){
        facade = FacadeFactory.criarFacadeFactory();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        int mensagemid = Integer.getInteger(req.getParameter("mensagemid"));
        int remetente = Integer.getInteger(req.getParameter("remetente"));
        int destinatario = Integer.getInteger(req.getParameter("destinatario"));
        String mensagem = req.getParameter("mensagem");
        int status = Integer.getInteger(req.getParameter("status"));
        
        facade.enviarMensagem(mensagemid, remetente, destinatario, mensagem, status);
        res.sendRedirect("home.jsp");
    }
        
}
