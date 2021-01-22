/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import Services.IServicio;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedList;

/**
 *
 * @author El Pitagoras
 */
public class Resumen implements Serializable {

    private LinkedList<Transaccion> listaTransacciones;
    private final LocalDate fecha;

    private int cantRecarga;
    private double ingRecarga;
    private int cantServBancarios;
    private double ingServBancarios;
    private int cantServNativos;
    private double ingServNativos;
    private int cantRecaudacion;
    private double ingRecaudacion;
    private int cantProductos;
    private double ingProductos;

    public Resumen() {
        listaTransacciones = new LinkedList<>();
        fecha = LocalDate.now();
    }

    public void añadirTransaccion(Transaccion t) {
        listaTransacciones.add(t);
    }

    public void addDatosTransaccion(Transaccion t) {
        for (IServicio is : t.getListaServicios()) {
            switch (is.getServicio()) {
                case "Recarga":
                    cantRecarga++;
                    ingRecarga += is.getTotal();
                    break;
                case "Servicios Bancarios":
                    cantServBancarios++;
                    ingServBancarios += is.getTotal();
                    break;
                case "Servicios Nativo":
                    cantServNativos++;
                    ingServNativos += is.getTotal();
                    break;
                case "Recaudacion":
                    cantRecaudacion++;
                    ingRecaudacion += is.getTotal();
                    break;
                case "Venta de Producto":
                    cantProductos++;
                    ingProductos += is.getTotal();
                    break;
            }
        }
    }

    public LocalDate getFecha() {
        return fecha;
    }
}
