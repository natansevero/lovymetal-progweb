/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.psd.lovymetal.facade;

import br.edu.ifpb.psd.lovymetal.entidades.Mensagem;
import br.edu.ifpb.psd.lovymetal.entidades.Postagem;
import br.edu.ifpb.psd.lovymetal.entidades.Usuario;
import java.util.List;
import java.util.Map;


/**
 *
 * @author Natan Severo
 */
public interface FacadeIF {
    
//  Usuário ===================  
    public void adicionarUsuario(String senha, String nome, String apelido, String nasc, String cidade, String email, String profissao,
            String descricao, String sexo, String status, double altura, double peso, String cabelo, String fotoperfil);
    
    public Usuario getByEmail(String email);
    
    public Usuario getById(int id);
    
    public boolean atualizarUsuario(int id_usuario, String senha, String nome, String apelido, String nasc, String cidade, String email, String profissao,
            String descricao, String sexo, String status, double altura, double peso, String cabelo, String fotoperfil);
    public boolean excluirUsuario(String email, String senha);
    
    public List<Usuario> listarUsuarios();
    
    public List<Map<String, String>> pesquisarUsuario(String apelido);
    
//  Amizade (Solicitar, aceitar, rejeitar, listar) =====================
    public boolean solicitarAmizade(int id_solicitador, int id_solicitante);
    
    /* 
        Método para verficar o status de solicitação entre dois usuários. Se já foi aceita ou ainda está pendente
        Este método servirá para UX do botão de solicitar amizade no perfil do usuário
    */
    public int verificarSolicitacao(int id_solicitador, int id_solicitante);
    
    /*
        Método para listar as Solicitações que um usuário recebeu
    */
    public List<Map<String, String>> listarSolicitacao(int id_usuario);
    
    /* Método para aceitar uma solicitação, passando o id de quem mandou a solicitação e o id de quem recebe a solicitação */
    public boolean aceitarSolicitacao(int id_solicitador, int id_solicitante);
    
    /* Método para rejeitar uma solicitação, passando o id de quem mandou a solicitação e o id de quem recebe a solicitação */
    public boolean rejeitarSolicitacao(int id_solicitador, int id_solicitante);
    
    /* Método para contar a quandidade de solicitações que o user possui */
    public int contarSolicitacoes(int id_usuario);
    
    /* Metodos para Amizade ================ */
    public boolean novaAmizade(int usuario, int amigo);
    
    public void novoPassatempo(int id_usuario, String passatempo);
    
    public void removePassatempo(int id_usuario, String passatempo);
    
    public boolean postarFoto(int id_usuario, String descricao, String foto);
        
    public List<String> listarPostagens(int id_usuario);
    
    public void excluiPostagem(int postagem_id,int id_usuario);
    
    public void novaGaleria(int galeria_id, int id_usuario, String nomegaleria, String foto);
    
    public void removeGaleria(int galeria_id, int id_usuario);
    
    public void enviarMensagem(int mensagemid, int remetente, int destinatario, String mensagem, int status);
    
    public List<Map<String, String>> verificarMensagens(int destinatario);
    
    public List<Map<String, String>> lerMensagens(int destinatario, int remetente);
    
    public void excluirMensagem(int id);
    
    public void novaRelacao(int id_usuario, String tipo, int par);
    
    public void removeRelacao(int id_usuario, int par);
    
}
