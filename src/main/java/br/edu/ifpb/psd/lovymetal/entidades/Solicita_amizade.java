/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.entidades;

/**
 *
 * @author Julierme Heinstein
 */
public class Solicita_amizade {
    /* Todos os atributos da tabela Solicita_amizade do banco de dados estão declarados aqui */
    private int solicitador;
    private int solicitante;
    private int status;
    
    /* Construtor padrão */
    public Solicita_amizade(){
    }
    
    /* Contrutor de Solicita_amizade que recebe todos os atributos */
    public Solicita_amizade(int solicitador, int solicitante, int status){
        this.solicitador = solicitador;
        this.solicitante = solicitante;
        this.status = status;
    }
    
    /* get e set de Solicitador */
    public int getSolicitador(){
        return this.solicitador;
    }
    public void setSolicitador(int solicitador){
        this.solicitador = solicitador;
    }
    
    /* get e set de Solicitante */
    public int getSolicitante(){
        return this.solicitante;
    }
    public void setSolicitante(int solicitante){
        this.solicitante = solicitante;
    }
    
    /* get e set de Status */
    public int getStatus(){
        return this.status;
    }
    public void setStatus(int status){
        this.status = status;
    }
}
