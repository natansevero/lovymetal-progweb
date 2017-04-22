/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO.managers;

import br.edu.ifpb.psd.lovymetal.DAO.DAOFactory;
import br.edu.ifpb.psd.lovymetal.DAO.interfaces.DAOFactoryInter;
import br.edu.ifpb.psd.lovymetal.DAO.interfaces.Solicita_amizadeDAOinter;
import br.edu.ifpb.psd.lovymetal.entidades.Solicita_amizade;
import javax.persistence.PersistenceException;

/**
 *
 * @author JuliermeH
 */
public class GerenciadorSolicitacao {
    /* Declarando os respectivos atributos para esta entidade */
    private DAOFactoryInter fabrica = null;
    private Solicita_amizadeDAOinter solicita_amizadedao = null;
    
    /* Construtor responsável por criar uma nova Amizade */
    public GerenciadorSolicitacao(){
        fabrica = DAOFactory.criarFactory();
        try{
            solicita_amizadedao = (Solicita_amizadeDAOinter) fabrica.novaSolicitacao();
        } catch (PersistenceException e){}
    }
    
    /* Método responsável por adicionar uma nova Solicitação e fazer a persistência no BD */
    public void novaSolicitacao(int solicitador,int solicitante, int status) throws PersistenceException{
        Solicita_amizade solicitacao = new Solicita_amizade();
        solicitacao.setSolicitador(solicitador);
        solicitacao.setSolicitante(solicitante);
        solicitacao.setStatus(status);
        solicita_amizadedao.solicita(solicitacao);
    }
    
    /* Método responsável por remover a Solicitacao do BD usando o id do solicitador e do solicitante */
    public void excluiSolicitacao(int solicitador, int solicitante) throws PersistenceException{
        solicita_amizadedao.excluisolicitacao(solicitador, solicitante);
    }
}
