/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.facade;

import br.edu.ifpb.psd.lovymetal.DAO.managers.GerenciadorUsuario;
import java.sql.Date;

/**
 *
 * @author Natan Severo
 */
public class Facade implements FacadeIF {

    @Override
    public void adicionarUsuario(String login, String senha, String nome, String apelido, Date nasc, String cidade, String profissao,
            String descricao, String sexo, String status, float altura, float peso, String cabelo, String fotoperfil) {
        
        GerenciadorUsuario gerenciadorUsuario = new GerenciadorUsuario();
        
        gerenciadorUsuario.adicionaUsuario(login, senha, nome, apelido, nasc, cidade, profissao, descricao, sexo, status, altura, peso, cabelo, fotoperfil);
    }
    
}
