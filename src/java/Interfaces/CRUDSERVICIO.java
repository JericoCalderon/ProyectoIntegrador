package Interfaces;

import Modelo.Servicio;
import java.util.List;


public interface CRUDSERVICIO {
    public List listar();
    public Servicio list(int idServicio);
    public boolean add(Servicio ser);
    public boolean edit(Servicio ser);
    public boolean eliminar(int idServicio);
}
