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
import java.time.LocalDate;
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
        iniciarTransaccion(0, event);
    }
    
    @FXML
    private void iniTran2(MouseEvent event) throws IOException {
        iniciarTransaccion(1, event);
    }
    
    @FXML
    private void iniTran3(MouseEvent event) throws IOException {
        iniciarTransaccion(2, event);
    }

    private void actualizarDatos() {
        txtTran1.setText(obtenerDisponibilidad(sistema.getTransaccion(0)));
        txtTran2.setText(obtenerDisponibilidad(sistema.getTransaccion(1)));
        txtTran3.setText(obtenerDisponibilidad(sistema.getTransaccion(2)));
    }
    
    private String obtenerDisponibilidad(Transaccion t) {
        return t == null ? "- Sin Cliente" : "- Pendiente";
    }
    
    private void iniciarTransaccion(int id, Event ev) throws IOException {
        if (sistema.getTransaccion(id) == null) {
            Transaccion t = new Transaccion(id + 1);
            sistema.setTransaccion(t, id);
            sistema.setTransaccionActual(t);
        }
        sistema.setTransaccionActual(sistema.getTransaccion(id));
        App.cambiarEscena("Principal", ev);
    }
    
    @FXML
    private void resumenHistorico(MouseEvent ev) {
        sistema.salvarResumenes();
    }

}
