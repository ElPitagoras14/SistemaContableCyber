/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Main.App;
import System.Sistema;
import System.Transaccion;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author El Pitagoras
 */
public class MenuController implements Initializable {

    @FXML
    private Button btnTransaccion1;
    @FXML
    private Button btnTransaccion2;
    @FXML
    private Button btnTransaccion3;
    @FXML
    private Label txtTran1;
    @FXML
    private Label txtTran2;
    @FXML
    private Label txtTran3;

    private Sistema sistema;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sistema = Sistema.getSistema();
        actualizarDatos();
    }

    @FXML
    private void iniTran1(MouseEvent event) throws IOException {
        if (sistema.getTransaccion(0) == null) {
            Transaccion t1 = new Transaccion(1);
            sistema.setTransaccion(t1, 0);
            sistema.setTransaccionActual(t1);
        }
        sistema.setTransaccionActual(sistema.getTransaccion(0));
        App.cambiarEscena("Principal", (Event) event);
    }
    
    @FXML
    private void iniTran2(MouseEvent event) throws IOException {
        if (sistema.getTransaccion(1) == null) {
            Transaccion t1 = new Transaccion(2);
            sistema.setTransaccion(t1, 1);
            sistema.setTransaccionActual(t1);
        }
        sistema.setTransaccionActual(sistema.getTransaccion(1));
        App.cambiarEscena("Principal", (Event) event);
    }
    
    @FXML
    private void iniTran3(MouseEvent event) throws IOException {
        if (sistema.getTransaccion(2) == null) {
            Transaccion t1 = new Transaccion(3);
            sistema.setTransaccion(t1, 2);
            sistema.setTransaccionActual(t1);
        }
        sistema.setTransaccionActual(sistema.getTransaccion(2));
        App.cambiarEscena("Principal", (Event) event);
    }

    private void actualizarDatos() {
        txtTran1.setText(obtenerDisponibilidad(sistema.getTransaccion(0)));
        txtTran2.setText(obtenerDisponibilidad(sistema.getTransaccion(1)));
        txtTran3.setText(obtenerDisponibilidad(sistema.getTransaccion(2)));
    }
    
    private String obtenerDisponibilidad(Transaccion t) {
        return t == null ? "- Sin Cliente" : "- Pendiente";
    }

}
