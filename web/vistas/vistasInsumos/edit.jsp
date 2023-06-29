<%@page import="Modelo.Insumos"%>
<%@page import="ModeloDAO.InsumosDAO"%>
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
                    InsumosDAO dao = new InsumosDAO();
                    int idInsumo = Integer.parseInt((String) request.getAttribute("idins"));
                    Insumos i = (Insumos) dao.list(idInsumo);
                %>
                <h1>Modificar Insumo</h1>
                <form action="ControladorInsumos">
                    Insumo: <br>    
                    <input type =" text" name ="txtIdInsumo" value="<%= i.getIdInsumo()%>" readonly="readonly" ><br><br>
                    Nombre Insumo: <br>
                    <input class="form-control" type="text" name="txtNomInsumo" value="<%= i.getNomInsumo()%>"><br>
                    <input class="btn btn-primary" type="submit" name="accion" value="Actualizar" onclick="edicionConfirmada()"> 
                    <a href="ControladorInsumos?accion=listar" onclick="return confirmarRegreso()">Regresar</a>
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