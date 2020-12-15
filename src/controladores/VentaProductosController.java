/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Main.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author GeovannyRojas
 */
public class VentaProductosController implements Initializable {

    @FXML
    private Button btnConfirmar;
    @FXML
    private Button btnAtras;
    @FXML
    private TextField txtCantidad;
    @FXML
    private TextField IDProducto;
    @FXML
    private TableView tablaPrincipal;
    @FXML
    private Button btnAñadirProducto;
    @FXML
    private TextField txtValorTotal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
