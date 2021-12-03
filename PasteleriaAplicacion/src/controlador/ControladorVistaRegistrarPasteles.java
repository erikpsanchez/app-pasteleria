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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.Pasteles;



/**
 * FXML Controller class
 *
 * @author carlo
 */
public class ControladorVistaRegistrarPasteles extends ControladorPasteles implements Initializable {
    
   
    
    @FXML 
    private TableView<Pasteles> tbPPasteles;
    @FXML
    private TableColumn<?, ?> colID;
    @FXML
    private TableColumn<?, ?> colTipo;
    @FXML
    private TableColumn<?, ?> colNombre;
    @FXML
    private TableColumn<?, ?> colPrecio;
    @FXML
    private TableColumn<?, ?> colCantidad;
    @FXML
    private TableColumn<?, ?> coltamano;
    @FXML
    private TableColumn<?, ?> colSabor;
    @FXML
    private Button btnAgregarPas;
    @FXML
    private Button btnEditarPas;
    @FXML
    private Button btnEliminarPas;
    @FXML
    private Label lbID;
    @FXML 
    private TextField txtID;
    @FXML
    private Label lbTipo;
    @FXML 
    private TextField txtTipo;
    @FXML
    private Label lbNombre;
    @FXML 
    private TextField txtNombre;
    @FXML
    private Label lbPrecio;
    @FXML 
    private TextField txtPrecio;
    @FXML
    private Label lbCantidad;
    @FXML 
    private Spinner <Integer>SpCantidad;
    @FXML
    private Label lbtamano;
    @FXML 
    private ComboBox  CmTamano;
    @FXML
    private Label lbSabor;
    @FXML 
    private TextField txtSabor;
    @FXML
    private Label lbInventario;
    @FXML
    private Label lbTotal;
    @FXML
    private Button btnMenu;
    
    
    public ObservableList<Pasteles> Lpasteles = FXCollections.observableArrayList(listPasteles);
    
    
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       ObservableList<String> tamano = FXCollections.observableArrayList("Chico","Mediano","Grande");
       CmTamano.setItems(tamano);
       
      
       this.colID.setCellValueFactory(new PropertyValueFactory("ID"));
       this.colTipo.setCellValueFactory(new PropertyValueFactory("tipo"));
       this.colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
       this.colPrecio.setCellValueFactory(new PropertyValueFactory("precio"));
       this.colCantidad.setCellValueFactory(new PropertyValueFactory("cantidad"));
       this.coltamano.setCellValueFactory(new PropertyValueFactory("tamano"));
       this.colSabor.setCellValueFactory(new PropertyValueFactory("sabor"));
       
        SpinnerValueFactory<Integer> valores= new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100);
       valores.setValue(1);
       SpCantidad.setValueFactory(valores);
       
       Lpasteles.setAll(listPasteles);
        this.tbPPasteles.setItems(Lpasteles);
    }   
    
    @FXML
    private void Agregar(ActionEvent event) throws NumberFormatException {
        
            //Por si algún campo de texto está vacio
            if(this.txtPrecio.getText() == null || this.txtPrecio.getText().trim().isEmpty() || this.txtSabor.getText() == null || this.txtSabor.getText().trim().isEmpty() || this.txtID.getText() == null || this.txtID.getText().trim().isEmpty() || CmTamano.getSelectionModel().getSelectedItem() == null){
               
                
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Inténtelo de nuevo");
                alert.setContentText("No puede haber campos vacíos");
                alert.showAndWait();
            }else{
                try{
                    
                    
                //Lectura de los campos de texto
                Integer auxID =Integer.parseInt(this.txtID.getText());
                String ID = String.valueOf(auxID);
                String tipo = this.txtTipo.getText();
                String nombre = this.txtNombre.getText();
                Double precio = Double.parseDouble(this.txtPrecio.getText());
                Integer cantidad =SpCantidad.getValue();
                String tamaano = CmTamano.getSelectionModel().getSelectedItem().toString();
                String saabor = this.txtSabor.getText();
               
                
                
                
                
                
                if(!existe(ID)){//Si el cliente no existe, lo busca por ID
                    agregar(ID, tipo, nombre, precio , cantidad , tamaano, saabor); //Agrega a la lista
                    double inventario = 0;
                    double productos =0;
                    for (int i = 0; i < listPasteles.size(); i++) {
                        productos = listPasteles.get(i).getPrecio() * listPasteles.get(i).getCantidad() ;
                        inventario = inventario + productos;
                    }
                    
                    
                    Lpasteles.clear();
                    Lpasteles.setAll(listPasteles);
                    this.tbPPasteles.setItems(Lpasteles); //Los pone en la tabla
                    //Limpieza de los campos de textos
                    txtID.clear();
                    txtPrecio.clear();
                    txtSabor.clear();
                    lbTotal.setText("");
                    lbTotal.setText("  "+inventario);
                    
                    //Mensaje de agregado
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Información");
                    alert.setContentText("El producto ha sido agregado");
                    alert.showAndWait();
                }else{ //Si el cliente ya existe no se crea otra con la misma información
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Inténtelo de nuevo");
                    alert.setContentText("El Producto ya existe");
                    alert.showAndWait();
                }
                }catch(NumberFormatException  e){
                    e.getMessage();
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Inténtelo de nuevo");
                    alert.setContentText("Verifique campos  ID y PRECIO ,solo acepta numeros enteros");
                    alert.showAndWait();
                }
                
            }
    }
    
    @FXML
    private void seleccionar(MouseEvent event) {
        //Selecciona al cliente
        Pasteles c = this.tbPPasteles.getSelectionModel().getSelectedItem();
        
        if(c != null){//Si ya se ha seleccionado algo
            //Pone en los campos de texto
            this.txtID.setText(c.getID());
            this.txtID.setEditable(false);//El campo ID no es editable
            this.txtTipo.setText(c.getTipo());
            this.txtNombre.setText(c.getNombre());           
            this.txtPrecio.setText(String.valueOf(c.getPrecio()));//se cambia , de numerido  a String
           this.SpCantidad.getValueFactory().setValue(c.getCantidad());
           this.CmTamano.getSelectionModel().select(c.getTamano());
            this.txtSabor.setText(c.getSabor());
        }
    }
    
    @FXML
    private void modificar(ActionEvent event) throws NumberFormatException{
        //Selección de la persona
        Pasteles c = this.tbPPasteles.getSelectionModel().getSelectedItem();
        
        if(c == null){ //Si no ha seleccionado
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Inténtelo de nuevo");
            alert.setContentText("Debe seleccionar a un Producto");
            alert.showAndWait();
        }else{
            try{
            //Cuando ya se seleccionó a un cliente 
                Integer auxID =Integer.parseInt(this.txtID.getText());
                String ID = String.valueOf(auxID);
                String tipo = this.txtTipo.getText();
                String nombre = this.txtNombre.getText();
                Double precio = Double.parseDouble(this.txtPrecio.getText());
                Integer cantidad =SpCantidad.getValue();
                String tamaano = CmTamano.getSelectionModel().getSelectedItem().toString();
                String saabor = this.txtSabor.getText();
                
                
                //Por si algún campo está vacío
                if(this.txtPrecio.getText() == null || this.txtPrecio.getText().trim().isEmpty() || this.txtSabor.getText() == null || this.txtSabor.getText().trim().isEmpty() || this.txtID.getText() == null || this.txtID.getText().trim().isEmpty() || CmTamano.getSelectionModel().getSelectedItem() == null){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Inténtelo de nuevo");
                    alert.setContentText("No puede haber campos vacíos");
                    alert.showAndWait();
                }else{ //Los campos no están vacíos
                    if(!existe(ID)){
                        agregar(ID, tipo, nombre, precio , cantidad , tamaano, saabor); //Agrega a la lista
                        
                        
                        
                    double inventario = 0;
                    double productos =0;
                    for (int i = 0; i < listPasteles.size(); i++) {
                        productos = listPasteles.get(i).getPrecio() * listPasteles.get(i).getCantidad() ;
                        inventario = inventario + productos;
                    }
                    
                    
                    
                        //Limpieza de los campos de textos
                        txtID.clear();
                        txtPrecio.clear();
                        txtSabor.clear();
                        lbTotal.setText("");
                        lbTotal.setText("  "+inventario);

                        Lpasteles.clear();
                        Lpasteles.setAll(listPasteles);
                        this.tbPPasteles.setItems(Lpasteles); //Los pone en la tabla
                        this.tbPPasteles.refresh();
                         //Refresco de la tabla
                         //textID.setEditable(false); //Regresa a editable el ID

                         //Mensaje de agregado
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setTitle("Información");
                        alert.setContentText("Producto agregado");
                        alert.showAndWait();
                        
                    }else{
                        //Modificación de la persona
                        listPasteles.get(buscar(ID)).setPrecio(precio);
                        listPasteles.get(buscar(ID)).setCantidad(cantidad);
                        listPasteles.get(buscar (ID)).setTamano(tamaano);
                        listPasteles.get(buscar (ID)).setSabor(saabor);
                       
                    double inventario = 0;
                    double productos =0;
                    for (int i = 0; i < listPasteles.size(); i++) {
                        productos = listPasteles.get(i).getPrecio() * listPasteles.get(i).getCantidad() ;
                        inventario = inventario + productos;
                    }
                    
                        //Limpieza de los campos de textos
                        txtID.clear();
                        txtPrecio.clear();
                        txtSabor.clear();
                        lbTotal.setText("");
                        lbTotal.setText("  "+inventario);

                        Lpasteles.clear();
                        Lpasteles.setAll(listPasteles);
                        this.tbPPasteles.setItems(Lpasteles); //Los pone en la tabla
                        this.tbPPasteles.refresh(); //Refresco de la tabla
                        txtID.setEditable(true); //Regresa a editable el ID
                        
                        //Mensaje de editado
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setTitle("Información");
                        alert.setContentText("Cliente modificado");
                        alert.showAndWait();
                    }
                }
                
            }catch(NumberFormatException e){
                    e.getMessage();
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Inténtelo de nuevo");
                    alert.setContentText("Verifique campos  ID y PRECIO ,solo acepta numeros enteros");
                    alert.showAndWait();
            }
            
        }
    }

    
    
    
    @FXML
    private void eliminar(ActionEvent event) {
        Pasteles c = this.tbPPasteles.getSelectionModel().getSelectedItem();
        
        if(c == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Inténtelo de nuevo");
            alert.setContentText("Debe seleccionar a un Producto");
            alert.showAndWait();
        }else{
            eliminar(c.getID());
            Lpasteles.clear();
            Lpasteles.setAll(listPasteles);
            this.tbPPasteles.refresh();
            txtID.setEditable(true);
            
                    double inventario = 0;
                    double productos =0;
                    for (int i = 0; i < listPasteles.size(); i++) {
                        productos = listPasteles.get(i).getPrecio() * listPasteles.get(i).getCantidad() ;
                        inventario = inventario + productos;
                    }
                    
                        //Limpieza de los campos de textos
                        txtID.clear();
                        txtPrecio.clear();
                        txtSabor.clear();
                        lbTotal.setText("");
                        lbTotal.setText("  "+inventario);
                        
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Información");
            alert.setContentText("Producto eliminado");
            alert.showAndWait();
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
