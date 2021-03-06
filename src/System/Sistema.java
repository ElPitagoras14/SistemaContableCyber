package System;

import FileResources.Serializar;
import Services.Producto.ProductoPortada;
import java.time.LocalDate;
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
    private LocalDate fechaActual;

    private Serializar<Resumen> serResumen;

    private Sistema() {
        arregloTransaccion = new Transaccion[3];
        fechaActual = LocalDate.now();

        serResumen = new Serializar<>();
        listaResumenes = serResumen.deserializar("Historico/historico.ser");
        resumenActual = obtenerResumenActual();
    }

    public static Sistema getSistema() {
        if (sistema == null) {
            sistema = new Sistema();
        }
        return sistema;
    }

    private Resumen obtenerResumenActual() {
        if (listaResumenes.size() > 0 && listaResumenes.getLast().getFecha().equals(fechaActual)) {
            return listaResumenes.getLast();
        }
        Resumen nuevo = new Resumen();
        listaResumenes.add(nuevo);
        return nuevo;
    }

    public void salvarResumenes() {
        serResumen.serializar(listaResumenes, "Historico/historico.ser");
    }

    public void terminarTransaccion(Transaccion t) {
        resumenActual.addTransaccion(t);
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

    public Resumen getResumenFechas(LocalDate ini, LocalDate fin) {
        Resumen resumenFecha = new Resumen();
        if (ini.isEqual(fin)) {
            for (Resumen r : listaResumenes) {
                if (r.getFecha().isEqual(ini)) {
                    return r;
                }
            }
        }

        for (Resumen r : listaResumenes) {
            if (r.getFecha().isEqual(ini) || r.getFecha().isEqual(fin)
                    || (r.getFecha().isBefore(fin) && r.getFecha().isAfter(ini))) {
                resumenFecha.añadirDatos(r);
            }
        }
        return resumenFecha;
    }

}
