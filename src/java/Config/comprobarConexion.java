package Config;

public class comprobarConexion {
public static void main(String[] args){
        Conexion c = new Conexion();
        if(c.Conexion()!= null){
            System.out.println("conexion es correcta");
        }else{
            System.out.println("conexion erronea");
        }
    }
    
}
