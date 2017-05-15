/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO.managers;

import br.edu.ifpb.psd.lovymetal.DAO.DAOFactory;
import br.edu.ifpb.psd.lovymetal.DAO.interfaces.DAOFactoryInter;
import br.edu.ifpb.psd.lovymetal.DAO.interfaces.PostagemDAOinter;
import br.edu.ifpb.psd.lovymetal.entidades.Postagem;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author JuliermeH
 */
public class GerenciadorPostagem {
    /* Declarando os respectivos atributos para esta entidade */
    private DAOFactoryInter fabrica = null;
    private PostagemDAOinter postagemdao = null;
    
    /* Construtor responsável por criar uma nova Amizade */
    public GerenciadorPostagem(){
        fabrica = DAOFactory.criarFactory();
        try{
            postagemdao = fabrica.novaPostagem();
        } catch (PersistenceException e){}
    }
    
    /* Método responsável por adicionar uma nova Postagem e fazer a persistência no BD */
    public boolean novaPostagem(int id_usuario, String descricao, String foto) throws PersistenceException{
        Postagem postagem = new Postagem();
        postagem.setIDUsuario(id_usuario);
        postagem.setDescricao(descricao);
        postagem.setFoto(foto);
        return postagemdao.novaPostagem(postagem);
    }
    
    /* Método responsável por ver as Postagens dos amigos do Usuario */
    public List<String> listarPostagens(int id_usuario) throws PersistenceException{
        return postagemdao.verPostagens(id_usuario);
    }
    
    /* Método responsável por remover uma Postagem do BD usando o id da postagem e do usuario */
    public void excluiPostagem(int postagem_id,int id_usuario) throws PersistenceException{
        postagemdao.excluirPostagem(postagem_id, id_usuario);
    }
}
