/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO.managers;

import br.edu.ifpb.psd.lovymetal.DAO.DAOFactory;
import br.edu.ifpb.psd.lovymetal.DAO.interfaces.DAOFactoryInter;
import br.edu.ifpb.psd.lovymetal.DAO.interfaces.RelacionamentoDAOinter;
import br.edu.ifpb.psd.lovymetal.entidades.Relacionamento;
import javax.persistence.PersistenceException;

/**
 *
 * @author JuliermeH
 */
public class GerenciadorRelacionamento {
    /* Declarando os respectivos atributos para esta entidade */
    private DAOFactoryInter fabrica = null;
    private RelacionamentoDAOinter relacaodao = null;
    
    /* Construtor responsável por criar uma nova Fábrica de Relacionamento */
    public GerenciadorRelacionamento(){
        fabrica = DAOFactory.criarFactory();
        try{
            relacaodao = (RelacionamentoDAOinter) fabrica.novoRelacionamento();
        } catch (PersistenceException e){}
    }
    
    /* Método responsável por criar um novo Tipo de Relacionamento e fazer a persistência no BD */
    public void novaRelacao(String login, String tipo, String par) throws PersistenceException{
        Relacionamento relacao = new Relacionamento();
        relacao.setUsuariologin(login);
        relacao.setTipo(tipo);
        relacao.setPar(par);
        relacaodao.adicionaRelacionamento(relacao);
    }
    
    /* Método responsável por remover o Relacionamento do BD usando o id da mesma */
    public void removeRelacao(String login) throws PersistenceException{
        relacaodao.excluiRelacionamento(login);
    }
}
