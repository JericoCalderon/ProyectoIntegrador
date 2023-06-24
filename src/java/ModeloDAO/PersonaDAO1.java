package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUD;
import Modelo.Persona;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO1 implements CRUD{
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Persona p=new Persona();
    
    public Persona BuscarCliente(int idPersona){
        Persona persona = new Persona();
        String consulta = "SELECT * FROM persona WHERE idPersona = ? " ;
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(consulta); 
            ps.setInt(1, idPersona);
            rs = ps.executeQuery();
            while(rs.next()){
                persona.setIdPersona(rs.getInt("idPersona"));              
                persona.setNomPersona(rs.getString("nomPersona")); 
                persona.setApelPat(rs.getString("apelPat")); 
                persona.setApelMat(rs.getString("apelMat")); 
                persona.setFechNaci(rs.getString("fechNaci")); 
                persona.setDni(rs.getString("dni"));
                persona.setDireccion(rs.getString("direccion"));
                persona.setTelefono(rs.getString("telefono"));
                persona.setEstado(rs.getString("estado"));
                persona.setEmail(rs.getString("email"));         
                System.err.println(""+persona.getNomPersona());
              }
        } catch (Exception e) {
        }
        return persona;
    }
    @Override
    public List listar() {
        ArrayList<Persona>list=new ArrayList<>();
        String sql="SELECT idPersona, nomPersona, apelPat, apelMat, fechNaci, dni, direccion, telefono, estado, email, idUsuario FROM persona where idUsuario = 1";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Persona per=new Persona();
                per.setIdPersona(rs.getInt("idPersona"));
                per.setNomPersona(rs.getString("nomPersona"));
                per.setApelPat(rs.getString("apelPat"));
                per.setApelMat(rs.getString("apelMat"));
                per.setFechNaci(rs.getString("fechNaci"));
                per.setDni(rs.getString("dni"));
                per.setDireccion(rs.getString("direccion"));
                per.setTelefono(rs.getString("telefono"));
                per.setEstado(rs.getString("estado"));
                per.setEmail(rs.getString("email"));
                per.setIdUsuario(rs.getInt("idUsuario"));
                list.add(per);
            }
        } catch (Exception e) {
        }
        return list;
    }

     @Override
    public Persona list(int idPersona) {
       String sql="SELECT idPersona, nomPersona, apelPat, apelMat, fechNaci, dni, direccion, telefono, estado, email, idUsuario FROM persona where idUsuario = 1 and idPersona =  " + idPersona;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                p.setIdPersona(rs.getInt("idPersona"));
                p.setNomPersona(rs.getString("nomPersona"));
                p.setApelPat(rs.getString("apelPat"));
                p.setApelMat(rs.getString("apelMat"));
                p.setFechNaci(rs.getString("fechNaci"));
                p.setDni(rs.getString("dni"));
                p.setDireccion(rs.getString("direccion"));
                p.setTelefono(rs.getString("telefono"));
                p.setEstado(rs.getString("estado"));
                p.setEmail(rs.getString("email"));
                p.setIdUsuario(rs.getInt("idUsuario"));
            }
        } catch (Exception e) {
        }
        return p;
    }

    @Override
    public boolean add(Persona per) {
       String sql="INSERT INTO persona (nomPersona, apelPat, apelMat, fechNaci, dni, direccion, telefono, estado, email, idUsuario) values ('"+per.getNomPersona()+"' , '"+per.getApelPat()+"' , '"+per.getApelMat()+"', '"+per.getFechNaci()+"', '"+per.getDni()+"', '"+per.getDireccion()+"', '"+per.getTelefono()+"', '"+per.getEstado()+"', '"+per.getEmail()+"', '"+per.getIdUsuario()+"')";
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
    public boolean edit(Persona per) {
        String sql="update persona set nomPersona ='"+per.getNomPersona()+"', apelPat ='"+per.getApelPat()+"', apelMat ='"+per.getApelMat()+"', fechNaci = '"+per.getFechNaci()+"', dni ='"+per.getDni()+"', direccion ='"+per.getDireccion()+"', telefono ='"+per.getTelefono()+"', estado ='"+per.getEstado()+"', email ='"+per.getEmail()+"', idUsuario ='"+per.getIdUsuario()+"'where idPersona ="+per.getIdPersona();
        try {
            con=cn.getConnection();
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
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

}
