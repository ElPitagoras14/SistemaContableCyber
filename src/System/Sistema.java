package System;

import FileResources.Serializar;
import Services.Producto.ProductoPortada;
import java.util.HashMap;
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

    private HashMap<String, ProductoPortada> mapaProductos;
    private LinkedList<Resumen> listaResumenes;
    private Resumen resumenActual;
    private Transaccion transaccionActual;
    private Transaccion[] arregloTransaccion;
    
    private Serializar<Resumen> serResumen;

    private Sistema() {
        transaccionActual = new Transaccion();
        arregloTransaccion = new Transaccion[3];
        
        serResumen = new Serializar<>();
        listaResumenes = serResumen.deserializar("Historico/historico.ser");
        if (listaResumenes.size() > 0) {
            resumenActual = listaResumenes.getLast();
        }
        resumenActual = new Resumen();
        listaResumenes.add(resumenActual);
    }

    public static Sistema getSistema() {
        if (sistema == null) {
            sistema = new Sistema();
        }
        return sistema;
    }
    
    public void salvarResumenes() {
        serResumen.serializar(listaResumenes, "Historico/historico.ser");
    }

    public Resumen getResumenActual() {
        return resumenActual;
    }

    public Transaccion getTransaccionActual() {
        return transaccionActual;
    }
    
    public void setTransaccionActual(Transaccion t) {
        transaccionActual = t;
    }
    
    public ProductoPortada obtenerProducto(String id) {
        return mapaProductos.get(id);
    }
    
    public Transaccion getTransaccion(int id) {
        return arregloTransaccion[id];
    }
    
    public void setTransaccion(Transaccion t, int id) {
        arregloTransaccion[id] = t;
    }

}
