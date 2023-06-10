package Modelo;


public class Persona {
        private int idPersona;
        private int idRol;
        private String nomPersona;
        private String apelPat;
        private String apelMat;
        private String fechNaci;
        private String dni;
        private String direccion;
        private String telefono;
        private String estado;
        private String email;
        private String contrasena;
        

    public Persona() {
    }

    public Persona(int idPersona, int idRol, String nomPersona, String apelPat, String apelMat, String fechNaci, String dni, String direccion, String telefono, String estado, String email, String contrasena) {
        this.idPersona = idPersona;
        this.idRol = idRol;
        this.nomPersona = nomPersona;
        this.apelPat = apelPat;
        this.apelMat = apelMat;
        this.fechNaci = fechNaci;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estado = estado;
        this.email = email;
        this.contrasena = contrasena;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNomPersona() {
        return nomPersona;
    }

    public void setNomPersona(String nomPersona) {
        this.nomPersona = nomPersona;
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

    public String getFechNaci() {
        return fechNaci;
    }

    public void setFechNaci(String fechNaci) {
        this.fechNaci = fechNaci;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

         
}

