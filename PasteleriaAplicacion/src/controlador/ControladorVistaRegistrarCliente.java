/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.Cliente;

/**
 * FXML Controller class
 *
 * @author Maria Belen Couoh Chan
 * @author Leandro Angel Dzib Nauat
 * @author Erik Alejandro Poot Sánchez
 * @author Carlos Fernando Sánchez Chuc
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
    @FXML
    private Button btnMenu;
    
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

    /**
     * Método para seleccionar un cliente de la tabla
     */
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

    /**
     * Método para eliminar un cliente
     */
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
            eliminar(c.getID());
            clientesVista.clear();
            clientesVista.setAll(clientes);
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

    /**
     * Método para modificar un cliente
     */
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
                
                
                //Por si algún campo está vacío
                if(this.textNombre.getText() == null || this.textNombre.getText().trim().isEmpty() || this.textApellido.getText() == null || this.textApellido.getText().trim().isEmpty()){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Inténtelo de nuevo");
                    alert.setContentText("No puede haber campos vacíos");
                    alert.showAndWait();
                }else{ //Los campos no están vacíos
                    if(!existe(ID)){
                        agregar(ID, nombre, apellidos, sweetpoints); //Agrega a la lista
                        
                        //Limpieza de los campos
                        textID.clear();
                        textNombre.clear();
                        textApellido.clear();
                       
                        clientesVista.clear();
                        clientesVista.setAll(clientes);
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
                        clientes.get(buscar(ID)).setNombre(nombre);
                        clientes.get(buscar(ID)).setApellido(apellidos);
                    
                        //Limpieza de los campos
                        textID.clear();
                        textNombre.clear();
                        textApellido.clear();
                        
                        clientesVista.clear();
                        clientesVista.setAll(clientes);
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

    /**
     * Método para agregar un cliente
     */
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

                if(!existe(ID)){//Si el cliente no existe, lo busca por ID
                    agregar(ID, nombre, apellidos, sweetpoints); //Agrega a la lista
                    
                    clientesVista.clear();
                    clientesVista.setAll(clientes);
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
}
