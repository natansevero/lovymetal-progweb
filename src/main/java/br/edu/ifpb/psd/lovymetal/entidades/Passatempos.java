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
public class Passatempos implements Serializable{
    /* Todos os atributos da tabela Mensagem do banco de dados estão declarados aqui */
    private String usuariologin;
    private String passatempo;
    
    /* Construtor padrão */
    public Passatempos(){
    }
    
    /* Contrutor de Passatempo que recebe todos os atributos */
    public Passatempos(String usuariologin, String passatempo){
        this.usuariologin = usuariologin;
        this.passatempo = passatempo;
    }
    
     /* get e set de usuariologin */
    public String getUsuariologin(){
        return this.usuariologin;
    }
    public void setUsuariologin(String usuariologin){
        usuariologin = this.usuariologin;
    }
    
     /* get e set de passatempo */
    public String getPassatempo(){
        return this.passatempo;
    }
    public void setPassatempo(String passatempo){
        passatempo = this.passatempo;
    }
}
