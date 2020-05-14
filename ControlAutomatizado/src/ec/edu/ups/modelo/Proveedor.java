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

    public Proveedor(String empresa, int codigo, String nombre, String apellido, String direccion, String cedula, String telefono, String email, String genero) {
        super(codigo, nombre, apellido, direccion, cedula, telefono, email, genero);
        this.empresa = empresa;
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
