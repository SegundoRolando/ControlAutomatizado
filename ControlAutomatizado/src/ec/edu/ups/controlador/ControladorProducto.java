/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Producto;
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
public class ControladorProducto {
    
    
    
    private ConexionBD conexion= new ConexionBD();
    
    public void Crear(Producto p){
        try {
          
            PreparedStatement pst=null;
            String sql="INSERT INTO CON_PRODUCTOS (PROD_CODIGO,PROD_CODIGOBARRA,PROD_NOMBRE,PROD_DESCRIPCION,PROD_COSTOVENTA,PROD_COSTOCOMPRA,PROD_STOCK,PROD_IVA,PROD_EMPRESA, CATEGORIA_CAT_CODIGO, PROD_ESTADO,PROD_UTILIDAD)"
                    + "VALUES (CON_PRODUCTOS_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?)";
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            
             pst.setString(1, p.getCodigoBarra());
            pst.setString(2, p.getNombre());
            pst.setString(3, p.getDescripcion());
            pst.setDouble(4, p.getPrecioVenta());
            pst.setDouble(5, p.getPrecioCompra());
            pst.setInt(6, p.getStock());
            pst.setBoolean(7, p.getIva());
            pst.setString(8, p.getEmpresa());
            pst.setInt(9, p.getCodigoCategoria());
            pst.setBoolean(10, p.getEstado());
            pst.setDouble(11, p.getUtilidad());
            pst.executeUpdate();
            conexion.getConexion().commit();
            conexion.Desconectar();
            JOptionPane.showMessageDialog(null, "Producto Creado Correctamente");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo crear el producto");
        }
    }
  
 
    public void Actualizar(Producto p){
        try {
            PreparedStatement pst=null;
            String sql="UPDATE CON_PRODUCTOS SET PROD_CODIGOBARRA=?, PROD_NOMBRE=?,PROD_DESCRIPCION=?,PROD_COSTOVENTA=?,PROD_COSTOCOMPRA=?,PROD_STOCK=?,PROD_IVA=?, PROD_EMPRESA=?,"
                    + "CATEGORIA_CAT_CODIGO=?,PROD_ESTADO=?,PROD_UTILIDAD=?"
                    + "WHERE PROD_CODIGO = ?";
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            
            pst.setString(1, p.getCodigoBarra());
            pst.setString(2, p.getNombre());
            pst.setString(3, p.getDescripcion());
            pst.setDouble(4, p.getPrecioVenta());
            pst.setDouble(5, p.getPrecioCompra());
            pst.setInt(6, p.getStock());
            pst.setBoolean(7, p.getIva());
            pst.setString(8, p.getEmpresa());
            pst.setInt(9, p.getCodigoCategoria());
            pst.setBoolean(10,p.getEstado());
            pst.setDouble(11, p.getUtilidad());
            pst.setInt(12, p.getCodigo());
            
            pst.execute();
            conexion.Desconectar();
            JOptionPane.showMessageDialog(null, "Producto Actualizado Correctamente");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo Actualizar el producto");
        }
    }
    
    public void ActualizarStock(int p,int nuevo){
        try {
            PreparedStatement pst=null;
            String sql="UPDATE CON_PRODUCTOS SET PROD_STOCK=?"
                    + "WHERE PROD_CODIGO = ?";
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
           
            pst.setInt(1, nuevo);
            pst.setInt(2, p);
            
            pst.execute();
            conexion.Desconectar();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo Actualizar el producto");
        }
    }
    
    
     public void Eliminar(int codigo){
          try {
            boolean estado=false;
            PreparedStatement pst=null;
            String sql="UPDATE CON_PRODUCTOS SET PROD_ESTADO = ?"
                    + "WHERE PROD_CODIGO= ?";
            
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            pst.setBoolean(1, estado);
            pst.setInt(2, codigo);
            pst.execute();
            conexion.getConexion().commit();
            conexion.Desconectar();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo Eliminar el Producto");
        }
     }
   
    
     public List<Producto> buscarCategoria(int cat){
     
        try {
            List<Producto> lista=new ArrayList<>();
            conexion.Conectar();
            String sql="SELECT * FROM CON_PRODUCTOS WHERE CATEGORIA_CAT_CODIGO="+cat+" AND PROD_ESTADO= 1";
            
            Statement sta= conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            
            while(respuesta.next()){
                
                Producto p=new Producto();
                p.setCodigo(respuesta.getInt(1));
                p.setCodigoBarra(respuesta.getString(2));
                p.setNombre(respuesta.getString(3));
                p.setDescripcion(respuesta.getString(4));
                
                p.setPrecioVenta(respuesta.getDouble(5));
                p.setPrecioCompra(respuesta.getDouble(6));
                
                p.setStock(respuesta.getInt(7));
                p.setIva(respuesta.getBoolean(8));
                p.setEmpresa(respuesta.getString(9));
                p.setCodigoCategoria(respuesta.getInt(10));
                p.setEstado(respuesta.getBoolean(11));
                p.setUtilidad(respuesta.getDouble(12));
                
                lista.add(p);
            }
            
            return lista;
        } catch (SQLException ex) {
            
        }
        return null;
     }  
     
    public List<Producto> buscarEmpresa(String cat){
     
        try {
            List<Producto> lista=new ArrayList<>();
            conexion.Conectar();
            String sql="SELECT PROD_CODIGO,PROD_CODIGOBARRAS,PROD_NOMBRE,PROD_DESCRIPCION,PROD_COSTOVENTA,PROD_COSTOCOMPRA,PROD_STOCK,PROD_IVA,PROD_EMPRESA,CATEGORIA_CAT_CODIGO,PROD_ESTADO,PROD_UTILIDAD,"
                    + "FROM CON_PRODUCTOS P,CON_PROVEEDORES PR,CON_PROVEEDORPRODUCTOS  PP "
                    + "WHERE PR.PRO_EMPRESA LIKE '"+cat+"%' AND PR.PRO_CODIGO=PP.PROVEEDOR_PRO_CODIGO"
                    + "AND P.PROD_CODIGO=PP.PRODUCTO_PROD_CODIGO AND PRO_ESTADO=1 "
                    + "UNION "
                    + "SELECT PROD_CODIGO,PROD_CODIGOBARRA,PROD_NOMBRE,PROD_DESCRIPCION,PROD_COSTOVENTA,"
                    + "PROD_COSTOCOMPRA,PROD_STOCK,PROD_IVA,PROD_EMPRESA,CATEGORIA_CAT_CODIGO,PROD_ESTADO, PROD_UTILIDAD,"
                    + "FROM CON_PRODUCTOS WHERE PROD_ESTADO= 1";
            
            Statement sta= conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            
            while(respuesta.next()){
                Producto p=new Producto();
                p.setCodigo(respuesta.getInt(1));
                p.setCodigoBarra(respuesta.getString(2));
                p.setNombre(respuesta.getString(3));
                p.setDescripcion(respuesta.getString(4));
                p.setPrecioVenta(respuesta.getDouble(5));
                p.setPrecioCompra(respuesta.getDouble(6));
                p.setStock(respuesta.getInt(7));
                p.setIva(respuesta.getBoolean(8));
                p.setEmpresa(respuesta.getString(9));
                p.setCodigoCategoria(respuesta.getInt(10));
                p.setEstado(respuesta.getBoolean(11));
                p.setUtilidad(respuesta.getDouble(12));
                
                lista.add(p);
            }
            
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
     }
     
      
     public List<Producto> buscarProducto(String cat){
     
        try {
            List<Producto> lista=new ArrayList<>();
            conexion.Conectar();
            String sql="SELECT * FROM CON_PRODUCTOS WHERE PROD_NOMBRE LIKE '"+cat+"%' AND PROD_ESTADO = 1";
            
            Statement sta= conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            
            while(respuesta.next()){
                Producto p=new Producto();
                p.setCodigo(respuesta.getInt(1));
                p.setCodigoBarra(respuesta.getString(2));
                p.setNombre(respuesta.getString(3));
                p.setDescripcion(respuesta.getString(4));
                p.setPrecioCompra(respuesta.getDouble(6));
                p.setPrecioVenta(respuesta.getDouble(5));
                p.setStock(respuesta.getInt(7));
                p.setIva(respuesta.getBoolean(8));
                p.setEmpresa(respuesta.getString(9));
                p.setCodigoCategoria(respuesta.getInt(10));
                p.setEstado(respuesta.getBoolean(11));
                p.setUtilidad(respuesta.getDouble(12));
                
                lista.add(p);
            }
            
            return lista;
        } catch (SQLException ex) {
            
        }
        return null;
     }
     //revisar
     public Producto buscarProductoFactura(int codigo){
        try {
            String sql="SELECT * FROM CON_PRODUCTOS WHERE PROD_CODIGO = "+codigo+" AND PROD_ESTADO= 1";
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            Producto p=new Producto();
            while(respuesta.next()){
                 p.setCodigo(respuesta.getInt(1));
                p.setCodigoBarra(respuesta.getString(2));
                p.setNombre(respuesta.getString(3));
                p.setDescripcion(respuesta.getString(4));
                p.setPrecioVenta(respuesta.getDouble(5));
                p.setPrecioCompra(respuesta.getDouble(6));
                p.setStock(respuesta.getInt(7));
                p.setIva(respuesta.getBoolean(8));
                p.setEmpresa(respuesta.getString(9));
                p.setCodigoCategoria(respuesta.getInt(10));
                p.setEstado(respuesta.getBoolean(11));
                p.setUtilidad(respuesta.getDouble(12));
            }
            conexion.Desconectar();
            return p;
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return null;
     }
     
     
      public String descripcion(int codigo){
        try {
            String sql="SELECT PROD_DESCRIPCION FROM CON_PRODUCTOS WHERE PROD_CODIGO = "+codigo+" AND PROD_ESTADO= 1";
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            String p="";
            while(respuesta.next()){
               p=respuesta.getString(1);
            }
            conexion.Desconectar();
            return p;
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return null;
    }
     
     public int buscarcodproducto(String nombre){
        try {
            String sql="SELECT * FROM CON_PRODUCTOS WHERE PROD_NOMBRE ='"+nombre+"' AND PROD_ESTADO = 1 ";
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            int codigoPro=0;
            while(respuesta.next()){
                 codigoPro=respuesta.getInt(1);
                 System.out.println("es el codigo del producto " +codigoPro);
               
            }
            return codigoPro;
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return 0;
    }
    
     public void ingresarMercaderia(int codigo,int suma){
        try {
            PreparedStatement pst=null;
            String sql="UPDATE CON_PRODUCTOS SET PROD_STOCK=?"
                    + "WHERE PROD_CODIGO = ?";
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            pst.setInt(1, suma);
            pst.setInt(2, codigo);
            
            pst.execute();
            conexion.getConexion().commit();
            conexion.Desconectar();
            JOptionPane.showMessageDialog(null,"Stock ingresado Satisfactoriamente");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo Actualizar el Stock");
        }
    }
     public void utilidad(Producto p){
         
         
        
     }
}
