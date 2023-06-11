package Modelo;

public class TipoPago {
    
    private int idTipo;
    private String nomTipo;
    private String descripcion;

    public TipoPago() {
    }

    public TipoPago(int idTipo, String nomTipo, String descripcion) {
        this.idTipo = idTipo;
        this.nomTipo = nomTipo;
        this.descripcion = descripcion;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getNomTipo() {
        return nomTipo;
    }

    public void setNomTipo(String nomTipo) {
        this.nomTipo = nomTipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
