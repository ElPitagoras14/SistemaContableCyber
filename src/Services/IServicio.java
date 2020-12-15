/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

/**
 *
 * @author El Pitagoras
 */
public interface IServicio {

    String getServicio();

    String getCaracteristica();

    double getValor();

    double getComision();

    default String getResumen() {
        StringBuilder sb = new StringBuilder();
        sb.append(getServicio());
        sb.append(" ");
        sb.append(getCaracteristica());
        return String.format("%-30s $%6.2f", sb.toString(), (getValor() + getComision()));
    }

    default double getTotal() {
        return getValor() + getComision();
    }
}
