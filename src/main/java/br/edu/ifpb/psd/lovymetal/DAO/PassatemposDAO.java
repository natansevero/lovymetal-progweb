/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO;

import br.edu.ifpb.psd.lovymetal.DAO.interfaces.PassatemposDAOinter;
import br.edu.ifpb.psd.lovymetal.entidades.Passatempos;
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
public class PassatemposDAO implements PassatemposDAOinter{

    /* Objeto conexão e Propriedades do Banco de Dados */
    private PropBD prop;
    private Connection conexao;
    
    /* Estabelecendo conexão com o banco usando as propriedades */
    public PassatemposDAO() throws PersistenceException, SQLException, ClassNotFoundException{
        this.conexao = ConnFactory.getConnection(prop.getURL(), prop.getUser(), prop.getSenha());
    }
    
    /* Implementação da interface PassatempoDAOinter */
    @Override
    public String adiciona(Passatempos passatempo) throws PersistenceException {
        String sql = "INSERT INTO Passatempos(id_usuario, passatempo)" +
                "VALUES (1,2)";
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1,passatempo.getIDUsuario());
            statement.setString(2,passatempo.getPassatempo());
            conexao.close();
            return "Passatempo adicionado";
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Passatempo não adcionado";
    }

    @Override
    public String exclui(int id_usuario, String passatempo) throws PersistenceException {
        String sql = "DELETE FROM Passatempo WHERE id_usuario=" + id_usuario +
                "AND passatempo=" + passatempo;
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.execute();
            conexao.close();
            return "Passatempo excluído";
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Passatempo não excluído";
    } 
}
