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
public class Galeria implements Serializable{
    /* Todos os atributos da tabela Galeria do banco de dados estão declarados aqui */
    private int galeria_id;
    private int id_usuario;
    private String nomegaleria;
    private String foto;
    
    /* Construtor padrão */
    public Galeria(){
    }
    
    /* Contrutor de Galeria que recebe todos os atributos */
    public Galeria(int galeria_id, int id_usuario, String nomegaleria, String foto){
        this.galeria_id = galeria_id;
        this.id_usuario = id_usuario;
        this.nomegaleria = nomegaleria;
        this.foto = foto;
    }
    
    /* get e set de id */
    public int getID(){
        return this.galeria_id;
    }
    public void setID(int id){
        id = this.galeria_id;
    }
    
    /* get e set de Login */
    public int getIDUsuario(){
        return this.id_usuario;
    }
    public void setIDUsuario(int id_usuario){
        id_usuario = this.id_usuario;
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
