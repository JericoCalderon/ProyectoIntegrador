/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;



import Modelo.Comprobante;
import Config.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author PC-USER
 */
public class ComprobanteDAO {
     
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
     Comprobante p=new Comprobante();
    
    public String numeroComprobante() {
        String numerodefactura ="";
        String consulta = "SELECT MAX(numerocomprobante) FROM comprobante";
        con = cn.Conexion(); 
 
        try {
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                numerodefactura = rs.getString(1);
                System.err.println("numcom"+numerodefactura);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComprobanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return numerodefactura; 

    }

        public void RegistrarVenta(Comprobante venta){
         String sentencia = "INSERT INTO comprobante (idcomprobante,idreserva,numeroComprobante,fecha,total) VALUES(?,?,?,?,?)";
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(sentencia);
            ps.setInt(1,venta.getIdComprobante());
            ps.setInt(2, venta.getIdCliente());
            ps.setString(3, venta.getNumeroComprobante());
            ps.setString(4, venta.getFecha());
            ps.setDouble(5, venta.getMonto());
          
            ps.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(ComprobanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void GuardarDetalleVenta(Comprobante venta){
          String sentencia = "INSERT INTO detalleventa (idcomprobante,idservicio,cantidad,precio) VALUES(?,?,?,?)";
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(sentencia);
            ps.setInt(1,venta.getIdComprobante()); 
            ps.setInt(2, venta.getIdServicio());
            ps.setInt(3, venta.getCantidad());
            ps.setDouble(4, venta.getPrecio());
           
            ps.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(ComprobanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public int ObtenerMaximoIdVentas(){
        int idComprobante=0;
        String consulta = "SELECT MAX(idComprobante) FROM comprobante";
        con = cn.Conexion();
         try {
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
               idComprobante=rs.getInt(1);
               System.out.println("max"+idComprobante);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComprobanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return idComprobante;
    }
     
     public void Eliminar(int idComprobante) {

        String sql = "DELETE FROM ventas WHERE idComprobante=" + idComprobante;
        con = cn.Conexion();
        try { 
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ComprobanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    
}
