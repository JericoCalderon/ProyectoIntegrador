/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author PC-USER
 */
public class Comprobante {
    int idComprobante, item, idServicio, cantidad, idReserva;
    String numeroComprobante, descripcionServicio,fecha, nomServicio, tiempo; 
    double precio, subtotal, monto;

    public Comprobante() {
    }

    public Comprobante(int idComprobante, int item,int idServicio, int cantidad, int idReserva, String numeroComprobante, String descripcionServicio, String fecha, String nomServicio, String tiempo, double precio, double subtotal, double monto) {
        this.idComprobante = idComprobante;
        this.item = item;
        this.idServicio = idServicio;             
        this.cantidad = cantidad;
        this.idReserva = idReserva;
        this.numeroComprobante = numeroComprobante;
        this.descripcionServicio = descripcionServicio;
        this.nomServicio = nomServicio;
        this.tiempo = tiempo;
        this.fecha = fecha;    
        this.precio = precio;
        this.subtotal = subtotal;
        this.monto = monto;
    }

    public int getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(int idComprobante) {
        this.idComprobante = idComprobante;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }
  
       public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }
    

    public String getNumeroComprobante() {
        return numeroComprobante;
    }

    public void setNumeroComprobante(String numeroComprobante) {
        this.numeroComprobante = numeroComprobante;
    }

    public String getDescripcionServicio() {
        return descripcionServicio;
    }

    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }

    public String getNomServicio() {
        return nomServicio;
    }

    public void setNomServicio(String nomServicio) {
        this.nomServicio = nomServicio;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }
    
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getMonto() {
        return monto;
    }
 
    public void setMonto(double monto) {
        this.monto = monto;
    }    
}
