/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO.interfaces;

import br.edu.ifpb.psd.lovymetal.Entidades.Usuario;
import javax.persistence.PersistenceException;

/**
 *
 * @author JuliermeH
 */
public interface UsuarioDAOinter {
    /* Interface da classe Usuario */
    public String persiste(Usuario usuario) throws PersistenceException;
    public Usuario pesquisar(String nome) throws PersistenceException;
    public String exlui(String login) throws PersistenceException;
}
