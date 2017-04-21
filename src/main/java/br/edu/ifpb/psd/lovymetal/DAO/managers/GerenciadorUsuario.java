/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO.managers;

import br.edu.ifpb.psd.lovymetal.DAO.DAOFactory;
import br.edu.ifpb.psd.lovymetal.DAO.interfaces.DAOFactoryInter;
import br.edu.ifpb.psd.lovymetal.DAO.interfaces.UsuarioDAOinter;
import br.edu.ifpb.psd.lovymetal.entidades.Usuario;
import java.sql.Date;
import javax.persistence.PersistenceException;

/**
 *
 * @author JuliermeH
 */
public class GerenciadorUsuario {
    /* Declarando os respectivos atributos para esta entidade */
    private DAOFactoryInter fabrica = null;
    private UsuarioDAOinter userdao = null;
    
    /* Construtor responsável por criar uma nova Fábrica de Usuários */
    public GerenciadorUsuario(){
        fabrica = DAOFactory.criarFactory();
        try{
            userdao = (UsuarioDAOinter) fabrica.criaUsuario();
        } catch (PersistenceException e){}
    }
    
    /* Método responsável por adicionar um usuário e fazer a persistência no BD */
    public void adicionaUsuario(String senha, String nome_completo, String apelido, String nasc, String cidade, String email, String profissao,
            String descricao, String sexo, String status, double altura,String cor_cabelo, String foto_perfil)
            throws PersistenceException{
        Usuario novousuario = new Usuario(senha, nome_completo, apelido, nasc, cidade, email, profissao, descricao, sexo, status, altura, cor_cabelo, foto_perfil);
        
//        novousuario.setID(id);
        
        
        System.out.println("Novo usuario: " + novousuario.toString());
        
        String cadastra = userdao.cadastra(novousuario);
        System.out.println(cadastra);
    }
        
    /* Método responsável por remover um usuário do BD usando o login */
    public void removeUsuario(int id) throws PersistenceException{
        userdao.exlui(id);
    }
}
