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
import java.util.Map;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Julierme Heinstein
 */
public class MensagensRemetente extends SimpleTagSupport{
    private int id_usuario;
    private int remetente;
    private List<Map<String, String>> mensagens;
    private String mensagem;
    
    public List<Map<String, String>> Mensagens() {
        id_usuario = (int) this.getJspContext().getAttribute("id_usuario");
        remetente = (int) this.getJspContext().getAttribute("id_pessoa");
        FacadeIF facade = null;
        try {
            mensagens = facade.lerMensagens(id_usuario, remetente);
        } catch (NullPointerException e){
        }
        return mensagens;
    }
    
    @Override
    public void doTag() throws JspException, IOException{
        this.getJspContext().setAttribute(mensagem, Mensagens());
    }
}
