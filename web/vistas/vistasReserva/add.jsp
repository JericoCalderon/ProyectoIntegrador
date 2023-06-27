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
                <h1>Agregar Reserva</h1>
                <form action="ControladorReserva">
                    Cliente: <br>
                    <input class="form-control" type="number" name="txtIdPersona" placeholder="Ingresar el Código del Cliente"><br>
                    Servicio: <br>
                    <input class="form-control" type="number" name="txtIdServicio" placeholder="Ingresar el Código del Servicio"><br>
                    Fecha de Reserva: <br>
                    <input class="form-control" type="date" name="txtFechReserva"><br>
                    Hora de Reserva: <br>
                    <input class="form-control" type="time" name="txtHoraReserva"><br>
                    Técnico: <br>
                    <input class="form-control" type="number" name="txtIdTecnico" placeholder="Ingresar el Código del Técnico"><br>
                    Tipo de Pago: <br>
                    <input class="form-control" type="number" name="txtIdTipo" placeholder="Ingresar el Código del Tipo: 1 = Presencial o  2 = Virtual"><br>
                    Forma de Pago: <br>
                    <input class="form-control" type="text" name="txtFormaPago" placeholder="Ingresar la Forma de Pago según el Tipo de Pago"><br>
                    Estado: <br>
                    <input class="form-control" type="text" name="txtEstado" placeholder="Ingresar Estado: 'Activo'"><br>
                    Sala Atención: <br>
                    <input class="form-control" type="text" name="txtSalaAtencion" placeholder="Ingresar la Sala de Atención"><br>
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar" onclick="confirmarInsersion()">
                    <a href="ControladorReserva?accion=listar" onclick="return confirmarRegreso()">Regresar</a>
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