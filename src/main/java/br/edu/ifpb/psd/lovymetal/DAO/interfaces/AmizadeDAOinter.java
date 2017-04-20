/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO.interfaces;
import br.edu.ifpb.psd.lovymetal.entidades.Amizade;
import javax.persistence.PersistenceException;

/**
 *
 * @author JuliermeH
 */
public interface AmizadeDAOinter {
    /* Interface da classe Amizade */
    public String adiciona(Amizade amizade) throws PersistenceException;
    public void desfaz(int id,int amigo) throws PersistenceException;
}
