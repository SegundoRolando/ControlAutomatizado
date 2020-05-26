/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

/**
 *
 * @author srcti
 */
public class Proveedor extends Persona {
    private String empresa; //nombre del negocio o de la emmpresa -Tienda Mega

    public Proveedor() {
    }

    public Proveedor(int codigo, String nombre, String apellido, String cedula, String direccion, String telefono, String email, String genero, String estado) {
        super(codigo, nombre, apellido, cedula, direccion, telefono, email, genero, estado);
    }

    
    
    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "empresa=" + empresa + '}';
    }

    
}
