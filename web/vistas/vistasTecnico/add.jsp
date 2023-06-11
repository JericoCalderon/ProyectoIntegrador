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
                <h1>Agregar Técnico</h1>
                <form action="ControladorTecnico">
                    Nombre Técnico: <br>
                    <input class="form-control" type="text" name="txtNomTecnico"><br>
                    Apellido Paterno: <br>
                    <input class="form-control" type="text" name="txtApelPat"><br>
                     Apellido Materno: <br>
                    <input class="form-control" type="text" name="txtApelMat"><br>
                     DNI: <br>
                     <input class="form-control" type="number" name="txtDNI"><br>
                     Email: <br>
                     <input class="form-control" type="email" name="txtEmail"><br>
                    Teléfono: <br>
                    <input class="form-control" type="tel" name="txtTelefono"><br>
                     Estado: <br>
                    <input class="form-control" type="text" name="txtEstado"><br>
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    <a href="ControladorTecnico?accion=listar">Regresar</a>
                </form>
            </div>

        </div>
    </body>
</html>