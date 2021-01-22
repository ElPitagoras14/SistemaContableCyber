/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Main.App;
import Services.IServicio;
import System.Sistema;
import System.Validacion;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author El Pitagoras
 */
public class CerrarTransaccionController implements Initializable {

    @FXML
    private Button btnConfirmar;
    @FXML
    private Button btnAtras;
    @FXML
    private Label txtTransaccion;
    @FXML
    private TableView<IServicio> tablaPrincipal;
    @FXML
    private TableColumn<IServicio, String> colServicio;
    @FXML
    private TableColumn<IServicio, String> colTipo;
    @FXML
    private TableColumn<IServicio, Double> colPrecio;
    @FXML
    private TableColumn<IServicio, Double> colComision;
    @FXML
    private TableColumn<IServicio, Double> colTotal;
    @FXML
    private TextField txtValorTotal;
    @FXML
    private TextField txtCliente;
    @FXML
    private TextField txtId;
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
        txtTransaccion.setText("Transacción " + sistema.getTransaccionActual().getIdTmp());
        txtId.setText("No sé que poner aquí");
        txtCliente.setText(sistema.getTransaccionActual().getCliente());
        iniciarTabla();
        añadirProductos();
    }

    @FXML
    private void confirmar(MouseEvent ev) throws IOException {
        if (parametrosValidos()) {
            cerrarTransaccion((Event) ev);
        }
    }

    @FXML
    private void retroceder(MouseEvent ev) throws IOException {
        volverMenu((Event) ev);
    }

    @FXML
    private void txtActualizarDatos(KeyEvent event) {
        actualizarDatos();
    }

    @FXML
    private void logicaPantalla(KeyEvent ev) {
        try {
            switch (ev.getCode()) {
                case ESCAPE:
                    volverMenu((Event) ev);
                    break;
                case ENTER:
                    if (parametrosValidos()) {
                        cerrarTransaccion((Event) ev);
                    }
                    break;
            }
        } catch (IOException error) {
            System.out.println("error");
        }
    }
    
    private void añadirProductos() {
        for (IServicio is: sistema.getTransaccionActual().getListaServicios()) {
            tablaPrincipal.getItems().add(is);
        }
        txtValorTotal.setText(String.format("%.2f",sistema.getTransaccionActual().getValorTotal()));
    }
    
    private void volverMenu(Event e) throws IOException {
        App.cambiarEscena("Principal", e);
    }
    
    private void iniciarTabla() {
        colServicio.setCellValueFactory(new PropertyValueFactory<>("Servicio"));
        colPrecio.setStyle("-fx-alignment: CENTER;");
        colTipo.setCellValueFactory(new PropertyValueFactory<>("Caracteristica"));
        colPrecio.setStyle("-fx-alignment: CENTER;");
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("Valor"));
        colPrecio.setStyle("-fx-alignment: CENTER-RIGHT;");
        colComision.setCellValueFactory(new PropertyValueFactory<>("Comision"));
        colComision.setStyle("-fx-alignment: CENTER-RIGHT;");
        colTotal.setCellValueFactory(new PropertyValueFactory<>("Total"));
        colTotal.setStyle("-fx-alignment: CENTER-RIGHT;");
        tablaPrincipal.setItems(FXCollections.observableArrayList());
    }
    
    private void cerrarTransaccion(Event ev) throws IOException {
        sistema.terminarTransaccion(sistema.getTransaccionActual());
        sistema.setTransaccion(null, sistema.getTransaccionActual().getIdTmp() - 1);
        volverMenu(ev);
    }
    
    private boolean parametrosValidos() {
        return Validacion.validarPrecioDouble(txtVuelto.getText()) > 0;
    }
    
    private void actualizarDatos() {
        double pago = Validacion.validarPrecioPositivoDouble(txtPago.getText());
        double total = Validacion.validarPrecioDouble(txtValorTotal.getText());
        System.out.println(pago-total);
        txtVuelto.setText(String.valueOf(pago - total));
    }
}
