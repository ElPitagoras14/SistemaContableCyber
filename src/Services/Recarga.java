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
    private double valor;
    private double comision;

    public Recarga(Operadora operadora, String numero, TipoRecarga tipo, double valorTotal, double comision) {
        this.operadora = operadora;
        this.numero = numero;
        this.tipo = tipo;
        this.valor = valorTotal;
        this.comision = comision;
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
        return valor;
    }

    @Override
    public double getComision() {
        return comision;
    }
    
    public static double getComision(Operadora oper, double valor) {
        switch (oper) {
            case MOVISTAR:
            case CLARO:
            case CNT:
            case TUENTI:
                if (valor < 3) {
                    return valor * 0.10;
                } else if (valor == 3){
                    return 0.25;
                } else if (valor == 5) {
                    return 0.40;
                } else {
                    return valor * 0.10;
                }
            case DIRECTV:
                if (valor < 10) {
                    return 0.40;
                } else if (valor < 15){
                    return 0.50;
                } else {
                    return 1;
                }
        }
        return 0;
    }
}
