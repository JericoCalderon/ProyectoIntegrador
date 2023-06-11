
<%@page import="Modelo.Servicio"%>
<%@page import="ModeloDAO.ServicioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-6">
              <%
              ServicioDAO dao=new ServicioDAO();
              int idServicio=Integer.parseInt((String)request.getAttribute("idser"));
              Servicio p=(Servicio)dao.list(idServicio);
              %>
            <h1>Modificar Persona</h1>
            <form action="ControladorServicio">
                    Nombre Servicio: <br>
                    <input class="form-control" type="text" name="txtNomServicio" value="<%= p.getNomServicio()%>"><br>
                    Descripción: <br>
                    <input class="form-control" type="text" name="txtDescripcion" value="<%= p.getDescripcion()%>"><br>
                    Tiempo: <br>
                    <input class="form-control" type="text" name="txtTiempo" value="<%= p.getTiempo()%>"><br>
                     Precio: <br>
                    <input class="form-control" type="number" name="txtPrecio" value="<%= p.getPrecio()%>"><br>
                    <input type =" text" name ="txtIdServicio" value="<%= p.getIdServicio()%>" readonly="readonly" >
                    <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                <a href="ControladorServicio?accion=listar">Regresar</a>
            </form>
          </div>
        </div>
    </body>
</html>
