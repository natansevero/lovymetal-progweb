/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO.managers;

import br.edu.ifpb.psd.lovymetal.DAO.DAOFactory;
import br.edu.ifpb.psd.lovymetal.DAO.interfaces.DAOFactoryInter;
import br.edu.ifpb.psd.lovymetal.DAO.interfaces.AmizadeDAOinter;
import br.edu.ifpb.psd.lovymetal.entidades.Amizade;
import javax.persistence.PersistenceException;

/**
 *
 * @author JuliermeH
 */
public class GerenciadorAmizade {
    /* Declarando os respectivos atributos para esta entidade */
    private DAOFactoryInter fabrica = null;
    private AmizadeDAOinter amizadedao = null;
    
    /* Construtor responsável por criar uma nova Amizade */
    public GerenciadorAmizade(){
        fabrica = DAOFactory.criarFactory();
        try{
            amizadedao = fabrica.novaAmizade();
        } catch (PersistenceException e){}
    }
    
    /* Método responsável por adicionar uma nova Amizade e fazer a persistência no BD */
    public boolean novaAmizade(int usuario,int amigo) throws PersistenceException{
        Amizade amizade = new Amizade();
        amizade.setUsuario(usuario);
        amizade.setAmigo(amigo);
        return amizadedao.adiciona(amizade);
    }
    
    /* Método responsável por remover a Amizade do BD usando o id do usuario e do amigo */
    public void removeAmizade(int usuario, int amigo) throws PersistenceException{
        amizadedao.desfaz(usuario, amigo);
    }
}
