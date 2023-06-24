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
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-6">
                <h1>Agregar Técnico</h1>
                <form action="ControladorTecnico">
                    Nombre Técnico: <br>
                    <input class="form-control" type="text" name="txtNomTecnico" placeholder="Ingresar el Nombre Completo"><br>
                    Apellido Paterno: <br>
                    <input class="form-control" type="text" name="txtApelPat" placeholder="Ingresar el Apellido Paterno"><br>
                     Apellido Materno: <br>
                    <input class="form-control" type="text" name="txtApelMat" placeholder="Ingresar el Apellido Materno"><br>
                     DNI: <br>
                     <input class="form-control" type="number" name="txtDNI" placeholder="Ingresar el DNI"><br>
                     Email: <br>
                     <input class="form-control" type="email" name="txtEmail" placeholder="Ingresar el Email"><br>
                    Teléfono: <br>
                    <input class="form-control" type="tel" name="txtTelefono" placeholder="Ingresar el Teléfono"><br>
                     Estado: <br>
                    <input class="form-control" type="text" name="txtEstado" placeholder="Ingresar Estado: 'Activo'"><br>
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    <a href="ControladorTecnico?accion=listar">Regresar</a>
                </form>
            </div>

        </div>
    </body>
</html>
<%
    }else{
        response.sendRedirect("index.jsp");
    }
%>