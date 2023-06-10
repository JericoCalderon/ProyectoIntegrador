
<%@page import="Modelo.Persona"%>
<%@page import="ModeloDAO.PersonaDAO"%>
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
              PersonaDAO dao=new PersonaDAO();
              int idPersona=Integer.parseInt((String)request.getAttribute("idper"));
              Persona p=(Persona)dao.list(idPersona);
              %>
            <h1>Modificar Persona</h1>
            <form action="ControladorPersona">
                    ID Rol <br>
                    <input class="form-control" type="number" name="txtIdRol" value="<%= p.getIdRol()%>"><br>
                     Nombres <br>
                    <input class="form-control" type="text" name="txtNomPersona" value="<%= p.getNomPersona()%>"><br>
                    Apellido Paterno: <br>
                    <input class="form-control" type="text" name="txtApelPat" value="<%= p.getApelPat()%>"><br>
                     Apellido Materno: <br>
                    <input class="form-control" type="text" name="txtApelMat" value="<%= p.getApelMat()%>"><br>
                    Fecha Nacimiento: <br>
                    <input class="form-control" type="date" name="txtFechNacimiento" value="<%= p.getFechNaci()%>"><br>
                     DNI: <br>
                     <input class="form-control" type="number" name="txtDNI" value="<%= p.getDni()%>" ><br>
                     Dirección: <br>
                    <input class="form-control" type="text" name="txtDireccion" value="<%= p.getDireccion()%>"><br>
                    Teléfono: <br>
                    <input class="form-control" type="number" name="txtTelefono" value="<%= p.getTelefono()%>"><br>
                     Estado <br>
                    <input class="form-control" type="text" name="txtEstado" value="<%= p.getEstado()%>"><br>
                     Email: <br>
                     <input class="form-control" type="email" name="txtEmail" value="<%= p.getEmail()%>"><br>
                    <input type =" text" name ="txtIdPersona" value="<%= p.getIdPersona()%>" readonly="readonly" >
                    <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                <a href="ControladorPersona?accion=listar">Regresar</a>
            </form>
          </div>
        </div>
    </body>
</html>
