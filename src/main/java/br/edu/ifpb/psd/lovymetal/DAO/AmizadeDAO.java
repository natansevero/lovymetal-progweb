/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO;

import br.edu.ifpb.psd.lovymetal.DAO.interfaces.AmizadeDAOinter;
import br.edu.ifpb.psd.lovymetal.Entidades.Amizade;
import javax.persistence.PersistenceException;

/**
 *
 * @author JuliermeH
 */
public class AmizadeDAO implements AmizadeDAOinter{
    
    /* Implementação da interface AmizadeDAOinter */
    @Override
    public String desfaz(Amizade amizade) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String adiciona(String login) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
