<%@page import="Modelo.Persona"%>
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
        <title>JSP Page</title>
        <script type="text/javascript">
            function edicionConfirmada(){
                alert("¡Se editaron los datos correctamente!");
            }
            
            function confirmarRegreso()
            {
                var respuesta = confirm("¿Seguro que quieres regresar al listado de datos?");
                if(respuesta == true) {
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
                    PersonaDAO dao = new PersonaDAO();
                    int idPersona = Integer.parseInt((String) request.getAttribute("idper"));
                    Persona p = (Persona) dao.list(idPersona);
                %>
                <h1>Modificar Administrador</h1>
                <form action="ControladorPersona">
                    Administrador: <br>    
                    <input type =" text" name ="txtIdPersona" value="<%= p.getIdPersona()%>" readonly="readonly" ><br><br>
                    Nombres: <br>
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
                    Estado: <br>
                    <input class="form-control" type="text" name="txtEstado" placeholder="Activo o Inactivo" value="<%= p.getEstado()%>"><br>
                    Email: <br>
                    <input class="form-control" type="email" name="txtEmail" value="<%= p.getEmail()%>"><br>
                    Usuario: <br>
                    <input class="form-control" type="number" name="txtIdUsuario" value="<%= p.getIdUsuario()%>"><br>
                    <input class="btn btn-primary" type="submit" name="accion" value="Actualizar" onclick="edicionConfirmada()"> 
                    <a href="ControladorPersona?accion=listar" onclick="return confirmarRegreso()">Regresar</a>
                </form>
            </div>
        </div>
    </body>
</html>
<%
    } else {
        response.sendRedirect("index.jsp");
    }
%>