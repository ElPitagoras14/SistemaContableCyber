/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Producto;

import java.util.HashMap;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author El Pitagoras
 */
public class ProductoPortada {
    private SimpleStringProperty id;
    private SimpleStringProperty nombre;
    private SimpleDoubleProperty valorUnidad;

    public ProductoPortada(String id, String nombre, double valorUnidad) {
        this.id = new SimpleStringProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
        this.valorUnidad = new SimpleDoubleProperty(valorUnidad);
    }
       
    public static HashMap<String, ProductoPortada> cargarProductos(String path) {
        return null;
    }

    public String getId() {
        return id.get();
    }

    public String getNombre() {
        return nombre.get();
    }

    public double getValorUnidad() {
        return valorUnidad.get();
    }
}
