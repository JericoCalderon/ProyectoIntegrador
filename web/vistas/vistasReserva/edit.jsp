
<%@page import="Modelo.Reserva"%>
<%@page import="ModeloDAO.ReservaDAO"%>
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
              <%
              ReservaDAO dao=new ReservaDAO();
              int idReserva=Integer.parseInt((String)request.getAttribute("idres"));
              Reserva r=(Reserva)dao.list(idReserva);
              %>
            <h1>Modificar Reserva</h1>
            <form action="ControladorReserva">
                     ID Persona: <br>
                    <input class="form-control" type="number" name="txtIdPersona" value="<%= r.getIdPersona()%>"><br>
                     ID Servicio: <br>
                    <input class="form-control"  type="number" name="txtIdServicio" value="<%= r.getIdServicio()%>"><br>
                    Fecha Reserva: <br>
                    <input class="form-control" type="date" name="txtFechReserva"value="<%= r.getFechReserva()%>"><br>
                     Hora Reserva: <br>
                    <input class="form-control" type="time" name="txtHoraReserva" value="<%= r.getHoraReserva()%>"><br>
                     ID Técnico: <br>
                    <input class="form-control" type="number" name="txtIdTecnico" value="<%= r.getIdTecnico()%>"><br>
                     ID Tipo: <br>
                     <input class="form-control" type="number" name="txtIdTipo" value="<%= r.getIdTipo()%>" ><br>
                     Forma de Pago: <br>
                    <input class="form-control" type="text" name="txtFormaPago" value="<%= r.getFormaPago()%>"><br>
                    Estado: <br>
                    <input class="form-control" type="text" name="txtEstado" value="<%= r.getEstado()%>"><br>
                    <input type =" text" name ="txtIdReserva" value="<%= r.getIdReserva()%>" readonly="readonly" >
                    <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                <a href="ControladorReserva?accion=listar">Regresar</a>
            </form>
          </div>
        </div>
    </body>
</html>
