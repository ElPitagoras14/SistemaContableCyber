/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Enums.TipoServicioNativo;
import Main.App;
import Services.IServicio;
import Services.ServicioNativo;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author GeovannyRojas
 */
public class ServiciosNativosController implements Initializable {

    @FXML
    private Button btnConfirmar;
    @FXML
    private Button btnAtras;
    @FXML
    private ComboBox cmbTipo;
    @FXML
    private TextField txtValor;
    @FXML
    private TextArea txtDescripcion;
    @FXML
    private TextField txtValorTotal;
    @FXML
    private Label nota;
    
    private Sistema sistema;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sistema = Sistema.getSistema();
        cmbTipo.setItems(FXCollections.observableArrayList(TipoServicioNativo.values()));
        cmbTipo.setValue(TipoServicioNativo.INVESTIGACION);
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
    private void confirmar(MouseEvent ev) throws IOException {
        crearServicio((Event) ev);
    }
    
    @FXML
    private void txtActualizarDatos(KeyEvent ev) {
        actualizarDatos();
    }

    @FXML
    private void retroceder(MouseEvent event) {
        try {
            volverMenu((Event) event);
        } catch (IOException ex) {
            System.out.println("f");
        }
    }

    private void volverMenu(Event e) throws IOException {
        App.cambiarEscena("Principal", e);
    }
    
    private void crearServicio(Event ev) throws IOException {
        if (parametrosValidos()) {
            IServicio sn = new ServicioNativo((TipoServicioNativo) cmbTipo.getValue(), txtDescripcion.getText(), Validacion.validarPrecioPositivoDouble(txtValor.getText()));
            sistema.getTransaccionActual().añadirServicio(sn);
            volverMenu(ev);
        } else {
            System.out.println("Ingrese un valor mayor a 0");
        }
    }
    
    private void actualizarDatos() {
        double valor = Validacion.validarPrecioPositivoDouble(txtValor.getText());
        if (valor >= 0 && cmbTipo.getValue() != null) {
            txtValorTotal.setText(String.format("%.2f", valor));
        }
    }
    
    private boolean parametrosValidos() {
        return Validacion.validarPrecioPositivoDouble(txtValor.getText()) > 0;
    }

}
