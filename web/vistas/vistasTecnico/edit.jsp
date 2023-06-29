<%@page import="Modelo.Tecnico"%>
<%@page import="ModeloDAO.TecnicoDAO"%>
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
                    TecnicoDAO dao = new TecnicoDAO();
                    int idTecnico = Integer.parseInt((String) request.getAttribute("idtec"));
                    Tecnico p = (Tecnico) dao.list(idTecnico);
                %>
                <h1>Modificar Técnico</h1>
                <form action="ControladorTecnico">
                    Ténico: <br>
                    <input type =" text" name ="txtIdTecnico" value="<%= p.getIdTecnico()%>" readonly="readonly" ><br><br>
                    Nombre Ténico: <br>
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
                    Estado: <br>
                    <input class="form-control" type="text" name="txtEstado" placeholder="Activo o Inactivo" value="<%= p.getEstado()%>"><br>
                    <input class="btn btn-primary" type="submit" name="accion" value="Actualizar" onclick="edicionConfirmada()"> 
                    <a href="ControladorTecnico?accion=listar" onclick="return confirmarRegreso()">Regresar</a>
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