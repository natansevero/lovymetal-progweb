/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO.interfaces;

import br.edu.ifpb.psd.lovymetal.entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author JuliermeH
 */
public interface UsuarioDAOinter {
    /* Interface da classe Usuario */
    public String cadastra(Usuario usuario) throws PersistenceException;
    public List<Usuario> listar() throws PersistenceException;
    public String atualiza(Usuario usuario) throws PersistenceException;
    public ArrayList pesquisar(String nome) throws PersistenceException;
    public ArrayList pesquisar(String sexo, String cabelo) throws PersistenceException;
    public ArrayList pesquisar(float altura, float peso) throws PersistenceException;
    public String exlui(int id) throws PersistenceException;
}
