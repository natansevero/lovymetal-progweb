/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO;

import br.edu.ifpb.psd.lovymetal.DAO.interfaces.Solicita_amizadeDAOinter;
import br.edu.ifpb.psd.lovymetal.entidades.Solicita_amizade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PersistenceException;

/**
 *
 * @author Julierme Heinstein
 */
public class Solicita_amizadeDAO implements Solicita_amizadeDAOinter {
    /* Objeto conexão e Propriedades do Banco de Dados */
    private PropBD prop;
    private Connection conexao;
    
    /* Estabelecendo conexão com o banco usando as propriedades */
    public Solicita_amizadeDAO() throws PersistenceException, SQLException, ClassNotFoundException{
        this.conexao = ConnFactory.getConnection(prop.getURL(), prop.getUser(), prop.getSenha()); 
    }
    
    /* Implementação da interface Solicita_amizadeDAOinter */
    /* De acordo com a RF_07 dos Requisitos Funcionais */
    @Override
    public String solicita(Solicita_amizade solicitacao) throws PersistenceException{
        String sql = "INSERT INTO solicita_amizade(solicitador,solicitante,status)" +
                "VALUES (1,2,3)";
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1,solicitacao.getSolicitador());
            statement.setInt(2,solicitacao.getSolicitante());
            statement.setInt(3,solicitacao.getStatus());
            conexao.close();
            return "Solicitação enviada";
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Solicitação não enviada";
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
}
