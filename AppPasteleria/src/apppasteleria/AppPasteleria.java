/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apppasteleria;
import apppasteleria.controlador.ControladorPersona;
import apppasteleria.modelo.Cliente;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author erikp
 */
public class AppPasteleria extends Application {
    @Override
    public void init(){
        ControladorPersona obj = new ControladorPersona();
        
        
        Persona obj1 = new  Cliente("986119552","Sergio ", "Aguilar Hernandez", 0);
        Persona obj2 = new Administrador("2000021","Carlos", "Sánchez Chuc","1234");
        Persona obj3 =new Empleado("12345", "Lorenzo carrillo", " Zapata Ortega");
        
        obj.agregarCliente(obj1);
        obj.agregarAdministrador(obj2);
        obj.agregarEmpleado(obj3);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args); 
    }
    
}
