/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Banco;

import Enums.Banco;
import Enums.TipoCuenta;
import Services.IServicio;

/**
 *
 * @author El Pitagoras
 */
public abstract class ServicioBancario implements IServicio{
    protected Banco banco;
    protected TipoCuenta tipoCuenta;
    private double valorTotal;

    public ServicioBancario(Banco banco, TipoCuenta tipoCuenta, double valorTotal) {
        this.banco = banco;
        this.tipoCuenta = tipoCuenta;
        this.valorTotal = valorTotal;
    }
    
    @Override
    public String getServicio() {
        return "Servicio Bancario";
    }

    @Override
    public double getValor() {
        return valorTotal + getComision();
    }
    
    @Override
    public double getComision() {
        return Math.floor(valorTotal / 50) * 0.25;
    }
}
