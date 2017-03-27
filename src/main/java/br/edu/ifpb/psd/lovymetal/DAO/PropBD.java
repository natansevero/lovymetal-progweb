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
    private String url = "jdbc:postgresql://127.0.0.1:5432/lovymetal";
    private String user = "postgres";
    private String senha = "nightwish";
    
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
