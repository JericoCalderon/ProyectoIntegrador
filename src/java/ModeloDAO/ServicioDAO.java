package ModeloDAO;

import Interfaces.CRUDSERVICIO;
import Modelo.Servicio;
import java.util.List;
import Config.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServicioDAO implements CRUDSERVICIO {

    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Servicio se=new Servicio();
    
    public Servicio ConsultaPorId(int idServicio) {
        Servicio servicio = new Servicio();
        con = cn.getConnection();
        String consulta = "SELECT * FROM servicio WHERE idServicio = " + idServicio;
        try {
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while(rs.next()){
                servicio.setIdServicio(rs.getInt("idServicio"));
                servicio.setNomServicio(rs.getString("nomServicio"));              
                servicio.setDescripcion(rs.getString("descripcion"));
                servicio.setTiempo(rs.getString("tiempo"));             
                servicio.setPrecio(Double.valueOf(rs.getString("precio")));
                                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return servicio; 
    }
    @Override
    public List listar() {
        ArrayList<Servicio>list=new ArrayList<>();
        String sql="SELECT * FROM servicio";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Servicio ser=new Servicio();
                ser.setIdServicio(rs.getInt("idServicio"));
                ser.setNomServicio(rs.getString("nomServicio"));
                ser.setDescripcion(rs.getString("descripcion"));
                ser.setTiempo(rs.getString("tiempo"));
                ser.setPrecio(rs.getDouble("precio"));
                list.add(ser);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Servicio list(int idServicio) {
        
         String sql="SELECT * FROM servicio WHERE idServicio= " + idServicio;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                se.setIdServicio(rs.getInt("idServicio"));
                se.setNomServicio(rs.getString("nomServicio"));
                se.setDescripcion(rs.getString("descripcion"));
                se.setTiempo(rs.getString("tiempo"));
                se.setPrecio(rs.getDouble("precio"));
            }
        } catch (Exception e) {
        }
        return se;
    }

    @Override
    public boolean add(Servicio ser) {
        
         String sql="INSERT INTO servicio (nomServicio, descripcion, tiempo, precio) values ('"+ser.getNomServicio()+"', '"+ser.getDescripcion()+"', '"+ser.getTiempo()+"', '"+ser.getPrecio()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
       return false;
    }

    @Override
    public boolean edit(Servicio ser) {
        String sql="update servicio set nomServicio ='"+ser.getNomServicio()+"', descripcion ='"+ser.getDescripcion()+"', tiempo ='"+ser.getTiempo()+"', precio ='"+ser.getPrecio()+"'where idServicio ="+ser.getIdServicio();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int idServicio) {
        String sql="delete from servicio where idServicio="+idServicio;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
}
