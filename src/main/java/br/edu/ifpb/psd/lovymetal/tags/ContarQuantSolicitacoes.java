/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.psd.lovymetal.tags;

import br.edu.ifpb.psd.lovymetal.facade.FacadeFactory;
import br.edu.ifpb.psd.lovymetal.facade.FacadeIF;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author natan
 */
public class ContarQuantSolicitacoes extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        FacadeIF facade = FacadeFactory.criarFacadeFactory();
        
        PageContext context = (PageContext) this.getJspContext();
        HttpServletRequest request = (HttpServletRequest) context.getRequest();
        
        HttpSession session = request.getSession();
        int id_usuario = (int) session.getAttribute("idUsuario");
        
        this.getJspContext().setAttribute("quantSolicitacoes", facade.contarSolicitacoes(id_usuario));
    }
    
}
