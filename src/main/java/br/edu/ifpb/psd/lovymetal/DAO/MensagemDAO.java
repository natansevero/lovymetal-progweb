/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO;

import br.edu.ifpb.psd.lovymetal.DAO.interfaces.MensagemDAOinter;
import br.edu.ifpb.psd.lovymetal.Entidades.Mensagem;
import javax.persistence.PersistenceException;

/**
 *
 * @author JuliermeH
 */
public class MensagemDAO implements MensagemDAOinter{

    /* Implementação da interface MensagemDAOinter */
    @Override
    public String enviar(Mensagem mensagem) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String excluir(String id) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
