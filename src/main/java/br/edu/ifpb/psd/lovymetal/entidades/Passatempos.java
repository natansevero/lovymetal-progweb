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
    private int id_usuario;
    private String passatempo;
    
    /* Construtor padrão */
    public Passatempos(){
    }
    
    /* Contrutor de Passatempo que recebe todos os atributos */
    public Passatempos(int id_usuario, String passatempo){
        this.id_usuario = id_usuario;
        this.passatempo = passatempo;
    }
    
     /* get e set de usuariologin */
    public int getIDUsuario(){
        return this.id_usuario;
    }
    public void setIDUsuario(int id_usuario){
        id_usuario = this.id_usuario;
    }
    
     /* get e set de passatempo */
    public String getPassatempo(){
        return this.passatempo;
    }
    public void setPassatempo(String passatempo){
        passatempo = this.passatempo;
    }
}
