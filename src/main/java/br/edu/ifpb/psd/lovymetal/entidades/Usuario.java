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

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome_completo() {
        return nome_completo;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(String datanasc) {
        this.datanasc = datanasc;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getCabelo() {
        return cabelo;
    }

    public void setCabelo(String cabelo) {
        this.cabelo = cabelo;
    }

    public String getFotoperfil() {
        return fotoperfil;
    }

    public void setFotoperfil(String fotoperfil) {
        this.fotoperfil = fotoperfil;
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
