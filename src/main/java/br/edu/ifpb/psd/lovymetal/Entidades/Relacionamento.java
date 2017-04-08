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
public class Relacionamento{
    /* Todos os atributos da tabela Relacionamento do banco de dados estão declarados aqui */
    private String usuariologin;
    private String tipo;
    private String par;
    
     /* get e set de usuariologin */
    public String getUsuariologin(){
        return this.usuariologin;
    }
    public void setUsuariologin(String usuariologin){
        usuariologin = this.usuariologin;
    }
    
     /* get e set de tipo */
    public String getTipo(){
        return this.tipo;
    }
    public void setTipo(String tipo){
        tipo = this.tipo;
    }
    
     /* get e set de par */
    public String getPar(){
        return this.par;
    }
    public void setPar(String par){
        par = this.par;
    }
}
