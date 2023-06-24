/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import Config.Fecha;
import Modelo.Comprobante;
import Modelo.Persona;
import Modelo.Servicio;
import ModeloDAO.ComprobanteDAO;
import ModeloDAO.PersonaDAO;
import ModeloDAO.PersonaDAO1;
import ModeloDAO.ServicioDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author PC-USER
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    Persona persona = new Persona();
    PersonaDAO1 personaDAO = new PersonaDAO1();
    int idUsuario;
    
    Servicio servicio = new Servicio();
    ServicioDAO servicioDAO = new ServicioDAO();
  
    
    Comprobante comprobante = new Comprobante();
    int item, codServicio,  cantidad;
    double precio;
    String descripcion, nomServicio, tiempo;
    double subtotal, totalapagar = 0;
    Fecha fechaSistem = new Fecha();
    
    
    List<Comprobante> listaVentas = new ArrayList();
    ComprobanteDAO ventaDAO = new ComprobanteDAO();
    int numcomp = 0;
    NumberFormat formatoNumero1;
    String total1;
      int coServicio = 0;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
       String menu = request.getParameter("menu");
       String accion = request.getParameter("accion");  
        if (menu.equals("Venta")) {
            request.getRequestDispatcher("Venta.jsp").forward(request, response);
        }
        
        if (menu.equals("Ventas")) {
            switch (accion) {
                case "BuscarPersona":                 
                    int idPersona = Integer.parseInt(request.getParameter("idPersona"));
                    persona = personaDAO.BuscarCliente(idPersona);
                    request.setAttribute("cliente", persona);
                    break;                  
                    
                case "BuscarServicio":
                   int idServicio = Integer.parseInt(request.getParameter("idServicio"));
                    servicio = servicioDAO.ConsultaPorId(idServicio);
                    request.setAttribute("servicio", servicio); 
                    request.setAttribute("cliente", persona); 
                    for (int i = 0; i < listaVentas.size(); i++) {
                        totalapagar += listaVentas.get(i).getSubtotal();
                    }
                    formatoNumero1 = NumberFormat.getNumberInstance();
                    total1 = formatoNumero1.format(totalapagar);
                    request.setAttribute("totalapagar", total1);
                    request.setAttribute("listaventas", listaVentas);
                    break;
                  case "Eliminar":
                 
                    coServicio = Integer.parseInt(request.getParameter("idServicio"));
                    if (listaVentas != null) {
                        for (int j = 0; j < listaVentas.size(); j++) {
                            if (listaVentas.get(j).getIdServicio()== coServicio) {
                                listaVentas.remove(j);
                            }
                        }
                    }
                break; 

                case "AgregarServicio":
                    totalapagar = 0;
                    comprobante = new Comprobante();
                    item++; 
                    codServicio = Integer.parseInt(request.getParameter("idServicio"));    
                    nomServicio = request.getParameter("nomServicio"); 
                    descripcion = request.getParameter("descripcion");   
                    tiempo = request.getParameter("tiempo"); 
                    precio = Double.parseDouble(request.getParameter("precio"));
                    cantidad = Integer.parseInt(request.getParameter("cantidad"));
                    subtotal = precio * cantidad;
                    comprobante.setItem(item);       
                    comprobante.setNomServicio(nomServicio);
                    comprobante.setDescripcionServicio(descripcion);
                    comprobante.setCantidad(cantidad); 
                    comprobante.setTiempo(tiempo);
                    comprobante.setPrecio(precio);
                    comprobante.setSubtotal(subtotal);                               
                    comprobante.setIdServicio(codServicio); 
                    listaVentas.add(comprobante); 
                    System.err.println("error venta");
                    request.setAttribute("listaventas", listaVentas);
                    for (int i = 0; i < listaVentas.size(); i++) {
                        totalapagar += listaVentas.get(i).getSubtotal();
                    }
                    formatoNumero1 = NumberFormat.getNumberInstance();
                    total1 = formatoNumero1.format(totalapagar);
                    request.setAttribute("totalapagar", total1);
                               
                case "GenerarVenta":
                            
                    comprobante.setNumeroComprobante("" + numcomp);
                    comprobante.setFecha(fechaSistem.FechaBD());
                    comprobante.setMonto(totalapagar);                   
                    ventaDAO.RegistrarVenta(comprobante);
                    int idv = ventaDAO.ObtenerMaximoIdVentas();
                    for (int i = 0; i < listaVentas.size(); i++) {
                        comprobante = new Comprobante();
                        comprobante.setIdComprobante(idv);
                        comprobante.setIdServicio(listaVentas.get(i).getIdServicio());
                        comprobante.setIdReserva(listaVentas.get(i).getIdServicio());
                        comprobante.setCantidad(listaVentas.get(i).getCantidad());
                        comprobante.setPrecio(listaVentas.get(i).getPrecio());
                        ventaDAO.GuardarDetalleVenta(comprobante);
                    }
                case "Actualizar":
                    Servicio servicio1 = new Servicio();
                  /*
                    //int idServici = Integer.parseInt(request.getParameter("txtIdServicio"));
                    String nomServicio=request.getParameter("txtNomServicio");
                    String descripcion=request.getParameter("txtDescripcion");
                    String tiempo=request.getParameter("txtTiempo");
                    Double precio= Double.valueOf(request.getParameter("txtPrecio"));
                   // servicio1.setIdServicio(idServici);
                    servicio1.setNomServicio(nomServicio);
                    servicio1.setDescripcion(descripcion);
                    servicio1.setTiempo(tiempo);
                    servicio1.setPrecio(precio);
                    servicioDAO.edit(servicio1);
                    request.getRequestDispatcher("ControladorServicio?accion=listar").forward(request, response);
                    break;
                    */            
                          
            }
            request.getRequestDispatcher("Venta.jsp").forward(request, response);
        }

    }
     // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    } 

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

