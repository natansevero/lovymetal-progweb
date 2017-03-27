/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO;

import br.edu.ifpb.psd.lovymetal.DAO.interfaces.RelacionamentoDAOinter;
import br.edu.ifpb.psd.lovymetal.Entidades.Relacionamento;
import javax.persistence.PersistenceException;

/**
 *
 * @author JuliermeH
 */
public class RelacionamentoDAO implements RelacionamentoDAOinter{

    /* Implementação da interface RelacionamentoDAOinter */
    @Override
    public void adicionaRelacionamento(Relacionamento relacionamento) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluiRelacionamento(String senha) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
