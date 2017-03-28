/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO.interfaces;

import br.edu.ifpb.psd.lovymetal.Entidades.Passatempos;
import javax.persistence.PersistenceException;

/**
 *
 * @author JuliermeH
 */
public interface PassatemposDAOinter {
    /* Interface da classe Passatempos */
    public String adiciona(Passatempos passatempo) throws PersistenceException;
    public String exclui(String login, String passatempo) throws PersistenceException;
}
