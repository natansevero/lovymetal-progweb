/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO.Gerenciador;

import br.edu.ifpb.psd.lovymetal.DAO.DAOFactory;
import br.edu.ifpb.psd.lovymetal.DAO.interfaces.DAOFactoryInter;
import br.edu.ifpb.psd.lovymetal.DAO.UsuarioDAO;
import br.edu.ifpb.psd.lovymetal.Entidades.Usuario;
import java.sql.Date;
import javax.persistence.PersistenceException;

/**
 *
 * @author JuliermeH
 */
public class GerenciadorUsuario {
    /* Declarando os respectivos atributos para esta entidade */
    private DAOFactoryInter fabrica = null;
    private UsuarioDAO userdao = null;
    
    /* Construtor responsável por criar uma nova Fábrica de Usuários */
    public GerenciadorUsuario(){
        fabrica = DAOFactory.criarFactory();
        try{
            userdao = (UsuarioDAO) fabrica.criaUsuario();
        } catch (PersistenceException e){}
    }
    
    /* Método responsável por adicionar um usuário e fazer a persistência no BD */
    public void adicionaUsuario(String login, String senha, String nome, String apelido, Date nasc, String cidade, String profissao,
            String descricao, String sexo, String status, float altura, float peso, String cabelo, String fotoperfil)
            throws PersistenceException{
        Usuario novousuario = new Usuario();
        novousuario.setLogin(login);
        novousuario.setSenha(senha);
        novousuario.setNome(nome);
        novousuario.setApelido(apelido);
        novousuario.setDataNasc(nasc);
        novousuario.setCidade(cidade);
        novousuario.setProfissao(profissao);
        novousuario.setDescricao(descricao);
        novousuario.setSexo(sexo);
        novousuario.setStatus(status);
        novousuario.setAltura(altura);
        novousuario.setPeso(peso);
        novousuario.setCabelo(cabelo);
        novousuario.setFotoPerfil(fotoperfil);
        userdao.persiste(novousuario);
    }
    
    /* Método responsável por remover um usuário do BD usando o login */
    public void removeUsuario(String login) throws PersistenceException{
        userdao.exlui(login);
    }
}
