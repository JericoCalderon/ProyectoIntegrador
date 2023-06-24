package Modelo;

public class Usuario {
    
    private int idUsuario;
    private String nomUsuario;
    private String contrasena;
    private boolean estado;
    private Rol idRol;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nomUsuario, String contrasena, boolean estado, Rol idRol) {
        this.idUsuario = idUsuario;
        this.nomUsuario = nomUsuario;
        this.contrasena = contrasena;
        this.estado = estado;
        this.idRol = idRol;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Rol getIdRol() {
        return idRol;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
    }

    
    
}
