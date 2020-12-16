/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author El Pitagoras
 */
public class App extends Application {
    
    private static Scene scene;
    
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Menu"));
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
     private static Parent loadFXML(String fxml) throws IOException {
        File f = new File("src/fxml/" + fxml + ".fxml");
        return FXMLLoader.load(f.toURI().toURL());
    }
    
     public static void cambiarEscena(String fxml, Event event) throws IOException {
        Parent root = loadFXML(fxml);
        Scene escena = new Scene(root);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(escena);
        appStage.toFront();
        appStage.show();
    }
}
