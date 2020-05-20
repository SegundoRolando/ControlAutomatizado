/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author srcti
 */
public class ConexionBD {
    private Connection conexion= null;
    private String login = "ControlAutomatizado";
    private String pasword = "controlautomatizado";
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    
    
    public ConexionBD (){
        
    }
    public void Conectar() {
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            conexion = DriverManager.getConnection(url, login, pasword);
            conexion.setAutoCommit(false);
            if (conexion!=null){
                System.out.println("Conexion exitosa");
            }else {
                System.out.println("Conexio Fallida");
            }
            
            
        } catch (ClassNotFoundException | SQLException e) {
            
        }
    }
    public void Desconectar() {
        try {
            conexion.close();
            System.out.println("Conexion desconectada");
            
        } catch (SQLException ex) {

        }
    } 

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
    
}
