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
public class VerMensagens implements CommandIF{
    /* Controlador responsável por ver as Mensagens */
    private final FacadeIF facade;
    
    public VerMensagens(){
        facade = FacadeFactory.criarFacadeFactory();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        int destinatario = Integer.getInteger(req.getParameter("id_usuario"));
        
        facade.verificarMensagens(destinatario);
    }
}
