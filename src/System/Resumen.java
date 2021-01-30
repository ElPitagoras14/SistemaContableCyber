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

    private double ingresoNeto;

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

    public void addTransaccion(Transaccion t) {
        listaTransacciones.add(t);
        addDatosTransaccion(t);
    }

    private void addDatosTransaccion(Transaccion t) {
        for (IServicio is : t.getListaServicios()) {
            ingresoNeto += is.getComision();
            switch (is.getServicio()) {
                case "Recarga":
                    cantRecarga++;
                    ingRecarga += is.getTotal();
                    break;
                case "Servicios Bancarios":
                    cantServBancarios++;
                    ingServBancarios += is.getTotal();
                    break;
                case "Servicio Nativo":
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

    public String toString() {
        return String.valueOf(listaTransacciones.size());
    }
    
    public double getTotalIngreso() {
        return ingRecarga + ingServBancarios + ingServNativos + ingRecaudacion + ingProductos;
    }

    public void añadirDatos(Resumen r) {
        cantRecarga += r.cantRecarga;
        ingRecarga += r.ingRecarga;
        cantServBancarios += r.cantServBancarios;
        ingServBancarios += r.ingServBancarios;
        cantServNativos += r.cantServNativos;
        ingServNativos += r.ingServNativos;
        cantRecaudacion += r.cantRecaudacion;
        ingRecaudacion += r.ingRecaudacion;
        cantProductos += r.cantProductos;
        ingProductos += r.ingProductos;
        ingresoNeto += r.ingresoNeto;
    }

    public double getIngresoNeto() {
        return ingresoNeto;
    }

    public int getCantRecarga() {
        return cantRecarga;
    }

    public double getIngRecarga() {
        return ingRecarga;
    }

    public int getCantServBancarios() {
        return cantServBancarios;
    }

    public double getIngServBancarios() {
        return ingServBancarios;
    }

    public int getCantServNativos() {
        return cantServNativos;
    }

    public double getIngServNativos() {
        return ingServNativos;
    }

    public int getCantRecaudacion() {
        return cantRecaudacion;
    }

    public double getIngRecaudacion() {
        return ingRecaudacion;
    }

    public int getCantProductos() {
        return cantProductos;
    }

    public double getIngProductos() {
        return ingProductos;
    }

}
