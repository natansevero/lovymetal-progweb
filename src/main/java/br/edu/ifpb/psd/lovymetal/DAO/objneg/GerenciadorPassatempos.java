/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO.objneg;

import br.edu.ifpb.psd.lovymetal.DAO.DAOFactory;
import br.edu.ifpb.psd.lovymetal.DAO.PassatemposDAO;
import br.edu.ifpb.psd.lovymetal.DAO.interfaces.DAOFactoryInter;
import br.edu.ifpb.psd.lovymetal.DAO.interfaces.PassatemposDAOinter;
import br.edu.ifpb.psd.lovymetal.Entidades.Passatempos;
import javax.persistence.PersistenceException;

/**
 *
 * @author JuliermeH
 */
public class GerenciadorPassatempos {
    /* Declarando os respectivos atributos para esta entidade */
    private DAOFactoryInter fabrica = null;
    private PassatemposDAOinter passatemposdao = null;
    
    /* Construtor responsável por criar uma nova Fábrica de Passatempos */
    public GerenciadorPassatempos(){
        fabrica = DAOFactory.criarFactory();
        try{
            passatemposdao = (PassatemposDAOinter) fabrica.novoPassatempo();
        } catch (PersistenceException e){}
    }
    
    /* Método responsável por criar um novo Passatempo e fazer a persistência no BD */
    public void novoPassatempo(String usuariologin, String passatempo) throws PersistenceException{
        Passatempos passatempos = new Passatempos();
        passatempos.setUsuariologin(usuariologin);
        passatempos.setPassatempo(passatempo);
        passatemposdao.adiciona(passatempos);
    }
    
    /* Método responsável por remover o Passatempo do BD usando o id da mesma */
    public void removePassatempo(String login, String passatempo) throws PersistenceException{
        passatemposdao.exclui(login, passatempo);
    }
}
