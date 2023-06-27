<%@page import="Modelo.Insumos"%>
<%@page import="ModeloDAO.InsumosDAO"%>
<%@page import="Config.Conexion"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.*"%>
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
            <h1>Insumos</h1>
            <a class="btn btn-success" href="ControladorInsumos?accion=add">Agregar Nuevo Insumo</a>
            <br>
            <br>
            <a class="btn btn-success" href="ControladorInsumos?accion=listar">Mostrar Datos</a>
            <br>
            <br>
            <label>Buscar: </label>
            <input id="searchTerm" type="text" onkeyup="doSearch()" />
            <br>
            <br>
            <table class="table table-bordered" id="datos">
                <thead>
                    <tr>
                        <th class="text-center">INSUMO</th>
                        <th class="text-center">NOMBRE INSUMO</th>
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    InsumosDAO dao = new InsumosDAO();
                    List<Insumos> list = dao.listar();
                    Iterator<Insumos> iter = list.iterator();
                    Insumos ins = null;
                    while (iter.hasNext()) {
                        ins = iter.next();

                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= ins.getIdInsumo()%></td>
                        <td class="text-center"><%= ins.getNomInsumo()%></td>
                        <td class="text-center">
                            <a class="btn btn-warning" href="ControladorInsumos?accion=editar&idInsumo=<%= ins.getIdInsumo()%>" onclick="return confirmarEdicion()">Editar</a>
                            <a class="btn btn-danger" href="ControladorInsumos?accion=eliminar&idInsumo=<%= ins.getIdInsumo()%>" onclick="return confirmarEliminar()">Remove</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
<%
    } else {
        response.sendRedirect("index.jsp");
    }
%>