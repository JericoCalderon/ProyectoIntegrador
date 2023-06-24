package ModeloDAO;

import Interfaces.CRUDTECNICO;
import Modelo.Tecnico;
import java.util.List;
import Config.Conexion;
import java.sql.*;
import java.util.ArrayList;

public class TecnicoDAO implements CRUDTECNICO {

    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Tecnico te=new Tecnico();
    
    
    @Override
    public List listar() {
        
        ArrayList<Tecnico>list=new ArrayList<>();
        String sql="SELECT * FROM tecnico";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Tecnico tec=new Tecnico();
                tec.setIdTecnico(rs.getInt("idTecnico"));
                tec.setNomTecnico(rs.getString("nomTecnico"));
                tec.setApelPat(rs.getString("apelPat"));
                tec.setApelMat(rs.getString("apelMat"));
                tec.setDni(rs.getString("dni"));
                tec.setEmail(rs.getString("email"));
                tec.setTelefono(rs.getString("telefono"));
                tec.setEstado(rs.getString("estado"));
                list.add(tec);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Tecnico list(int idTecnico) {
        
        String sql="SELECT * FROM tecnico WHERE idTecnico= " + idTecnico;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                te.setIdTecnico(rs.getInt("idTecnico"));
                te.setNomTecnico(rs.getString("nomTecnico"));
                te.setApelPat(rs.getString("apelPat"));
                te.setApelMat(rs.getString("apelMat"));
                te.setDni(rs.getString("dni"));
                te.setEmail(rs.getString("email"));
                te.setTelefono(rs.getString("telefono"));
                te.setEstado(rs.getString("estado"));
            }
        } catch (Exception e) {
        }
        return te;
        
    }

    @Override
    public boolean add(Tecnico tec) {
        
        String sql="INSERT INTO tecnico (nomTecnico, apelPat, apelMat, dni, email, telefono, estado) values ('"+tec.getNomTecnico()+"', '"+tec.getApelPat()+"', '"+tec.getApelMat()+"', '"+tec.getDni()+"', '"+tec.getEmail()+"', '"+tec.getTelefono()+"', '"+tec.getEstado()+"')";
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
    public boolean edit(Tecnico tec) {
        
        String sql="update tecnico set nomTecnico ='"+tec.getNomTecnico()+"', apelPat ='"+tec.getApelPat()+"', apelMat ='"+tec.getApelMat()+"', dni ='"+tec.getDni()+"', email ='"+tec.getEmail()+"', telefono ='"+tec.getTelefono()+"', estado ='"+tec.getEstado()+"'where idTecnico ="+tec.getIdTecnico();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int idTecnico) {
        String sql="delete from tecnico where idTecnico="+idTecnico;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
}
