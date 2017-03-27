/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO;

import br.edu.ifpb.psd.lovymetal.DAO.interfaces.PassatemposDAOinter;
import br.edu.ifpb.psd.lovymetal.Entidades.Passatempos;
import javax.persistence.PersistenceException;

/**
 *
 * @author JuliermeH
 */
public class PassatemposDAO implements PassatemposDAOinter{

    /* Implementação da interface PassatempoDAOinter */
    @Override
    public String adiciona(Passatempos passatempo) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String desfaz(String passatempo) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
}
