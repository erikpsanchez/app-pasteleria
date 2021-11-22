/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apppasteleria.controlador;

import apppasteleria.Administrador;
import apppasteleria.modelo.Cliente;
import apppasteleria.modelo.Empleado;
import apppasteleria.FXMLDocumentController;
import apppasteleria.Persona;
import java.util.ArrayList;

/**
 *
 * @author leodz
 */
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
    
    
    /*
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
    }*/
    
    
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
     
    public void agregarCliente(Persona p){
        if(existeCliente(p.getID())== false){
            clientes.add((Cliente) p);
            
        }else{
            System.out.println("Registro fallido.El numero "+p.getID()+" ya se encuentra ");
        }
        
    }
    
    public void agregarEmpleado(Persona Emp){
       
        if(existeEmpleado(Emp.getID())== false){
            empleados.add((Empleado) Emp);
            imprimir();
           
        }else{
            System.out.println("Registro fallido.");
        }
    }
    
    public void agregarAdministrador(Persona Admin){
           
        if(existeAdministrador(Admin.getID())== false){
            administradores.add((Administrador) Admin);
        }else{
            System.out.println("Registro fallido.");
        }
        
    }
   
    /*
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
        
    }*/
    public void imprimir(){
   
         System.out.println("\nLista Clinetes\n");
         for (int i = 0; i < clientes.size() ; i++) {
            System.out.println(clientes.get(i).toString());
         }
         System.out.println("\nLista Administradores\n");
         
         for (int in = 0; in < administradores.size(); in++) {
             System.out.println(administradores.get(in).toString());
         }
        
         System.out.println("\nLista Empleados\n");
         for (int index = 0; index < empleados.size(); index++) {
            System.out.println(empleados.get(index).toString());
         }
       
       
    }
    
    public void eliminarCliente(String ID){
        if(existeCliente(ID)){
            clientes.remove(buscarCliente(ID));
        }
    }
    /*
    public void eliminarEmpleado(String ID){
        if(existeEmpleado(ID)){
            empleados.remove(buscarEmpleado(ID));
        }
    }
    
    public void eliminarAdministrador(String ID){
        if(existeAdministrador(ID)){
            administradores.remove(buscarAdministrador(ID));
        }
    }*/
      
    
}
