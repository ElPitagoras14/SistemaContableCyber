/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeParseException;

/**
 *
 * @author El Pitagoras
 */
public class Validacion {

    public static String validarNumeroDigitos(String numero, int digitos, boolean obligatorio) {
        try {
            if (obligatorio && numero.trim().equals("")) {
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
            String newValor = valor.replace(",", ".");
            double tmp = Double.parseDouble(newValor);
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
            String newValor = valor.replace(",", ".");
            return Double.parseDouble(newValor);
        } catch (NumberFormatException ex) {

        }
        return 0;
    }
    
    public static LocalDate validarFecha(String valor) {
        try {
            String[] partes = valor.split("/");
            StringBuilder sb = new StringBuilder();
            sb.append(partes[2]);
            sb.append("-");
            sb.append(partes[1]);
            sb.append("-");
            sb.append(partes[0]);
            return LocalDate.parse(sb.toString());
        } catch (DateTimeParseException ex) {
            
        }
        return null;
    }
}
