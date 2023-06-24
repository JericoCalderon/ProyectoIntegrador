package Modelo;

public class Reserva {
    
        private int idReserva;
        private int idPersona;
        private int idServicio;
        private String fechReserva;
        private String horaReserva;
        private int idTecnico;
        private int idTipo;
        private String formaPago;
        private String estado;
        private String salaAtencion;

        public Reserva() {
        }

    public Reserva(int idReserva, int idPersona, int idServicio, String fechReserva, String horaReserva, int idTecnico, int idTipo, String formaPago, String estado, String salaAtencion) {
        this.idReserva = idReserva;
        this.idPersona = idPersona;
        this.idServicio = idServicio;
        this.fechReserva = fechReserva;
        this.horaReserva = horaReserva;
        this.idTecnico = idTecnico;
        this.idTipo = idTipo;
        this.formaPago = formaPago;
        this.estado = estado;
        this.salaAtencion = salaAtencion;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getFechReserva() {
        return fechReserva;
    }

    public void setFechReserva(String fechReserva) {
        this.fechReserva = fechReserva;
    }

    public String getHoraReserva() {
        return horaReserva;
    }

    public void setHoraReserva(String horaReserva) {
        this.horaReserva = horaReserva;
    }

    public int getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(int idTecnico) {
        this.idTecnico = idTecnico;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSalaAtencion() {
        return salaAtencion;
    }

    public void setSalaAtencion(String salaAtencion) {
        this.salaAtencion = salaAtencion;
    }
        
}
