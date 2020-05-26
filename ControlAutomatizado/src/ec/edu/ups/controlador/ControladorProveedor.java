package ec.edu.ups.controlador;

import ec.edu.ups.controlador.ConexionBD;
import ec.edu.ups.modelo.Empleado;
import ec.edu.ups.modelo.Proveedor;
import static java.lang.System.out;
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
public class ControladorProveedor {

    private ConexionBD conexion;

    public ControladorProveedor() {
    conexion = new ConexionBD();
    }

    public void crearProveedor(Proveedor proveedor) {
        
        PreparedStatement pst = null;
        String sql = "INSERT INTO CON_PROVEEDORES(PRO_CODIGO, PRO_NOMBRE,PRO_APELLIDO,PRO_CEDULA, PRO_DIRECCION ,PRO_TELEFONO,PRO_EMAIL,PRO_GENERO,PRO_EMPRESA)"
        + " VALUES (CON_PROVEEDORES_SEQ.NEXTVAL,?,?,?,?,?,?,?,?)";
        try {
            conexion.Conectar();
            pst = conexion.getConexion().prepareStatement(sql);
            
            pst.setString(1, proveedor.getNombre());
            pst.setString(2, proveedor.getApellido());
            pst.setString(3, proveedor.getCedula());
            pst.setString(4, proveedor.getDireccion());
            pst.setString(5, proveedor.getTelefono());
            pst.setString(6, proveedor.getEmail());
            pst.setString(7, proveedor.getGenero());
            pst.setString(8, proveedor.getEmpresa());
            pst.executeUpdate();
            out.println("insertado");
            conexion.getConexion().commit();
            JOptionPane.showMessageDialog(null, proveedor.getNombre()+" Creado Correctamente");
            conexion.Desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }
    

    public void actualizar(Proveedor proveedor) {
        PreparedStatement pst = null;
        String sql = "UPDATE CON_PROVEEDORES SET PRO_NOMBRE= ?, PRO_APELLIDO= ?,PRO_CEDULA= ?, PRO_DIRECCION= ?,  PRO_TELEFONO= ?, PRO_EMAIL= ?, PRO_GENERO= ?, PRO_EMPRESA= ?"
                + " WHERE PRO_CODIGO =?";
        try {
            conexion.Conectar();
            pst = conexion.getConexion().prepareStatement(sql);
            pst.setString(1, proveedor.getNombre());
            pst.setString(2, proveedor.getApellido());
            pst.setString(3, proveedor.getCedula());
            pst.setString(4, proveedor.getDireccion());
            pst.setString(5, proveedor.getTelefono());
            pst.setString(6, proveedor.getEmail());
            pst.setString(7, proveedor.getGenero());
            pst.setString(8, proveedor.getEmpresa());
            pst.setInt(9, proveedor.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, proveedor.getNombre()+" Actualizado Correctamente");
            conexion.getConexion().commit();
            conexion.Desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error " + ex.getMessage());
        }
    }

 public void eliminar(int Codigo) {
        try {
            PreparedStatement pst = null;
            String sql = "DELETE FROM CON_PROVEEDORES  WHERE PRO_CODIGO =?";

            conexion.Conectar();
            pst = conexion.getConexion().prepareStatement(sql);
            pst.setInt(1, Codigo);
            pst.execute();
            conexion.Desconectar();
            JOptionPane.showMessageDialog(null, "Proveedor ELiminado Correctamente", "Eliminar", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se puedo Eliminar Correctamente!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Proveedor buscarCedula(String c){
        try {
           
            Proveedor proveedor=new Proveedor();
            String sql="SELECT * FROM CON_PROVEEDORES WHERE PRO_CEDULA='"+c+"'";
           
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            
            while(respuesta.next()){
                proveedor.setCodigo(respuesta.getInt(1));
                proveedor.setNombre(respuesta.getString(2));
                proveedor.setApellido(respuesta.getString(3));
                proveedor.setCedula(respuesta.getString(4));
                proveedor.setDireccion(respuesta.getString(5));
                proveedor.setTelefono(respuesta.getString(6));
                proveedor.setEmail(respuesta.getString(7));
                proveedor.setGenero(respuesta.getString(8));
                proveedor.setEmpresa(respuesta.getString(9));
                
            }
            conexion.Desconectar();
            return proveedor;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<Proveedor> buscarNombre(String c){
        try {
            List<Proveedor>lista=new ArrayList<>();
            String sql="SELECT * FROM CON_PROVEEDORES WHERE PRO_NOMBRE LIKE '"+c+"%'";
            
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            while(respuesta.next()){
                Proveedor proveedor=new Proveedor();
                proveedor.setCodigo(respuesta.getInt(1));
                proveedor.setNombre(respuesta.getString(2));
                proveedor.setApellido(respuesta.getString(3));
                proveedor.setCedula(respuesta.getString(4));
                proveedor.setDireccion(respuesta.getString(5));
                proveedor.setTelefono(respuesta.getString(6));
                proveedor.setEmail(respuesta.getString(7));
                proveedor.setGenero(respuesta.getString(8));
                proveedor.setEmpresa(respuesta.getString(9));
                
                lista.add(proveedor);
            }
            conexion.Desconectar();
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
   public List<Proveedor> listar(){
        List<Proveedor>lista=new ArrayList<>();
        try {
            String sql ="SELECT * FROM CON_PROVEEDORES";
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            
            while(respuesta.next()){
                 Proveedor proveedor=new Proveedor();
                proveedor.setCodigo(respuesta.getInt(1));
                proveedor.setNombre(respuesta.getString(2));
                proveedor.setApellido(respuesta.getString(3));
                proveedor.setCedula(respuesta.getString(4));
                proveedor.setDireccion(respuesta.getString(5));
                proveedor.setTelefono(respuesta.getString(6));
                proveedor.setEmail(respuesta.getString(7));
                proveedor.setGenero(respuesta.getString(8));
                proveedor.setEmpresa(respuesta.getString(9));
                lista.add(proveedor);
            }
            return lista;
        } catch (SQLException ex) {
            
        }
        return null;
    }
    
    public List<Proveedor> buscarEmpresa(String empresa){
        
        try {
            String sql ="SELECT * FROM CON_PROVEEDORES WHERE PRO_EMPRESA LIKE '"+empresa+"%'";
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            List<Proveedor> lista=new ArrayList<>();
            while(respuesta.next()){
                Proveedor proveedor=new Proveedor();
                proveedor.setCodigo(respuesta.getInt(1));
                proveedor.setNombre(respuesta.getString(2));
                proveedor.setApellido(respuesta.getString(3));
                proveedor.setCedula(respuesta.getString(4));
                proveedor.setDireccion(respuesta.getString(5));
                proveedor.setTelefono(respuesta.getString(6));
                proveedor.setEmail(respuesta.getString(7));
                proveedor.setGenero(respuesta.getString(8));
                proveedor.setEmpresa(respuesta.getString(9));
                lista.add(proveedor);
            }
            return lista;
        } catch (SQLException ex) {
            
        }
        return null;
    }
    
    
}


