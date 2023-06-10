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
                <h1>Agregar Persona</h1>
                <form action="ControladorPersona">
                    ID Rol <br>
                    <input class="form-control" type="number" name="txtIdRol"><br>
                     Nombres <br>
                    <input class="form-control" type="text" name="txtNomPersona"><br>
                    Apellido Paterno: <br>
                    <input class="form-control" type="text" name="txtApelPat"><br>
                     Apellido Materno: <br>
                    <input class="form-control" type="text" name="txtApelMat"><br>
                    Fecha Nacimiento: <br>
                    <input class="form-control" type="date" name="txtFechNacimiento"><br>
                     DNI: <br>
                     <input class="form-control" type="number" name="txtDNI"><br>
                     Dirección: <br>
                    <input class="form-control" type="text" name="txtDireccion"><br>
                    Teléfono: <br>
                    <input class="form-control" type="number" name="txtTelefono"><br>
                     Estado <br>
                    <input class="form-control" type="text" name="txtEstado"><br>
                     Email: <br>
                     <input class="form-control" type="email" name="txtEmail"><br>
                     Contraseña <br>
                     <input class="form-control" type="password" name="txtContrasena"><br>
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    <a href="ControladorPersona?accion=listar">Regresar</a>
                </form>
            </div>

        </div>
    </body>
</html>
