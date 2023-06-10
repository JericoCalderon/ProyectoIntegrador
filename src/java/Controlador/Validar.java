package Controlador;

import Modelo.Persona;
import ModeloDAO.PersonaDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Validar extends HttpServlet {

    Persona p=new Persona();
    PersonaDAO dao =new PersonaDAO();
        
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

       @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               
        String accion=request.getParameter("accion");
        if(accion.equalsIgnoreCase("Ingresar"))
        {
            String email=request.getParameter("txtEmail");
            String  pass=request.getParameter("txtContra");
            p=dao.validar(email, pass);
            if(p.getEmail() != null)
            {
                request.getRequestDispatcher("ControladorPersona?accion=menuAdministrador").forward(request, response);
            } else{
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
