package Controlador;

import Modelo.Tecnico;
import ModeloDAO.TecnicoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ControladorTecnico", urlPatterns = {"/ControladorTecnico"})
public class ControladorTecnico extends HttpServlet {

        String listar="vistas/vistasTecnico/listar.jsp";
        String add="vistas/vistasTecnico/add.jsp";
        String edit="vistas/vistasTecnico/edit.jsp";
        Tecnico t=new Tecnico();
        TecnicoDAO dao=new TecnicoDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorTecnico</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorTecnico at " + request.getContextPath() + "</h1>");
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
            String nomTecnico=request.getParameter("txtNomTecnico");
            String apelPat=request.getParameter("txtApelPat");
            String apelMat=request.getParameter("txtApelMat");
            String dni=request.getParameter("txtDNI");
            String email=request.getParameter("txtEmail");
            String telefono=request.getParameter("txtTelefono");
            String estado=request.getParameter("txtEstado");
            t.setNomTecnico(nomTecnico);
            t.setApelPat(apelPat);
            t.setApelMat(apelMat);
            t.setDni(dni);
            t.setEmail(email);
            t.setTelefono(telefono);
            t.setEstado(estado);
            dao.add(t);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idtec",request.getParameter("idTecnico"));
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            int idTecnico = Integer.parseInt(request.getParameter("txtIdTecnico"));
            String nomTecnico=request.getParameter("txtNomTecnico");
            String apelPat=request.getParameter("txtApelPat");
            String apelMat=request.getParameter("txtApelMat");
            String dni=request.getParameter("txtDNI");
            String email=request.getParameter("txtEmail");
            String telefono=request.getParameter("txtTelefono");
            String estado=request.getParameter("txtEstado");
            t.setIdTecnico(idTecnico);
            t.setNomTecnico(nomTecnico);
            t.setApelPat(apelPat);
            t.setApelMat(apelMat);
            t.setDni(dni);
            t.setEmail(email);
            t.setTelefono(telefono);
            t.setEstado(estado);
            dao.edit(t);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            int idTecnico=Integer.parseInt(request.getParameter("idTecnico"));
            t.setIdTecnico(idTecnico);
            dao.eliminar(idTecnico);
            acceso=listar;
            
        }

        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
        
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
