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
public class Amizade implements Serializable{
    /* Todos os atributos da tabela Amizade do banco de dados estão declarados aqui */
    private String usuario;
    private String amigo;
    
    /* Construtor padrão */
    public Amizade(){
    }
    
    /* Contrutor de Amizade que recebe todos os atributos */
    public Amizade(String usuario,String amigo){
        this.usuario = usuario;
        this.amigo = amigo;
    }
    
    /* get e set de Usuario */
    public String getUsuario(){
        return this.usuario;
    }
    public void setUsuario(String usuario){
        usuario = this.usuario;
    }
    
    /* get e set de Amigo */
    public String getAmigo(){
        return this.amigo;
    }
    public void setAmigo(String amigo){
        amigo = this.amigo;
    }
}
