/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.Date;

/**
 *
 * @author srcti
 */
public class FacturaCabecera {
    
    private int codigo;
    private Date fecha;
    private double subtotal;
    private double descuento;
    private double iva;
    private double total;
    private String formaPago;
    private int codigoCliente;
    private int codigoEmpleado;
    private boolean estado;

    public FacturaCabecera() {
    }

    public FacturaCabecera(int codigo, Date fecha, double subtotal, double descuento, double iva, double total, String formaPago, int codigoCliente, int codigoEmpleado, boolean estado) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.iva = iva;
        this.total = total;
        this.formaPago = formaPago;
        this.codigoCliente = codigoCliente;
        this.codigoEmpleado = codigoEmpleado;
        this.estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "FacturaCabecera{" + "codigo=" + codigo + ", fecha=" + fecha + ", subtotal=" + subtotal + ", descuento=" + descuento + ", iva=" + iva + ", total=" + total + ", formaPago=" + formaPago + ", codigoCliente=" + codigoCliente + ", codigoEmpleado=" + codigoEmpleado + ", estado=" + estado + '}';
    }

    
}
