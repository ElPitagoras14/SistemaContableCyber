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
import System.Validacion;
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
    private TableView<ProductoFisico> tablaPrincipal;
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
        iniciarTabla();
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
        txtValorTotal.setText(String.format("%.2f", total));
    }

    private void volverMenu(Event e) throws IOException {
        App.cambiarEscena("Principal", e);
    }

    private boolean parametrosValidos() {
        int cantidad = Validacion.validarPrecioPositivoInt(txtCantidad.getText());
        ProductoPortada prod = sistema.obtenerProducto(txtId.getText());
        return cantidad > 0 && prod != null;
    }

    private void crearServicio(Event event) throws IOException {
        IServicio vp = new VentaProducto((LinkedList<ProductoFisico>) tablaPrincipal.getItems());
        sistema.getTransaccionActual().addServicio(vp);
        volverMenu(event);
    }
    
    private void iniciarTabla() {
        colId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colId.setStyle("-fx-alignment: CENTER;");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        colNombre.setStyle("-fx-alignment: CENTER;");
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("ValorUnidad"));
        colPrecio.setStyle("-fx-alignment: CENTER-RIGHT;");
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("Cantidad"));
        colCantidad.setStyle("-fx-alignment: CENTER-RIGHT;");
        colTotal.setCellValueFactory(new PropertyValueFactory<>("Total"));
        colTotal.setStyle("-fx-alignment: CENTER-RIGHT;");
        tablaPrincipal.setItems(FXCollections.observableArrayList());
    }

}
