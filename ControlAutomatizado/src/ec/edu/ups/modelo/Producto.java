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
    private  int codigo;
    private  String codigoBarra;
    private String nombre;
    private String descripcion;
    private double precioVenta;
    private double precioCompra;
    private int Stock;
    private Boolean iva;
    private String empresa;
    private int codigoCategoria;
    private Boolean estado;
    private double utilidad;

    public Producto() {
    }

    public Producto(int codigo, String codigoBarra, String nombre, String descripcion, double precioVenta, double precioCompra, int Stock, Boolean iva, String empresa, int codigoCategoria, Boolean estado, double utilidad) {
        this.codigo = codigo;
        this.codigoBarra = codigoBarra;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioVenta = precioVenta;
        this.precioCompra = precioCompra;
        this.Stock = Stock;
        this.iva = iva;
        this.empresa = empresa;
        this.codigoCategoria = codigoCategoria;
        this.estado = estado;
        this.utilidad = utilidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;// editado el precio compra
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public Boolean getIva() {
        return iva;
    }

    public void setIva(Boolean iva) {
        this.iva = iva;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public double getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(double utilidad) {
        this.utilidad = utilidad;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", codigoBarra=" + codigoBarra + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precioVenta=" + precioVenta + ", precioCompra=" + precioCompra + ", Stock=" + Stock + ", iva=" + iva + ", empresa=" + empresa + ", codigoCategoria=" + codigoCategoria + ", estado=" + estado + ", utilidad=" + utilidad + '}';
    }

    
}
