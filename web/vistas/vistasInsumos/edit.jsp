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
                    <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                    <a href="ControladorInsumos?accion=listar">Regresar</a>
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