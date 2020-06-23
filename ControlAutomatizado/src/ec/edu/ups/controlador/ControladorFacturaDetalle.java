/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.FacturaDetalle;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author srcti
 */
public class ControladorFacturaDetalle {
     private ConexionBD conexion;

    public ControladorFacturaDetalle() {
    conexion=new ConexionBD();
    }
    
    
    public void crearFactura(FacturaDetalle facturaDetalle){
        try {
            PreparedStatement pst=null;
            boolean estado=true;
            String sql="INSERT INTO CON_FACTURADETALLES (FACD_CODIGO, FACD_CANTIDAD, FACD_PRECIOUNITARIO, FACD_PRECIOTOTAL,FACTURA_FAC_CODIGO,PRODUCTO_PRO_CODIGO)"
                    + "VALUES (CON_FACTURADETALLES_SEQ.NEXTVAL,?,?,?,?,?)";
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            pst.setInt(1, facturaDetalle.getCantidad());
            pst.setDouble(2, facturaDetalle.getPrecioUnitario());
            pst.setDouble(3, facturaDetalle.getPrecioTotal());
            pst.setInt(4, facturaDetalle.getCodigoFactura());
            pst.setInt(5, facturaDetalle.getCodigoProducto());
            pst.executeUpdate();
            conexion.getConexion().commit();
            conexion.Desconectar();
            
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
    }
    
    public void actualizarCodFactura(int codigoProducto,int codigoFactura){
        try {
            PreparedStatement pst=null;
            String sql="UPDATE CON_FACTURADETALLES SET FACTURA_FACD_CODIGO= ?"
                    + "WHERE PRODUCTO_PRO_CODIGO= ?";
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            pst.setInt(1, codigoFactura);
            pst.setInt(2, codigoProducto);
            
            pst.executeUpdate();
            conexion.Desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void eliminarDetalle(int codigo){
        try {
            PreparedStatement pst=null;
            String sql="DELETE FROM CON_FACTURADETALLES WHERE PRODUCTO_PRO_CODIGO="+codigo+"";
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            pst.executeUpdate();
        } catch (SQLException ex) {
            
        }
    }
    
    public List<FacturaDetalle> listar(int codigo){
        
        try {
            List<FacturaDetalle> lista=new ArrayList<>();
            String sql="SELECT * FROM CON_FACTURADETALLES WHERE FACTURA_FAC_CODIGO= "+codigo+"";
            
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            while(respuesta.next()){
                FacturaDetalle facturaDetalle=new FacturaDetalle();
                facturaDetalle.setCodigo(respuesta.getInt(1));
                facturaDetalle.setCantidad(respuesta.getInt(2));
                facturaDetalle.setPrecioUnitario(respuesta.getDouble(3));
                facturaDetalle.setPrecioTotal(respuesta.getDouble(4));
                facturaDetalle.setCodigoFactura(respuesta.getInt(5));
                facturaDetalle.setCodigoProducto(respuesta.getInt(6));
                lista.add(facturaDetalle);
            }
            conexion.Desconectar();
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}
