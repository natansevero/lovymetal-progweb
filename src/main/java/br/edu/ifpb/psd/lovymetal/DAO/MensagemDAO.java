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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        this.prop = new PropBD();
        this.conexao = ConnFactory.getConnection(prop.getURL(), prop.getUser(), prop.getSenha());
    }
    
    /* Implementação da interface MensagemDAOinter de acordo com a Regra 02 */
    /* De acordo com a RF_08 dos Requisitos Funcionais */
    @Override
    public String enviar(Mensagem mensagem) throws PersistenceException {
        String sql = "INSERT INTO Mensagem(mensagem_id, remetente, destinatario, mensagem, status)" +
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
    public List<Map<String, String>> verificarmensagens(int destinatario) throws PersistenceException{
        String sql = "select U.apelido AS destinatario, U.apelido AS remetente, U.foto_perfil AS foto_remetente, M.mensagem, M.status from Mensagem M, Usuario U"
                + "where (M.destinatario = U.id and M.remetente = U.id) and M.destinatario=" + destinatario
                + " order by destinatario";
        
        try {
            PreparedStatement statement = conexao.prepareStatement(sql);
            
            ResultSet rs = statement.executeQuery();
            
            List<Map<String, String>> mensagens = new ArrayList<>();
            
            while(rs.next()) {
                Map<String, String> dados_mensagens= new HashMap<>();
                
                if(rs.getInt(5) != 1){
                    dados_mensagens.put("destinatario", ""+rs.getInt(1));
                    dados_mensagens.put("remetente", ""+rs.getInt(2));
                    dados_mensagens.put("foto_remetente", ""+rs.getString(3));
                    dados_mensagens.put("mensagem", ""+rs.getString(4));
                    dados_mensagens.put("status", ""+rs.getInt(5));
                }               
            }
            return mensagens;
            
        } catch(SQLException e) {
            throw new PersistenceException(e);
        }
    }
    
    @Override
    public List<Map<String, String>> lermensagens(int destinatario, int remetente) throws PersistenceException{
        String sql = "select U.apelido AS destinatario, U.foto_perfil AS foto_destinatario, U.apelido AS remetente, U.foto_perfil AS foto_remetente, M.mensagem, M.status from Mensagem M, Usuario U"
                + "where (M.destinatario = U.id and M.remetente = U.id) and M.destinatario=" + destinatario + " and remetente =" + remetente
                + " order by destinatario";
        
        try {
            PreparedStatement statement = conexao.prepareStatement(sql);
            
            ResultSet rs = statement.executeQuery();
            
            List<Map<String, String>> mensagens = new ArrayList<>();
            
            while(rs.next()) {
                Map<String, String> dados_mensagens= new HashMap<>();
                
                    dados_mensagens.put("destinatario", ""+rs.getInt(1));
                    dados_mensagens.put("destinatario", ""+rs.getInt(2));
                    dados_mensagens.put("remetente", ""+rs.getInt(3));
                    dados_mensagens.put("foto_remetente", ""+rs.getString(4));
                    dados_mensagens.put("mensagem", ""+rs.getString(5));
                    dados_mensagens.put("status", "" +rs.getString(6));
                    String sql1 = "update Mensagens set status = 0 where status=1 and remetente="+remetente;
                    statement.execute(sql1);
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
