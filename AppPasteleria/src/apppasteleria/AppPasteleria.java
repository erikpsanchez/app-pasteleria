/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apppasteleria;
import apppasteleria.modelo.Empleado;
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
        
        
        Persona obj1 = new  Cliente("986119552", "Sergio ", "Aguilar Hernandez",0);
        Persona obj112 = new  Cliente("986119554","Sergio", "Aguilar Hernandez",0);
        Persona obj113 = new  Cliente("986119552","Armamndo ", "Lopez Hernandez",0);
        Persona obj12 = new  Cliente("986104045","donatelo ", "Fernandez Solís",0);
        Persona obj2 = new Administrador("2000021","Carlos", "Sánchez Chuc","1234");
        Persona obj23 = new Administrador("2003022","roberto", "Eureliano Finto","1234");
        Persona obj24= new Administrador("2000394","Emilio", "Arceo","1234");
        Persona obj3 =new Empleado("12345", "Lorenzo carrillo", " Zapata Ortega");
        
        obj.agregarCliente(obj1);
        obj.agregarCliente(obj12);
        obj.agregarCliente(obj112);
        obj.agregarCliente(obj113);
        obj.agregarAdministrador(obj2);
        obj.agregarAdministrador(obj23);
        obj.agregarAdministrador(obj24);
        obj.agregarEmpleado(obj3);
        
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
        
    }
    
    @Override
    public void stop(){
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args); 
    }
    
}
