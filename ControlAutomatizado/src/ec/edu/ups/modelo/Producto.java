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
public class Producto {
    private  String codigoBarra;
    private String nombre;

    public Producto(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigoBarra=" + codigoBarra + ", nombre=" + nombre + '}';
    }

    
}
