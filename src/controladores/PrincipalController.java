/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Main.App;
import System.Sistema;
import System.Validacion;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author El Pitagoras
 */
public class PrincipalController implements Initializable {

    @FXML
    private Button btnRecarga;

    @FXML
    private Button btnServiciosBancarios;

    @FXML
    private Button btnServiciosNativos;

    @FXML
    private Button btnVender;

    @FXML
    private Button btnRecaudacion;

    @FXML
    private Button btnCerrarTransaccion;

    @FXML
    private TextField txtValorTotal;

    @FXML
    private Label txtTransaccion;

    @FXML
    private Button btnVolver;

    @FXML
    private TextField txtPago;

    @FXML
    private TextField txtVuelto;

    private Sistema sistema;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sistema = Sistema.getSistema();
        txtTransaccion.setText("Estás en la transacción " + sistema.getTransaccionActual().getIdTmp());
        txtValorTotal.setText(String.format("%.2f",sistema.getTransaccionActual().getValorTotal()));
    }

    @FXML
    private void logicaPantalla(KeyEvent ev) {
        try {
            switch (ev.getCode()) {
                case ESCAPE:
                    volverMenu((Event) ev);
                    break;
                case ENTER:
                    cerrarTransaccion();
                    break;
            }
        } catch (IOException error) {
            System.out.println("error");
        }
    }

    @FXML
    private void recargas(MouseEvent event) throws IOException {
        App.cambiarEscena("Recarga", (Event) event);
    }

    @FXML
    private void serviciosBancarios(MouseEvent event) throws IOException {
        App.cambiarEscena("ServiciosBancarios", (Event) event);
    }

    @FXML
    private void serviciosNativos(MouseEvent event) throws IOException {
        App.cambiarEscena("ServiciosNativos", (Event) event);
    }

    @FXML
    private void recaudacion(MouseEvent e) throws IOException {
        App.cambiarEscena("Recaudacion", (Event) e);
    }

    @FXML
    private void aVender(MouseEvent e) throws IOException {
        App.cambiarEscena("VentaProductos", (Event) e);
    }

    @FXML
    private void atras(MouseEvent ev) throws IOException {
        volverMenu((Event) ev);
    }

    @FXML
    private void terminarTransaccion(MouseEvent ev) throws IOException {
        cerrarTransaccion();
        volverMenu((Event) ev);
    }

    @FXML
    private void txtActualizarDatos(KeyEvent ev) {
        actualizarDatos();
    }

    private void actualizarDatos() {
        double pago = Validacion.validarPrecioPositivoDouble(txtPago.getText());
        double valorTotal = Validacion.validarPrecioDouble(txtValorTotal.getText());
        txtVuelto.setText(String.format("%.2f", pago - valorTotal));
    }

    private void cerrarTransaccion() {
        sistema.terminarTransaccion(sistema.getTransaccionActual());
        sistema.setTransaccion(null, sistema.getTransaccionActual().getIdTmp() - 1);
    }

    private void volverMenu(Event ev) throws IOException {
        App.cambiarEscena("Menu", ev);
    }
}
