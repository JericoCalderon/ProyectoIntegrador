<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("usuario") != null) {
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <title>Inicio</title>
        <script type="text/javascript">
            function confirmarCerrarSesion()
            {
                var respuesta = confirm("¿Estás seguro que desea cerrar la sesión?");
                if (respuesta == true) {
                    return true;
                } else {
                    return false;
                }
            }
        </script>
    </head>
    <body>    
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="menuAdministrador.jsp">SPA UTP</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="nav-link active"  href="ControladorPersona?accion=listar" target="miContenedor">Administradores</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="nav-link active"  href="ControladorPersona1?accion=listar" target="miContenedor">Clientes</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="nav-link active" href="ControladorReserva?accion=listar" target="miContenedor">Reservas</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="nav-link active" href="ControladorServicio?accion=listar" target="miContenedor">Servicios</a>
                    </li>          
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="nav-link active" href="ControladorTecnico?accion=listar" target="miContenedor">Técnicos</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="nav-link active" href="ControladorInsumos?accion=listar" target="miContenedor">Insumos</a>
                    </li>
                    <div class="btn-group">  
                        <button type="button" class="nav-link btn btn-link" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="border: none; color: black;  text-decoration: none;">Reportes</button>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="ControladorServicio?accion=reporte1">Reporte de Servicios</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="ControladorServicio?accion=reporte2">Reporte de Servicios por Cliente</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="ControladorServicio?accion=reporte3">Resumen de Servicios por Ténico</a>
                        </div>
                    </div>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="nav-link active" href="Controlador?menu=Venta&accion=default" target="miContenedor">Comprobantes</a>
                    </li>            
                </ul>
                <div class="btn-group" style="position: absolute; left: 1700px;">  
                    <button type="button" class="nav-link dropdown-toggle btn btn-link position-static" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="border: none; color: black;  text-decoration: none;">
                        Bienvenido, ${usuario.nomUsuario}
                    </button>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="#"><i class="fas fa-user"></i> -->  ${usuario.idUsuario} - ${usuario.nomUsuario}</a>
                        <div class="dropdown-divider"></div>
                        <div class="pull-right">
                            <a href="ControladorUsuario?accion=cerrar" class="btn btn-default btn-flat" onclick="return confirmarCerrarSesion()">Cerrar Session</a>
                        </div>
                    </div>
                </div>
            </div>
        </nav> 

        <div class="m-0" style="height:800px;">
            <iframe name="miContenedor" style="height:100%; width:100%;  border: none;" ></iframe>
        </div>
        <section style="position: fixed; top: 0; left: 0; width: 100%; height: 100%; z-index: -1; overflow: hidden;">
            <img src="img/fondospa.jpg" style="width: 100%; height: 100%;" alt="Fondo de pantalla">
        </section>                

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
        <script src="js/noBack.js" type="text/javascript"></script>
    </body>
</html>
<%
    } else {
        response.sendRedirect("index.jsp");
    }
%>