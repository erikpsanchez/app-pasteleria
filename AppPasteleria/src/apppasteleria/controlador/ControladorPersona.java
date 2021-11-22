/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apppasteleria.controlador;

/**
 *
 * @author leodz
 * @author erikp
 * @author belen
 * @author carlos
 * 
 * @version 21/noviembre/2021 21:45 hrs
 */

import apppasteleria.modelo.Administrador;
import apppasteleria.modelo.Cliente;
import apppasteleria.modelo.Empleado;
import java.util.ArrayList;


public class ControladorPersona {
    
    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Administrador> administradores = new ArrayList<>();
    ArrayList<Empleado> empleados = new ArrayList<>();
   
    
    public int buscarCliente(String ID){
        for(int i=0;i<clientes.size();i++){
            if(ID.equals(clientes.get(i).getID())){
                return i;
            }
        }
        return -1;
    }
    
    public int buscarEmpleado(String ID){
        for(int i=0;i<empleados.size();i++){
            if(ID.equals(empleados.get(i).getID())){
                return i;
            }
        }
        return -1;
    }
    
    public int buscarAdministrador(String ID){
        for(int i=0;i<administradores.size();i++){
            if(ID.equals(administradores.get(i).getID())){
                return i;
            }
        }
        return -1;
    }
    
    
    public boolean existeCliente(String ID){
        if(buscarCliente(ID) != -1){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean existeEmpleado(String ID){
        if(buscarEmpleado(ID) != -1){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean existeAdministrador(String ID){
        if(buscarAdministrador(ID) != -1){
            return true;
        }else{
            return false;
        }
    }
    
     /**
      * Método para agregar clientes
     * @throw Lanza la excepción NumberFormatException para detectar si en el atributo de sweetpoint se ingresa algo que no sea un número.
     * @param ID 
     * @param nombre
     * @param apellido
     * @param sweetpoints
      **/
    public void agregarCliente(String ID, String nombre, String apellido, Integer sweetpoints){
        try{
            if(!existeCliente(ID)){
                clientes.add(new Cliente(ID, nombre, apellido, sweetpoints));
            }
        }catch(NumberFormatException e){
            System.out.println("Datos ingresados en el campo 'sweetpoints' deben ser números.");
        }
    }
    
    public void agregarEmpleado(String ID, String nombre, String apellido){
        if(!existeEmpleado(ID)){
            empleados.add(new Empleado(ID, nombre, apellido));
        }
        
    }
    
    public void agregarAdministrador(String ID, String nombre, String apellido, String password){
        if(!existeAdministrador(ID)){
            administradores.add(new Administrador(ID, nombre, apellido, password));
        }
        
    }
    
    
    public void eliminarCliente(String ID){
        if(existeCliente(ID)){
            clientes.remove(clientes.get(buscarCliente(ID)));
        }
    }
    
    public void eliminarEmpleado(String ID){
        if(existeEmpleado(ID)){
            empleados.remove(empleados.get(buscarEmpleado(ID)));
        }
    }
    
    public void eliminarAdministrador(String ID){
        if(existeAdministrador(ID)){
            administradores.remove(administradores.get(buscarAdministrador(ID)));
        }
    }
      
    
}

