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
import br.edu.ifpb.psd.lovymetal.DAO.interfaces.PostagemDAOinter;
import br.edu.ifpb.psd.lovymetal.DAO.interfaces.RelacionamentoDAOinter;
import br.edu.ifpb.psd.lovymetal.DAO.interfaces.Solicita_amizadeDAOinter;
import br.edu.ifpb.psd.lovymetal.DAO.interfaces.UsuarioDAOinter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PersistenceException;
/**
 *
 * @author JuliermeH
 */
public class DAOFactoryBD implements DAOFactoryInter{
    
    
    
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
    public Solicita_amizadeDAOinter novaSolicitacao() throws PersistenceException {
        try {
            return new Solicita_amizadeDAO();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DAOFactoryBD.class.getName()).log(Level.SEVERE, null, ex);
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
    
    /* Essa classe cria uma nova PostagemDAO */
    @Override
    public PostagemDAOinter novaPostagem() throws PersistenceException {
        try {
            return new PostagemDAO();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DAOFactoryBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /* Essa classe cria um novo RelacionamentoDAO */
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
