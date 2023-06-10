
package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUD;
import Modelo.Persona;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO implements CRUD{
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Persona p=new Persona();
    
    public Persona validar(String email, String contrasena) {
        Persona pe = new Persona();
        String sql ="SELECT * FROM persona where email=? and contrasena?";
        try {
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, contrasena);
            rs=ps.executeQuery();
            
            while (rs.next()){
                pe.setEmail(rs.getString("email"));
                pe.setContrasena(rs.getString("contrasena"));
            }
                      
        } catch (Exception e) {
        }
        return pe;
    }
      
    @Override
    public List listar() {
        ArrayList<Persona>list=new ArrayList<>();
        String sql="SELECT idPersona, idRol, nomPersona, apelPat, apelMat, fechNaci, dni, direccion, telefono, estado, email FROM persona";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Persona per=new Persona();
                per.setIdPersona(rs.getInt("idPersona"));
                per.setIdRol(rs.getInt("idRol"));
                per.setNomPersona(rs.getString("nomPersona"));
                per.setApelPat(rs.getString("apelPat"));
                per.setApelMat(rs.getString("apelMat"));
                per.setFechNaci(rs.getString("fechNaci"));
                per.setDni(rs.getString("dni"));
                per.setDireccion(rs.getString("direccion"));
                per.setTelefono(rs.getString("telefono"));
                per.setEstado(rs.getString("estado"));
                per.setEmail(rs.getString("email"));
                list.add(per);
            }
        } catch (Exception e) {
        }
        return list;
    }

     @Override
    public Persona list(int idPersona) {
       String sql="SELECT idPersona, idRol, nomPersona, apelPat, apelMat, fechNaci, dni, direccion, telefono, estado, email FROM persona where idPersona =  " + idPersona;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                p.setIdPersona(rs.getInt("idPersona"));
                p.setIdRol(rs.getInt("idRol"));
                p.setNomPersona(rs.getString("nomPersona"));
                p.setApelPat(rs.getString("apelPat"));
                p.setApelMat(rs.getString("apelMat"));
                p.setFechNaci(rs.getString("fechNaci"));
                p.setDni(rs.getString("dni"));
                p.setDireccion(rs.getString("direccion"));
                p.setTelefono(rs.getString("telefono"));
                p.setEstado(rs.getString("estado"));
                p.setEmail(rs.getString("email"));
                p.setContrasena(rs.getString("contrasena"));
            }
        } catch (Exception e) {
        }
        return p;
    }

    @Override
    public boolean add(Persona per) {
       String sql="INSERT INTO persona (idRol, nomPersona, apelPat, apelMat, fechNaci, dni, direccion, telefono, estado, email, contrasena) values ('"+per.getIdRol()+"', '"+per.getNomPersona()+"' , '"+per.getApelPat()+"' , '"+per.getApelMat()+"', '"+per.getFechNaci()+"', '"+per.getDni()+"', '"+per.getDireccion()+"', '"+per.getTelefono()+"', '"+per.getEstado()+"', '"+per.getEmail()+"', '"+per.getContrasena()+"')";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
       return false;
    }

    @Override
    public boolean edit(Persona per) {
        String sql="update persona set idRol ='"+per.getIdRol()+"', nomPersona ='"+per.getNomPersona()+"', apelPat ='"+per.getApelPat()+"', apelMat ='"+per.getApelMat()+"', fechNaci = '"+per.getFechNaci()+"', dni ='"+per.getDni()+"', direccion ='"+per.getDireccion()+"', telefono ='"+per.getTelefono()+"', estado ='"+per.getEstado()+"', email ='"+per.getEmail()+"'where idPersona ="+per.getIdPersona();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int idPersona) {
        String sql="delete from persona where idPersona="+idPersona;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

}
