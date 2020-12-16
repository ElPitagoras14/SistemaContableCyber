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
public abstract class ServicioBancario implements IServicio {

    protected Banco banco;
    protected TipoCuenta tipoCuenta;
    private double valor;
    private double comision;

    public ServicioBancario(Banco banco, TipoCuenta tipoCuenta, double valor, double comision) {
        this.banco = banco;
        this.tipoCuenta = tipoCuenta;
        this.valor = valor;
        this.comision = comision;
    }

    @Override
    public String getServicio() {
        return "Servicio Bancario";
    }

    @Override
    public double getValor() {
        return valor + getComision();
    }

    @Override
    public double getComision() {
        return comision;
    }

    public static double getComision(double valor) {
        return Math.ceil((valor + 1) / 50) * 0.25;
    }
}
