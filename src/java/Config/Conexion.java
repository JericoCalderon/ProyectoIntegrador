
package Config;

import java.sql.*;

public class Conexion {
    Connection con;
    
    public Connection Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/integrador","root","");            
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
        return con;
    }
  }