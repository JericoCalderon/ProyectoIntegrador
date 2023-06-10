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
    int idComprobante, item, idServicio, idProducto,  idCliente, cantidad;
    String numeroComprobante, descripcionServicio,fecha;
    double precio, subtotal, monto;

    public Comprobante() {
    }

    public Comprobante(int idComprobante, int item,int idServicio, int idCliente, int cantidad, String numeroComprobante, String descripcionServicio, String fecha, double precio, double subtotal, double monto) {
        this.idComprobante = idComprobante;
        this.item = item;
        this.idServicio = idServicio;      
        this.idCliente = idCliente;
        this.cantidad = cantidad;
        this.numeroComprobante = numeroComprobante;
        this.descripcionServicio = descripcionServicio;
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

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
   
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
