/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO.interfaces;

import br.edu.ifpb.psd.lovymetal.entidades.Postagem;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author JuliermeH
 */
public interface PostagemDAOinter {
     /* Interface da classe Galeria */
    public boolean novaPostagem(Postagem postagem) throws PersistenceException;
    public List<String> verPostagens(int id_usuario) throws PersistenceException;
    public void excluirPostagem(int postagem_id, int id_usuario) throws PersistenceException;
}
