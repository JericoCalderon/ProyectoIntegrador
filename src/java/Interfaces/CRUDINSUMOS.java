package Interfaces;

import Modelo.Insumos;
import java.util.List;

public interface CRUDINSUMOS {
    
    public List listar();
    public Insumos list(int idInsumo);
    public boolean add(Insumos i);
    public boolean edit(Insumos i);
    public boolean eliminar(int idInsumo);
    
}
