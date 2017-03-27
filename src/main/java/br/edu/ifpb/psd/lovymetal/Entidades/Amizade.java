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
public class Amizade {
    /* Todos os atributos da tabela Amizade do banco de dados estão declarados aqui */
    private String usuario;
    private String amigo;
    
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
