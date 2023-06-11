package Modelo;

public class Tecnico {
        private int idTecnico;
        private String nomTecnico;
        private String apelPat;
        private String apelMat;
        private String dni;
        private String email;
        private String telefono;
        private String estado;

    public Tecnico() {
    }

    public Tecnico(int idTecnico, String nomTecnico, String apelPat, String apelMat, String dni, String email, String telefono, String estado) {
        this.idTecnico = idTecnico;
        this.nomTecnico = nomTecnico;
        this.apelPat = apelPat;
        this.apelMat = apelMat;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
        this.estado = estado;
    }

    public int getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(int idTecnico) {
        this.idTecnico = idTecnico;
    }

    public String getNomTecnico() {
        return nomTecnico;
    }

    public void setNomTecnico(String nomTecnico) {
        this.nomTecnico = nomTecnico;
    }

    public String getApelPat() {
        return apelPat;
    }

    public void setApelPat(String apelPat) {
        this.apelPat = apelPat;
    }

    public String getApelMat() {
        return apelMat;
    }

    public void setApelMat(String apelMat) {
        this.apelMat = apelMat;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
        
        
}
