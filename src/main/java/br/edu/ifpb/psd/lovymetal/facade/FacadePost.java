/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.facade;

import br.edu.ifpb.psd.lovymetal.DAO.managers.GerenciadorPostagem;
import br.edu.ifpb.psd.lovymetal.entidades.Mensagem;
import br.edu.ifpb.psd.lovymetal.entidades.Postagem;
import br.edu.ifpb.psd.lovymetal.entidades.Usuario;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Julierme Heinstein
 */
public class FacadePost implements FacadeIF{
    
    GerenciadorPostagem gerenciadorpostagem;

    @Override
    public void adicionarUsuario(String senha, String nome, String apelido, String nasc, String cidade, String email, String profissao, String descricao, String sexo, String status, double altura, double peso, String cabelo, String fotoperfil) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Usuario getByEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean atualizarUsuario(int id_usuario, String senha, String nome, String apelido, String nasc, String cidade, String email, String profissao, String descricao, String sexo, String status, double altura, double peso, String cabelo, String fotoperfil) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Usuario> listarUsuarios() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Map<String, String>> pesquisarUsuario(String apelido) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /* Implementação dos métodos da FacadeIF */
    @Override
    public List<Postagem> verPostagens(int id_usuario) {
        return gerenciadorpostagem.verPostagens(id_usuario);
    }

    @Override
    public void fazerPostagem(int postagem_id, int id_usuario, String descricao, String foto) {
        gerenciadorpostagem.novaPostagem(postagem_id, id_usuario, descricao, foto);
    }

    @Override
    public void excluiPostagem(int postagem_id, int id_usuario) {
        gerenciadorpostagem.excluiPostagem(postagem_id, id_usuario);
    }

    @Override
    public void novoPassatempo(int id_usuario, String passatempo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removePassatempo(int id_usuario, String passatempo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void novaGaleria(int galeria_id, int id_usuario, String nomegaleria, String foto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeGaleria(int galeria_id, int id_usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enviarMensagem(int mensagemid, int remetente, int destinatario, String mensagem, int status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Mensagem> verificarMensagens(int destinatario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluirMensagem(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void novaRelacao(int id_usuario, String tipo, int par) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeRelacao(int id_usuario, int par) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
