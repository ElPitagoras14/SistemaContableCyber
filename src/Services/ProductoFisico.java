/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

/**
 *
 * @author El Pitagoras
 */
public class ProductoFisico {
    private ProductoPortada producto;
    private int cantidad;

    public ProductoFisico(ProductoPortada producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public ProductoPortada getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }
    
    
}
