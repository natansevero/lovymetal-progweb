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
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author natan
 */
public class EditarUsuario implements CommandIF {

    private final FacadeIF facade;
    
    public EditarUsuario() {
        this.facade = FacadeFactory.criarFacadeFactory();
    }
    
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        // Pegar todos os parametros da requisição
        // Tratá-los
        // Chamar o método atualizarUsuario da Facade
        
        HttpSession session = req.getSession();
        Map<String, String> dados_usuario = dados_usuario = (Map<String, String>) session.getAttribute("fullUsuario");
        
        int id_usuario = Integer.parseInt(dados_usuario.get("id")); 
        
        System.out.println(id_usuario);
        
        String nome_completo = req.getParameter("nome_completo");
        String apelido = req.getParameter("apelido");
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");
        String sexo = req.getParameter("sexo");
        String data_nasc = req.getParameter("data_nasc");
        String cidade = req.getParameter("cidade");
        String profissao = req.getParameter("profissao");
        String descricao = req.getParameter("descricao");
        String status = req.getParameter("status");
        double altura = Double.parseDouble(req.getParameter("altura"));
        double peso = Double.parseDouble(req.getParameter("peso"));
        String cor_cabelo = req.getParameter("cor_cabelo");
        String foto_perfil = null;
        
        if(facade.atualizarUsuario(id_usuario, senha, nome_completo, apelido, data_nasc, cidade, email, profissao, descricao, sexo, status, altura, peso, cor_cabelo, foto_perfil)) {
            Usuario usuario_atualizado = facade.getByEmail(email);
            
            Map<String, String> novos_dados_usuario = new HashMap<>();
            novos_dados_usuario.put("id", ""+usuario_atualizado.getID());
            novos_dados_usuario.put("senha", ""+usuario_atualizado.getSenha());
            novos_dados_usuario.put("nome_completo", ""+usuario_atualizado.getNome_completo());
            novos_dados_usuario.put("apelido", ""+usuario_atualizado.getApelido());
            novos_dados_usuario.put("data_nasc", ""+usuario_atualizado.getDatanasc());
            novos_dados_usuario.put("cidade", ""+usuario_atualizado.getCidade());
            novos_dados_usuario.put("email", ""+usuario_atualizado.getEmail());
            novos_dados_usuario.put("profissao", ""+usuario_atualizado.getProfissao());
            novos_dados_usuario.put("descricao", ""+usuario_atualizado.getDescricao());
            novos_dados_usuario.put("sexo", ""+usuario_atualizado.getSexo());
            novos_dados_usuario.put("status", ""+usuario_atualizado.getStatus());
            novos_dados_usuario.put("altura", ""+usuario_atualizado.getAltura());
            novos_dados_usuario.put("peso", ""+usuario_atualizado.getPeso());
            novos_dados_usuario.put("cor_cabelo", ""+usuario_atualizado.getCabelo());
            novos_dados_usuario.put("foto_perfil", ""+usuario_atualizado.getFotoperfil());
            
                
            session.setAttribute("fullUsuario", novos_dados_usuario);
                   
            res.sendRedirect("home.jsp");
        } else {
            res.sendRedirect("editar.jsp");
        }
    }
    
}
