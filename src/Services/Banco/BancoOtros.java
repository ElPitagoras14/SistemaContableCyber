/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Banco;

import Enums.Banco;
import Services.IServicio;

/**
 *
 * @author El Pitagoras
 */
public class BancoOtros implements IServicio{
    private double valor;
    private Banco banco;

    public BancoOtros(Banco banco, double valor) {
        this.banco = banco;
        this.valor = valor;
    }

    @Override
    public String getServicio() {
        return "Servicio Bancario";
    }

    @Override
    public String getCaracteristica() {
        return "Otros";
    }

    @Override
    public double getValor() {
        return valor;
    }

    @Override
    public double getComision() {
        return 0;
    }
    
}
