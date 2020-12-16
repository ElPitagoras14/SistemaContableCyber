/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Producto;

import Services.IServicio;
import java.util.LinkedList;

/**
 *
 * @author El Pitagoras
 */
public class VentaProducto implements IServicio {

    private LinkedList<ProductoFisico> listaProducto;
    private double valorTotal;

    public VentaProducto(LinkedList<ProductoFisico> listaProducto) {
        this.listaProducto = listaProducto;
        actualizarPrecio();
    }

    private void actualizarPrecio() {
        valorTotal = 0;
        double valor = 0;
        for (ProductoFisico p : listaProducto) {
            valor += p.getCantidad() * p.getProducto().getValorUnidad();
        }
        valorTotal = valor;
    }

    @Override
    public String getServicio() {
        return "Venta de Producto";
    }

    @Override
    public String getCaracteristica() {
        return "";
    }

    @Override
    public double getValor() {
        return valorTotal;
    }

    @Override
    public double getComision() {
        return 0;
    }

}
