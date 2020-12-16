/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Enums.TipoRecaudacion;
import Main.App;
import System.Sistema;
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

    private Sistema sistema;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sistema = Sistema.getSistema();
        cmbTipo.setItems(FXCollections.observableArrayList(TipoRecaudacion.values()));
    }    

    @FXML
    private void confirmar(MouseEvent event) {
        System.out.println("confirmo");
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
    
}
