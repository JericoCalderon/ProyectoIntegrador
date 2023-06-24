package Controlador;

import Modelo.Usuario;
import ModeloDAO.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ControladorUsuario", urlPatterns = {"/ControladorUsuario"})
public class ControladorUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        try {
            if (accion != null) {
                switch (accion) {
                    case "verificar":
                        verificar(request, response);
                        break;
                    case "cerrar":
                        cerrarsession(request, response);
                        break;
                    default:
                        response.sendRedirect("index.jsp");
                }
            } else {
                response.sendRedirect("index.jsp");
            }
        } catch (Exception e) {
            try {

            } catch (Exception ex) {
                System.out.println("Error" + e.getMessage());
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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

    private void verificar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession sesion;
        UsuarioDAO dao;
        Usuario usuario;
        usuario = this.obtenerUsuario(request);
        dao = new UsuarioDAO();
        usuario = dao.identificar(usuario);

        if (usuario != null && usuario.getIdRol().getNomRol().equals("Administrador")) {
            sesion = request.getSession();
            sesion.setAttribute("usuario", usuario);
            this.getServletConfig().getServletContext().getRequestDispatcher("/menuAdministrador.jsp").forward(request, response);
        } else if (usuario != null && usuario.getIdRol().getNomRol().equals("Cliente")) {
            sesion = request.getSession();
            sesion.setAttribute("cliente", usuario);
            this.getServletConfig().getServletContext().getRequestDispatcher("").forward(request, response);
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }

    private void cerrarsession(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession sesion = request.getSession();
        sesion.setAttribute("usuario", null);
        sesion.invalidate();
        response.sendRedirect("index.jsp");
    }

    private Usuario obtenerUsuario(HttpServletRequest request) {
        Usuario u = new Usuario();
        u.setNomUsuario(request.getParameter("txtUsu"));
        u.setContrasena(request.getParameter("txtContra"));
        return u;
    }
}
