/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Main.App;
import System.Resumen;
import System.Sistema;
import System.Validacion;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author El Pitagoras
 */
public class ResumenFecha implements Initializable {

    @FXML
    private Button btnAtras;
    @FXML
    private TextField txtFechaFin;
    @FXML
    private TextField txtFechaIni;
    @FXML
    private Button btnObtenerResumen;
    @FXML
    private TextField txtCantRecarga;
    @FXML
    private TextField txtCantBanco;
    @FXML
    private TextField txtCantNativo;
    @FXML
    private TextField txtCantRecaudacion;
    @FXML
    private TextField txtCantProducto;
    @FXML
    private TextField txtIngRecarga;
    @FXML
    private TextField txtIngBanco;
    @FXML
    private TextField txtIngNativo;
    @FXML
    private TextField txtIngRecaudacion;
    @FXML
    private TextField txtIngProducto;
    @FXML
    private TextField txtTotal;
    
    private Sistema sistema;
    @FXML
    private TextField txtIngNeto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sistema = Sistema.getSistema();
    }    

    @FXML
    private void retroceder(MouseEvent event) throws IOException {
        volverMenu((Event) event);
    }

    @FXML
    private void obtenerResumen(MouseEvent event) {
        LocalDate ini = Validacion.validarFecha(txtFechaIni.getText());
        LocalDate fin = Validacion.validarFecha(txtFechaFin.getText());
        if (ini != null && fin != null) {
            asignarValores(sistema.getResumenFechas(ini, fin));
        }
    }

    @FXML
    private void logicaPantalla(KeyEvent ev) {
        try {
            switch (ev.getCode()) {
                case ESCAPE:
                    volverMenu((Event) ev);
                    break;
            }
        } catch (IOException error) {
            System.out.println("error");
        }
    }
    
    private void volverMenu(Event ev) throws IOException {
        App.cambiarEscena("Menu", ev);
    }
    
    private void asignarValores(Resumen r) {
        txtCantRecarga.setText(String.valueOf(r.getCantRecarga()));
        txtCantBanco.setText(String.valueOf(r.getCantServBancarios()));
        txtCantNativo.setText(String.valueOf(r.getCantServNativos()));
        txtCantRecaudacion.setText(String.valueOf(r.getCantRecaudacion()));
        txtCantProducto.setText(String.valueOf(r.getCantProductos()));
        
        txtIngRecarga.setText(String.format("%.2f", r.getIngRecarga()));
        txtIngBanco.setText(String.format("%.2f", r.getIngServBancarios()));
        txtIngNativo.setText(String.format("%.2f", r.getIngServNativos()));
        txtIngRecaudacion.setText(String.format("%.2f", r.getIngRecaudacion()));
        txtIngProducto.setText(String.format("%.2f", r.getIngProductos()));
        
        txtTotal.setText(String.format("%.2f", r.getTotalIngreso()));
        txtIngNeto.setText(String.format("%.2f", r.getIngresoNeto()));
    }
    
}
