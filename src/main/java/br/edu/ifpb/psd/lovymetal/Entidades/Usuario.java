/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.Entidades;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author JuliermeH
 */
public class Usuario implements Serializable{
    /* Todos os atributos da tabela Usuario do banco de dados estão declarados aqui */
    private String login;
    private String senha;
    private String nome;
    private String apelido;
    private Date datanasc;
    private String cidade;
    private String email;
    private String profissao;
    private String descricao;
    private String sexo;
    private String status;
    private float altura;
    private float peso;
    private String cabelo;
    private String fotoperfil;
    
    /* Construtor padrão */
    public Usuario(){
    }
    
    /* Contrutor de Usuario que recebe todos os atributos */
    public Usuario(String login, String senha, String nome, String apelido, Date nasc, String cidade, String profissao,
            String descricao, String sexo, String status, float altura, float peso, String cabelo, String fotoperfil){
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.apelido = apelido;
        this.datanasc = nasc;
        this.cidade = cidade;
        this.profissao = profissao;
        this.descricao = descricao;
        this.sexo = sexo;
        this.status = status;
        this.altura = altura;
        this.peso = peso;
        this.cabelo = cabelo;
        this.fotoperfil = fotoperfil;
    }
    
    /* get e set de Login */
    public String getLogin(){
        return this.login;
    }
    public void setLogin(String login){
        login = this.login;
    }
    
     /* get e set de Senha */
    public String getSenha(){
        return this.senha;
    }
    public void setSenha(String senha){
        senha = this.senha;
    }
    
     /* get e set de Nome */
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        nome = this.nome;
    }
    
     /* get e set de Apelido */
    public String getApelido(){
        return this.apelido;
    }
    public void setApelido(String apelido){
        apelido = this.apelido;
    }
    
     /* get e set de DataNasc */
    public Date getDataNasc(){
        return this.datanasc;
    }
    public void setDataNasc(Date datanasc){
        datanasc = this.datanasc;
    }
    
     /* get e set de Cidade */
    public String getCidade(){
        return this.cidade;
    }
    public void setCidade(String cidade){
        cidade = this.cidade;
    }
    
     /* get e set de Email */
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        email = this.email;
    }
    
    
     /* get e set de Profissao */
    public String getProfissao(){
        return this.profissao;
    }
    public void setProfissao(String profissao){
        profissao = this.profissao;
    }
    
     /* get e set de Descricao */
    public String getDescricao(){
        return this.apelido;
    }
    public void setDescricao(String descricao){
        descricao = this.descricao;
    }
    
     /* get e set de Sexo */
    public String getSexo(){
        return this.sexo;
    }
    public void setSexo(String sexo){
        sexo = this.sexo;
    }
    
    /* get e set Status */
    public String getStatus(){
        return this.status;
    }
    public void setStatus(String status){
        status = this.status;
    }
    
     /* get e set de Altura */
    public float getAltura(){
        return this.altura;
    }
    public void setAltura(float altura){
        altura = this.altura;
    }
    
     /* get e set de Peso */
    public float getPeso(){
        return this.peso;
    }
    public void setPeso(float peso){
        peso = this.peso;
    }
    
     /* get e set de Cabelo */
    public String getCabelo(){
        return this.cabelo;
    }
    public void setCabelo(String cabelo){
        cabelo = this.cabelo;
    }
    
     /* get e set de FotoPerfil */
    public String getFotoPerfil(){
        return this.fotoperfil;
    }
    public void setFotoPerfil(String fotoperfil){
        fotoperfil = this.fotoperfil;
    }
}
