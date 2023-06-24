package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUDINSUMOS;
import Modelo.Insumos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InsumosDAO implements CRUDINSUMOS{
     Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Insumos in=new Insumos();

    @Override
    public List listar() {
       ArrayList<Insumos>list=new ArrayList<>();
        String sql="SELECT * FROM insumos";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Insumos ins=new Insumos();
                ins.setIdInsumo(rs.getInt("idInsumo"));
                ins.setNomInsumo(rs.getString("nomInsumo"));
                list.add(ins);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Insumos list(int idInsumo) {
        String sql="SELECT * FROM insumos where idInsumo =" + idInsumo;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                in.setIdInsumo(rs.getInt("idInsumo"));
                in.setNomInsumo(rs.getString("nomInsumo"));
            }
        } catch (Exception e) {
        }
        return in;
        
    }

    @Override
    public boolean add(Insumos i) {
        String sql="INSERT INTO insumos (nomInsumo) values ('"+i.getNomInsumo()+"')";
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
    public boolean edit(Insumos i) {
       String sql="update insumos set nomInsumo ='"+i.getNomInsumo()+"'where idInsumo ="+i.getIdInsumo();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
        
    }

    @Override
    public boolean eliminar(int idInsumo) {
        String sql="delete from insumos where idInsumo= "+idInsumo;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
}
