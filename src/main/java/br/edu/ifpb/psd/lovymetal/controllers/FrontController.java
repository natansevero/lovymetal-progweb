/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.psd.lovymetal.controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author natan
 */
@MultipartConfig
public class FrontController extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        
        RequestDispatcher dispatcher = null;
        
        try {
            String action = req.getParameter("command"); //Parametro da url
            CommandIF command = (CommandIF) Class.forName("br.edu.ifpb.psd.lovymetal.controllers." + action).newInstance();
            command.execute(req, res);
        } catch(IOException | ClassNotFoundException | IllegalAccessException | InstantiationException | ServletException e) {
            System.out.println("Front Controller ex: " + e.getMessage());
        }
    }
}
