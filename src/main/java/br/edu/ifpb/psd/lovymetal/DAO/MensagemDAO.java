/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO;

import br.edu.ifpb.psd.lovymetal.DAO.interfaces.MensagemDAOinter;
import br.edu.ifpb.psd.lovymetal.Entidades.Mensagem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PersistenceException;

/**
 *
 * @author JuliermeH
 */
public class MensagemDAO implements MensagemDAOinter{

    /* Objeto conexão e Propriedades do Banco de Dados */
    private PropBD prop;
    Connection conexao;
    
    /* Estabelecendo conexão com o banco usando as propriedades */
    public MensagemDAO() throws PersistenceException, SQLException{
        this.conexao = DriverManager.getConnection(prop.getURL(),prop.getUser(),prop.getSenha());
        
    }
    
    /* Implementação da interface MensagemDAOinter */
    @Override
    public String enviar(String login, Mensagem mensagem) throws PersistenceException {
        String sql = "INSERT INTO Mensagem(mensagemid, remetente, destinatario, mensagem)" +
                "VALUES (1,2,3,4)";
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1,mensagem.getMensagemID());
            statement.setString(2,mensagem.getRemetente());
            statement.setString(3,mensagem.getDestinatario());
            statement.setString(4,mensagem.getMensagem());
            return "Mensagem enviada";
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Mensagem não enviada";
    }

    @Override
    public String excluir(String id) throws PersistenceException {
        String sql = "DELETE FROM Mensagem WHERE mensagemid="+ id;
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.execute();
            return "Mensagem excluída";
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Mensagem não excluída";
    }
    
}
