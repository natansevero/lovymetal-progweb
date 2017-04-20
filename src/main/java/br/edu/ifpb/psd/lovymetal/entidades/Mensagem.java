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
    private int mensagemid;
    private int remetente;
    private int destinatario;
    private String mensagem;
    private int status;
    
    public Mensagem(){
    }
    
    public Mensagem(int mensagemid, int remetente, int destinatario, String mensagem, int status){
        this.mensagemid = mensagemid;
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.mensagem = mensagem;
        this.status = status;
    }
    
    /* get e set de id */
    public int getMensagemID(){
        return this.mensagemid;
    }
    public void setMensagemID(int mensagemid){
        mensagemid = this.mensagemid;
    }
    
     /* get e set de Remetente */
    public int getRemetente(){
        return this.remetente;
    }
    public void setRemetente(int remetente){
        remetente = this.remetente;
    }
    
     /* get e set de Destinatario */
    public int getDestinatario(){
        return this.destinatario;
    }
    public void setDestinatario(int destinatario){
        destinatario = this.destinatario;
    }
    
     /* get e set de Mensagem */
    public String getMensagem(){
        return this.mensagem;
    }
    public void setMensagem(String mensagem){
        mensagem = this.mensagem;
    }
    
    /* get e set de status */
    public int getStatus(){
        return this.status;
    }
    public void setStatus(int status){
        this.status = status;
    }
}
