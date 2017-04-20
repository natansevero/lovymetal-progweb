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
public class Relacionamento implements Serializable{
    /* Todos os atributos da tabela Relacionamento do banco de dados estão declarados aqui */
    private int id_usuario;
    private String tipo;
    private int par;
    
    /* Construtor padrão */
    public Relacionamento(){
    }
    
    /* Contrutor de Relacionamento que recebe todos os atributos */
    public Relacionamento(int id_usuario, String tipo, int par){
        this.id_usuario = id_usuario;
        this.tipo = tipo;
        this.par = par;
    }
    
     /* get e set de usuariologin */
    public int getIDUsuario(){
        return this.id_usuario;
    }
    public void setIDUsuario(int id_usuario){
        id_usuario = this.id_usuario;
    }
    
     /* get e set de tipo */
    public String getTipo(){
        return this.tipo;
    }
    public void setTipo(String tipo){
        tipo = this.tipo;
    }
    
     /* get e set de par */
    public int getPar(){
        return this.par;
    }
    public void setPar(int par){
        par = this.par;
    }
}
