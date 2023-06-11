package Interfaces;

import Modelo.Reserva;
import java.util.List;

public interface CRUDRESERVA {
    
    public List listar();
    public Reserva list(int idReserva);
    public boolean add(Reserva res);
    public boolean edit(Reserva res);
    public boolean eliminar(int idReserva);
    
}
