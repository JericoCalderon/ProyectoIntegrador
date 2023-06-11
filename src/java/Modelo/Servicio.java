package Modelo;

public class Servicio {
    
        private int idServicio;
        private String nomServicio;
        private String descripcion;
        private String tiempo;
        private Double precio;

    public Servicio() {
    }

    public Servicio(int idServicio, String nomServicio, String descripcion, String tiempo, Double precio) {
        this.idServicio = idServicio;
        this.nomServicio = nomServicio;
        this.descripcion = descripcion;
        this.tiempo = tiempo;
        this.precio = precio;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getNomServicio() {
        return nomServicio;
    }

    public void setNomServicio(String nomServicio) {
        this.nomServicio = nomServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
        
    
}
