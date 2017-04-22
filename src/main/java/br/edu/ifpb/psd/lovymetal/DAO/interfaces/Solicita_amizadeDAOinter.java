/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO.interfaces;

import br.edu.ifpb.psd.lovymetal.entidades.Solicita_amizade;
import javax.persistence.PersistenceException;

/**
 *
 * @author JuliermeH
 */
public interface Solicita_amizadeDAOinter {
    /* Interface da classe Solicita_amizade */
    public String solicita(Solicita_amizade solicitacao) throws PersistenceException;
    public void excluisolicitacao(int solicitador,int solicitante) throws PersistenceException;
}
