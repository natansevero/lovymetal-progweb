/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO;

import br.edu.ifpb.psd.lovymetal.DAO.interfaces.PostagemDAOinter;
import br.edu.ifpb.psd.lovymetal.entidades.Postagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PersistenceException;

/**
 *
 * @author JuliermeH
 */
public class PostagemDAO implements PostagemDAOinter{
    
    /* Objeto conexão e Propriedades do Banco de Dados */
    private PropBD prop;
    private Connection conexao;
    
    /* Estabelecendo conexão com o banco usando as propriedades */
    public PostagemDAO() throws PersistenceException, SQLException, ClassNotFoundException{
        this.prop = new PropBD();
        this.conexao = ConnFactory.getConnection(prop.getURL(), prop.getUser(), prop.getSenha()); 
    }
    
    /* Implementação da interface PostagemDAOinter de acordo com a Regra 04 */
    @Override
    public void novaPostagem(Postagem postagem) throws PersistenceException {
        String sql = "INSERT INTO Postagem(postagem_id,id_usuario,descricao,foto)" +
                "VALUES (1,2,3,4)";
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1,postagem.getPostagemID());
            statement.setInt(2,postagem.getIDUsuario());
            statement.setString(3,postagem.getDescricao());
            statement.setString(4,postagem.getFoto());
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<Postagem> verPostagens(int usuario) throws PersistenceException {
        String sql = "SELECT A.amigo, P.descricao, P.foto"
                + "FROM (Amizade A JOIN Postagem P ON A.amigo = P.id_usuario) WHERE A.usuario =" + usuario;
        
        try {
            PreparedStatement statement = conexao.prepareStatement(sql);
            
            ResultSet rs = statement.executeQuery();
            
            List<Postagem> postagens = new ArrayList<>();
            
            while(rs.next()) {
                Postagem postagem = new Postagem();
                postagem.setIDUsuario(rs.getInt(1));
                postagem.setDescricao(rs.getString(2));
                postagem.setFoto(rs.getString(3));
                
                postagens.add(postagem);
            }
            return postagens;
            
        } catch(SQLException e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public void excluirPostagem(int postagem_id, int id_usuario) throws PersistenceException {
        String sql = "DELETE FROM Postagem WHERE postagem_id="+ postagem_id +
                "AND id_usuario=" + id_usuario;
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.execute();
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
