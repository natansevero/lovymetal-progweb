/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO;

import br.edu.ifpb.psd.lovymetal.DAO.interfaces.GaleriaDAOinter;
import br.edu.ifpb.psd.lovymetal.Entidades.Galeria;
import javax.persistence.PersistenceException;

/**
 *
 * @author JuliermeH
 */
public class GaleriaDAO implements GaleriaDAOinter{

    /* Implementação da interface GaleriaDAOinter */
    @Override
    public void novaGaleria(Galeria galeria) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluirGaleria(String id) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
