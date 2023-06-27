<%@page import="Config.Conexion"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Reserva"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.*"%>
<%@page import="ModeloDAO.ReservaDAO"%>
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
            <h1>Reservas</h1>
             <a class="btn btn-success" href="ControladorReserva?accion=add">Agregar Nueva Reserva</a>
             <br>
             <br>
             <a class="btn btn-success" href="ControladorReserva?accion=listar">Mostrar Datos</a>
            <br>
            <br>
             <label>Buscar: </label>
            <input id="searchTerm" type="text" onkeyup="doSearch()" />
            <br>
            <br>
            <table class="table table-bordered" id="datos">
                <thead>
                    <tr>
                        <th class="text-center">RESERVA</th>
                        <th class="text-center">CLIENTE</th>
                        <th class="text-center">SERVICIO</th>
                        <th class="text-center">FECHA RESERVA</th>
                        <th class="text-center">HORA RESERVA</th>
                        <th class="text-center">TÉCNICO</th>
                        <th class="text-center">TIPO DE PAGO</th>
                        <th class="text-center">FORMA DE PAGO</th>
                        <th class="text-center">ESTADO</th>
                        <th class="text-center">SALA ATENCIÓN</th>
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    ReservaDAO dao=new ReservaDAO();
                    List<Reserva>list=dao.listar();
                    Iterator<Reserva>iter=list.iterator();
                    Reserva res=null;
                    while(iter.hasNext()){
                        res=iter.next();
                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= res.getIdReserva()%></td>
                        <td class="text-center"><%= res.getIdPersona()%></td>
                        <td class="text-center"><%= res.getIdServicio()%></td>
                        <td class="text-center"><%= res.getFechReserva()%></td>
                        <td class="text-center"><%= res.getHoraReserva()%></td>
                        <td class="text-center"><%= res.getIdTecnico()%></td>
                        <td class="text-center"><%= res.getIdTipo()%></td>
                        <td class="text-center"><%= res.getFormaPago()%></td>
                        <td class="text-center"><%= res.getEstado()%></td>
                        <td class="text-center"><%= res.getSalaAtencion()%></td>
                         <td class="text-center">
                             <a class="btn btn-warning" href="ControladorReserva?accion=editar&idReserva=<%= res.getIdReserva()%>" onclick="return confirmarEdicion()">Editar</a>
                            <a class="btn btn-danger" href="ControladorReserva?accion=eliminar&idReserva=<%= res.getIdReserva()%>" onclick="return confirmarEliminar()">Remove</a>
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