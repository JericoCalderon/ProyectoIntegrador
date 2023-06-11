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
                <h1>Agregar Reserva</h1>
                <form action="ControladorReserva">
                    ID Persona: <br>
                    <input class="form-control" type="number" name="txtIdPersona"><br>
                     ID Servicio: <br>
                     <input class="form-control" type="number" name="txtIdServicio"><br>
                    Fecha Reserva: <br>
                    <input class="form-control" type="date" name="txtFechReserva"><br>
                     Hora Reserva: <br>
                     <input class="form-control" type="time" name="txtHoraReserva"><br>
                    ID Técnico: <br>
                    <input class="form-control" type="number" name="txtIdTecnico"><br>
                     ID Tipo: <br>
                     <input class="form-control" type="number" name="txtIdTipo"><br>
                     Forma de Pago: <br>
                    <input class="form-control" type="text" name="txtFormaPago"><br>
                    Estado: <br>
                    <input class="form-control" type="text" name="txtEstado"><br>
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    <a href="ControladorReserva?accion=listar">Regresar</a>
                </form>
            </div>

        </div>
    </body>
</html>