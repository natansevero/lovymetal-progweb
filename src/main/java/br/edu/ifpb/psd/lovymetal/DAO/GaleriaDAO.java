/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO;

import br.edu.ifpb.psd.lovymetal.DAO.interfaces.GaleriaDAOinter;
import br.edu.ifpb.psd.lovymetal.Entidades.Galeria;
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
public class GaleriaDAO implements GaleriaDAOinter{

    /* Objeto conexão e Propriedades do Banco de Dados */
    private PropBD prop;
    Connection conexao;
    
    /* Estabelecendo conexão com o banco usando as propriedades */
    public GaleriaDAO() throws PersistenceException, SQLException{
        this.conexao = DriverManager.getConnection(prop.getURL(),prop.getUser(),prop.getSenha());
        
    }
    
    /* Implementação da interface GaleriaDAOinter */
    @Override
    public void novaGaleria(Galeria galeria) throws PersistenceException {
        String sql = "INSERT INTO Galeria(id,usuariologin,nomegaleria,foto)" +
                "VALUES (1,2,3,4)";
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1,galeria.getID());
            statement.setString(2,galeria.getUsuariologin());
            statement.setString(3,galeria.getNomeGaleria());
            statement.setString(4,galeria.getFoto());
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void excluirGaleria(String id) throws PersistenceException {
        String sql = "DELETE FROM Galeria WHERE id=" + id;
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
