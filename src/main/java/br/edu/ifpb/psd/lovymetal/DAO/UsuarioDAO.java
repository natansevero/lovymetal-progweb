/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO;

import br.edu.ifpb.psd.lovymetal.DAO.interfaces.UsuarioDAOinter;
import br.edu.ifpb.psd.lovymetal.Entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PersistenceException;
import static jdk.nashorn.internal.objects.ArrayBufferView.length;

/**
 *
 * @author JuliermeH
 */
public class UsuarioDAO implements UsuarioDAOinter{
    
    /* Objeto conexão e Propriedades do Banco de Dados */
    private PropBD prop;
    private Connection conexao;
    
    /* Estabelecendo conexão com o banco usando as propriedades */
    public UsuarioDAO() throws PersistenceException, SQLException, ClassNotFoundException {
        this.conexao = ConnFactory.getConnection(prop.getURL(), prop.getUser(), prop.getSenha());
    }
    /* Implementação da interface UsuarioDAOinter */
    /* De acordo com a RF_01 dos Requisitos Funcionais */
    @Override
    public String cadastra(Usuario usuario) throws PersistenceException {
        String sql = "INSERT INTO USUARIO (login,senha,nome,apelido,datanasc,cidade, email, profissao, descricao, sexo,status, altura, peso, cabelo, fotoperfil)"
                + "VALUES (1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)";
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, usuario.getLogin());
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
            conexao.close();
            return "Usuário Atualizado!";
        } catch (SQLException e){
            throw new PersistenceException(e);
        }
    }
    
     /* De acordo com a RF_03 dos Requisitos Funcionais */
    @Override
    public String atualiza(Usuario usuario) throws PersistenceException{
        String sql = "UPDATE TABLE Usuario SET senha = ?, nome = ?, apelido = ?,datanasc = ?,cidade = ?,"
                + "email = ?, profissao = ?, descricao = ?, sexo = ?,status = ?, altura = ?, peso = ?, cabelo = ?, fotoperfil = ?"
                + "WHERE login =" + usuario.getLogin();
        
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, usuario.getSenha());
            statement.setString(2, usuario.getNome());
            statement.setString(3, usuario.getApelido());
            statement.setDate(4, usuario.getDataNasc());
            statement.setString(5, usuario.getCidade());
            statement.setString(6, usuario.getEmail());
            statement.setString(7, usuario.getProfissao());
            statement.setString(8, usuario.getDescricao());
            statement.setString(9, usuario.getSexo());
            statement.setString(10, usuario.getStatus());
            statement.setFloat(11, usuario.getAltura());
            statement.setFloat(12, usuario.getPeso());
            statement.setString(13, usuario.getCabelo());
            statement.setString(14, usuario.getFotoPerfil());
            conexao.close();
            return "Usuário Atualizado!";
        } catch (SQLException e){
            throw new PersistenceException(e);
        }
    }
    
    /* De acordo com a RF_12 dos Requisitos Funcionais */
    @Override
    public ArrayList pesquisar(String nome) throws PersistenceException {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuario WHERE nome LIKE" + "%" + nome + "%";
        try{
            Statement statement = conexao.createStatement(
                ResultSet.CLOSE_CURSORS_AT_COMMIT,
                ResultSet.TYPE_SCROLL_SENSITIVE);
            ResultSet resultado = statement.executeQuery(sql);
            listaUsuarios(resultado, usuarios);
            conexao.close();
        } catch (SQLException e){
            throw new PersistenceException(e);
        }
        return usuarios;
    }
    
    @Override
    public ArrayList pesquisar(String sexo, String cabelo) throws PersistenceException {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuario WHERE sexo=" + sexo + "AND cabelo=" + cabelo;
        try{
            Statement statement = conexao.createStatement(
                ResultSet.CLOSE_CURSORS_AT_COMMIT,
                ResultSet.TYPE_SCROLL_SENSITIVE);
            ResultSet resultado = statement.executeQuery(sql);
            listaUsuarios(resultado, usuarios);
            conexao.close();
        } catch (SQLException e){
            throw new PersistenceException(e);
        }
        return usuarios;
    }
    
    @Override
    public ArrayList pesquisar(float altura, float peso) throws PersistenceException {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuario WHERE altura=" + altura + "AND peso=" + peso;
        try{
            Statement statement = conexao.createStatement(
                ResultSet.CLOSE_CURSORS_AT_COMMIT,
                ResultSet.TYPE_SCROLL_SENSITIVE);
            ResultSet resultado = statement.executeQuery(sql);
            listaUsuarios(resultado, usuarios);
            conexao.close();
        } catch (SQLException e){
            throw new PersistenceException(e);
        }
        return usuarios;
    }

    /* Método responsável por adicionar um Usuário num ArrayList a partir de um ResultSet */
    public ArrayList<Usuario> listaUsuarios(ResultSet rs, ArrayList lista) throws PersistenceException, SQLException{
        int total = length(rs);
        for (int i = 0; i < total; i++){
            lista.add((Usuario) rs.getObject(i));
        }
        return lista;
    }
    
    /* De acordo com a RF_04 dos Requisitos Funcionais */
    @Override
    public String exlui(String login) throws PersistenceException {
        String sql = "DELETE FROM Usuario WHERE login="+ login +" ON CASCADE";
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.execute();
            conexao.close();
            return "Usuário excluído";
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Usuário não excluído";
    }
}
