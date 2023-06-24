
package Interfaces;

import Modelo.Rol;
import java.util.List;


public interface CRUDROL {
    public List listar();
    public Rol list(int idRol);
    public boolean add(Rol r);
    public boolean edit(Rol r);
    public boolean eliminar(int idRol);
}
