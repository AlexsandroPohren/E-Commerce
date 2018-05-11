/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fameg.farmacia.Exception;

/**
 *
 * @author pazak
 */
public class ErrosSistema extends Exception {

    public ErrosSistema(String message) {
        super(message);
    }
    
    public ErrosSistema(String message, Throwable cause){
        super(message, cause);
    }
       
}
