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
public class FacturaDetalle {
    private int codigo;
    private int cantidad;
    private double precioUnitario;
    private double precioTotal;
    private int codigoFactura;
    private int codigoProducto;
   

    public FacturaDetalle() {
    }

    public FacturaDetalle(int codigo, int cantidad, double precioUnitario, double precioTotal, int codigoFactura, int codigoProducto) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.precioTotal = precioTotal;
        this.codigoFactura = codigoFactura;
        this.codigoProducto = codigoProducto;
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public int getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(int codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    @Override
    public String toString() {
        return "FacturaDetalle{" + "codigo=" + codigo + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + ", precioTotal=" + precioTotal + ", codigoFactura=" + codigoFactura + ", codigoProducto=" + codigoProducto + '}';
    }


    
}
