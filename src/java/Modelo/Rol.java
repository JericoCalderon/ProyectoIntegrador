package Modelo;

public class Rol {
    
    private int idRol;
    private String nomRol;

    public Rol() {
    }

    public Rol(int idRol, String nomRol) {
        this.idRol = idRol;
        this.nomRol = nomRol;
    }
    
    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNomRol() {
        return nomRol;
    }

    public void setNomRol(String nomRol) {
        this.nomRol = nomRol;
    }

  
    
}
