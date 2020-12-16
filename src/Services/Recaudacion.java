/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Enums.TipoRecaudacion;

/**
 *
 * @author El Pitagoras
 */
public class Recaudacion implements IServicio {

    private TipoRecaudacion tipo;
    private double valor;
    private String descripcion;
    private double comision;

    public Recaudacion(TipoRecaudacion tipo, String descripcion, double valor) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.valor = valor;
        comision = Recaudacion.getComision(valor);
    }

    @Override
    public String getServicio() {
        return "Recaudacion";
    }

    @Override
    public String getCaracteristica() {
        return tipo.toString();
    }

    @Override
    public double getValor() {
        return valor;
    }

    @Override
    public double getComision() {
        return comision;
    }

    public static double getComision(double valor) {
        if (valor == 0) {
            return 0;
        } else if (valor < 100) {
            return 0.50;
        } else {
            return Math.floor(valor / 50) * 0.25;
        }
    }
}
