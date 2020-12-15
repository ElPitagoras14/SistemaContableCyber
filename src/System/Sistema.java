package System;

import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author El Pitagoras
 */
public class Sistema {
    public static Sistema sistema;
    private LinkedList<Resumen> listaResumenes;
    
    private Sistema() {
        
    }
    
    public Sistema getSistema() {
        if (sistema == null) {
            sistema = new Sistema();
        }
        return sistema;
    }
    
}
