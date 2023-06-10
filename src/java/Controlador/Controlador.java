/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import Modelo.Comprobante;
import ModeloDAO.ComprobanteDAO;

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

    Comprobante venta = new Comprobante();
    int item, codServicio, precio, cantidad;
    String descripcion;
    double subtotal, totalapagar = 0;
    
    List<Comprobante> listaVentas = new ArrayList();
    ComprobanteDAO ventaDAO = new ComprobanteDAO();
    int numcomp = 0;
    NumberFormat formatoNumero1;
    String total1;
    
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
                case "BuscarCliente":
                  
                    break;

                case "BuscarServicio":
                   int codigoServicio = Integer.parseInt(request.getParameter("codigoservicio"));
                    //producto = productoDAO.ConsultaPorCodigo(codigoServicio);
                   // request.setAttribute("servicioseleccionado", servicio);
                    //request.setAttribute("cliente", usuario);
                    for (int i = 0; i < listaVentas.size(); i++) {
                        totalapagar += listaVentas.get(i).getSubtotal();
                    }
                    formatoNumero1 = NumberFormat.getNumberInstance();
                    total1 = formatoNumero1.format(totalapagar);
                    request.setAttribute("totalapagar", total1);
                    request.setAttribute("listaventas", listaVentas);
                    break;
                  

                case "AgregarProducto":
                    totalapagar = 0;
                    venta = new Comprobante();
                    item++;
                    codServicio = Integer.parseInt(request.getParameter("codigoServicio"));
                    descripcion = request.getParameter("nombreservicio");
                    precio = Integer.parseInt(request.getParameter("precioservicio"));
                    cantidad = Integer.parseInt(request.getParameter("cantidad"));
                    subtotal = precio * cantidad;
                    venta.setItem(item);
                    venta.setDescripcionServicio(descripcion);
                    venta.setCantidad(cantidad);
                    venta.setPrecio(precio);
                    venta.setSubtotal(subtotal);                  
                    venta.setIdCliente(item); 
                    venta.setIdComprobante(codServicio);
                    listaVentas.add(venta);
                    System.err.println("error venta");
                    request.setAttribute("listaventas", listaVentas);
                    for (int i = 0; i < listaVentas.size(); i++) {
                        totalapagar += listaVentas.get(i).getSubtotal();
                    }
                    formatoNumero1 = NumberFormat.getNumberInstance();
                    total1 = formatoNumero1.format(totalapagar);
                    request.setAttribute("totalapagar", total1);
                    break;
                    
                case "GenerarVenta":
                    
                    venta.setIdCliente(1);
                    venta.setNumeroComprobante("" + numcomp);
                    venta.setFecha("2023-06-10");
                    venta.setMonto(totalapagar);                   
                    ventaDAO.RegistrarVenta(venta);
                    int idv = ventaDAO.ObtenerMaximoIdVentas();
                    for (int i = 0; i < listaVentas.size(); i++) {
                        venta = new Comprobante();
                        venta.setIdComprobante(idv);
                        venta.setIdServicio(listaVentas.get(i).getIdServicio());
                        venta.setCantidad(listaVentas.get(i).getCantidad());
                        venta.setPrecio(listaVentas.get(i).getPrecio());
                        ventaDAO.GuardarDetalleVenta(venta);
                    }

                    break;
                case "Eliminar":
                    item = Integer.parseInt(request.getParameter("idVenta"));
                    ventaDAO.Eliminar(item);
                    request.getRequestDispatcher("Controlador?menu=Venta&accion=default").forward(request, response);
             
 
                default:
                    String comprobante = ventaDAO.numeroComprobante();
                    System.err.println("nume comprobante" + comprobante);
                    if (comprobante == null) {
                        comprobante = "1";
                    } else {
                        numcomp = Integer.parseInt(comprobante) + 1;
                    }

                    request.setAttribute("numeroComprobante", numcomp);

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

