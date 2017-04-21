/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.entidades;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author JuliermeH
 */
public class Usuario implements Serializable{
    /* Todos os atributos da tabela Usuario do banco de dados estão declarados aqui */
    private int id;
    private String senha;
    private String nome_completo;
    private String apelido;
    private String datanasc;
    private String cidade;
    private String email;
    private String profissao;
    private String descricao;
    private String sexo;
    private String status;
    private double altura;
    private String cabelo;
    private String fotoperfil;
    
    /* Construtor padrão */
    public Usuario(){
    }
    
    /* Contrutor de Usuario que recebe todos os atributos */
    public Usuario(String senha, String nome_completo, String apelido, String nasc, String cidade, String email, String profissao,
            String descricao, String sexo, String status, double altura, String cabelo, String fotoperfil){
        
        this.senha = senha;
        this.nome_completo = nome_completo;
        this.apelido = apelido;
        this.datanasc = nasc;
        this.cidade = cidade;
        this.email = email;
        this.profissao = profissao;
        this.descricao = descricao;
        this.sexo = sexo;
        this.status = status;
        this.altura = altura;
        this.cabelo = cabelo;
        this.fotoperfil = fotoperfil;
    }
    
    /* get e set de ID */
    public int getID(){
        return this.id;
    }
    public void setID(int id){
        id = this.id;
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
        return this.nome_completo;
    }
    public void setNome(String nome_completo){
        nome_completo = this.nome_completo;
    }
    
     /* get e set de Apelido */
    public String getApelido(){
        return this.apelido;
    }
    public void setApelido(String apelido){
        apelido = this.apelido;
    }
    
     /* get e set de DataNasc */
    public String getDataNasc(){
        return this.datanasc;
    }
    public void setDataNasc(String datanasc){
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
    public double getAltura(){
        return this.altura;
    }
    public void setAltura(double altura){
        altura = this.altura;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id;
        hash = 71 * hash + Objects.hashCode(this.senha);
        hash = 71 * hash + Objects.hashCode(this.nome_completo);
        hash = 71 * hash + Objects.hashCode(this.apelido);
        hash = 71 * hash + Objects.hashCode(this.datanasc);
        hash = 71 * hash + Objects.hashCode(this.cidade);
        hash = 71 * hash + Objects.hashCode(this.email);
        hash = 71 * hash + Objects.hashCode(this.profissao);
        hash = 71 * hash + Objects.hashCode(this.descricao);
        hash = 71 * hash + Objects.hashCode(this.sexo);
        hash = 71 * hash + Objects.hashCode(this.status);
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.altura) ^ (Double.doubleToLongBits(this.altura) >>> 32));
        hash = 71 * hash + Objects.hashCode(this.cabelo);
        hash = 71 * hash + Objects.hashCode(this.fotoperfil);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.nome_completo, other.nome_completo)) {
            return false;
        }
        if (!Objects.equals(this.apelido, other.apelido)) {
            return false;
        }
        if (!Objects.equals(this.datanasc, other.datanasc)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.profissao, other.profissao)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (Double.doubleToLongBits(this.altura) != Double.doubleToLongBits(other.altura)) {
            return false;
        }
        if (!Objects.equals(this.cabelo, other.cabelo)) {
            return false;
        }
        if (!Objects.equals(this.fotoperfil, other.fotoperfil)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", senha=" + senha + ", nome_completo=" + nome_completo + ", apelido=" + apelido + ", datanasc=" + datanasc + ", cidade=" + cidade + ", email=" + email + ", profissao=" + profissao + ", descricao=" + descricao + ", sexo=" + sexo + ", status=" + status + ", altura=" + altura + ", cabelo=" + cabelo + ", fotoperfil=" + fotoperfil + '}';
    }
    
    
}
