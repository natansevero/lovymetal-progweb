/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO.managers;

import br.edu.ifpb.psd.lovymetal.DAO.DAOFactory;
import br.edu.ifpb.psd.lovymetal.DAO.interfaces.DAOFactoryInter;
import br.edu.ifpb.psd.lovymetal.DAO.interfaces.MensagemDAOinter;
import br.edu.ifpb.psd.lovymetal.entidades.Mensagem;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author JuliermeH
 */
public class GerenciadorMensagem {
    /* Declarando os respectivos atributos para esta entidade */
    private DAOFactoryInter fabrica = null;
    private MensagemDAOinter mensagemdao = null;
    
    /* Construtor responsável por criar uma nova Fábrica de Mensagem */
    public GerenciadorMensagem(){
        fabrica = DAOFactory.criarFactory();
        try{
            mensagemdao = fabrica.novaMensagem();
        } catch (PersistenceException e){}
    }
    
    /* Método responsável por criar uma nova Mensagem e fazer a persistência no BD */
    public void novaMensagem(int id, int remetente, int destinatario, String mensagem, int status) throws PersistenceException{
        Mensagem msn = new Mensagem();
        msn.setMensagemID(id);
        msn.setRemetente(remetente);
        msn.setDestinatario(destinatario);
        msn.setMensagem(mensagem);
        msn.setStatus(status);
        mensagemdao.enviar(msn);
    }
    
    /* Método responsável por listar as Mensagens do usuário como destinatário */
    public List<Mensagem> verificarmensagens(int destinatario)throws PersistenceException{
        List mensagens = mensagemdao.verificarmensagens(destinatario);
        return mensagens;
    }
    
    /* Método responsável por remover uma Mensagem do BD usando o id da mesma */
    public void removerMensagem(int id) throws PersistenceException{
        mensagemdao.excluir(id);
    }
}
