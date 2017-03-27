/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO;

import br.edu.ifpb.psd.lovymetal.DAO.interfaces.UsuarioDAOinter;
import br.edu.ifpb.psd.lovymetal.Entidades.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author JuliermeH
 */
public class UsuarioDAO implements UsuarioDAOinter{
    
    private PropBD prop;
    Connection conexao;
    
    public UsuarioDAO() throws PersistenceException, SQLException{
        this.conexao = DriverManager.getConnection(prop.getURL(),prop.getUser(),prop.getSenha());
        
    }
    /* Implementação da interface UsuarioDAOinter */
    @Override
    public String persiste(Usuario usuario) throws PersistenceException {
        String sql = "INSERT INTO USUARIO (login,senha,nome,apelido,datanasc,cidade, email, profissao, descricao, sexo,status, altura, peso, cabelo, fotoperfil)"
                + "VALUES (1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)";
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1,usuario.getLogin());
            statement.setString(2, usuario.getSenha());
            statement.setString(3, usuario.getNome());
            statement.setString(4, usuario.getApelido());
            statement.setDate(5, usuario.getDataNasc());
            statement.setString(6, usuario.getCidade());
            statement.setString(7, usuario.getEmail());
            statement.setString(8, usuario.getProfissao());
            statement.setString(9, usuario.getDescricao());
            statement.setString(10, usuario.getSexo());
            statement.setString(11, usuario.getStatus());
            statement.setFloat(12, usuario.getAltura());
            statement.setFloat(13, usuario.getPeso());
            statement.setString(14, usuario.getCabelo());
            statement.setString(15, usuario.getFotoPerfil());
            return "Usuário Adicionado!";
        } catch (SQLException e){
            throw new PersistenceException(e);
        }
    }

    @Override
    public Usuario pesquisar(String nome) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /* public List<Usuario> lista() throws PersistenceException{
        Usuario[] users = {};
        List<Usuario> usuario = new ArrayList<Usuario>();
        for (Usuario user:users){
        }
        return ;
    } */

    @Override
    public String exlui(String login) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   /* private Usuario leUsuario(ResultSet rs) throws SQLException{
        PreparedEstatement statement = connection.preparedStatement(sql);
        statement.getObject(usuario);
    } */
}
