/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Banco;

import Enums.Banco;
import Enums.TipoCuenta;

/**
 *
 * @author El Pitagoras
 */
public class Deposito extends ServicioBancario{
    private String numeroCuenta;

    public Deposito(String numeroCuenta, Banco banco, TipoCuenta tipoCuenta, double valor, double comision) {
        super(banco, tipoCuenta, valor, comision);
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public String getCaracteristica() {
        return "Deposito Banco: " + banco.toString() + " Cta " + tipoCuenta.toString() + "\nCta: " + numeroCuenta;
    }
}
