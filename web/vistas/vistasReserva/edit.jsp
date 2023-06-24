<%@page import="Modelo.Reserva"%>
<%@page import="ModeloDAO.ReservaDAO"%>
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
              <%
              ReservaDAO dao=new ReservaDAO();
              int idReserva=Integer.parseInt((String)request.getAttribute("idres"));
              Reserva r=(Reserva)dao.list(idReserva);
              %>
            <h1>Modificar Reserva</h1>
            <form action="ControladorReserva">
                    Reserva: <br>
                    <input type =" text" name ="txtIdReserva" value="<%= r.getIdReserva()%>" readonly="readonly" ><br><br>
                    Cliente: <br>
                    <input class="form-control" type="number" name="txtIdPersona" value="<%= r.getIdPersona()%>"><br>
                     Servicio: <br>
                    <input class="form-control"  type="number" name="txtIdServicio" value="<%= r.getIdServicio()%>"><br>
                    Fecha deReserva: <br>
                    <input class="form-control" type="date" name="txtFechReserva"value="<%= r.getFechReserva()%>"><br>
                     Hora de Reserva: <br>
                    <input class="form-control" type="time" name="txtHoraReserva" value="<%= r.getHoraReserva()%>"><br>
                     Técnico: <br>
                    <input class="form-control" type="number" name="txtIdTecnico" value="<%= r.getIdTecnico()%>"><br>
                     Tipo de Pago: <br>
                     <input class="form-control" type="number" name="txtIdTipo" value="<%= r.getIdTipo()%>" ><br>
                     Forma de Pago: <br>
                    <input class="form-control" type="text" name="txtFormaPago" value="<%= r.getFormaPago()%>"><br>
                    Estado: <br>
                    <input class="form-control" type="text" name="txtEstado" value="<%= r.getEstado()%>"><br>
                    Sala Atención: <br>
                    <input class="form-control" type="text" name="txtSalaAtencion" value="<%= r.getSalaAtencion()%>"><br>
                    <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                <a href="ControladorReserva?accion=listar">Regresar</a>
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