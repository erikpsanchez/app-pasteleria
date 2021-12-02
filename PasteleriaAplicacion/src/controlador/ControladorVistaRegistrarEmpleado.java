/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import modelo.Empleado;

/**
 * FXML Controller class
 *
  * @author Maria Belen Couoh Chan
 * @author Leandro Angel Dzib Nauat
 * @author Erik Alejandro Poot Sánchez
 * @author Carlos Fernando Sánchez Chuc
 */
public class ControladorVistaRegistrarEmpleado extends ControladorEmpleado implements Initializable {
    @FXML
    private TableView<Empleado> tablaEmpleados;
    @FXML
    private TableColumn<?, ?> colID;
    @FXML
    private TableColumn<?, ?> colNombre;
    @FXML
    private TableColumn<?, ?> colApellido;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnAgregar;
    @FXML
    private Label Apellido;
    @FXML
    private TextField textApellido;
    @FXML
    private Label Nombre;
    @FXML
    private TextField textNombre;
    @FXML
    private Label ID;
    @FXML
    private TextField textID;
    
    protected ObservableList<Empleado> empleadosVista; 
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        empleadosVista = FXCollections.observableArrayList(empleados);
        
        this.colID.setCellValueFactory(new PropertyValueFactory("ID"));
        this.colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colApellido.setCellValueFactory(new PropertyValueFactory("apellido"));
    }  
    
    /**
     * Método para seleccionar un cliente de la tabla
     */
    @FXML
    private void seleccionar(MouseEvent event) {
        //Selecciona al cliente
        Empleado e = this.tablaEmpleados.getSelectionModel().getSelectedItem();
        
        if(e != null){//Si ya se ha seleccionado algo
            //Pone en los campos de texto
            this.textID.setText(e.getID());
            this.textID.setEditable(false);//El campo ID no es editable
            this.textNombre.setText(e.getNombre());
            this.textApellido.setText(e.getApellido());
        }
    }
    
     /**
     * Método para eliminar un cliente
     */
    @FXML
    private void eliminar(ActionEvent event) {
        Empleado e = this.tablaEmpleados.getSelectionModel().getSelectedItem();
        
        if(e == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Inténtelo de nuevo");
            alert.setContentText("Debe seleccionar un empleado");
            alert.showAndWait();
        }else{
            eliminar(e.getID());
            empleadosVista.clear();
            empleadosVista.setAll(empleados);
            this.tablaEmpleados.refresh();
            
            textID.clear();
            textNombre.clear();
            textApellido.clear();
                       
            textID.setEditable(true);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Información");
            alert.setContentText("Empleado eliminado");
            alert.showAndWait();
        }
    }
    
    /**
     * Método para modificar un cliente
     */
    @FXML
    private void modificar(ActionEvent event) {
        //Selección de la persona
        Empleado e = this.tablaEmpleados.getSelectionModel().getSelectedItem();
        
        if(e == null){ //Si no ha seleccionado
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Inténtelo de nuevo");
            alert.setContentText("Debe seleccionar un empleado");
            alert.showAndWait();
        }else{
            //Cuando ya se seleccionó a un empleado     
                String ID = this.textID.getText();
                String nombre = this.textNombre.getText();
                String apellidos = this.textApellido.getText();                
                
                //Por si algún campo está vacío
                if(this.textNombre.getText() == null || this.textNombre.getText().trim().isEmpty() || this.textApellido.getText() == null || this.textApellido.getText().trim().isEmpty()){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Inténtelo de nuevo");
                    alert.setContentText("No puede haber campos vacíos");
                    alert.showAndWait();
                }else{ //Los campos no están vacíos
                    if(!existe(ID)){
                        agregar(ID, nombre, apellidos); //Agrega a la lista
                        
                        //Limpieza de los campos
                        textID.clear();
                        textNombre.clear();
                        textApellido.clear();
                       
                        empleadosVista.clear();
                        empleadosVista.setAll(empleados);
                        this.tablaEmpleados.refresh(); //Refresco de la tabla
                        textID.setEditable(true); //Regresa a editable el ID
                        
                         //Mensaje de agregado
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setTitle("Información");
                        alert.setContentText("Empleado agregado");
                        alert.showAndWait();
                        
                    }else{
                        //Modificación de la persona
                        empleados.get(buscar(ID)).setNombre(nombre);
                        empleados.get(buscar(ID)).setApellido(apellidos);
                        empleados.get(buscar(ID)).setApellido(apellidos);
                    
                        //Limpieza de los campos
                        textID.clear();
                        textNombre.clear();
                        textApellido.clear();
                        
                        empleadosVista.clear();
                        empleadosVista.setAll(empleados);
                        this.tablaEmpleados.refresh(); //Refresco de la tabla
                        textID.setEditable(true); //Regresa a editable el ID
                        
                        //Mensaje de editado
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setTitle("Información");
                        alert.setContentText("Empleado modificado");
                        alert.showAndWait();
                    }
                }
                       
        }
    }
    
    /**
     * Método para agregar un cliente
     */
    @FXML
    private void agregar(ActionEvent event) {
        //Lectura de los campos de texto
            String ID = this.textID.getText();
            String nombre = this.textNombre.getText();
            String apellidos = this.textApellido.getText();
                        
            //Por si algún campo de texto está vacio
            if(this.textNombre.getText() == null || this.textNombre.getText().trim().isEmpty() || this.textApellido.getText() == null || this.textApellido.getText().trim().isEmpty() || this.textID.getText() == null || this.textID.getText().trim().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Inténtelo de nuevo");
                alert.setContentText("No puede haber campos vacíos");
                alert.showAndWait();
            }else{

                if(!existe(ID)){//Si el cliente no existe, lo busca por ID
                    agregar(ID, nombre, apellidos); //Agrega a la lista
                    
                    empleadosVista.clear();
                    empleadosVista.setAll(empleados);
                    this.tablaEmpleados.setItems(empleadosVista); //Los pone en la tabla
                    //Limpieza de los campos de textos
                    textID.clear();
                    textNombre.clear();
                    textApellido.clear();
                  
                    
                    //Mensaje de agregado
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Información");
                    alert.setContentText("Empleado agregado");
                    alert.showAndWait();
                }else{ //Si el cliente ya existe no se crea otra con la misma información
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Inténtelo de nuevo");
                    alert.setContentText("El empleado ya existe");
                    alert.showAndWait();
                }
            }
    }
}
