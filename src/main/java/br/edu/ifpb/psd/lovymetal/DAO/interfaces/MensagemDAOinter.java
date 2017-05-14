/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO.interfaces;

import br.edu.ifpb.psd.lovymetal.entidades.Mensagem;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author JuliermeH
 */
public interface MensagemDAOinter {
    /* Interface da classe Mensagem */
    public String enviar(Mensagem mensagem) throws PersistenceException;
    public List<Mensagem> verificarmensagens(int destinatario) throws PersistenceException;
    public List<Mensagem> lermensagens(int destinatario, int remetente) throws PersistenceException;
    public String excluir(int id) throws PersistenceException;
}
