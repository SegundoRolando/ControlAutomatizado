/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Categoria;
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
public class ControladorCategoria {
     private ConexionBD conexion= new ConexionBD();
    
    public void CrearCategoria(String nombre){
        try {
            PreparedStatement pst=null;
            String sql="INSERT INTO CON_CATEGORIAS (CAT_CODIGO,CAT_NOMBRE)"
                    + "VALUES (CON_CATEGORIAS_SEQ.NEXTVAL,?)";
            
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            pst.setString(1, nombre);
            pst.executeUpdate();
            conexion.getConexion().commit();
            conexion.Desconectar();
            JOptionPane.showMessageDialog(null, "Categoria Creada Correctamente");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo crear la Categoria");
        }
    }
    
    public void Eliminar(int codigo){
          try {
            PreparedStatement pst=null;
            String sql="DELETE FROM CON_CATEGORIAS WHERE CAT_CODIGO =?";
            
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            pst.setInt(1,codigo);
            pst.execute();
            conexion.Desconectar();
            JOptionPane.showMessageDialog(null, "Categoria Eliminada Correctamente");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo Eliminar la Categoria");
        }
     }
    
    
    public Categoria buscar(String nombre){
        
        try {
            String sql="SELECT * FROM CON_CATEGORIAS WHERE CAT_NOMBRE LIKE '"+nombre+"%'";
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            Categoria m=new Categoria();
            while(respuesta.next()){
                m.setCodigo(respuesta.getInt(1));
                m.setCategoria(respuesta.getString(2));
            }
            
            return m;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
            
    }
    
    public List<Categoria> Listar(){
        
        try {
            String sql="SELECT * FROM CON_CATEGORIAS";
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            List<Categoria> lista=new ArrayList<>();
            
            while(respuesta.next()){
                Categoria categoria=new Categoria();
                categoria.setCodigo(respuesta.getInt(1));
                categoria.setCategoria(respuesta.getString(2));
                lista.add(categoria);
            }
            return lista;
        } catch (SQLException ex) {
            
        }
        return null;
            
    }
    
    
}
