/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.Entidades;

/**
 *
 * @author JuliermeH
 */
public class Mensagem {
    /* Todos os atributos da tabela Mensagem do banco de dados estão declarados aqui */
    private String mensagemid;
    private String remetente;
    private String destinatario;
    private String mensagem;
    
    
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
    public void setFoto(String remetente){
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
