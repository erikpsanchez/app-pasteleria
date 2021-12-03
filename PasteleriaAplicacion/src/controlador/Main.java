/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.ControladorAdministrador.administradores;
import static controlador.ControladorCliente.clientes;
import static controlador.ControladorEmpleado.empleados;
import static controlador.ControladorPasteles.listPasteles;
import static controlador.ControladorPostresDelicias.listDelicias;
import static controlador.ControladorVenta.ventaTemporal;
import static controlador.ControladorVenta.ventas;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Maria Belen Couoh Chan
 * @author Leandro Angel Dzib Nauat
 * @author Erik Alejandro Poot Sánchez
 * @author Carlos Fernando Sánchez Chuc
 */
public class Main extends Application{
    
    @Override
    public void init(){
       /* ControladorAdministrador a = new ControladorAdministrador();
        ControladorCliente b = new ControladorCliente();
        ControladorEmpleado c = new ControladorEmpleado();
        ControladorPasteles d = new ControladorPasteles();
        ControladorPostresDelicias e = new ControladorPostresDelicias();
        ControladorVenta f = new ControladorVenta();
        ControladorVistaMenu g = new ControladorVistaMenu();
        ControladorVistaRegistrarAdministrador h = new ControladorVistaRegistrarAdministrador();
        ControladorVistaRegistrarCliente i = new ControladorVistaRegistrarCliente();
        ControladorVistaRegistrarEmpleado j = new ControladorVistaRegistrarEmpleado();
        ControladorVistaRegistrarPasteles k = new ControladorVistaRegistrarPasteles();
        ControladorVistaRegistrarPersonas l = new ControladorVistaRegistrarPersonas();
        ControladorVistaRegistrarPostresDelicias m = new ControladorVistaRegistrarPostresDelicias();
        ControladorVistaRegistrarProductos n = new ControladorVistaRegistrarProductos();
        ControladorVistaVender o = new ControladorVistaVender(); */
    }

    @Override
    public void start(Stage primaryStage){
        try{
            FXMLLoader loader = new FXMLLoader();


            //loader.setLocation(Main.class.getResource("/vista/VistaRegistrarCliente.fxml"));

            //loader.setLocation(Main.class.getResource("/vista/VistaRegistrarCliente.fxml"));

            //loader.setLocation(Main.class.getResource("/vista/RegistrarPasteles.fxml"));
            //loader.setLocation(Main.class.getResource("/vista/RegistrarPostresDelicias.fxml"));
            //loader.setLocation(Main.class.getResource("/vista/VistaRegistrarAdministrador.fxml"));
            //loader.setLocation(Main.class.getResource("/vista/VistaVender.fxml"));

            //loader.setLocation(Main.class.getResource("/vista/VistaRegistrarEmpleado.fxml"));
           loader.setLocation(Main.class.getResource("/vista/VistaMenu.fxml"));

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
        System.out.println(clientes);
        System.out.println(administradores);
        System.out.println(empleados);
        System.out.println(listPasteles);
        System.out.println(listDelicias);
        System.out.println(ventas);
        System.out.println(ventaTemporal);

    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}