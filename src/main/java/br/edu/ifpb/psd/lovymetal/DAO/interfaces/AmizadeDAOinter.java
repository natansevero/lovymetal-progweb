/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO.interfaces;
import br.edu.ifpb.psd.lovymetal.Entidades.Amizade;
import javax.persistence.PersistenceException;

/**
 *
 * @author JuliermeH
 */
public interface AmizadeDAOinter {
    /* Interface da classe Amizade */
    public String adiciona(String login) throws PersistenceException;
    public String desfaz(Amizade amizade) throws PersistenceException;
}
