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
public class Postagem {
    /* Todos os atributos da tabela Postagem do banco de dados estão declarados aqui */
    private int postagem_id;
    private int id_usuario;
    private String descricao;
    private String foto;
    
    /* Construtor padrão */
    public Postagem(){
    }
    
    /* Contrutor de Postagem que recebe todos os atributos */
    public Postagem(int postagem_id, int id_usuario, String descricao,String foto){
        this.postagem_id = postagem_id;
        this.id_usuario = id_usuario;
        this.descricao = descricao;
        this.foto = foto;
    }
    
    /* get e set de Postagem_ID */
    public int getPostagemID(){
        return this.postagem_id;
    }
    public void setPostagemID(int postagem_id){
        postagem_id = this.postagem_id;
    }
    
    /* get e set de ID_Usuario */
    public int getIDUsuario(){
        return this.id_usuario;
    }
    public void setIDUsuario(int id_usuario){
        id_usuario = this.id_usuario;
    }
    
    /* get e set de Descricao */
    public String getDescricao(){
        return this.descricao;
    }
    public void setDescricao(String descricao){
        descricao = this.descricao;
    }
    
    /* get e set de Foto */
    public String getFoto(){
        return this.foto;
    }
    public void setFoto(String foto){
        foto = this.foto;
    }
}
