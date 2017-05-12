/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO;

import br.edu.ifpb.psd.lovymetal.DAO.interfaces.AmizadeDAOinter;
import br.edu.ifpb.psd.lovymetal.entidades.Amizade;
import java.sql.Connection;
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
        this.prop = new PropBD();
        this.conexao = ConnFactory.getConnection(prop.getURL(), prop.getUser(), prop.getSenha()); 
    }
    
    /* Implementação da interface AmizadeDAOinter de acordo com a Regra 01*/
    /* De acordo com a RF_05 dos Requisitos Funcionais */
    @Override
    public String adiciona(Amizade amizade) throws PersistenceException {
        String sql = "INSERT INTO Amizade(usuario,amigo)" +
                "VALUES (1,2)";
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1,amizade.getUsuario());
            statement.setInt(2,amizade.getAmigo());
            conexao.close();
            return "Amigo adicionado";
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Amigo não adicionado";
    }
    
    @Override
    public void desfaz(int usuario, int amigo) throws PersistenceException {
        String sql = "DELETE FROM Amizade WHERE usuario="+ usuario +
                "AND amigo=" + amigo;
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.execute();
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
