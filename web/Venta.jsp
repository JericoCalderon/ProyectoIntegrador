<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Locale"%>

<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
        <title>Spa UTP</title>
        <style>
            @media print{
                .seccion1, .btn, .accion{
                    display:none;
                }
            }
        </style> 
    </head>
    <body>
        <div class="row">
            <div class="col-md-12 seccion1">
                <div class="card">
                    
                    <div class="card-body">
                        <form method="post" action="Controlador?menu=Ventas">
                             <div class="row">
                                <div class="col-md-3 d-flex">
                                    <input type="number" name="idPersona" class="form-control" placeholder="id cliente" value="${cliente.getIdPersona()}">
                                    <input type="submit" name="accion" value="BuscarPersona" class="btn btn-outline-dark">
                                </div> 
                                <div class="col-md-3 d-flex">
                                    <input type="text" name="nomPersona" class="form-control" placeholder="Nombre cliente" value="${cliente.getNomPersona()}">
                                </div>
                                <div class="col-md-3 d-flex">
                                    <input type="text" name="apelPat" class="form-control" placeholder="ApellidoP cliente" value="${cliente.getApelPat()}">
                                </div>
                                <div class="col-md-3 d-flex">
                                    <input type="text" name="apelMat" class="form-control" placeholder="ApellidoM cliente" value="${cliente.getApelMat()}">
                                </div>
                            </div>
                            <div class="row"></div>

                        </form>
                    </div>
                </div> 
                <div class="card">
                    <h5 class="card-header">Datos Servicio</h5>
                    <div class="card-body">
                        <form action="Controlador?menu=Ventas" method="post">
                            <div class="row"> 
                                <div class="col-md-5 d-flex form-group">
                                    <input type="number" name="idServicio" class="form-control" placeholder="IDServicio" value="${servicio.getIdServicio()}">
                                    <input type="submit" name="accion" value="BuscarServicio" class="btn btn-outline-dark">
                                </div>
                                <div class="col-md-8 d-flex form-group">
                                    <input type="text" name="nomServicio" class="form-control" placeholder="Nombre Servicio" value="${servicio.getNomServicio()}">
                                </div>
                                  <div class="col-md-8 d-flex form-group">
                                    <textarea style="height: 100px; overflow: auto;" name="descripcion" class="form-control" placeholder="descripcion">${servicio.getDescripcion()}</textarea>
                                </div>
                                  <div class="col-md-8 d-flex form-group">
                                    <input type="text" name="tiempo" class="form-control" placeholder="tiempo" value="${servicio.getTiempo()}">
                                </div>
                                <div class="col-md-4 d-flex form-group">
                                    <input type="text" name="precio" class="form-control" placeholder="s/ 0000.00" value="${servicio.getPrecio()}">
                                </div> 
                                <div class="col-md-8 d-flex form-group">
                                    <input type="number" value="" name="cantidad" id="cantidad" class="form-control" placeholder="Cantidad">                           
                                </div>
                               
                            </div> 
                                
                            <input type="submit" name="accion" value="AgregarServicio" class="btn btn-outline-dark">
                            <div class="row"></div>

                        </form>
                    </div>
                </div>
            </div>
            <div class="col-md-12">
                <div class="card">
                   
                    <div class="card-body">
                    <table id="tablaVentas" class="table">
                    <thead class="thead-light">
                        <tr> 
                            <th scope="col">#</th>
                            <th scope="col">IDServicio</th>    
                            <th scope="col">NombreServicio</th> 
                            <th scope="col">Descripcion</th>  
                            <th scope="col">Tiempo</th>
                            <th scope="col">Fecha</th>
                            <th scope="col">Cantidad</th>
                            <th scope="col">Precio</th> 
                            <th scope="col">Total</th>
                            <th scope="col" class="accion">Acciones</th>
                          
                        </tr>  
                    </thead>
                    <tbody> 
                   
                       <c:forEach var="lista" items="${listaventas}"> 
                        <tr>
                             <th scope="row" style="width: 30px;">${lista.getItem()}</th>
                            <th style="width: 30px;">${lista.getIdServicio()}</th>  
                            <td style="width: 250px;">${lista.getNomServicio()}</td>
                            <td style="width: 350px;">${lista.getDescripcionServicio()}</td>   
                            <td style="width: 30px;">${lista.getTiempo()}</td>
                            <td style="width: 110px;">${lista.getFecha()}</td>   
                            <td style="width: 30px;">${lista.getCantidad()}</td>
                            <td>S/ ${lista.getPrecio()}</td>
                            <td>S/ ${lista.getSubtotal()}</td>
                            <td class="columna">
                                 
                            <input type="hidden" id="item2" value="${lista.getIdServicio()}">
                            <a id="deleteItem" href="#" class="btn"><i class="fas fa-trash-alt"></i></a>          
                                                               
                            </td>
                        </tr>
                        </c:forEach> 

                       </tbody>
                </table>
                    </div>
                    <div class="card-footer d-flex">
                        <div class="col-md-8 text-center">
                            <a class="btn btn-outline-dark" onclick="window.print()" href="Controlador?menu=Ventas&accion=GenerarVenta">Generar Venta</a>
                            <a class="btn btn-outline-dark" href="Controlador?menu=Venta&accion=NuevaVenta">Nueva Venta</a>
                          
                        </div>
                        <div class="col-md-4">
                            <input type=text" name="txttotalapagar" class="form-control" placeholder="s/00.000.00" disabled="disabled" value="S/ ${totalapagar}">
                         </div>
                    </div>
                    
                </div>

            </div>
        </div>

        <!-- Optional JavaScript; choose one of the two! -->

        <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

        <!-- Option 2: jQuery, Popper.js, and Bootstrap JS
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
        -->
    </body>
</html>
