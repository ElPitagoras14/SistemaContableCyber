/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Producto;

import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author El Pitagoras
 */
public class ProductoFisico {

    private ProductoPortada producto;
    private SimpleIntegerProperty cantidad;

    public ProductoFisico(ProductoPortada producto, int cantidad) {
        this.producto = producto;
        this.cantidad = new SimpleIntegerProperty(cantidad);
    }

    public ProductoPortada getProducto() {
        return producto;
    }

    public String getId() {
        return producto.getId();
    }

    public String getNombre() {
        return producto.getNombre();
    }

    public double getValorUnidad() {
        return producto.getValorUnidad();
    }

    public int getCantidad() {
        return cantidad.get();
    }

    public double getTotal() {
        return getValorUnidad() * getCantidad();
    }
}
