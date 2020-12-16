/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Enums.TipoServicioNativo;

/**
 *
 * @author El Pitagoras
 */
public class ServicioNativo implements IServicio{
    private TipoServicioNativo tipo;
    private double valorTotal;
    private String descripcion;

    public ServicioNativo(TipoServicioNativo tipo, String descripcion, double valorTotal) {
        this.tipo = tipo;
        this.valorTotal = valorTotal;
        this.descripcion = descripcion;
    }

    @Override
    public String getServicio() {
        return "Servicio Nativo";
    }

    @Override
    public String getCaracteristica() {
        return tipo.toString();
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
