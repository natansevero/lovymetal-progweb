/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO;

import br.edu.ifpb.psd.lovymetal.DAO.interfaces.MensagemDAOinter;
import br.edu.ifpb.psd.lovymetal.entidades.Mensagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    private Connection conexao;
    
    /* Estabelecendo conexão com o banco usando as propriedades */
    public MensagemDAO() throws PersistenceException, SQLException, ClassNotFoundException{
        this.conexao = ConnFactory.getConnection(prop.getURL(), prop.getUser(), prop.getSenha());
    }
    
    /* Implementação da interface MensagemDAOinter de acordo com a Regra 02 */
    /* De acordo com a RF_08 dos Requisitos Funcionais */
    @Override
    public String enviar(Mensagem mensagem) throws PersistenceException {
        String sql = "INSERT INTO Mensagem(mensagemid, remetente, destinatario, mensagem, status)" +
                "VALUES (1,2,3,4,5)";
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1,mensagem.getMensagemID());
            statement.setInt(2,mensagem.getRemetente());
            statement.setInt(3,mensagem.getDestinatario());
            statement.setString(4,mensagem.getMensagem());
            statement.setInt(5, mensagem.getStatus());
            conexao.close();
            return "Mensagem enviada";
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Mensagem não enviada";
    }
    
    /* De acordo com a RF_09 dos Requisitos Funcionais */
    @Override
    public List<Mensagem> verificarmensagens(int destinatario) throws PersistenceException{
        String sql = "select * from Mensagem where destinatario=" + destinatario;
        
        try {
            PreparedStatement statement = conexao.prepareStatement(sql);
            
            ResultSet rs = statement.executeQuery();
            
            List<Mensagem> mensagens = new ArrayList<>();
            
            while(rs.next()) {
                Mensagem mensagem = new Mensagem();
                mensagem.setMensagemID(rs.getInt(1));
                mensagem.setRemetente(rs.getInt(2));
                mensagem.setMensagem(rs.getString(4));
                mensagem.setStatus(rs.getInt(5));
                
                mensagens.add(mensagem);
            }
            
            return mensagens;
            
        } catch(SQLException e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public String excluir(int id) throws PersistenceException {
        String sql = "DELETE FROM Mensagem WHERE mensagemid="+ id;
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.execute();
            conexao.close();
            return "Mensagem excluída";
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Mensagem não excluída";
    }
    
}
