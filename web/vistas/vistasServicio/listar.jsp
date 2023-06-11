<%@page import="Config.Conexion"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Servicio"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.*"%>
<%@page import="ModeloDAO.ServicioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <h1>Servicios</h1>
             <a class="btn btn-success" href="ControladorServicio?accion=add">Agregar Nueva Persona</a>
             <br>
             <br>
             <a class="btn btn-success" href="ControladorServicio?accion=listar">Mostrar Datos</a>
            <br>
            <br>
             <label>Buscar: </label>
            <input id="searchTerm" type="text" onkeyup="doSearch()" />
            <br>
            <br>
            <table class="table table-bordered" id="datos">
                <thead>
                    <tr>
                        <th class="text-center">IDServicio</th>
                        <th class="text-center">NOMBRE SERVICIO</th>
                        <th class="text-center">DESCRIPCCIÓN</th>
                        <th class="text-center">TIEMPO</th>
                        <th class="text-center">PRECIO</th>
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    ServicioDAO dao=new ServicioDAO();
                    List<Servicio>list=dao.listar();
                    Iterator<Servicio>iter=list.iterator();
                    Servicio ser=null;
                    while(iter.hasNext()){
                        ser=iter.next();
                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= ser.getIdServicio()%></td>
                        <td class="text-center"><%= ser.getNomServicio()%></td>
                        <td class="text-center"><%= ser.getDescripcion()%></td>
                        <td class="text-center"><%= ser.getTiempo()%></td>
                        <td class="text-center"><%= ser.getPrecio()%></td>
                         <td class="text-center">
                            <a class="btn btn-warning" href="ControladorServicio?accion=editar&idServicio=<%= ser.getIdServicio()%>">Editar</a>
                            <a class="btn btn-danger" href="ControladorServicio?accion=eliminar&idServicio=<%= ser.getIdServicio()%>">Remove</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
    </div>
    </body>
</html>
