/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO;

import br.edu.ifpb.psd.lovymetal.DAO.interfaces.UsuarioDAOinter;
import br.edu.ifpb.psd.lovymetal.entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        this.prop = new PropBD();
        this.conexao = ConnFactory.getConnection(prop.getURL(), prop.getUser(), prop.getSenha());
    }
    /* Implementação da interface UsuarioDAOinter */
    /* De acordo com a RF_01 dos Requisitos Funcionais */
    @Override
    public String cadastra(Usuario usuario) throws PersistenceException {
        String sql = "INSERT INTO usuario (senha,nome_completo,apelido,data_nasc,cidade, email, profissao, descricao, sexo,status, altura, peso, cor_cabelo, foto_perfil)"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        System.out.println("Cadastra usuario no DAO: " + usuario.toString());
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
//            statement.setInt(1, usuario.getID());
            statement.setString(1, usuario.getSenha());
            statement.setString(2, usuario.getNome_completo());
            statement.setString(3, usuario.getApelido());
            statement.setString(4, usuario.getDatanasc());
            statement.setString(5, usuario.getCidade());
            statement.setString(6, usuario.getEmail());
            statement.setString(7, usuario.getProfissao());
            statement.setString(8, usuario.getDescricao());
            statement.setString(9, usuario.getSexo());
            statement.setString(10, usuario.getStatus());
            statement.setDouble(11, usuario.getAltura());
            statement.setDouble(12, usuario.getPeso());
            statement.setString(13, usuario.getCabelo());
            statement.setString(14, usuario.getFotoperfil());
            
            statement.executeUpdate();
            conexao.close();
            return "Usuário Cadastrado!";
        } catch (SQLException e){
            throw new PersistenceException(e);
        }
    }
    
    @Override
    public Usuario getByEmail(String email) throws PersistenceException {
        String sql = "select * from Usuario where email = ?";
        
        try {
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, email);
            
            ResultSet rs = statement.executeQuery();
            
            Usuario usuario = new Usuario();
            
            while(rs.next()) {
                usuario.setID(rs.getInt(1));
                usuario.setSenha(rs.getString(2));
                usuario.setNome_completo(rs.getString(3));
                usuario.setApelido(rs.getString(4));
                usuario.setDatanasc(rs.getString(5));
                usuario.setCidade(rs.getString(6));
                usuario.setEmail(rs.getString(7));
                usuario.setProfissao(rs.getString(8));
                usuario.setDescricao(rs.getString(9));
                usuario.setSexo(rs.getString(10));
                usuario.setStatus(rs.getString(11));
                usuario.setAltura(rs.getDouble(12));
                usuario.setPeso(rs.getDouble(13));
                usuario.setCabelo(rs.getString(14));
                usuario.setFotoperfil(rs.getString(15));
            }
            
            return usuario;
            
        } catch(SQLException e) {
            throw new PersistenceException(e);
        }
    }
    
    @Override
    public List<Usuario> listar() throws PersistenceException {
        String sql = "select * from Usuario";
        
        try {
            PreparedStatement statement = conexao.prepareStatement(sql);
            
            ResultSet rs = statement.executeQuery();
            
            List<Usuario> usuarios = new ArrayList<>();
            
            while(rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setID(rs.getInt(1));
                usuario.setSenha(rs.getString(2));
                usuario.setNome_completo(rs.getString(3));
                usuario.setApelido(rs.getString(4));
                usuario.setDatanasc(rs.getString(5));
                usuario.setCidade(rs.getString(6));
                usuario.setEmail(rs.getString(7));
                usuario.setProfissao(rs.getString(8));
                usuario.setDescricao(rs.getString(9));
                usuario.setSexo(rs.getString(10));
                usuario.setStatus(rs.getString(11));
                usuario.setAltura(rs.getDouble(12));
                usuario.setPeso(rs.getDouble(13));
                usuario.setCabelo(rs.getString(14));
                usuario.setFotoperfil(rs.getString(15));
                
                usuarios.add(usuario);
            }
            
            return usuarios;
            
        } catch(SQLException e) {
            throw new PersistenceException(e);
        }
    }
    
     /* De acordo com a RF_03 dos Requisitos Funcionais */
    @Override
    public boolean atualizar(Usuario usuario) throws PersistenceException{
        String sql = "UPDATE usuario SET senha = ?, nome_completo = ?, apelido = ?, data_nasc = ?,cidade = ?,"
                + "email = ?, profissao = ?, descricao = ?, sexo = ?, status = ?, altura = ?, peso = ?, cor_cabelo = ? WHERE id = ?";
        
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, usuario.getSenha());
            statement.setString(2, usuario.getNome_completo());
            statement.setString(3, usuario.getApelido());
            statement.setString(4, usuario.getDatanasc());
            statement.setString(5, usuario.getCidade());
            statement.setString(6, usuario.getEmail());
            statement.setString(7, usuario.getProfissao());
            statement.setString(8, usuario.getDescricao());
            statement.setString(9, usuario.getSexo());
            statement.setString(10, usuario.getStatus());
            statement.setDouble(11, usuario.getAltura());
            statement.setDouble(12, usuario.getPeso());
            statement.setString(13, usuario.getCabelo());
            statement.setInt(14, usuario.getID());
            
//            conexao.close();
            
            return statement.executeUpdate() > 0;
            
        } catch (SQLException e){
            throw new PersistenceException(e);
        }
    }
    
    /* De acordo com a RF_12 dos Requisitos Funcionais */
    @Override
    public List<Map<String, String>> pesquisar(String apelido) throws PersistenceException {
        String sql = "select * from Usuario where apelido = ?";
        
        try {
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, apelido);
            
            ResultSet rs = statement.executeQuery();
            
            List<Map<String, String>> usuarios = new ArrayList<>();
            
            while(rs.next()) {
                // Construindo o Map
                Map<String, String> usuario = new HashMap<>();
                usuario.put("id", ""+rs.getInt(1));
    //            usuario.put("senha", rs.getString(2));
                usuario.put("nome_completo", rs.getString(3));
                usuario.put("apelido", rs.getString(4));
                usuario.put("data_nasc", rs.getString(5));
                usuario.put("cidade", rs.getString(6));
                usuario.put("email", rs.getString(7));
                usuario.put("profissao", rs.getString(8));
                usuario.put("descricao", rs.getString(9));
                usuario.put("sexo", rs.getString(10));
                usuario.put("status", rs.getString(11));
                usuario.put("altura", ""+rs.getDouble(12));
                usuario.put("peso", ""+rs.getDouble(13));
                usuario.put("cor_cabelo", rs.getString(14));
                usuario.put("foto_perfil", rs.getString(15));
                
                // Adicionando Map no List de Usuarios
                usuarios.add(usuario);
            }
            
            return usuarios;
            
        } catch(SQLException e) {
            throw new PersistenceException(e);
        }
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
    public String exlui(int id) throws PersistenceException {
        String sql = "DELETE FROM Usuario WHERE id="+ id +" ON CASCADE";
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

    /* De acordo com a Regra 05 e ao RF_09 de Recomendar Pessoa para um Amigo */
    @Override
    public String recomendacao(int id_usuario, int amigo, int recomendado) throws PersistenceException {
         String sql = "CREATE VIEW Recomendacoes\n" +
"           AS SELECT U.id AS Usuario, U.Nome_Completo AS Amigo, U.Nome_Completo AS Recomendacao\n" +
"           FROM Usuario U, Amizade A\n" +
"           WHERE saoamigos(" + amigo + "," + recomendado + ") = 1";
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.execute();
            conexao.close();
            return "Usuário recomendado";
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Usuário não recomendado";
    }
}
