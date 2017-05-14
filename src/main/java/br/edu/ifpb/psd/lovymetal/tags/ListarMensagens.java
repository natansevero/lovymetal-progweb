/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.tags;

import br.edu.ifpb.psd.lovymetal.entidades.Mensagem;
import br.edu.ifpb.psd.lovymetal.facade.FacadeIF;
import java.io.IOException;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Julierme Heinstein
 */
public class ListarMensagens extends SimpleTagSupport{
    private int id_usuario;
    private List<Mensagem> mensagens;
    private String mensagem;
    
    public List<Mensagem> Mensagens() {
        id_usuario = (int) this.getJspContext().getAttribute("id_usuario");
        FacadeIF facade = null;
        try {
            mensagens = facade.verificarMensagens(id_usuario);
        } catch (NullPointerException e){
        }
        return mensagens;
    }
    
    @Override
    public void doTag() throws JspException, IOException{
        this.getJspContext().setAttribute(mensagem, Mensagens());
        int len = mensagens.size();
        if(len == 0){
            mensagem = "Não há mensagens ainda";
        }
    }
}
