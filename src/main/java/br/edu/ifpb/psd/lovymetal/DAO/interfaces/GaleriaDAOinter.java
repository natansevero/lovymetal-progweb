/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO.interfaces;

import br.edu.ifpb.psd.lovymetal.entidades.Galeria;
import javax.persistence.PersistenceException;

/**
 *
 * @author JuliermeH
 */
public interface GaleriaDAOinter {
    /* Interface da classe Galeria */
    public void novaGaleria(Galeria galeria) throws PersistenceException;
    public void excluirGaleria(int galeria_id, int id_usuario) throws PersistenceException;
}
