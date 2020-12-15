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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void recaudacion(MouseEvent e) throws IOException{
        App.cambiarEscena("Recaudacion", (Event) e);

    }
    @FXML
    private void aVender(MouseEvent e) throws IOException{
        App.cambiarEscena("VentaProductos", (Event) e);

    }
    
}
