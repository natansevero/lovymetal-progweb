/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO.interfaces;

import br.edu.ifpb.psd.lovymetal.Entidades.Relacionamento;
import javax.persistence.PersistenceException;

/**
 *
 * @author JuliermeH
 */
public interface RelacionamentoDAOinter {
    /* Interface da classe Relacionamento */
    public void adicionaRelacionamento(Relacionamento relacionamento) throws PersistenceException;
    public void excluiRelacionamento(String login) throws PersistenceException;
}
