/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.entidades;

import java.io.Serializable;

/**
 *
 * @author JuliermeH
 */
public class Mensagem implements Serializable{
    /* Todos os atributos da tabela Mensagem do banco de dados estão declarados aqui */
    private String mensagemid;
    private String remetente;
    private String destinatario;
    private String mensagem;
    
    public Mensagem(){
    }
    
    public Mensagem(String id, String remetente, String destinatario, String mensagem){
        this.mensagemid = id;
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.mensagem = mensagem;
    }
    
     /* get e set de id */
    public String getMensagemID(){
        return this.mensagemid;
    }
    public void setMensagemID(String mensagemid){
        mensagemid = this.mensagemid;
    }
    
     /* get e set de Remetente */
    public String getRemetente(){
        return this.remetente;
    }
    public void setRemetente(String remetente){
        remetente = this.remetente;
    }
    
     /* get e set de Destinatario */
    public String getDestinatario(){
        return this.destinatario;
    }
    public void setDestinatario(String destinatario){
        destinatario = this.destinatario;
    }
    
     /* get e set de Mensagem */
    public String getMensagem(){
        return this.mensagem;
    }
    public void setMensagem(String mensagem){
        mensagem = this.mensagem;
    }
}
