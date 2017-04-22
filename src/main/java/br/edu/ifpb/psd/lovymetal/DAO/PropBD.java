/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO;

/**
 *
 * @author JuliermeH
 */
public class PropBD {
    /* Propriedades do Banco de Dados PostgreSQL */
    private String url;
    private String user;
    private String senha;
    
    /* BD Natan */
    public PropBD() {
        url = "jdbc:postgresql://127.0.0.1:5432/lovymetal";
        user = "postgres";
        senha = "12345";
    }
    
    /* BD Julierme */
    /* public PropBD(){
        url = "jdbc:postgresql://127.0.0.1:5432/lovymetal";
        user = "postgres";
        senha = "nightwish";
    } */
    
    /* Métodos GET apenas para acessar os valores das propriedades*/
    public String getURL(){
        return this.url;
    }
    public String getUser(){
        return this.user;
    }
    public String getSenha(){
        return this.senha;
    }
}
