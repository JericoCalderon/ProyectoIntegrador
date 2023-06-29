<%@page import="Config.Conexion"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Persona"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.*"%>
<%@page import="ModeloDAO.PersonaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("usuario") != null) {
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="js/BuscadorTabla.js" type="text/javascript"></script>
        <title>JSP Page</title>
        <script type="text/javascript">
            function confirmarEliminar()
            {
                var respuesta = confirm("¿Estás seguro que desees eliminar el registro?");
                if (respuesta == true) {
                    return true;
                } else {
                    return false;
                }
            }

            function confirmarEdicion()
            {
                var respuesta = confirm("¿Estás seguro que desees editar el registro?");
                if (respuesta == true) {
                    return true;
                } else {
                    return false;
                }
            }
        </script>
    </head>
    <body>
        <div class="container">
            <h1>Administradores</h1>
            <a class="btn btn-success" href="ControladorPersona?accion=add">Agregar Nuevo Administrador</a>
            <br>
            <br>
            <a class="btn btn-success" href="ControladorPersona?accion=listar">Mostrar Datos</a>
            <br>
            <br>
            <label>Buscar: </label>
            <input id="searchTerm" type="text" onkeyup="doSearch()" />
            <br>
            <br>
            <table class="table table-bordered" id="datos">
                <thead>
                    <tr>
                        <th class="text-center">ADMINISTRADOR</th>
                        <th class="text-center">NOMBRES</th>
                        <th class="text-center">APELLIDO PATERNO</th>
                        <th class="text-center">APELLIDO MATERNO</th>
                        <th class="text-center">FECHA NACIMIENTO</th>
                        <th class="text-center">DNI</th>
                        <th class="text-center">DIRECCION</th>
                        <th class="text-center">TELÉFONO</th>
                        <th class="text-center">ESTADO</th>
                        <th class="text-center">EMAIL</th>
                        <th class="text-center">USUARIO</th>
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    PersonaDAO dao = new PersonaDAO();
                    List<Persona> list = dao.listar();
                    Iterator<Persona> iter = list.iterator();
                    Persona per = null;
                    while (iter.hasNext()) {
                        per = iter.next();

                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= per.getIdPersona()%></td>
                        <td class="text-center"><%= per.getNomPersona()%></td>
                        <td class="text-center"><%= per.getApelPat()%></td>
                        <td class="text-center"><%= per.getApelMat()%></td>
                        <td class="text-center"><%= per.getFechNaci()%></td>
                        <td class="text-center"><%= per.getDni()%></td>
                        <td class="text-center"><%= per.getDireccion()%></td>
                        <td class="text-center"><%= per.getTelefono()%></td>
                        <td class="text-center"><%= per.getEstado()%></td>
                        <td class="text-center"><%= per.getEmail()%></td>
                        <td class="text-center"><%= per.getIdUsuario()%></td>
                        <td class="text-center">
                            <a class="btn btn-warning" href="ControladorPersona?accion=editar&idPersona=<%= per.getIdPersona()%>" onclick="return confirmarEdicion()">Editar</a>
                            <a class="btn btn-danger" href="ControladorPersona?accion=eliminar&idPersona=<%= per.getIdPersona()%>" onclick="return confirmarEliminar()">Remove</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
        <script src="js/noBack.js" type="text/javascript"></script>
    </body>
</html>
<%
    } else {
        response.sendRedirect("index.jsp");
    }
%>