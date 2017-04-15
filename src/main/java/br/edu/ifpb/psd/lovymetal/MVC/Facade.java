/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.MVC;

import br.edu.ifpb.psd.lovymetal.DAO.AmizadeDAO;
import br.edu.ifpb.psd.lovymetal.DAO.GaleriaDAO;
import br.edu.ifpb.psd.lovymetal.DAO.MensagemDAO;
import br.edu.ifpb.psd.lovymetal.DAO.PassatemposDAO;
import br.edu.ifpb.psd.lovymetal.DAO.RelacionamentoDAO;
import br.edu.ifpb.psd.lovymetal.DAO.UsuarioDAO;
import br.edu.ifpb.psd.lovymetal.DAO.objneg.GerenciadorUsuario;



/**
 *
 * @author Julierme Heinstein
 */
public class Facade {
    protected GerenciadorUsuario gerenciador;
    protected UsuarioDAO usuario;
    protected PassatemposDAO passatempo;
    protected MensagemDAO mensagem;
    protected AmizadeDAO amizade;
    protected RelacionamentoDAO relacionamento;
    protected GaleriaDAO galeria;
    
    public void inicializadorUsuario(){
        
    }
}
