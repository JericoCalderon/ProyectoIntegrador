package Controlador;

import Modelo.Reserva;
import ModeloDAO.ReservaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControladorReserva", urlPatterns = {"/ControladorReserva"})
public class ControladorReserva extends HttpServlet {
    
        String listar="vistas/vistasReserva/listar.jsp";
        String add="vistas/vistasReserva/add.jsp";
        String edit="vistas/vistasReserva/edit.jsp";
        Reserva r=new Reserva();
        ReservaDAO dao=new ReservaDAO();

       protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorReserva</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorReserva at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acceso="";
        String action=request.getParameter("accion");
        if(action.equalsIgnoreCase("listar")){
            acceso=listar;            
        }
        else if(action.equalsIgnoreCase("add")){
            acceso=add;
        }
        else if(action.equalsIgnoreCase("Agregar")){
            int idPersona= Integer.parseInt( request.getParameter("txtIdPersona"));
            int idServicio= Integer.parseInt( request.getParameter("txtIdServicio"));
            String fechReserva=request.getParameter("txtFechReserva");
            String horaReserva=request.getParameter("txtHoraReserva");
            int idTecnico= Integer.parseInt( request.getParameter("txtIdTecnico"));
            int idTipo= Integer.parseInt( request.getParameter("txtIdTipo"));
            String formaPago=request.getParameter("txtFormaPago");
            String estado=request.getParameter("txtEstado");
            r.setIdPersona(idPersona);
            r.setIdServicio(idServicio);
            r.setFechReserva(fechReserva);
            r.setHoraReserva(horaReserva);
            r.setIdTecnico(idTecnico);
            r.setIdTipo(idTipo);
            r.setFormaPago(formaPago);
            r.setEstado(estado);
            dao.add(r);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idres",request.getParameter("idReserva"));
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            int idReserva = Integer.parseInt(request.getParameter("txtIdReserva"));
            int idPersona= Integer.parseInt( request.getParameter("txtIdPersona"));
            int idServicio= Integer.parseInt( request.getParameter("txtIdServicio"));
            String fechReserva=request.getParameter("txtFechReserva");
            String horaReserva=request.getParameter("txtHoraReserva");
            int idTecnico= Integer.parseInt( request.getParameter("txtIdTecnico"));
            int idTipo= Integer.parseInt( request.getParameter("txtIdTipo"));
            String formaPago=request.getParameter("txtFormaPago");
            String estado=request.getParameter("txtEstado");
            r.setIdReserva(idReserva);
            r.setIdPersona(idPersona);
            r.setIdServicio(idServicio);
            r.setFechReserva(fechReserva);
            r.setHoraReserva(horaReserva);
            r.setIdTecnico(idTecnico);
            r.setIdTipo(idTipo);
            r.setFormaPago(formaPago);
            r.setEstado(estado);
            dao.edit(r);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            int idReserva=Integer.parseInt(request.getParameter("idReserva"));
            r.setIdReserva(idReserva);
            dao.eliminar(idReserva);
            acceso=listar;
            
        }

        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
        processRequest(request, response);
    }

        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
