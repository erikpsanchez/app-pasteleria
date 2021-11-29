/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author leodz
 */
public class Main extends Application{

    @Override
    public void start(Stage primaryStage){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/vista/VistaRegistrarCliente.fxml"));
            Pane ventana = (Pane) loader.load();
            
            Scene scene = new Scene(ventana);
            
            primaryStage.setTitle("Tabla");
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
}