/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Enums.Operadora;
import Enums.TipoRecarga;
import Main.App;
import Services.IServicio;
import Services.Recarga;
import System.Sistema;
import System.Validaciones;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author El Pitagoras
 */
public class RecargaController implements Initializable {

    @FXML
    private AnchorPane pantalla;

    @FXML
    private ComboBox cmbOperadora;

    @FXML
    private TextField txtNumero;

    @FXML
    private RadioButton btnNormal;

    @FXML
    private RadioButton btnIlimitada;

    @FXML
    private TextField txtValor;

    @FXML
    private TextField txtComision;

    @FXML
    private TextField txtValorTotal;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnConfirmar;

    private Sistema sistema;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sistema = Sistema.getSistema();
        cmbOperadora.setItems(FXCollections.observableArrayList(Operadora.values()));
    }

    @FXML
    private void logicaPantalla(KeyEvent ev) {
        try{
        switch (ev.getCode()) {
            case ESCAPE:
                volverMenu((Event) ev);
                break;
            case ENTER:
                crearServicio();
                volverMenu((Event) ev);
                break;
        }
        }catch(IOException error)
        {
            System.out.println("error");
        }
    }

    @FXML
    private void retroceder(MouseEvent ev) {
        try {
            volverMenu((Event) ev);
        } catch (IOException ex) {
            Logger.getLogger(RecargaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void confirmar(MouseEvent ev) throws IOException {
        crearServicio();
        volverMenu((Event) ev);
    }

    @FXML
    private void actualizarValores(KeyEvent ev) {
        double valor = Validaciones.validarPrecio(txtValor.getText());
        if (valor > 0 && cmbOperadora.getValue() != null) {
            double comision = Recarga.getComision((Operadora) cmbOperadora.getValue(), valor);
            txtComision.setText(String.valueOf(comision));
            txtValorTotal.setText(String.valueOf(valor + comision));
        }

    }

    @FXML
    private void selNormal(MouseEvent ev) {
        if (btnIlimitada.isSelected()) {
            btnNormal.setSelected(true);
            btnIlimitada.setSelected(false);
        }
    }

    @FXML
    private void selIlimitada(MouseEvent ev) {
        if (btnNormal.isSelected()) {
            btnIlimitada.setSelected(true);
            btnNormal.setSelected(false);
        }
    }

    private void volverMenu(Event e) throws IOException {
        App.cambiarEscena("Principal", e);
    }

    private void crearServicio() {
        if (parametrosValidos()) {
            IServicio r = new Recarga((Operadora) cmbOperadora.getValue(), txtNumero.getText(), obtenerTipo(), Double.parseDouble(txtValor.getText()), Double.parseDouble(txtComision.getText()));
            sistema.getTransaccionActual().añadirServicio(r);
        }
    }

    private TipoRecarga obtenerTipo() {
        return btnNormal.isSelected() ? TipoRecarga.NORMAL : TipoRecarga.ILIMITADA;
    }

    private boolean parametrosValidos() {
        boolean operadora = cmbOperadora.getValue() != null;
        String numero = Validaciones.validarNumeroDigitos(txtNumero.getText(), 10, true);
        double valor = Validaciones.validarPrecio(txtValor.getText());
        return operadora && numero != null && valor > 0;
    }
}
