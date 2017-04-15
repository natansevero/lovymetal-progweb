/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO;

import br.edu.ifpb.psd.lovymetal.DAO.interfaces.RelacionamentoDAOinter;
import br.edu.ifpb.psd.lovymetal.Entidades.Relacionamento;
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
public class RelacionamentoDAO implements RelacionamentoDAOinter{

    /* Objeto conexão e Propriedades do Banco de Dados */
    private PropBD prop;
    private Connection conexao;
    
    /* Estabelecendo conexão com o banco usando as propriedades */
    public RelacionamentoDAO() throws PersistenceException, SQLException, ClassNotFoundException{
        this.conexao = ConnFactory.getConnection(prop.getURL(), prop.getUser(), prop.getSenha());   
    }
    
    /* Implementação da interface RelacionamentoDAOinter de acordo com a Regra 03 */
    @Override
    public void adicionaRelacionamento(Relacionamento relacionamento) throws PersistenceException {
        String sql = "INSERT INTO Relacionamento(usuariologin, tipo, par)" +
                "VALUES (1,2,3)";
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1,relacionamento.getUsuariologin());
            statement.setString(2,relacionamento.getTipo());
            statement.setString(3,relacionamento.getPar());
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void excluiRelacionamento(String login) throws PersistenceException {
        String sql = "DELETE FROM Mensagem WHERE usuariologin="+login;
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
