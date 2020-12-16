/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Enums.Banco;
import Enums.TipoCuenta;
import Main.App;
import System.Sistema;
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
        volverMenu((Event) ev);
    }
    
     private void volverMenu(Event e) throws IOException {
        App.cambiarEscena("Principal", e);
    }
     
    @FXML
    private void selDeposito(MouseEvent ev) {
        if (btnDeposito.isSelected()) {
            btnRetiro.setSelected(false);
            btnOtros.setSelected(false);
            btnDeposito.setSelected(true);
        }
    }

    @FXML
    private void selRetiro(MouseEvent ev) {
        if (btnRetiro.isSelected()) {
            btnDeposito.setSelected(false);
            btnOtros.setSelected(false);
            btnRetiro.setSelected(true);
        }
    }
    
    @FXML
    private void selOtros(MouseEvent ev){
         if (btnOtros.isSelected()) {
            btnDeposito.setSelected(false);
            btnOtros.setSelected(true);
            btnRetiro.setSelected(false);

        }
    }
    
    
}
