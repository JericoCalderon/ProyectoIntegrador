package Interfaces;

import Modelo.Tecnico;
import java.util.List;


public interface CRUDTECNICO {
    
     public List listar();
    public Tecnico list(int idTecnico);
    public boolean add(Tecnico tec);
    public boolean edit(Tecnico tec);
    public boolean eliminar(int idTecnico);
    
    
}
