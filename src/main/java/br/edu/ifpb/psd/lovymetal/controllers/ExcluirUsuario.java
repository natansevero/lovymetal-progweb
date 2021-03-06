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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author natan
 */
public class ExcluirUsuario implements CommandIF {
    
    private final FacadeIF facade;
    
    public ExcluirUsuario() {
        facade = FacadeFactory.criarFacadeFactory();
    }
    
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");
        
        HttpSession session = req.getSession();
        
        // Excluir a foto do servidor
        String appPath = req.getServletContext().getRealPath("");
        String local_foto = appPath + "/imagens/" + session.getAttribute("emailUsuario");
        System.out.println("Local Fotot: " + local_foto);
        File dir = new File(local_foto);
        
        if(this.deleteDir(dir) && facade.excluirUsuario(email, senha)) {
            
            session.invalidate();
            res.sendRedirect("index.html");
        } else {
            res.sendRedirect("excluir.jsp");
        }
    }
    
    private static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i=0; i<children.length; i++) { 
               boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
    
        // Agora o diretório está vazio, restando apenas deletá-lo.
        return dir.delete();
    }
    
}
