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
    private double valorTotal;

    public Recaudacion(TipoRecaudacion tipo, double valorTotal) {
        this.tipo = tipo;
        this.valorTotal = valorTotal;
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
        return valorTotal;
    }

    @Override
    public double getComision() {
        if (valorTotal < 100) {
            return 0.50;
        } else {
            return Math.floor(valorTotal / 50) * 0.25;
        }
    }

}
