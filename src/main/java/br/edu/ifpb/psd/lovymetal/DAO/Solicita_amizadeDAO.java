/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO;

import br.edu.ifpb.psd.lovymetal.DAO.interfaces.Solicita_amizadeDAOinter;
import br.edu.ifpb.psd.lovymetal.entidades.Mensagem;
import br.edu.ifpb.psd.lovymetal.entidades.Solicita_amizade;
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
public class Solicita_amizadeDAO implements Solicita_amizadeDAOinter {
    /* Objeto conexão e Propriedades do Banco de Dados */
    private PropBD prop;
    private Connection conexao;
    
    /* Estabelecendo conexão com o banco usando as propriedades */
    public Solicita_amizadeDAO() throws PersistenceException, SQLException, ClassNotFoundException{
        this.prop = new PropBD();
        this.conexao = ConnFactory.getConnection(prop.getURL(), prop.getUser(), prop.getSenha()); 
    }
    
    /* Implementação da interface Solicita_amizadeDAOinter */
    /* De acordo com a RF_07 dos Requisitos Funcionais */
    @Override
    public boolean solicita(Solicita_amizade solicitacao) throws PersistenceException{
        String sql = "INSERT INTO solicita_amizade(solicitador,solicitante,status)" +
                "VALUES (?,?,?)";
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1,solicitacao.getSolicitador());
            statement.setInt(2,solicitacao.getSolicitante());
            statement.setInt(3,solicitacao.getStatus());
            
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw new PersistenceException(ex);
        }
    }
    
    @Override
    public int verifica(Solicita_amizade solicitacao) throws PersistenceException {
        String sql = "select status from solicita_amizade where solicitador = ? and solicitante = ?";
        
        try {
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1,solicitacao.getSolicitador());
            statement.setInt(2,solicitacao.getSolicitante());
            
            ResultSet rs = statement.executeQuery();
            
            int status = -1;
            while(rs.next()) {
                status = rs.getInt(1);
                System.out.println("Status no DAO: " + status);
            }
            
            /* 
                Se retornar -1, é pq não existe solicitação
                Se retornar 1, pq tá pendente
                Se retornar 2, pq tá aeita e é amigo
            */
            return status;
        } catch (SQLException ex) {
            throw new PersistenceException(ex);
        }
    }
    
    @Override
    public void excluisolicitacao(int solicitador,int solicitante) throws PersistenceException{
        String sql = "DELETE FROM solicita_amizade WHERE solicitador="+ solicitador +
                "AND solicitante=" + solicitante;
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.execute();
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     /* De acordo com a RF_06 dos Requisitos Funcionais */
    @Override
    public List<Map<String, String>> listaSolicitacoes(int id_usuario, int status) throws PersistenceException {
        String sql = "select u.id, u.nome_completo, u.apelido, u.foto_perfil, sa.solicitador, sa.solicitante, sa.status from "
                   + "usuario u, solicita_amizade sa "
                   + "where u.id = sa.solicitador and sa.solicitante = ? and sa.status = ?";
        
        try {
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, id_usuario);
            statement.setInt(2, status);
            
            ResultSet rs = statement.executeQuery();
            
            List<Map<String, String>> solicitacoes = new ArrayList<>();
            
            while(rs.next()) {
                Map<String, String> dados_solicitacoes = new HashMap<>();
                dados_solicitacoes.put("id_usuario", ""+rs.getInt(1));
                dados_solicitacoes.put("nome_completo", rs.getString(2));
                dados_solicitacoes.put("apelido", rs.getString(3));
                dados_solicitacoes.put("foto_perfil", rs.getString(4));
                dados_solicitacoes.put("id_solicitador", ""+rs.getInt(5));
                dados_solicitacoes.put("id_solicitante", ""+rs.getInt(6));
                dados_solicitacoes.put("status", ""+rs.getInt(7));
                
                solicitacoes.add(dados_solicitacoes);
            }
            
            return solicitacoes;
            
        } catch(SQLException e) {
            throw new PersistenceException(e);
        }
    }
}
