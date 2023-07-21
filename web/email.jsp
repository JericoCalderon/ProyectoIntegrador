<%-- 
    Document   : enviar
    Created on : 18 jul. 2023, 12:12:10
    Author     : PC-USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Formulario de contacto</title>
         
        <link rel="stylesheet" href="css/estilos.css">
        <link rel="stylesheet" href="css/font-awesome.css">

        <script src="js/jquery-3.2.1.js"></script>
        <script src="js/script.js"></script>
    </head>
    <body>
        <section class="form_wrap">

        <section class="cantact_info">
            <section class="info_title">
                
                <h2>SPA<br>UTP</h2>
            </section>
            <section class="info_items">
                <strong>Correo electrónico:</strong> spautp.contact@gmail.com<br>
                <strong>Teléfono de contacto:</strong> 956285476
            </section>
        </section>
 
        <form action="MiServlet" method="post" class="form_contact" enctype="multipart/form-data">
            <h2>Envia un mensaje</h2>
            <div class="user_info">
                <label for="names">Nombre</label>
                <input type="text" id="names" name="nombre" required value="Administrador SPA UTP">

                <label for="phone">Telefono / Celular</label>
                <input type="text" id="phone" name="telefono" value="956285476" >

                <label for="email">Correo electronico *</label>
                <input type="text" id="email" name="correo" required value="sgarden123456@gmail.com">
                              
                <label for="destinatario">Destinatario *</label>
                <input type="text" id="destinatario" name="destinatario" required >
                
                <label for="mensaje">Mensaje *</label>
                <textarea id="mensaje" name="mensaje" required >Le escribo para informarle que su registro de cita ha sido exitosamente registrado en nuestro sistema.Agradecemos su preferencia.Nuestro equipo estara listo para atenderlo(a) y brindarle el mejor servicio posible.Si tiene alguna pregunta o necesita realizar algun cambio en su cita, por favor no dude en comunicarse con nosotros.Esperamos poder brindarle una experiencia satisfactoria durante su visita.Estamos a su disposicion para cualquier consulta adicional.
Atentamente,
[Administrador SPA UTP]</textarea>
                
                 <label for="archivo">Enviar Archivo</label>
                <input type="file" id="archivo" name="archivo">

                <input type="submit" value="Enviar Mensaje" id="btnSend">
            </div>
        </form>
    </section>
    </body>
</html>
