/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.ProductoProveedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author srcti
 */
public class ControladorProveedorProducto {
    
    
    
     private ConexionBD conexion= new ConexionBD();
    
    public void CrearProductoProveedor(ProductoProveedor pp){
        try {
            PreparedStatement pst=null;
            String sql="INSERT INTO CON_PROVEEDORPRODUCTOS (PROP_CODIGO,PROP_STOCK,PROVEEDOR_PRO_CODIGO, PRODUCTO_PROD_CODIGO )"
                    + "VALUES (CON_PROVEEDORPRODUCTOS_SEQ.NEXTVAL,?,?,?)";
            
            
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            pst.setDouble(1, pp.getCantidad());
            pst.setInt(2, pp.getCodigoProveedor());
            pst.setInt(3, pp.getCodigoProducto());
            pst.executeUpdate();
            conexion.getConexion().commit();
            conexion.Desconectar();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo completar el guardado de informacion==>>"+ex.getMessage());
        }
    }
    
    public int buscarcodproveedor(int codigo){
        try {
            String sql="SELECT * FROM CON_PROVEEDORPRODUCTOS WHERE PRODUCTO_PROD_CODIGO="+codigo+"";
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            int codigoPro=0;
            while(respuesta.next()){
                
                codigoPro=respuesta.getInt(3);
                
            }
            conexion.Desconectar();
            return codigoPro;
            
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return 0;
    }
    
    
    
    public List<ProductoProveedor> listar(){
       List<ProductoProveedor> lista= new ArrayList<>();
       
       try {
            String sql="SELECT * FROM CON_PROVEEDORPRODUCTOS";
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
        
             while(respuesta.next()){
                ProductoProveedor pp=new ProductoProveedor();
                pp.setCodigo(respuesta.getInt(1));
                pp.setCantidad(respuesta.getInt(2));
                pp.setCodigoProveedor(respuesta.getInt(3));
                pp.setCodigoProducto(respuesta.getInt(4));
                lista.add(pp);
            }
            conexion.Desconectar();
            return lista;
            
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return null;
    }
    
    public void Eliminar(int codigo){
          try {
            PreparedStatement pst=null;
            String sql="delete from CON_PROVEEDORPRODUCTOS where PRODUCTO_PROD_CODIGO =?";
            
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            pst.setInt(1, codigo);
             pst.execute();
             conexion.getConexion().commit();
            conexion.Desconectar();
            //JOptionPane.showMessageDialog(null, "Producto Eliminado Correctamente");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo Eliminar el Producto");
        }
     }
    
    public void EliminarProveedor(int codigo){
          try {
            PreparedStatement pst=null;
            String sql="delete from CON_PROVEEDORPRODUCTOS where   PROVEEDOR_PRO_CODIGO  =?";
            
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            pst.setInt(1, codigo);
             pst.execute();
             conexion.getConexion().commit();
            conexion.Desconectar();
            //JOptionPane.showMessageDialog(null, "Producto Eliminado Correctamente");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo Eliminar el Producto");
        }
     }
    
}
