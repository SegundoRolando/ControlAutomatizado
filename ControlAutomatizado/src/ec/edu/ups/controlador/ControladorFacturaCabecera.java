/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.FacturaCabecera;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author srcti
 */
public class ControladorFacturaCabecera {
    

    private ConexionBD conexion;
    public ControladorFacturaCabecera() {
    conexion= new ConexionBD();
    }

    public int numeroFactura(){
       int numero=0;
        try {
            String sql="select nvl(max(FACC_CODIGO),0) from CON_FACTURASCABECERA";
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet res=sta.executeQuery(sql);
            while(res.next()){
                numero=res.getInt(1);
                numero++;
            }
            conexion.Desconectar();
            return numero;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return numero;
    }
    
    public void crearFactura(FacturaCabecera facturaCabecera){
        try {
            PreparedStatement pst=null;
            boolean estado=true;
            String sql="INSERT INTO CON_FACTURASCABECERA (FACC_CODIGO, FACC_FECHA, FACC_SUBTOTAL, FACC_DESCUENTO, FACC_IVA, FACC_TOTAL, FACC_FORMA_PAGO, CLIENTE_CLI_CODIGO, EMPLEADO_EMP_CODIGO,FAC_ESTADO)"
                    + "VALUES (CON_FACTURASCABECERA_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?)";
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            SimpleDateFormat formateador = new SimpleDateFormat ("dd-MMM-yyyy");
            String fecha=formateador.format (new Date());
            pst.setString(1, fecha);
            pst.setDouble(2, facturaCabecera.getSubtotal());
            pst.setDouble(3, facturaCabecera.getDescuento());
            pst.setDouble(4, facturaCabecera.getIva());
            pst.setDouble(5, facturaCabecera.getTotal());
            pst.setString(6, facturaCabecera.getFormaPago());
            pst.setInt(7, facturaCabecera.getCodigoCliente());
            pst.setInt(8, facturaCabecera.getCodigoEmpleado());
            pst.setBoolean(9, estado);
            pst.executeUpdate();
            conexion.getConexion().commit();
            conexion.Desconectar();
            JOptionPane.showMessageDialog(null, "Factura Creada Correctamente");
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
    }
    
    
    public void anularFactura(int codigo){
        try {
            PreparedStatement pst=null;
            boolean estado=false;
            String sql="UPDATE CON_FACTURASCABECERA SET FACC_ESTADO=?"
                    + "WHERE FACC_CODIGO=?";
            
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            pst.setBoolean(1, estado);
            pst.setInt(2, codigo);
            pst.executeUpdate();
            conexion.Desconectar();
            JOptionPane.showConfirmDialog(null, "Factura Anulada");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public FacturaCabecera buscarFactura(int codigo){
        
        try {
            String sql="SELECT * FROM CON_FACTURASCABECERA"
                    + " WHERE FACC_CODIGO= "+codigo+"";
            
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            FacturaCabecera facturaCabecera=new FacturaCabecera();
            while(respuesta.next()){
                
                facturaCabecera.setCodigo(respuesta.getInt(1));
                facturaCabecera.setFecha(respuesta.getDate(2));
                facturaCabecera.setSubtotal(respuesta.getDouble(3));
                facturaCabecera.setDescuento(respuesta.getDouble(4));
                facturaCabecera.setIva(respuesta.getDouble(5));
                facturaCabecera.setTotal(respuesta.getDouble(6));
                facturaCabecera.setFormaPago(respuesta.getString(7));
                facturaCabecera.setCodigoCliente(respuesta.getInt(8));
                facturaCabecera.setCodigoEmpleado(respuesta.getInt(9));
                
            }
            return facturaCabecera;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    /*
    public List<FacturaCabecera> buscarFacturas(String cedula){
        List<FacturaCabecera> lista= new ArrayList<>();
        try {
            String sql="SELECT * FROM FER_FACTURAS F,FER_CLIENTES C"
                    + " WHERE F.FER_CLIENTE_CLI_CODIGO=C.CLI_CODIGO AND C.CLI_CEDULA= '"+cedula+"' AND F.FAC_ESTADO= 1";
            
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            while(respuesta.next()){
                FacturaCabecera facturaCabecera=new FacturaCabecera();
                facturaCabecera.setCodigo(respuesta.getInt(1));
                facturaCabecera.setFecha(respuesta.getDate(2));
                facturaCabecera.setSubtotal(respuesta.getDouble(3));
                facturaCabecera.setDescuento(respuesta.getDouble(4));
                facturaCabecera.setIva(respuesta.getDouble(5));
                facturaCabecera.setTotal(respuesta.getDouble(6));
                facturaCabecera.setFormaPago(respuesta.getString(7));
                facturaCabecera.setCodigoCliente(respuesta.getInt(8));
                facturaCabecera.setCodigoEmpleado(respuesta.getInt(9));
                lista.add(facturaCabecera);
            }
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }*/
}
