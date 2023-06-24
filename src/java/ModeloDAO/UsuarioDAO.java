package ModeloDAO;

import Config.Conexion;
import Modelo.Rol;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UsuarioDAO extends Conexion {

    public Usuario identificar(Usuario user) throws Exception {
        Usuario usu = null;
        Conexion con;
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "SELECT U.idUsuario, R.nomRol FROM usuario U "
                + "INNER JOIN rol R ON U.idRol = R.idRol "
                + "WHERE U.estado = 1 and U.nomUsuario = '" + user.getNomUsuario() + "' "
                + "AND U.contrasena = '" + user.getContrasena() + " ' ";
        con = new Conexion();
        try {
            cn = con.getConnection();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next() == true) {
                usu = new Usuario();
                usu.setIdUsuario(rs.getInt("idUsuario"));
                usu.setNomUsuario(user.getNomUsuario());
                usu.setIdRol(new Rol());
                usu.getIdRol().setNomRol(rs.getString("nomRol"));
            }
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        } finally {
            if (rs != null && rs.isClosed() == false) {
                rs.close();
            }
            rs = null;
            if (st != null && st.isClosed() == false) {
                st.close();

            }
            st = null;
            if (cn != null & cn.isClosed() == false) {
                cn.close();

            }
            cn = null;
        }
        return usu;
    }

}
