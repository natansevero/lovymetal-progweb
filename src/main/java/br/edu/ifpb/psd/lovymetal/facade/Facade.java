/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.facade;

import br.edu.ifpb.psd.lovymetal.DAO.managers.GerenciadorGaleria;
import br.edu.ifpb.psd.lovymetal.DAO.managers.GerenciadorMensagem;
import br.edu.ifpb.psd.lovymetal.DAO.managers.GerenciadorPassatempos;
import br.edu.ifpb.psd.lovymetal.DAO.managers.GerenciadorPostagem;
import br.edu.ifpb.psd.lovymetal.DAO.managers.GerenciadorRelacionamento;
import br.edu.ifpb.psd.lovymetal.DAO.managers.GerenciadorUsuario;
import br.edu.ifpb.psd.lovymetal.entidades.Mensagem;
import br.edu.ifpb.psd.lovymetal.entidades.Postagem;
import br.edu.ifpb.psd.lovymetal.entidades.Usuario;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Natan Severo
 */
public class Facade implements FacadeIF {

    GerenciadorUsuario gerenciadorUsuario;
    GerenciadorGaleria gerenciadorGaleria;
    GerenciadorMensagem gerenciadorMensagem;
    GerenciadorPassatempos gerenciadorPassatempos;
    GerenciadorPostagem gerenciadorPostagem;
    GerenciadorRelacionamento gerenciadorRelacionamento;
    
    public Facade() {
        gerenciadorUsuario = new GerenciadorUsuario();
        gerenciadorGaleria = new GerenciadorGaleria();
        gerenciadorMensagem = new GerenciadorMensagem();
        gerenciadorPassatempos = new GerenciadorPassatempos();
        gerenciadorPostagem = new GerenciadorPostagem();
        gerenciadorRelacionamento = new GerenciadorRelacionamento();
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
    public List<Map<String, String>> pesquisarUsuario(String apelido) {
        return gerenciadorUsuario.pesquisarUsuario(apelido);
    }
    
    /* Métodos implementados dos Passatempos */
    @Override
    public void novoPassatempo(int id_usuario, String passatempo) {
        gerenciadorPassatempos.novoPassatempo(id_usuario, passatempo);
    }

    @Override
    public void removePassatempo(int id_usuario, String passatempo) {
        gerenciadorPassatempos.removePassatempo(id_usuario, passatempo);
    }
    
    /* Métodos implementados da Postagem */
    @Override
    public List<Postagem> verPostagens(int id_usuario) {
        return gerenciadorPostagem.verPostagens(id_usuario);
    }

    @Override
    public void fazerPostagem(int postagem_id, int id_usuario, String descricao, String foto) {
        gerenciadorPostagem.novaPostagem(postagem_id, id_usuario, descricao, foto);
    }

    @Override
    public void excluiPostagem(int postagem_id, int id_usuario) {
        gerenciadorPostagem.excluiPostagem(postagem_id, id_usuario);
    }
    
    /* Métodos implementados da Galeria */
    @Override
    public void novaGaleria(int galeria_id, int id_usuario, String nomegaleria, String foto){
        gerenciadorGaleria.novaGaleria(galeria_id, id_usuario, nomegaleria, foto);
    }
    
    @Override
    public void removeGaleria(int galeria_id, int id_usuario){
        gerenciadorGaleria.removeGaleria(galeria_id, id_usuario);
    }
    
    /* Métodos implementados da Mensagem */
    @Override
    public void enviarMensagem(int mensagem_id, int remetente, int destinatario, String mensagem, int status) {
        gerenciadorMensagem.novaMensagem(mensagem_id, remetente, destinatario, mensagem, status);
    }

    @Override
    public List<Mensagem> verificarMensagens(int destinatario) {
        List mensagens = gerenciadorMensagem.verificarmensagens(destinatario);
        return mensagens;
    }

    @Override
    public void excluirMensagem(int id) {
        gerenciadorMensagem.removerMensagem(id);
    }
    
    /* Métodos implementados do Relacionamento */
    @Override
    public void novaRelacao(int id_usuario, String tipo, int par) {
        gerenciadorRelacionamento.novaRelacao(id_usuario, tipo, par);
    }

    @Override
    public void removeRelacao(int id_usuario, int par) {
        gerenciadorRelacionamento.removeRelacao(id_usuario, par);
    }
}
