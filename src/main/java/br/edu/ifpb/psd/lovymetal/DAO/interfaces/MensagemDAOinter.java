/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO.interfaces;

import br.edu.ifpb.psd.lovymetal.entidades.Mensagem;
import javax.persistence.PersistenceException;

/**
 *
 * @author JuliermeH
 */
public interface MensagemDAOinter {
    /* Interface da classe Mensagem */
    public String enviar(Mensagem mensagem) throws PersistenceException;
    public String excluir(String id) throws PersistenceException;
}
