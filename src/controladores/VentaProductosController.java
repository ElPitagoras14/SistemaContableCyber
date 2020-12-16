/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Main.App;
import Services.IServicio;
import Services.Producto.ProductoFisico;
import Services.Producto.ProductoPortada;
import Services.Producto.VentaProducto;
import System.Sistema;
import System.Validaciones;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

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
    private TextField txtId;
    @FXML
    private TableView tablaPrincipal;
    @FXML
    private TableColumn<ProductoFisico, String> colId;
    @FXML
    private TableColumn<ProductoFisico, String> colNombre;
    @FXML
    private TableColumn<ProductoFisico, Double> colPrecio;
    @FXML
    private TableColumn<ProductoFisico, Integer> colCantidad;
    @FXML
    private TableColumn<ProductoFisico, Double> colTotal;
    @FXML
    private Button btnAñadirProducto;
    @FXML
    private TextField txtValorTotal;
    
    private Sistema sistema;
    private double total;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sistema = Sistema.getSistema();
        total = 0;
        colId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("ValorUnidad"));
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("Cantidad"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("Total"));
        tablaPrincipal.setItems(FXCollections.observableArrayList());
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
    private void confirmar(MouseEvent event) throws IOException {
        crearServicio((Event) event);
    }

    @FXML
    private void retroceder(MouseEvent event) {
        try {
            volverMenu((Event) event);
        } catch (IOException ex) {
            System.out.println("f");
        }

    }

    @FXML
    private void añadirProducto(Event ev) {
        if (parametrosValidos()) {
            ProductoPortada prod = sistema.obtenerProducto(txtId.getText());
            int cantidad = Integer.parseInt(txtCantidad.getText());
            tablaPrincipal.getItems().add(new ProductoFisico(prod, cantidad));
            total += prod.getValorUnidad() * cantidad;
            actualizarDatos();
        }
    }
    
    private void actualizarDatos() {
        txtValorTotal.setText(String.valueOf(total));
    }

    private void volverMenu(Event e) throws IOException {
        App.cambiarEscena("Principal", e);
    }

    private boolean parametrosValidos() {
        int cantidad = Validaciones.validarPrecioInt(txtCantidad.getText());
        ProductoPortada prod = sistema.obtenerProducto(txtId.getText());
        return cantidad > 0 && prod != null;
    }

    private void crearServicio(Event event) throws IOException {
        IServicio vp = new VentaProducto((LinkedList<ProductoFisico>) tablaPrincipal.getItems());
        sistema.getTransaccionActual().añadirServicio(vp);
        volverMenu(event);
    }

}
