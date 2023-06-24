package Controlador;

import Modelo.Servicio;
import ModeloDAO.ServicioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControladorServicio", urlPatterns = {"/ControladorServicio"})
public class ControladorServicio extends HttpServlet {

    
        String listar="vistas/vistasServicio/listar.jsp";
        String add="vistas/vistasServicio/add.jsp";
        String edit="vistas/vistasServicio/edit.jsp";
        Servicio s=new Servicio();
        ServicioDAO dao=new ServicioDAO();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorServicio</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorServicio at " + request.getContextPath() + "</h1>");
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
            String nomServicio=request.getParameter("txtNomServicio");
            String descripcion=request.getParameter("txtDescripcion");
            String tiempo=request.getParameter("txtTiempo");
            Double precio= Double.valueOf(request.getParameter("txtPrecio"));
            s.setNomServicio(nomServicio);
            s.setDescripcion(descripcion);
            s.setTiempo(tiempo);
            s.setPrecio(precio);
            dao.add(s);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idser",request.getParameter("idServicio"));
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            int idServicio = Integer.parseInt(request.getParameter("txtIdServicio"));
            String nomServicio=request.getParameter("txtNomServicio");
            String descripcion=request.getParameter("txtDescripcion");
            String tiempo=request.getParameter("txtTiempo");
            Double precio= Double.valueOf(request.getParameter("txtPrecio"));
            s.setIdServicio(idServicio);
            s.setNomServicio(nomServicio);
            s.setDescripcion(descripcion);
            s.setTiempo(tiempo);
            s.setPrecio(precio);
            dao.edit(s);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            int idServicio=Integer.parseInt(request.getParameter("idServicio"));
            s.setIdServicio(idServicio);
            dao.eliminar(idServicio);
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
