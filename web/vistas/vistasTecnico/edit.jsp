
<%@page import="Modelo.Tecnico"%>
<%@page import="ModeloDAO.TecnicoDAO"%>
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
              TecnicoDAO dao=new TecnicoDAO();
              int idTecnico=Integer.parseInt((String)request.getAttribute("idtec"));
              Tecnico p=(Tecnico)dao.list(idTecnico);
              %>
            <h1>Modificar Técnico</h1>
            <form action="ControladorTecnico">
                    Nombre Ténico <br>
                    <input class="form-control" type="text" name="txtNomTecnico" value="<%= p.getNomTecnico()%>"><br>
                    Apellido Paterno: <br>
                    <input class="form-control" type="text" name="txtApelPat" value="<%= p.getApelPat()%>"><br>
                     Apellido Materno: <br>
                    <input class="form-control" type="text" name="txtApelMat" value="<%= p.getApelMat()%>"><br>
                     DNI: <br>
                     <input class="form-control" type="number" name="txtDNI" value="<%= p.getDni()%>" ><br>
                     Email: <br>
                     <input class="form-control" type="email" name="txtEmail" value="<%= p.getEmail()%>"><br>
                    Teléfono: <br>
                    <input class="form-control" type="tel" name="txtTelefono" value="<%= p.getTelefono()%>"><br>
                     Estado <br>
                    <input class="form-control" type="text" name="txtEstado" value="<%= p.getEstado()%>"><br>
                    <input type =" text" name ="txtIdTecnico" value="<%= p.getIdTecnico()%>" readonly="readonly" >
                    <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                <a href="ControladorTecnico?accion=listar">Regresar</a>
            </form>
          </div>
        </div>
    </body>
</html>
