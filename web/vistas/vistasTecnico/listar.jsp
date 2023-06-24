<%@page import="Config.Conexion"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Tecnico"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.*"%>
<%@page import="ModeloDAO.TecnicoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
if(session.getAttribute("usuario") != null)
{
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="js/BuscadorTabla.js" type="text/javascript"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <h1>Personas</h1>
             <a class="btn btn-success" href="ControladorTecnico?accion=add">Agregar Nuevo Técnico</a>
             <br>
             <br>
             <a class="btn btn-success" href="ControladorTecnico?accion=listar">Mostrar Datos</a>
            <br>
            <br>
             <label>Buscar: </label>
            <input id="searchTerm" type="text" onkeyup="doSearch()" />
            <br>
            <br>
            <table class="table table-bordered" id="datos">
                <thead>
                    <tr>
                        <th class="text-center">TÉCNICO</th>
                        <th class="text-center">NOMBRES</th>
                        <th class="text-center">APELLIDO PATERNO</th>
                        <th class="text-center">APELLIDO MATERNO</th>
                        <th class="text-center">DNI</th>
                        <th class="text-center">EMAIL</th>
                        <th class="text-center">TELÉFONO</th>
                        <th class="text-center">ESTADO</th>
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    TecnicoDAO dao=new TecnicoDAO();
                    List<Tecnico>list=dao.listar();
                    Iterator<Tecnico>iter=list.iterator();
                    Tecnico tec=null;
                    while(iter.hasNext()){
                        tec=iter.next();
                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= tec.getIdTecnico()%></td>
                        <td class="text-center"><%= tec.getNomTecnico()%></td>
                        <td class="text-center"><%= tec.getApelPat()%></td>
                        <td class="text-center"><%= tec.getApelMat()%></td>
                        <td class="text-center"><%= tec.getDni()%></td>
                        <td class="text-center"><%= tec.getEmail()%></td>
                        <td class="text-center"><%= tec.getTelefono()%></td>
                        <td class="text-center"><%= tec.getEstado()%></td>
                         <td class="text-center">
                            <a class="btn btn-warning" href="ControladorTecnico?accion=editar&idTecnico=<%= tec.getIdTecnico()%>">Editar</a>
                            <a class="btn btn-danger" href="ControladorTecnico?accion=eliminar&idTecnico=<%= tec.getIdTecnico()%>">Remove</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
    </div>
    </body>
</html>
<%
    }else{
        response.sendRedirect("index.jsp");
    }
%>