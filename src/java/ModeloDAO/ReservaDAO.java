package ModeloDAO;

import Interfaces.CRUDRESERVA;
import Modelo.Reserva;
import java.util.List;
import Config.Conexion;
import java.sql.*;
import java.util.ArrayList;

public class ReservaDAO implements CRUDRESERVA {

    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Reserva re=new Reserva();
    
    @Override
    public List listar() {
        ArrayList<Reserva>list=new ArrayList<>();
        String sql="SELECT * FROM reserva";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Reserva res=new Reserva();
                res.setIdReserva(rs.getInt("idReserva"));
                res.setIdPersona(rs.getInt("idPersona"));
                res.setIdServicio(rs.getInt("idServicio"));
                res.setFechReserva(rs.getString("fechReserva"));
                res.setHoraReserva(rs.getString("horaReserva"));
                res.setIdTecnico(rs.getInt("idTecnico"));
                res.setIdTipo(rs.getInt("idTipo"));
                res.setFormaPago(rs.getString("formaPago"));
                res.setEstado(rs.getString("estado"));
                list.add(res);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Reserva list(int idReserva) {
         String sql="SELECT * FROM reserva WHERE idReserva= " + idReserva;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                re.setIdReserva(rs.getInt("idReserva"));
                re.setIdPersona(rs.getInt("idPersona"));
                re.setIdServicio(rs.getInt("idServicio"));
                re.setFechReserva(rs.getString("fechReserva"));
                re.setHoraReserva(rs.getString("horaReserva"));
                re.setIdTecnico(rs.getInt("idTecnico"));
                re.setIdTipo(rs.getInt("idTipo"));
                re.setFormaPago(rs.getString("formaPago"));
                re.setEstado(rs.getString("estado"));
            }
        } catch (Exception e) {
        }
        return re;
    }

    @Override
    public boolean add(Reserva res) {

       String sql="INSERT INTO reserva (idPersona, idServicio, fechReserva, horaReserva, idTecnico, idTipo, formaPago, estado) values ('"+res.getIdPersona()+"', '"+res.getIdServicio()+"', '"+res.getFechReserva()+"', '"+res.getHoraReserva()+"', '"+res.getIdTecnico()+"', '"+res.getIdTipo()+"', '"+res.getFormaPago()+"', '"+res.getEstado()+"')";
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
    public boolean edit(Reserva res) {
        String sql="update reserva set idPersona ='"+res.getIdPersona()+"', idServicio ='"+res.getIdServicio()+"', fechReserva ='"+res.getFechReserva()+"', horaReserva ='"+res.getHoraReserva()+"', idTecnico = '"+res.getIdTecnico()+"', idTipo ='"+res.getIdTipo()+"', formaPago ='"+res.getFormaPago()+"', estado ='"+res.getEstado()+"'where idReserva ="+res.getIdReserva();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int idReserva) {
        String sql="delete from reserva where idReserva="+idReserva;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
}
