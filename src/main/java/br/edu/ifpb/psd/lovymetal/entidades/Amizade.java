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
    private int usuario;
    private int amigo;
    
    /* Construtor padrão */
    public Amizade(){
    }
    
    /* Contrutor de Amizade que recebe todos os atributos */
    public Amizade(int usuario, int amigo){
        this.usuario = usuario;
        this.amigo = amigo;
    }
    
    /* get e set de Usuario */
    public int getUsuario(){
        return this.usuario;
    }
    public void setUsuario(int usuario){
        this.usuario = usuario;
    }
    
    /* get e set de Amigo */
    public int getAmigo(){
        return this.amigo;
    }
    public void setAmigo(int amigo){
        this.amigo = amigo;
    }
}
