/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.psd.lovymetal.DAO;
import br.edu.ifpb.psd.lovymetal.DAO.interfaces.DAOFactoryInter;

/**
 *
 * @author JuliermeH
 */
public class DAOFactory {
    /* Entidade que cria a Fábrica de DAO do Banco de Dados */
    public static DAOFactoryInter criarFactory(){
        return new DAOFactoryDB();
    }
}
