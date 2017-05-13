/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO.managers;

import br.edu.ifpb.psd.lovymetal.DAO.DAOFactory;
import br.edu.ifpb.psd.lovymetal.DAO.interfaces.DAOFactoryInter;
import br.edu.ifpb.psd.lovymetal.DAO.interfaces.GaleriaDAOinter;
import br.edu.ifpb.psd.lovymetal.entidades.Galeria;
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
            galeriadao = fabrica.novaGaleria();
        } catch (PersistenceException e){}
    }
    
    /* Método responsável por criar uma nova Galeria e fazer a persistência no BD */
    public void novaGaleria(int galeria_id, int id_usuario, String nomegaleria, String foto) throws PersistenceException{
        Galeria galeria = new Galeria();
        galeria.setID(galeria_id);
        galeria.setIDUsuario(id_usuario);
        galeria.setNomeGaleria(nomegaleria);
        galeria.setFoto(foto);
        galeriadao.novaGaleria(galeria);
    }
    
    /* Método responsável por remover a galeria do BD usando o id da mesma */
    public void removeGaleria(int galeria_id, int id_usuario) throws PersistenceException{
        galeriadao.excluirGaleria(galeria_id,id_usuario);
    }
}
