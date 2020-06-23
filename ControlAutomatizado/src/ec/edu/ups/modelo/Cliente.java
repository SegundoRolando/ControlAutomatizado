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
public class Cliente extends Persona{

    public Cliente() {
    }

    public Cliente(int codigo, String nombre, String apellido, String cedula, String direccion, String telefono, String email, String genero, String estado) {
        super(codigo, nombre, apellido, cedula, direccion, telefono, email, genero, estado);
    }

    
    
}
