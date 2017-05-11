/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.facade;

import br.edu.ifpb.psd.lovymetal.DAO.managers.GerenciadorPostagem;
import br.edu.ifpb.psd.lovymetal.DAO.managers.GerenciadorUsuario;
import br.edu.ifpb.psd.lovymetal.controllers.FazerPostagem;
import br.edu.ifpb.psd.lovymetal.entidades.Postagem;
import br.edu.ifpb.psd.lovymetal.entidades.Usuario;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Natan Severo
 */
public class Facade implements FacadeIF {

    GerenciadorUsuario gerenciadorUsuario;
    
    public Facade() {
        gerenciadorUsuario = new GerenciadorUsuario();
    }
    
    @Override
    public void adicionarUsuario(String senha, String nome, String apelido, String nasc, String cidade, String email, String profissao,
            String descricao, String sexo, String status, double altura, double peso, String cabelo, String fotoperfil) {
        
        gerenciadorUsuario = new GerenciadorUsuario();
        
        gerenciadorUsuario.adicionaUsuario(senha, nome, apelido, nasc, cidade, email, profissao, descricao, sexo, status, altura, peso, cabelo, fotoperfil);
    }
    
    @Override
    public Usuario getByEmail(String email) {
        return gerenciadorUsuario.getByEmail(email);
    }
    
    @Override
    public boolean atualizarUsuario(int id_usuario, String senha, String nome, String apelido, String nasc, String cidade, String email, String profissao,
            String descricao, String sexo, String status, double altura, double peso, String cabelo, String fotoperfil) {
       
        gerenciadorUsuario = new GerenciadorUsuario();
        
        // Chamar Método atualizaUsuario do Gerenciador de usuario
        
        return gerenciadorUsuario.atualizaUsuario(id_usuario, senha, nome, apelido, nasc, cidade, email, profissao, descricao, sexo, status, altura, peso, cabelo, fotoperfil);
    }
    
    @Override
    public List<Usuario> listarUsuarios() {
        return gerenciadorUsuario.listarUsuarios();
    }
    
    @Override
    public List<Usuario> pesquisarUsuario(String apelido) {
        return gerenciadorUsuario.pesquisarUsuario(apelido);
    }
    
    /* Métodos implementados na FacadePost */
    @Override
    public List<Postagem> verPostagens(int id_usuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void fazerPostagem(int postagem_id, int id_usuario, String descricao, String foto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void excluiPostagem(int postagem_id, int id_usuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
