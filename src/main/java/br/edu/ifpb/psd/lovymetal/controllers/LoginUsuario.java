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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
            Map<String, String> dados_usuario = new HashMap<>();
            dados_usuario.put("id", ""+usuario.getID());
            dados_usuario.put("senha", ""+usuario.getSenha());
            dados_usuario.put("nome_completo", ""+usuario.getNome_completo());
            dados_usuario.put("apelido", ""+usuario.getApelido());
            dados_usuario.put("data_nasc", ""+usuario.getDatanasc());
            dados_usuario.put("cidade", ""+usuario.getCidade());
            dados_usuario.put("email", ""+usuario.getEmail());
            dados_usuario.put("profissao", ""+usuario.getProfissao());
            dados_usuario.put("descricao", ""+usuario.getDescricao());
            dados_usuario.put("sexo", ""+usuario.getSexo());
            dados_usuario.put("status", ""+usuario.getStatus());
            dados_usuario.put("altura", ""+usuario.getAltura());
            dados_usuario.put("peso", ""+usuario.getPeso());
            dados_usuario.put("cor_cabelo", ""+usuario.getCabelo());
            dados_usuario.put("foto_perfil", ""+usuario.getFotoperfil());
            
            synchronized(session) {
                session.setAttribute("emailUsuario", email);
                session.setAttribute("senhaUsuario", senha);
                session.setAttribute("fullUsuario", dados_usuario);
            }
            res.sendRedirect("secrets/home.jsp");
        } else {
            res.sendRedirect("index.html");
        }
        
        
    }
    
}
