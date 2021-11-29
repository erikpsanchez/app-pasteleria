/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apppasteleria.controlador;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author erikp
 */
public class AppPasteleria extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AppPasteleria.class.getResource("/vista/Vista.fxml"));
            Pane ventana = (Pane) loader.load();
            
            Scene scene = new Scene(ventana);
            
            primaryStage.setTitle("Tabla");
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
