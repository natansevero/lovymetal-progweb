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
    public void adicionarUsuario(String senha, String nome, String apelido, String nasc, String cidade, String email, String profissao,
            String descricao, String sexo, String status, double altura, String cabelo, String fotoperfil) {
        
        GerenciadorUsuario gerenciadorUsuario = new GerenciadorUsuario();
        
        gerenciadorUsuario.adicionaUsuario(senha, nome, apelido, nasc, cidade, email, profissao, descricao, sexo, status, altura, cabelo, fotoperfil);
    }
    
}
