/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.psd.lovymetal.facade;

import java.sql.Date;

/**
 *
 * @author Natan Severo
 */
public interface FacadeIF {
    public void adicionarUsuario(int id, String senha, String nome, String apelido, Date nasc, String cidade, String profissao,
            String descricao, String sexo, String status, float altura, float peso, String cabelo, String fotoperfil);
}
