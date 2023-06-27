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
            function confirmarInsersion(){
                alert("¡Se agregaron los datos correctamente!");
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
                <h1>Agregar Insumo</h1>
                <form action="ControladorInsumos">
                    Nombre Insumo: <br>
                    <input class="form-control" type="text" name="txtNomInsumo" placeholder="Ingresar el Nombre del Insumo"><br>
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar" onclick="confirmarInsersion()">
                    <a href="ControladorInsumos?accion=listar" onclick="return confirmarRegreso()">Regresar</a>
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