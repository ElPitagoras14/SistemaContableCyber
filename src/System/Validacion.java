/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

/**
 *
 * @author El Pitagoras
 */
public class Validacion {

    public static String validarNumeroDigitos(String numero, int digitos, boolean opcional) {
        try {
            if (opcional && numero.trim().equals("")) {
                return "SIN DATOS";
            }
            int numeroTmp = Integer.parseInt(numero);
            if (numero.length() == digitos) {
                return numero;
            }
        } catch (NumberFormatException ex) {

        }
        return null;
    }

    public static double validarPrecioPositivoDouble(String valor) {
        try {
            double tmp = Double.parseDouble(valor);
            if (tmp > 0) {
                return tmp;
            }
        } catch (NumberFormatException ex) {

        }
        return 0;
    }

    public static int validarPrecioPositivoInt(String valor) {
        try {
            int tmp = Integer.parseInt(valor);
            if (tmp > 0) {
                return tmp;
            }
        } catch (NumberFormatException ex) {

        }
        return 0;
    }

    public static double validarPrecioDouble(String valor) {
        try {
            return Double.parseDouble(valor);
        } catch (NumberFormatException ex) {

        }
        return 0;
    }
}
