<%@page import="Modelo.Servicio"%>
<%@page import="ModeloDAO.ServicioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("usuario") != null) {
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
        <script type="text/javascript">
            function edicionConfirmada() {
                alert("¡Se editaron los datos correctamente!");
            }

            function confirmarRegreso()
            {
                var respuesta = confirm("¿Seguro que quieres regresar al listado de datos?");
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
            <div class="col-lg-6">
                <%
                    ServicioDAO dao = new ServicioDAO();
                    int idServicio = Integer.parseInt((String) request.getAttribute("idser"));
                    Servicio p = (Servicio) dao.list(idServicio);
                %>
                <h1>Modificar Servicio</h1>
                <form action="ControladorServicio">
                    Servicio: <br>
                    <input type =" text" name ="txtIdServicio" value="<%= p.getIdServicio()%>" readonly="readonly" ><br><br>    
                    Nombre Servicio: <br>
                    <input class="form-control" type="text" name="txtNomServicio" value="<%= p.getNomServicio()%>"><br>
                    Descripción: <br>
                    <input class="form-control" type="text" name="txtDescripcion" value="<%= p.getDescripcion()%>"><br>
                    Tiempo: <br>
                    <input class="form-control" type="text" name="txtTiempo" value="<%= p.getTiempo()%>"><br>
                    Precio: <br>
                    <input class="form-control" type="number" name="txtPrecio" value="<%= p.getPrecio()%>"><br>
                    <input class="btn btn-primary" type="submit" name="accion" value="Actualizar" onclick="edicionConfirmada()"> 
                    <a href="ControladorServicio?accion=listar" onclick="return confirmarRegreso()">Regresar</a>
                </form>
            </div>
        </div>
        <script src="js/noBack.js" type="text/javascript"></script>
    </body>
</html>
<%
    } else {
        response.sendRedirect("index.jsp");
    }
%>