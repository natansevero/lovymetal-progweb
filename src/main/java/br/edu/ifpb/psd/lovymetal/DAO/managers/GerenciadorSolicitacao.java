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
import java.util.List;
import java.util.Map;
import javax.persistence.PersistenceException;

/**
 *
 * @author JuliermeH
 */
public class GerenciadorSolicitacao {
    /* Declarando os respectivos atributos para esta entidade */
    private DAOFactoryInter fabrica = null;
    private Solicita_amizadeDAOinter solicita_amizadedao = null;
    
    private final int PENDENTE = 1;
    private final int ACEITA = 2;
//    private final int REJEITADA = 3;
    
    /* Construtor responsável por criar uma nova Amizade */
    public GerenciadorSolicitacao(){
        fabrica = DAOFactory.criarFactory();
        try{
            solicita_amizadedao = fabrica.novaSolicitacao();
        } catch (PersistenceException e){}
    }
    
    /* Método responsável por adicionar uma nova Solicitação e fazer a persistência no BD */
    public boolean novaSolicitacao(int solicitador, int solicitante) throws PersistenceException{
        Solicita_amizade solicitacao = new Solicita_amizade();
        solicitacao.setSolicitador(solicitador);
        solicitacao.setSolicitante(solicitante);
        solicitacao.setStatus(this.PENDENTE);
        return solicita_amizadedao.solicita(solicitacao);
    }
    
    public int verificaSolicitacao(int solicitador, int solicitante) throws PersistenceException {
        Solicita_amizade solicitacao = new Solicita_amizade();
        solicitacao.setSolicitador(solicitador);
        solicitacao.setSolicitante(solicitante);
        return solicita_amizadedao.verifica(solicitacao);
    }
    
    public List<Map<String, String>> listaSolicitacao(int id_usuario) throws PersistenceException {
        return solicita_amizadedao.listaSolicitacoes(id_usuario, this.PENDENTE);
    }
    
    public boolean aceitaSolicitacao(int solicitador, int solicitante) throws PersistenceException {
        Solicita_amizade solicitacao = new Solicita_amizade();
        solicitacao.setSolicitador(solicitador);
        solicitacao.setSolicitante(solicitante);
        solicitacao.setStatus(this.ACEITA);
        return solicita_amizadedao.aceita(solicitacao);
    }
    
    public boolean rejeitaSolicitacao(int solicitador, int solicitante) throws PersistenceException {
        Solicita_amizade solicitacao = new Solicita_amizade();
        solicitacao.setSolicitador(solicitador);
        solicitacao.setSolicitante(solicitante);
        return solicita_amizadedao.rejeita(solicitacao);
    }
    
    public int contaSolicitacoes(int id_usuario) {
        return solicita_amizadedao.conta(id_usuario, this.PENDENTE);
    }
}
