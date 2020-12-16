/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import Services.IServicio;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;

/**
 *
 * @author El Pitagoras
 */
public class Transaccion {
    private static int ultimoId;
    private LinkedList<IServicio> listaServicios;
    private String cliente;
    private double valorTotal;
    
    public Transaccion() {
        listaServicios = new LinkedList<>();
        cliente = "SIN DATOS";
    }
    
    public Transaccion(String cliente) {
        listaServicios = new LinkedList<>();
        this.cliente = cliente;
    }
    
    public void añadirServicio(IServicio serv) {
        listaServicios.add(serv);
        añadirCosto();
    }
    
    public void eliminarServicio(IServicio serv) {
        listaServicios.remove(serv);
        actualizarCosto();
    }
    
    private void actualizarCosto() {
        valorTotal = 0;
        for(IServicio is: listaServicios) {
            valorTotal += is.getTotal();
        }
    }
    
    public static String obtenerUltimoId() {
        ultimoId++;
        return String.format("%010d", ultimoId);
    }
    
    private void añadirCosto() {
        valorTotal += listaServicios.getLast().getTotal();
    }
    
    private String resumenTransacciones() {
        StringBuilder sb = new StringBuilder();
        for (IServicio is: listaServicios) {
            sb.append("\t");
            sb.append(is.getResumen());
        }
        return sb.toString();
    }
    
    public LinkedList<IServicio> getListaServicios() {
        return listaServicios;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transaccion ");
        sb.append(Transaccion.obtenerUltimoId());
        sb.append(" Fecha: ");
        sb.append(LocalDate.now().toString());
        sb.append(" Hora: ");
        sb.append(LocalTime.now().toString());
        sb.append("\nCliente: ");
        sb.append(cliente);
        sb.append("\n");
        sb.append(resumenTransacciones());
        sb.append(String.format("%-30s $%6.2f", "Total", valorTotal));
        return sb.toString();
    }
}
