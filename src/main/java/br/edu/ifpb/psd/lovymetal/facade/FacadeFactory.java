/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.psd.lovymetal.facade;

/**
 *
 * @author Natan Severo
 */
public class FacadeFactory {
    public static FacadeIF criarFacadeFactory() {
        return new Facade();
    } 
}
