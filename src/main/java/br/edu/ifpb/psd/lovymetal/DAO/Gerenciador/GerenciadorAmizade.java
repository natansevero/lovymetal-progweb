/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO.Gerenciador;

import br.edu.ifpb.psd.lovymetal.DAO.AmizadeDAO;
import br.edu.ifpb.psd.lovymetal.DAO.DAOFactory;
import br.edu.ifpb.psd.lovymetal.DAO.interfaces.DAOFactoryInter;
import br.edu.ifpb.psd.lovymetal.Entidades.Amizade;
import javax.persistence.PersistenceException;

/**
 *
 * @author JuliermeH
 */
public class GerenciadorAmizade {
    /* Declarando os respectivos atributos para esta entidade */
    private DAOFactoryInter fabrica = null;
    private AmizadeDAO amizadedao = null;
    
    /* Construtor responsável por criar uma nova Amizade */
    public GerenciadorAmizade(){
        fabrica = DAOFactory.criarFactory();
        try{
            amizadedao = (AmizadeDAO) fabrica.novaAmizade();
        } catch (PersistenceException e){}
    }
    
    /* Método responsável por adicionar uma nova Amizade e fazer a persistência no BD */
    public void novaAmizade(String usuario,String amigo) throws PersistenceException{
        Amizade amizade = new Amizade();
        amizade.setUsuario(usuario);
        amizade.setAmigo(amigo);
        amizadedao.adiciona(amizade);
    }
    
    /* Método responsável por remover a Amizade do BD usando o login do usuario e o login do amigo */
    public void removeAmizade(String login, String amigo) throws PersistenceException{
        amizadedao.desfaz(login, amigo);
    }
}
