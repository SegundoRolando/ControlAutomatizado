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
    
    public Cliente(int codigo, String nombre, String apellido, String direccion, String cedula, String telefono, String email, String genero) {
        super(codigo, nombre, apellido, direccion, cedula, telefono, email, genero);
    }
    
}
