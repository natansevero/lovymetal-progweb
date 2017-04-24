/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.psd.lovymetal.controllers;

import br.edu.ifpb.psd.lovymetal.entidades.Usuario;
import br.edu.ifpb.psd.lovymetal.facade.FacadeFactory;
import br.edu.ifpb.psd.lovymetal.facade.FacadeIF;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author natan
 */
public class LoginUsuario implements CommandIF {

    private final FacadeIF facade;
    
    public LoginUsuario() {
        facade = FacadeFactory.criarFacadeFactory();
    }
    
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");
        
        HttpSession session = req.getSession(true);
        
        List<Usuario> usuarios = facade.listarUsuarios();
        
        System.out.println(usuarios);
        
        Usuario usuario = new Usuario();
        boolean autoriza = false;
        
        for(Usuario user : usuarios) {
            if(user.getEmail().equals(email) && user.getSenha().equals(senha)){
                autoriza = true;
                usuario = user;
                break;
            }
        }
        
        if(autoriza) {
            synchronized(session) {
                session.setAttribute("emailUsuario", email);
                session.setAttribute("senhaUsuario", senha);
                session.setAttribute("fullUsuario", usuario);
            }
            res.sendRedirect("home.html");
        } else {
            res.sendRedirect("index.html");
        }
        
        
    }
    
}
