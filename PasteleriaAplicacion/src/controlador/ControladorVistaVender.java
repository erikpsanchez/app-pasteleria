/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.ControladorCliente.clientes;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import modelo.Pasteles;
import modelo.PostresDelicias;
import static controlador.ControladorPasteles.listPasteles;
import static controlador.ControladorPostresDelicias.listDelicias;
import static controlador.ControladorVenta.ventaTemporal;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import modelo.Producto;
import modelo.Venta;

/**
 * FXML Controller class
 *
 * @author leodz
 */
public class ControladorVistaVender extends ControladorVenta implements Initializable {

    @FXML
    private TableView<Venta> tablaVenta;
    @FXML
    private TableColumn<?, ?> colProducto;
    @FXML
    private TableColumn<?, ?> colCantidad;
    @FXML
    private TableColumn<?, ?> colPrecio;
    @FXML
    private TextField textID;
    @FXML
    private Button btnCancelarVenta;
    @FXML
    private Button btnVenta;
    @FXML
    private Button btnCorteCaja;
    @FXML
    private TextField textCantidad;
    @FXML
    private TableView<Pasteles> tablaPasteles;
    @FXML
    private TableColumn<?, ?> colPastelesTipo;
    @FXML
    private TableColumn<?, ?> colPastelesNombre;
    @FXML
    private TableColumn<?, ?> colPastelesTamano;
    @FXML
    private TableColumn<?, ?> colPastelesSabor;
    @FXML
    private TableColumn<?, ?> colPastelesCantidad;
    @FXML
    private TableColumn<?, ?> colPastelesPrecio;
    @FXML
    private TableView<PostresDelicias> tablaPostresDelicias;
    @FXML
    private TableColumn<?, ?> colPostresTipo;
    @FXML
    private TableColumn<?, ?> colPostresNombre;
    @FXML
    private TableColumn<?, ?> colPostresCantidad;
    @FXML
    private TableColumn<?, ?> colPostresPrecio;
    @FXML
    private Label descuento;
    @FXML
    private Label importe;
    
    public ObservableList<Pasteles> pastelesVistaVenta;
    public ObservableList<PostresDelicias> postresVistaVenta;
    public ObservableList<Venta> ventasVista;
    @FXML
    private Button btnAgregarPastel;
    @FXML
    private Button btnAgregarPostre;
    @FXML
    private Button btnEliminarProducto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Poner los pasteles a vista
        pastelesVistaVenta = FXCollections.observableArrayList(listPasteles);
        
        this.colPastelesTipo.setCellValueFactory(new PropertyValueFactory("tipo"));
        this.colPastelesNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colPastelesTamano.setCellValueFactory(new PropertyValueFactory("tamano"));
        this.colPastelesSabor.setCellValueFactory(new PropertyValueFactory("sabor"));
        this.colPastelesCantidad.setCellValueFactory(new PropertyValueFactory("cantidad"));
        this.colPastelesPrecio.setCellValueFactory(new PropertyValueFactory("precio"));
        
        pastelesVistaVenta.setAll(listPasteles);
        this.tablaPasteles.setItems(pastelesVistaVenta);
        
        //Poner los postres a vista
        postresVistaVenta = FXCollections.observableArrayList(listDelicias);
        
        this.colPostresTipo.setCellValueFactory(new PropertyValueFactory("tipo"));
        this.colPostresNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colPostresCantidad.setCellValueFactory(new PropertyValueFactory("cantidad"));
        this.colPostresPrecio.setCellValueFactory(new PropertyValueFactory("precio"));
        
        postresVistaVenta.setAll(listDelicias);
        this.tablaPostresDelicias.setItems(postresVistaVenta);
        
        //Lista de ventas
        ventasVista = FXCollections.observableArrayList(ventaTemporal);
        
        this.colProducto.setCellValueFactory(new PropertyValueFactory("producto"));
        this.colCantidad.setCellValueFactory(new PropertyValueFactory("cantidad"));
        this.colPrecio.setCellValueFactory(new PropertyValueFactory("precio"));
        
    }    

    @FXML
    private void seleccionarPastel(MouseEvent event) {
        //Selecciona al cliente
        Producto p = this.tablaPasteles.getSelectionModel().getSelectedItem();
      
    }

    @FXML
    private void seleccionarPostre(MouseEvent event) {
        Producto p = this.tablaPostresDelicias.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void deseleccionar(MouseEvent event) {
        Producto p = null;
    }

    @FXML
    private void agregarPastelVenta(ActionEvent event) {
        Pasteles p = this.tablaPasteles.getSelectionModel().getSelectedItem();
        ControladorCliente x = new ControladorCliente();
        
        if(this.textCantidad.getText() == null || this.textCantidad.getText().trim().isEmpty() || this.textID.getText() == null || this.textID.getText().trim().isEmpty()){//campo Cantidad o ID está vacío
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Inténtelo de nuevo");
            alert.setContentText("Es necesario llenar el campo de cantidad o ID del cliente");
            alert.showAndWait();
        }else{//cantidad no está vacío
            try{
                Integer cantidad = Integer.parseInt(this.textCantidad.getText());
                if(cantidad <= p.getCantidad()){//existen suficientes en inventario
                    String ID = this.textID.getText();
                    if(x.existe(ID)){//sí existe cliente
                        agregarVentaTemporal(clientes.get(x.buscar(ID)).getID(), p.getID(),p.getTipo() + " " + p.getNombre() + " " + p.getSabor() + " " + p.getTamano(), cantidad, p.getPrecio());
                        ventasVista.clear();
                        ventasVista.setAll(ventaTemporal);
                        this.tablaVenta.refresh(); //Refresco de la tabla
                    }else{//no existe cliente
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setTitle("Inténtelo de nuevo");
                        alert.setContentText("El cliente no existe");
                        alert.showAndWait();
                    }
                }else{//no existen suficientes en inventario
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Inténtelo de nuevo");
                    alert.setContentText("No tiene inventario suficiente de ese producto");
                    alert.showAndWait();
                }
                    
            }catch(NumberFormatException e){ //Por si ingresamos algo que no sea un número en cantidad o está vacío
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("Ingrese un número en cantidad");
                    alert.showAndWait();
            } 
        }
        
    }

    @FXML
    private void agregarPostreAVenta(ActionEvent event) {
        PostresDelicias p = this.tablaPostresDelicias.getSelectionModel().getSelectedItem();
        ControladorCliente x = new ControladorCliente();
        
        if(this.textCantidad.getText() == null || this.textCantidad.getText().trim().isEmpty() || this.textID.getText() == null || this.textID.getText().trim().isEmpty()){//campo Cantidad o ID está vacío
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Inténtelo de nuevo");
            alert.setContentText("Es necesario llenar el campo de cantidad o ID del cliente");
            alert.showAndWait();
        }else{//cantidad no está vacío
            try{
                Integer cantidad = Integer.parseInt(this.textCantidad.getText());
                if(cantidad <= p.getCantidad()){//existen suficientes en inventario
                    String ID = this.textID.getText();
                    if(x.existe(ID)){//sí existe cliente
                        agregarVentaTemporal(clientes.get(x.buscar(ID)).getID(), p.getID(), p.getTipo() + " " + p.getNombre(), cantidad, p.getPrecio());
                        ventasVista.clear();
                        ventasVista.setAll(ventaTemporal);
                        this.tablaVenta.refresh(); //Refresco de la tabla
                    }else{//no existe cliente
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setTitle("Inténtelo de nuevo");
                        alert.setContentText("El cliente no existe");
                        alert.showAndWait();
                    }
                }else{//no existen suficientes en inventario
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Inténtelo de nuevo");
                    alert.setContentText("No tiene inventario suficiente de ese producto");
                    alert.showAndWait();
                }
                    
            }catch(NumberFormatException e){ //Por si ingresamos algo que no sea un número en cantidad o está vacío
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("Ingrese un número en cantidad");
                    alert.showAndWait();
            } 
        }
    }

    @FXML
    private void seleccionarProductoVenta(MouseEvent event) {
        Venta v = this.tablaVenta.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void eliminarProductoVenta(ActionEvent event) {
        Venta v = this.tablaVenta.getSelectionModel().getSelectedItem();
        if(v == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Inténtelo de nuevo");
            alert.setContentText("Debe seleccionar un producto de la lista de venta");
            alert.showAndWait();
        }else{
            eliminarVentaTemporal(v);
            ventasVista.clear();
            ventasVista.setAll(ventaTemporal);
            this.tablaVenta.refresh();
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Información");
            alert.setContentText("Producto eliminado de la venta");
            alert.showAndWait();
        }
    }
    
    @FXML
    private void realizarVenta(ActionEvent event) {  
        ControladorCliente x = new ControladorCliente();
        ControladorPasteles pastel = new ControladorPasteles();
        ControladorPostresDelicias postre = new ControladorPostresDelicias();
        
        String ID = this.textID.getText();
        if(this.textID.getText() == null || this.textID.getText().trim().isEmpty()){//ID está vacío
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Inténtelo de nuevo");
            alert.setContentText("Es necesario llenar el campo de ID del cliente");
            alert.showAndWait();
        }else{//ID no está vacío
            if(x.existe(ID)){//existe cliente
                //Comienza la venta y todo lo que implica
                Double importe = 0.;
                Integer newCantidad;
                
                //Para cada producto que se este comprando:
                for(int i=0;i<ventaTemporal.size();i++){                  
                    importe = importe + (ventaTemporal.get(i).getCantidad() * ventaTemporal.get(i).getPrecio());//el importe total
                    
                    //Actualizar las cantidades de los productos en el inventario después de la venta
                    if(pastel.existe(ventaTemporal.get(i).getIdProducto())){//si es Pastel
                        newCantidad = listPasteles.get(pastel.buscar(ventaTemporal.get(i).getIdProducto())).getCantidad() - ventaTemporal.get(i).getCantidad();
                        listPasteles.get(pastel.buscar(ventaTemporal.get(i).getIdProducto())).setCantidad(newCantidad);
                    }else if(postre.existe(ventaTemporal.get(i).getIdProducto())){//si es Postre y Delicia
                        newCantidad = listDelicias.get(pastel.buscar(ventaTemporal.get(i).getIdProducto())).getCantidad() - ventaTemporal.get(i).getCantidad();
                        listDelicias.get(pastel.buscar(ventaTemporal.get(i).getIdProducto())).setCantidad(newCantidad);
                    }    
                }
                //Checar descuento
                Integer descuento = 0;
                if(importe >= 50){
                    descuento = 10;
                }
                
                //Checas sweetpoints del cliente para aumentar el descuento
                Integer clienteSP = clientes.get(x.buscar(ID)).getSweetpoints();
                Integer newSP;
                
                if(clienteSP >= 100){//se suma dos descuentos
                    descuento = descuento + 10;
                    newSP = clienteSP - 100;
                    clientes.get(x.buscar(ID)).setSweetpoints(newSP);
                }else if(clienteSP >= 50){//se suma un descuento
                    descuento = descuento + 5;
                    newSP = clienteSP - 50;
                    clientes.get(x.buscar(ID)).setSweetpoints(newSP);
                }
                
                //Revisar el importe por si hay descuento que realizar
                Double resta = (descuento /100.)*importe;
                importe = importe - resta;
                
                //Poner en vista los resultados
                this.importe.setVisible(true);
                this.descuento.setVisible(true);
                this.importe.setText(importe + "");
                this.descuento.setText(descuento + "%");
                
                //Dar sweetpoints dependiendo de la compra
                Integer sPoints = x.convertirVentaASweetpoints(importe);
                newSP = clientes.get(x.buscar(ID)).getSweetpoints() + sPoints;
                clientes.get(x.buscar(ID)).setSweetpoints(newSP);
                
                //Pasa lo temporal a las ventas
                for(int i=0;i<ventaTemporal.size();i++){
                    String cliente = ventaTemporal.get(i).getCliente();
                    String idProducto = ventaTemporal.get(i).getIdProducto();
                    String producto = ventaTemporal.get(i).getProducto();
                    Integer cantidad = ventaTemporal.get(i).getCantidad();
                    Double precio = ventaTemporal.get(i).getPrecio();
                    agregarVenta(cliente, idProducto, producto, cantidad, precio);
                }
                
                //Quita todo en la vista y limpiar
                ventaTemporal.clear();
                ventasVista.clear();
                this.tablaVenta.refresh();
                this.textID.clear();
                this.textCantidad.clear();
                this.importe.setVisible(false);
                this.descuento.setVisible(false);
                
            }else{//no existe cliente
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Inténtelo de nuevo");
                alert.setContentText("El cliente no existe");
                alert.showAndWait();
            }
        }
       
    }

    @FXML
    private void cancelarVenta(ActionEvent event) {
        ventaTemporal.clear();
        ventasVista.clear();
        this.tablaVenta.refresh();
    }
    
}
