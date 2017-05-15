/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.tags;

import br.edu.ifpb.psd.lovymetal.entidades.Postagem;
import br.edu.ifpb.psd.lovymetal.facade.FacadeFactory;
import br.edu.ifpb.psd.lovymetal.facade.FacadeIF;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Julierme Heinstein
 */
public class MostrarPostagens extends SimpleTagSupport{
    private int id_usuario;
    private List<Postagem> postagens;
    private String mensagem;
    
    public List<Postagem> Postagens() {
        id_usuario = (int) this.getJspContext().getAttribute("idUsuario");
        FacadeIF facade = null;
        try {
//            postagens = facade.verPostagens(id_usuario);
        } catch (NullPointerException e){
        }
        return postagens;
    }
    
    @Override
    public void doTag() throws JspException, IOException{
        this.getJspContext().setAttribute("postagens",Postagens());
    }
}
