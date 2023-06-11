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
                <h1>Agregar Servicio</h1>
                <form action="ControladorServicio">
                    Nombre Servicio: <br>
                    <input class="form-control" type="text" name="txtNomServicio"><br>
                     Descripción: <br>
                    <input class="form-control" type="text" name="txtDescripcion"><br>
                     Tiempo: <br>
                    <input class="form-control" type="text" name="txtTiempo"><br>
                     Precio: <br>
                     <input class="form-control" type="number" name="txtPrecio"><br>
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    <a href="ControladorServicio?accion=listar">Regresar</a>
                </form>
            </div>

        </div>
    </body>
</html>