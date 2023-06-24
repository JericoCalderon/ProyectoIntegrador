package Controlador;

import Modelo.Persona;
import ModeloDAO.PersonaDAO1;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControladorPersona1", urlPatterns = {"/ControladorPersona1"})
public class ControladorPersona1 extends HttpServlet {

        String listar="vistas/vistasPersona1/listar.jsp";
        String add="vistas/vistasPersona1/add.jsp";
        String edit="vistas/vistasPersona1/edit.jsp";
        Persona p=new Persona();
        PersonaDAO1 dao=new PersonaDAO1();
    
    
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
        
        String accion=request.getParameter("accion");
        switch(accion) {
        case "menuAdministrador":
            request.getRequestDispatcher("menuAdministrador.jsp").forward(request, response);
            break;

        default:
            throw new AssertionError();
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
            String nomPersona=request.getParameter("txtNomPersona");
            String apelPat=request.getParameter("txtApelPat");
            String apelMat=request.getParameter("txtApelMat");
            String fechNaci=request.getParameter("txtFechNacimiento");
            String dni=request.getParameter("txtDNI");
            String direccion=request.getParameter("txtDireccion");
            String telefono=request.getParameter("txtTelefono");
            String estado=request.getParameter("txtEstado");
            String email=request.getParameter("txtEmail");
            int idUsuario= Integer.parseInt( request.getParameter("txtIdUsuario"));
            p.setNomPersona(nomPersona);
            p.setApelPat(apelPat);
            p.setApelMat(apelMat);
            p.setFechNaci(fechNaci);
            p.setDni(dni);
            p.setDireccion(direccion);
            p.setTelefono(telefono);
            p.setEstado(estado);
            p.setEmail(email);
            p.setIdUsuario(idUsuario);
            dao.add(p);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idper",request.getParameter("idPersona"));
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            int idPersona = Integer.parseInt(request.getParameter("txtIdPersona"));
            String nomPersona=request.getParameter("txtNomPersona");
            String apelPat=request.getParameter("txtApelPat");
            String apelMat=request.getParameter("txtApelMat");
            String fechNaci=request.getParameter("txtFechNacimiento");
            String dni=request.getParameter("txtDNI");
            String direccion=request.getParameter("txtDireccion");
            String telefono=request.getParameter("txtTelefono");
            String estado=request.getParameter("txtEstado");
            String email=request.getParameter("txtEmail");
            int idUsuario= Integer.parseInt( request.getParameter("txtIdUsuario"));
            p.setIdPersona(idPersona);
            p.setNomPersona(nomPersona);
            p.setApelPat(apelPat);
            p.setApelMat(apelMat);
            p.setFechNaci(fechNaci);
            p.setDni(dni);
            p.setDireccion(direccion);
            p.setTelefono(telefono);
            p.setEstado(estado);
            p.setEmail(email);
            p.setIdUsuario(idUsuario);
            dao.edit(p);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            int idPersona=Integer.parseInt(request.getParameter("idPersona"));
            p.setIdPersona(idPersona);
            dao.eliminar(idPersona);
            acceso=listar;
            
        }

        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }      
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
