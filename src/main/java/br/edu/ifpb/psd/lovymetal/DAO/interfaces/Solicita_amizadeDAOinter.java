/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO.interfaces;

import br.edu.ifpb.psd.lovymetal.entidades.Solicita_amizade;
import java.util.List;
import java.util.Map;
import javax.persistence.PersistenceException;

/**
 *
 * @author JuliermeH
 */
public interface Solicita_amizadeDAOinter {
    /* Interface da classe Solicita_amizade */
    public boolean solicita(Solicita_amizade solicitacao) throws PersistenceException;
    public int verifica(Solicita_amizade solicitacao) throws PersistenceException;
//    public List<Solicita_amizade> verificasolicitacoes(int solicitante) throws PersistenceException;
    public List<Map<String, String>> listaSolicitacoes(int id_usuario, int status) throws PersistenceException;
    public boolean aceita(Solicita_amizade solicitacao) throws PersistenceException;
    public boolean rejeita(Solicita_amizade solicitacao) throws PersistenceException;
}
