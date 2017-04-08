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
public class Passatempos {
    /* Todos os atributos da tabela Mensagem do banco de dados estão declarados aqui */
    private String usuariologin;
    private String passatempo;
    
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
