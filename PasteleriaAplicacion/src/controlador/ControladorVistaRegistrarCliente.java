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
import modelo.Cliente;

/**
 * FXML Controller class
 *
 * @author leodz
 */
public class ControladorVistaRegistrarCliente extends ControladorCliente implements Initializable {

    @FXML
    private TableView<Cliente> tablaClientes;
    @FXML
    private TableColumn<?, ?> colID;
    @FXML
    private TableColumn<?, ?> colNombre;
    @FXML
    private TableColumn<?, ?> colApellido;
    @FXML
    private TableColumn<?, ?> colSweetpoints;
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
    private TextField textID;
    @FXML
    private Label ID;
    
    protected ObservableList<Cliente> clientesVista; 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        clientesVista = FXCollections.observableArrayList(clientes);
        
        this.colID.setCellValueFactory(new PropertyValueFactory("ID"));
        this.colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colApellido.setCellValueFactory(new PropertyValueFactory("apellido"));
        this.colSweetpoints.setCellValueFactory(new PropertyValueFactory("sweetpoints"));
    }    

    @FXML
    private void seleccionar(MouseEvent event) {
        //Selecciona al cliente
        Cliente c = this.tablaClientes.getSelectionModel().getSelectedItem();
        
        if(c != null){//Si ya se ha seleccionado algo
            //Pone en los campos de texto
            this.textID.setText(c.getID());
            this.textID.setEditable(false);//El campo ID no es editable
            this.textNombre.setText(c.getNombre());
            this.textApellido.setText(c.getApellido());
        }
    }

    @FXML
    private void eliminar(ActionEvent event) {
        Cliente c = this.tablaClientes.getSelectionModel().getSelectedItem();
        
        if(c == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Inténtelo de nuevo");
            alert.setContentText("Debe seleccionar a un cliente");
            alert.showAndWait();
        }else{
            this.clientesVista.remove(c);
            this.tablaClientes.refresh();
            
            textID.clear();
            textNombre.clear();
            textApellido.clear();
                    
                   
            textID.setEditable(true);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Información");
            alert.setContentText("Cliente eliminado");
            alert.showAndWait();
        }
    }

    @FXML
    private void modificar(ActionEvent event) {
        //Selección de la persona
        Cliente c = this.tablaClientes.getSelectionModel().getSelectedItem();
        
        if(c == null){ //Si no ha seleccionado
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Inténtelo de nuevo");
            alert.setContentText("Debe seleccionar a un cliente");
            alert.showAndWait();
        }else{
            //Cuando ya se seleccionó a un cliente     
                String ID = this.textID.getText();
                String nombre = this.textNombre.getText();
                String apellidos = this.textApellido.getText();
                Integer sweetpoints = 0;
                
                Cliente aux = new Cliente(ID, nombre, apellidos, sweetpoints); //Creación de un cliente auxiliar
                
                //Por si algún campo está vacío
                if(this.textNombre.getText() == null || this.textNombre.getText().trim().isEmpty() || this.textApellido.getText() == null || this.textApellido.getText().trim().isEmpty()){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Inténtelo de nuevo");
                    alert.setContentText("No puede haber campos vacíos");
                    alert.showAndWait();
                }else{ //Los campos no están vacíos
                    if(!this.clientesVista.contains(aux)){
                        clientesVista.add(new Cliente(ID, nombre, apellidos, sweetpoints)); //Agrega a la lista
                        
                        //Limpieza de los campos
                        textID.clear();
                        textNombre.clear();
                        textApellido.clear();
                       
                        
                        this.tablaClientes.refresh(); //Refresco de la tabla
                        textID.setEditable(true); //Regresa a editable el ID
                        
                         //Mensaje de agregado
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setTitle("Información");
                        alert.setContentText("Cliente agregado");
                        alert.showAndWait();
                        
                    }else{
                        //Modificación de la persona
                        c.setNombre(nombre);
                        c.setApellido(apellidos);
                    
                        //Limpieza de los campos
                        textID.clear();
                        textNombre.clear();
                        textApellido.clear();
                        
                        this.tablaClientes.refresh(); //Refresco de la tabla
                        textID.setEditable(true); //Regresa a editable el ID
                        
                        //Mensaje de editado
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setTitle("Información");
                        alert.setContentText("Cliente modificado");
                        alert.showAndWait();
                    }
                }
                       
        }
    }

    @FXML
    private void agregar(ActionEvent event) {
        //Lectura de los campos de texto
            String ID = this.textID.getText();
            String nombre = this.textNombre.getText();
            String apellidos = this.textApellido.getText();
            Integer sweetpoints = 0;
            
            //Por si algún campo de texto está vacio
            if(this.textNombre.getText() == null || this.textNombre.getText().trim().isEmpty() || this.textApellido.getText() == null || this.textApellido.getText().trim().isEmpty() || this.textID.getText() == null || this.textID.getText().trim().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Inténtelo de nuevo");
                alert.setContentText("No puede haber campos vacíos");
                alert.showAndWait();
            }else{
                //Creacion del cliente
                Cliente c = new Cliente(ID, nombre, apellidos, sweetpoints);

                if(!this.clientesVista.contains(c)){//Si el cliente no existe, lo busca por ID
                    clientesVista.add(new Cliente(ID, nombre, apellidos, sweetpoints)); //Agrega a la lista
                    this.tablaClientes.setItems(clientesVista); //Los pone en la tabla
                    //Limpieza de los campos de textos
                    textID.clear();
                    textNombre.clear();
                    textApellido.clear();
                  
                    
                    //Mensaje de agregado
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Información");
                    alert.setContentText("Cliente agregado");
                    alert.showAndWait();
                }else{ //Si el cliente ya existe no se crea otra con la misma información
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Inténtelo de nuevo");
                    alert.setContentText("El cliente ya existe");
                    alert.showAndWait();
                }
            }
    }
    
}
