/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Enums.Operadora;
import Enums.TipoRecarga;

/**
 *
 * @author El Pitagoras
 */
public class Recarga implements IServicio {

    private Operadora operadora;
    private String numero;
    private TipoRecarga tipo;
    private double valorTotal;

    public Recarga(Operadora operadora, String numero, TipoRecarga tipo, double valorTotal) {
        this.operadora = operadora;
        this.numero = numero;
        this.tipo = tipo;
        this.valorTotal = valorTotal;
    }

    @Override
    public String getServicio() {
        return "Recarga";
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
        switch (operadora) {
            case MOVISTAR:
            case CLARO:
            case CNT:
            case TUENTI:
                if (valorTotal < 3) {
                    return valorTotal * 0.10;
                } else if (valorTotal == 3){
                    return 0.25;
                } else if (valorTotal == 5) {
                    return 0.40;
                } else {
                    return valorTotal * 0.10;
                }
            case DIRECTV:
                if (valorTotal < 10) {
                    return 0.40;
                } else if (valorTotal < 15){
                    return 0.50;
                } else {
                    return 1;
                }
        }
        return 0;
    }
}
