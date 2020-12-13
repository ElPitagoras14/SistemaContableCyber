/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.LinkedList;

/**
 *
 * @author El Pitagoras
 */
public class ProductoPortada {
    private int id;
    private String nombre;
    private double valorUnidad;

    public ProductoPortada(int id, String nombre, double valorUnidad) {
        this.id = id;
        this.nombre = nombre;
        this.valorUnidad = valorUnidad;
    }
       
    public static LinkedList<ProductoPortada> cargarProductos(String path) {
        return null;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getValorUnidad() {
        return valorUnidad;
    }

}
