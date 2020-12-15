/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.net.URL;
import java.util.ResourceBundle;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void pantalla (KeyEvent ev) {
        switch (ev.getCode()) {
            case ESCAPE:
                break;
            case ENTER:
                break;
        }
    }
    
    @FXML
    private void btnAtras (MouseEvent ev) {
        
    }
    
    @FXML
    private void btnConfirmar (MouseEvent ev) {
        
    }
    
    private void volverMenu() {
        
    }
    
    private void crearTransaccion() {
        
    }
    
}
