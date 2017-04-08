/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.Entidades;

import java.io.Serializable;

/**
 *
 * @author JuliermeH
 */
public class Galeria implements Serializable{
    /* Todos os atributos da tabela Galeria do banco de dados estão declarados aqui */
    private String id;
    private String usuariologin;
    private String nomegaleria;
    private String foto;
    
    /* Construtor padrão */
    public Galeria(){
    }
    
    /* Contrutor de Galeria que recebe todos os atributos */
    public Galeria(String id, String usuariologin, String nomegaleria, String foto){
        this.id = id;
        this.usuariologin = usuariologin;
        this.nomegaleria = nomegaleria;
        this.foto = foto;
    }
    
    /* get e set de id */
    public String getID(){
        return this.id;
    }
    public void setID(String id){
        id = this.id;
    }
    
    /* get e set de Login */
    public String getUsuariologin(){
        return this.usuariologin;
    }
    public void setUsuariologin(String usuariologin){
        usuariologin = this.usuariologin;
    }
    
    /* get e set de nomegaleria */
    public String getNomeGaleria(){
        return this.nomegaleria;
    }
    public void setNomeGaleria(String nomegaleria){
        nomegaleria = this.nomegaleria;
    }
    
    /* get e set de Foto */
    public String getFoto(){
        return this.foto;
    }
    public void setFoto(String foto){
        foto = this.foto;
    }
}
