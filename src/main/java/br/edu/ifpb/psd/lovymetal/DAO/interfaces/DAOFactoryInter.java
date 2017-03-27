/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO.interfaces;

import javax.persistence.PersistenceException;

/**
 *
 * @author JuliermeH
 */
public interface DAOFactoryInter {
    /* Interface da Fábrica de DAOs */
    public UsuarioDAOinter criaUsuario() throws PersistenceException;
    public AmizadeDAOinter novaAmizade() throws PersistenceException;
    public MensagemDAOinter armazenaMensagem() throws PersistenceException;
    public GaleriaDAOinter novaGaleria() throws PersistenceException;
    public PassatemposDAOinter novoPassatempo() throws PersistenceException;
    public RelacionamentoDAOinter novoRelacionamento() throws PersistenceException;
}
