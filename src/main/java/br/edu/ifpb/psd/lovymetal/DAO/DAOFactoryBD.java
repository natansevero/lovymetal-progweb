/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO;

import br.edu.ifpb.psd.lovymetal.DAO.interfaces.AmizadeDAOinter;
import br.edu.ifpb.psd.lovymetal.DAO.interfaces.DAOFactoryInter;
import br.edu.ifpb.psd.lovymetal.DAO.interfaces.GaleriaDAOinter;
import br.edu.ifpb.psd.lovymetal.DAO.interfaces.MensagemDAOinter;
import br.edu.ifpb.psd.lovymetal.DAO.interfaces.PassatemposDAOinter;
import br.edu.ifpb.psd.lovymetal.DAO.interfaces.RelacionamentoDAOinter;
import br.edu.ifpb.psd.lovymetal.DAO.interfaces.UsuarioDAOinter;
import com.sun.rowset.JdbcRowSetImpl;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PersistenceException;
import javax.sql.rowset.JdbcRowSet;

/**
 *
 * @author JuliermeH
 */
public class DAOFactoryBD implements DAOFactoryInter{
    
    private PropBD prop;
    JdbcRowSet jrs = null;
    /* Classe que implementa interface da Fábrica de DAOs e persiste no Banco de Dados*/
    private DAOFactoryBD instance;
    public DAOFactoryBD(){
        try{
            jrs = new JdbcRowSetImpl();
            jrs.setUrl(prop.getURL());
            jrs.setUsername(prop.getUser());
            jrs.setPassword(prop.getSenha());
        } catch (SQLException e){
        }
    }
    
    /* Essa classe cria um novo UsuárioDAO */
    @Override
    public UsuarioDAOinter criaUsuario() throws PersistenceException {
        try {
            return new UsuarioDAO();
        } catch (SQLException | ClassNotFoundException e) {
            Logger.getLogger(DAOFactoryBD.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    /* Essa classe cria uma nova AmizadeDAO */
    @Override
    public AmizadeDAOinter novaAmizade() throws PersistenceException {
        try {
            return new AmizadeDAO();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DAOFactoryBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /* Essa classe cria uma MensagemDAO */
    @Override
    public MensagemDAOinter novaMensagem() throws PersistenceException {
        try {
            return new MensagemDAO();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DAOFactoryBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /* Essa classe cria uma nova GaleriaDAO */
    @Override
    public GaleriaDAOinter novaGaleria() throws PersistenceException {
        try {
            return new GaleriaDAO();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DAOFactoryBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /* Essa classe cria um novo PassatempoDAO */
    @Override
    public PassatemposDAOinter novoPassatempo() throws PersistenceException {
        try {
            return new PassatemposDAO();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DAOFactoryBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /* Essa classe cria um novo UsuárioDAO */
    @Override
    public RelacionamentoDAOinter novoRelacionamento() throws PersistenceException {
        try {
            return new RelacionamentoDAO();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DAOFactoryBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
        
}
