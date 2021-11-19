/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;

/**
 *
 * @author leodz
 */
public class ControladorPersona {
    
    ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    ArrayList<Administrador> administradores = new ArrayList<Administrador>();
    ArrayList<Empleado> empleados = new ArrayList<Empleado>();
   
    
    public int buscarCliente(String ID){
        for(int i=0;i<clientes.size();i++){
            if(ID.equals(clientes.indexOf(i).ID)){
                return i;
            }
        }
        return -1;
    }
    
    public int buscarEmpleado(String ID){
        for(int i=0;i<empleados.size();i++){
            if(ID.equals(empleados.indexOf(i).ID)){
                return i;
            }
        }
        return -1;
    }
    
    public int buscarAdministrador(String ID){
        for(int i=0;i<administradores.size();i++){
            if(ID.equals(administradores.indexOf(i).ID)){
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
    
     
    public void agregarCliente(String ID, String nombre, String apellido, Integer sweetpoints){
        if(!existeCliente(ID)){
            clientes.add(new Cliente(ID, nombre, apellido, sweetpoints));
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
            clientes.remove(buscarCliente(ID));
        }
    }
    
    public void eliminarEmpleado(String ID){
        if(existeEmpleado(ID)){
            empleados.remove(buscarEmpleado(ID));
        }
    }
    
    public void eliminarAdministrador(String ID){
        if(existeAdministrador(ID)){
            administradores.remove(buscarAdministrador(ID));
        }
    }
      
    
}
