/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.psd.lovymetal.facade;

import br.edu.ifpb.psd.lovymetal.entidades.Postagem;
import br.edu.ifpb.psd.lovymetal.entidades.Usuario;
import java.util.List;
import java.util.Map;


/**
 *
 * @author Natan Severo
 */
public interface FacadeIF {
    public void adicionarUsuario(String senha, String nome, String apelido, String nasc, String cidade, String email, String profissao,
            String descricao, String sexo, String status, double altura, double peso, String cabelo, String fotoperfil);
    
    public Usuario getByEmail(String email);
    
    public boolean atualizarUsuario(int id_usuario, String senha, String nome, String apelido, String nasc, String cidade, String email, String profissao,
            String descricao, String sexo, String status, double altura, double peso, String cabelo, String fotoperfil);
    
    public List<Usuario> listarUsuarios();
    
    public List<Map<String, String>> pesquisarUsuario(String apelido);
    
    public void fazerPostagem(int postagem_id,int id_usuario,String descricao,String foto);
    
    public List<Postagem> verPostagens(int id_usuario);
    
    public void excluiPostagem(int postagem_id,int id_usuario);
}
