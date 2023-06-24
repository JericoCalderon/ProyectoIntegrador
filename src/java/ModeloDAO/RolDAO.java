package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUDROL;
import java.sql.Connection;
import Modelo.Rol;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RolDAO implements CRUDROL {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Rol r = new Rol();

    @Override
    public List listar() {
        ArrayList<Rol> list = new ArrayList<>();
        String sql = "SELECT * FROM rol";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Rol r = new Rol();
                r.setIdRol(rs.getInt("idRol"));
                r.setNomRol(rs.getString("nomRol"));
                list.add(r);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Rol list(int idRol) {
        String sql = "SELECT * FROM rol where idRol =" + idRol;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                r.setIdRol(rs.getInt("idRol"));
                r.setNomRol(rs.getString("nomRol"));
            }
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public boolean add(Rol r) {
        String sql = "INSERT INTO rol(idRol, nomRol) VALUES ('" + r.getIdRol() + "','" + r.getNomRol() + "')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return false;
    }

    @Override
    public boolean edit(Rol r) {
        String sql = "UPDATE rol SET nomRol='" + r.getNomRol() + "' WHERE idRol='" + r.getIdRol() + "'";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int idRol) {
        String sql = "delete from rol where idRol=" + idRol;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
  
}
