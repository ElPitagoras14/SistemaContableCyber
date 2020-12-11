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
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author GeovannyRojas
 */
public class PrincipalController implements Initializable {

    @FXML
    private Button btnRecarga;
    @FXML
    private Button btnServiciosBancarios;
    @FXML
    private Button btnServiciosNativos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void recargas(MouseEvent event) {
        
        System.out.println("Recargo");
    }

    @FXML
    private void serviciosBancarios(MouseEvent event) {
        System.out.println("Banco");
    }

    @FXML
    private void serviciosNativos(MouseEvent event) {
        System.out.println("ServiciosCyber");
    }
    
}
