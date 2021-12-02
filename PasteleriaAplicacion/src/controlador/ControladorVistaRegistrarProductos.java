/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author erikp
 */
public class ControladorVistaRegistrarProductos {
    @FXML
    private Button btnMenu;
    @FXML
    private Button btnRegistrarPasteles;
    @FXML
    private Button btnRegistrarPostresDelicias;
    
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    public void cerrarVentana() {
        try{
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(Main.class.getResource("/vista/VistaMenu.fxml"));
            
            ControladorVistaMenu controlador = loader.getController();
            
            Pane ventana = (Pane) loader.load();

            Scene scene = new Scene(ventana);
            Stage stage = new Stage();
            
            stage.setTitle("Menu");
            stage.setScene(scene);
            stage.show();
            
            Stage myStage = (Stage) this.btnMenu.getScene().getWindow();
            myStage.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    @FXML
    private void irARegistrarPasteles(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(Main.class.getResource("/vista/RegistrarPasteles.fxml"));
            
            ControladorVistaRegistrarPasteles controlador = loader.getController();
            
            Pane ventana = (Pane) loader.load();

            Scene scene = new Scene(ventana);
            Stage stage = new Stage();
            
            stage.setTitle("Pasteles");
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(e -> controlador.cerrarVentana());
            Stage myStage = (Stage) this.btnRegistrarPasteles.getScene().getWindow();
            myStage.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    @FXML
    private void irARegistrarPostresDelicias(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(Main.class.getResource("/vista/RegistrarPostresDelicias.fxml"));
            
            ControladorVistaRegistrarPostresDelicias controlador = loader.getController();
            
            Pane ventana = (Pane) loader.load();

            Scene scene = new Scene(ventana);
            Stage stage = new Stage();
            
            stage.setTitle("Postres y Delicias");
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(e -> controlador.cerrarVentana());
            Stage myStage = (Stage) this.btnRegistrarPostresDelicias.getScene().getWindow();
            myStage.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
