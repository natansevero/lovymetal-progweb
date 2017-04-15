/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO;

import br.edu.ifpb.psd.lovymetal.DAO.interfaces.AmizadeDAOinter;
import br.edu.ifpb.psd.lovymetal.Entidades.Amizade;
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
public class AmizadeDAO implements AmizadeDAOinter{
    /* Objeto conexão e Propriedades do Banco de Dados */
    private PropBD prop;
    private Connection conexao;
    
    /* Estabelecendo conexão com o banco usando as propriedades */
    public AmizadeDAO() throws PersistenceException, SQLException, ClassNotFoundException{
        this.conexao = ConnFactory.getConnection(prop.getURL(), prop.getUser(), prop.getSenha()); 
    }
    
    /* Implementação da interface AmizadeDAOinter */
    @Override
    public String adiciona(Amizade amizade) throws PersistenceException {
        String sql = "INSERT INTO Amizade(usuario,amigo)" +
                "VALUES (1,2)";
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1,amizade.getUsuario());
            statement.setString(2,amizade.getAmigo());
            return "Amigo adicionado";
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Amigo não adicionado";
    }
    
    @Override
    public void desfaz(String login, String amigo) throws PersistenceException {
        String sql = "DELETE FROM Amizade WHERE usuario="+ login +
                "AND amigo=" + amigo;
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
