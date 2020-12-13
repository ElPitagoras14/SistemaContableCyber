/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Enums.Banco;
import Enums.TipoCuenta;

/**
 *
 * @author El Pitagoras
 */
public class Retiro extends ServicioBancario{

    public Retiro(Banco banco, TipoCuenta tipoCuenta, double valorTotal) {
        super(banco, tipoCuenta, valorTotal);
    }
    

    @Override
    public String getCaracteristica() {
        return "Retiro Banco: " + banco.toString() + " Cta " + tipoCuenta.toString();
    }
}
