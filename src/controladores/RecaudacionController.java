/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Enums.TipoRecaudacion;
import Main.App;
import Services.IServicio;
import Services.Recaudacion;
import System.Sistema;
import System.Validacion;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author GeovannyRojas
 */
public class RecaudacionController implements Initializable {

    @FXML
    private Button btnConfirmar;

    @FXML
    private Button btnAtras;

    @FXML
    private ComboBox cmbTipo;

    @FXML
    private TextField txtValor;

    @FXML
    private TextArea txtDetalle;

    @FXML
    private TextField txtValorTotal;

    @FXML
    private TextField txtComision;

    private Sistema sistema;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sistema = Sistema.getSistema();
        cmbTipo.setItems(FXCollections.observableArrayList(TipoRecaudacion.values()));
        cmbTipo.setValue(TipoRecaudacion.BELCORP);
    }
    
    @FXML
    private void logicaPantalla(KeyEvent ev) {
        try {
            switch (ev.getCode()) {
                case ESCAPE:
                    volverMenu((Event) ev);
                    break;
                case ENTER:
                    crearServicio((Event) ev);
                    break;
            }
        } catch (IOException error) {
            System.out.println("error");
        }
    }

    @FXML
    private void confirmar(MouseEvent event) throws IOException {
        crearServicio((Event) event);
    }

    @FXML
    private void retroceder(MouseEvent event) {
        try {
            volverMenu((Event) event);
        } catch (IOException ex) {
            System.out.println("f");
        }
    }
    
    @FXML
    private void txtActualizarDatos(KeyEvent ev) {
        actualizarDatos();
    }

    private void volverMenu(Event e) throws IOException {
        App.cambiarEscena("Principal", e);
    }

    private void crearServicio(Event ev) throws IOException {
        if(parametrosValidos()) {
            IServicio rd = new Recaudacion((TipoRecaudacion) cmbTipo.getValue(), txtDetalle.getText(), Double.parseDouble(txtValor.getText()));
            sistema.getTransaccionActual().añadirServicio(rd);
            volverMenu(ev);
        }
    }

    private void actualizarDatos() {
        double valor = Validacion.validarPrecioPositivoDouble(txtValor.getText());
        if (valor >= 0) {
            double comision = Recaudacion.getComision(valor);
            txtComision.setText(String.format("%.2f", comision));
            txtValorTotal.setText(String.format("%.2f", valor + comision));
        }
    }

    private boolean parametrosValidos() {
        return Validacion.validarPrecioPositivoDouble(txtValor.getText()) > 0;
    }
}
