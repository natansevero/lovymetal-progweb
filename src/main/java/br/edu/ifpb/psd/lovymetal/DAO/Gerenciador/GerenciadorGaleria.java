/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO.Gerenciador;

import br.edu.ifpb.psd.lovymetal.DAO.DAOFactory;
import br.edu.ifpb.psd.lovymetal.DAO.interfaces.DAOFactoryInter;
import br.edu.ifpb.psd.lovymetal.DAO.interfaces.GaleriaDAOinter;
import br.edu.ifpb.psd.lovymetal.Entidades.Galeria;
import javax.persistence.PersistenceException;

/**
 *
 * @author JuliermeH
 */
public class GerenciadorGaleria {
    /* Declarando os respectivos atributos para esta entidade */
    private DAOFactoryInter fabrica = null;
    private GaleriaDAOinter galeriadao = null;
    
    /* Construtor responsável por criar uma nova Fábrica de Galeria */
    public GerenciadorGaleria(){
        fabrica = DAOFactory.criarFactory();
        try{
            galeriadao = (GaleriaDAOinter) fabrica.novaGaleria();
        } catch (PersistenceException e){}
    }
    
    /* Método responsável por criar uma nova Galeria e fazer a persistência no BD */
    public void novaGaleria(String id, String usuariologin, String nomegaleria, String foto) throws PersistenceException{
        Galeria galeria = new Galeria();
        galeria.setID(id);
        galeria.setUsuariologin(usuariologin);
        galeria.setNomeGaleria(nomegaleria);
        galeria.setFoto(foto);
        galeriadao.novaGaleria(galeria);
    }
    
    /* Método responsável por remover a galeria do BD usando o id da mesma */
    public void removeGaleria(String id) throws PersistenceException{
        galeriadao.excluirGaleria(id);
    }
}
