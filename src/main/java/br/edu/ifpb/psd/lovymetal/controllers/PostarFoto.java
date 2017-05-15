/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.psd.lovymetal.controllers;

import br.edu.ifpb.psd.lovymetal.facade.FacadeFactory;
import br.edu.ifpb.psd.lovymetal.facade.FacadeIF;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author natan
 */
public class PostarFoto implements CommandIF {

    private final FacadeIF facade;
    
    public PostarFoto() {
        this.facade = FacadeFactory.criarFacadeFactory();
    }
    
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        HttpSession session = req.getSession();
        int id_usuario = (int) session.getAttribute("idUsuario");
        String descricao = req.getParameter("descricao");
        String foto = null;
        
        String appPath = req.getServletContext().getRealPath("");
        String upPath = appPath + "/imagens" + File.separator + session.getAttribute("emailUsuario");
        
        List<Part> list = (List) req.getParts();
        
        for(Part p : list) {
            if(p.getName().equals("foto")) {
                foto = "imagens/" + session.getAttribute("emailUsuario") + "/" + p.getSubmittedFileName();
                p.write(upPath + File.separator + p.getSubmittedFileName());      
            }
        }
    
        if(facade.postarFoto(id_usuario, descricao, foto)) {
            res.sendRedirect("home.jsp");
        } else {
            res.sendRedirect("home.jsp");
        }
    }
    
}
