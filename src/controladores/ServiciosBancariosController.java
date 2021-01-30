/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Enums.Banco;
import Enums.TipoCuenta;
import Enums.TipoServicioBanco;
import Main.App;
import Services.Banco.BancoOtros;
import Services.Banco.Deposito;
import Services.Banco.Retiro;
import Services.Banco.ServicioBancario;
import Services.IServicio;
import System.Sistema;
import System.Validacion;
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
public class ServiciosBancariosController implements Initializable {

    @FXML
    private ComboBox cmbBancos;

    @FXML
    private ComboBox cmbTipoCuenta;

    @FXML
    private TextField txtNumeroCuenta;

    @FXML
    private TextField txtValor;

    @FXML
    private TextField txtComision;

    @FXML
    private TextField txtValorTotal;

    @FXML
    private RadioButton btnDeposito;

    @FXML
    private RadioButton btnRetiro;

    @FXML
    private RadioButton btnOtros;

    @FXML
    private AnchorPane pantalla;

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
        cmbBancos.setItems(FXCollections.observableArrayList(Banco.values()));
        cmbTipoCuenta.setItems(FXCollections.observableArrayList(TipoCuenta.values()));
        btnDeposito.setSelected(true);
        cmbBancos.setValue(Banco.GUAYAQUIL);
        cmbTipoCuenta.setValue(TipoCuenta.AHORRO);
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
    private void retroceder(MouseEvent ev) {
        try {
            volverMenu((Event) ev);
        } catch (IOException ex) {
            Logger.getLogger(RecargaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void confirmar(MouseEvent ev) throws IOException {
        crearServicio((Event) ev);
    }

    @FXML
    private void selDeposito(MouseEvent ev) {
        if (btnDeposito.isSelected()) {
            btnRetiro.setSelected(false);
            btnOtros.setSelected(false);
            btnDeposito.setSelected(true);
            cmbTipoCuenta.setDisable(false);
            txtNumeroCuenta.setDisable(false);
        }
    }

    @FXML
    private void selRetiro(MouseEvent ev) {
        if (btnRetiro.isSelected()) {
            btnDeposito.setSelected(false);
            btnOtros.setSelected(false);
            btnRetiro.setSelected(true);
            txtNumeroCuenta.setDisable(true);
            cmbTipoCuenta.setDisable(false);
        }
    }

    @FXML
    private void selOtros(MouseEvent ev) {
        if (btnOtros.isSelected()) {
            btnDeposito.setSelected(false);
            btnOtros.setSelected(true);
            btnRetiro.setSelected(false);
            cmbTipoCuenta.setDisable(true);
            txtNumeroCuenta.setDisable(true);
        }
    }

    private void volverMenu(Event e) throws IOException {
        App.cambiarEscena("Principal", e);
    }

    private void crearServicio(Event ev) throws IOException {
        if (parametrosValidos()) {
            switch (obtenerTipo()) {
                case DEPOSITO:
                    IServicio dp = new Deposito(txtNumeroCuenta.getText(),(Banco) cmbBancos.getValue(),(TipoCuenta) cmbTipoCuenta.getValue(), Validacion.validarPrecioPositivoDouble(txtValor.getText()), Validacion.validarPrecioPositivoDouble(txtComision.getText()));
                    sistema.getTransaccionActual().addServicio(dp);
                    volverMenu(ev);
                    break;
                case RETIRO:
                    IServicio rt = new Retiro((Banco) cmbBancos.getValue(), (TipoCuenta) cmbTipoCuenta.getValue(), Validacion.validarPrecioPositivoDouble(txtValor.getText()), Validacion.validarPrecioPositivoDouble(txtComision.getText()));
                    sistema.getTransaccionActual().addServicio(rt);
                    volverMenu(ev);
                    break;
                case OTROS:
                    IServicio ot = new BancoOtros((Banco) cmbBancos.getValue(), Validacion.validarPrecioPositivoDouble(txtValor.getText()));
                    sistema.getTransaccionActual().addServicio(ot);
                    volverMenu(ev);
            }
        }
    }
    
    @FXML
    private void txtActualizarDatos(KeyEvent ev) {
        actualizarDatos();
    }

    private TipoServicioBanco obtenerTipo() {
        return btnDeposito.isSelected() ? TipoServicioBanco.DEPOSITO
                : (btnRetiro.isSelected() ? TipoServicioBanco.RETIRO : TipoServicioBanco.OTROS);
    }

    private boolean parametrosValidos() {
        boolean banco;
        boolean tipo;
        boolean cta;
        double valor;
        switch (obtenerTipo()) {
            case DEPOSITO:
                banco = cmbBancos.getValue() != null;
                tipo = cmbTipoCuenta.getValue() != null;
                cta = Validacion.validarNumeroDigitos(txtNumeroCuenta.getText(), 10, true) != null
                        || Validacion.validarNumeroDigitos(txtNumeroCuenta.getText(), 8, true) != null;
                valor = Validacion.validarPrecioPositivoDouble(txtValor.getText());
                return banco && tipo && cta && valor > 0;
            case RETIRO:
                banco = cmbBancos.getValue() != null;
                tipo = cmbTipoCuenta.getValue() != null;
                valor = Validacion.validarPrecioPositivoDouble(txtValor.getText());
                return banco && tipo && valor > 0;
            case OTROS:
                return Validacion.validarPrecioPositivoDouble(txtValor.getText()) > 0;
        }
        return false;
    }

    private void actualizarDatos() {
        double valor = Validacion.validarPrecioPositivoDouble(txtValor.getText());
        if (valor >= 0 && cmbBancos.getValue() != null) {
            double comision = ServicioBancario.getComision(valor);
            if (btnOtros.isSelected()) {
                comision = 0;
            }
            txtComision.setText(String.format("%.2f", comision));
            txtValorTotal.setText(String.format("%.2f", valor + comision));
        }
    }

}
