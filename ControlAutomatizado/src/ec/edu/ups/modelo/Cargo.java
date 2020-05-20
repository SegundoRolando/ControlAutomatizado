/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

/**
 *
 * @author  srcti
 */
public class Cargo {
    private int codigo;
    private String cargo;

    public Cargo() {
    }

    public Cargo(int codigo, String cargo) {
        this.codigo = codigo;
        this.cargo = cargo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Cargo{" + "codigo=" + codigo + ", cargo=" + cargo + '}';
    }
    
}
