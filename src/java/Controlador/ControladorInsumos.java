package Controlador;

import Modelo.Insumos;
import ModeloDAO.InsumosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControladorInsumos", urlPatterns = {"/ControladorInsumos"})
public class ControladorInsumos extends HttpServlet {

        String listar="vistas/vistasInsumos/listar.jsp";
        String add="vistas/vistasInsumos/add.jsp";
        String edit="vistas/vistasInsumos/edit.jsp";
        Insumos in=new Insumos();
        InsumosDAO dao=new InsumosDAO();
    
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorInsumos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorInsumos at " + request.getContextPath() + "</h1>");
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
            String nomInsumo=request.getParameter("txtNomInsumo");
            in.setNomInsumo(nomInsumo);
            dao.add(in);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idins",request.getParameter("idInsumo"));
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            int idInsumo = Integer.parseInt(request.getParameter("txtIdInsumo"));
            String nomInsumo=request.getParameter("txtNomInsumo");
            in.setIdInsumo(idInsumo);
            in.setNomInsumo(nomInsumo);
            dao.edit(in);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            int idInsumo=Integer.parseInt(request.getParameter("idInsumo"));
            in.setIdInsumo(idInsumo);
            dao.eliminar(idInsumo);
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
