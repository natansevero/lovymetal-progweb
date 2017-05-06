/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.psd.lovymetal.controllers;

import br.edu.ifpb.psd.lovymetal.facade.FacadeFactory;
import br.edu.ifpb.psd.lovymetal.facade.FacadeIF;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.util.Base64;
import java.util.List;

/**
 *
 * @author natan
 */
public class AdicionarUsuario implements CommandIF {

    private final FacadeIF facade;
    
    public AdicionarUsuario() {
        this.facade = FacadeFactory.criarFacadeFactory();
    }
    
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
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
        
        String appPath = req.getServletContext().getRealPath("");
        String upPath = appPath + "imagens" + File.separator + email;
        System.out.println(upPath);
        File up = new File(upPath);
        if(!up.exists()) up.mkdirs();
        
//        System.out.println(foto_perfil.getSubmittedFileName());
//        
//        String caminho = "imagens/" + apelido + "/" + foto_perfil.getSubmittedFileName(); 
        
//        System.out.println(caminho);
        
        List<Part> list = (List) req.getParts();
        
        for(Part p : list) {
            if(p.getName().equals("foto_perfil")) {
                foto_perfil = "imagens/" + email + "/" + p.getSubmittedFileName();
                p.write(upPath + File.separator + p.getSubmittedFileName());      
            }
        }
                
        facade.adicionarUsuario(senha, nome_completo, apelido, data_nasc, cidade, email, profissao, descricao, sexo, status, altura, peso, cor_cabelo, foto_perfil);
            
//        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("home.jsp");
//        dispatcher.forward(req, res);
        res.sendRedirect("index.html");
    }
    
}
