/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Enums.TipoCuenta;

/**
 *
 * @author El Pitagoras
 */
public abstract class ServicioBancario implements IServicio{
    private String banco;
    private TipoCuenta tipoCuenta;
    private double valorTotal;
}
