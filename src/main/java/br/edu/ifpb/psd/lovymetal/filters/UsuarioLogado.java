/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.filters;

import br.edu.ifpb.psd.lovymetal.controllers.LoginUsuario;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Julierme Heinstein
 */
public class UsuarioLogado implements Filter{
    
   /* Filtro responsável por verificar se o Usuário está na Sessão */
   private FilterConfig config;
   private PrintWriter out;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = config;
        try{
            out = new PrintWriter(new File("Filterlog.txt"));
        } catch (FileNotFoundException ex) {
           Logger.getLogger(UsuarioLogado.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    @Override
    @SuppressWarnings("empty-statement")
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
                
        if(session.getAttribute("emailUsuario") == null){
            out.println("Usuário não logado");
            LoginUsuario login = new LoginUsuario(); 
            session = login.execute(req, res);
        } else{
            String user = (String) session.getAttribute("emailUsuario");
            out.println("Usuario "+user+" logado");
        }
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {
        config = null;
        out.close();
    }
    
}
