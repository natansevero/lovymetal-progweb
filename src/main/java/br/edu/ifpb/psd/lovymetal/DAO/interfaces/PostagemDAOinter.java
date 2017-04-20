/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO.interfaces;

import br.edu.ifpb.psd.lovymetal.entidades.Postagem;
import javax.persistence.PersistenceException;

/**
 *
 * @author Julierme Heinstein
 */
public interface PostagemDAOinter {
     /* Interface da classe Galeria */
    public void novaPostagem(Postagem postagem) throws PersistenceException;
    public void excluirPostagem(int postagem_id, int id_usuario) throws PersistenceException;
}
