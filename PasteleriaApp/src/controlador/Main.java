/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import static controlador.ControladorAdministrador.administradores;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author belen
 */
public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/vista/VistaRegistrarAdministrador.fxml"));
            Pane ventana = (Pane) loader.load();
            
            Scene scene = new Scene(ventana);
            
            primaryStage.setTitle("Tabla");
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public void stop(){
        System.out.println(administradores);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}