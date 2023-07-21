package Controlador;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author PC-USER
 */
import java.io.File;
import java.io.FileOutputStream;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException; 
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "MiServlet", urlPatterns = {"/MiServlet"})
@MultipartConfig
public class MiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              
        // Recuperar el archivo adjunto del formulario
        Part filePart = request.getPart("archivo");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        InputStream fileContent = filePart.getInputStream();

        // Recuperar los valores del formulario
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        String destinatario = request.getParameter("destinatario");
        String mensaje = request.getParameter("mensaje");

        // Configurar la conexión SMTP
        String host = "smtp.gmail.com";
        String port = "465";
        String username = "sgarden123456@gmail.com";
        String password = "rlkmujrjwlzlgnzv";

        // Crear una nueva instancia de Properties
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");

        // Autenticar al usuario y construir la sesión de correo
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Crear el mensaje de correo
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject("Contacto desde nuestra web");
            message.setText("De: " + nombre + "\nCorreo: " + correo + "\nTelefono: " + telefono + "\nMensaje: " + mensaje);
            


            // Cuerpo del mensaje
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("De: " + nombre + "\nCorreo: " + correo + "\nTelefono: " + telefono + "\nMensaje: " + mensaje);
            // Parte del archivo adjunto
             MimeBodyPart attachmentBodyPart = new MimeBodyPart();
            attachmentBodyPart.attachFile(convert(filePart));
             // Combinar texto y archivo adjunto
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentBodyPart);
            
             // Establecer el contenido del mensaje como el cuerpo combinado
            message.setContent(multipart);

            // Enviar el mensaje de correo
            Transport.send(message); 

            // Redirigir a una página de confirmación
            response.sendRedirect("mensaje-de-envio.jsp");
        } catch (MessagingException e) {
            e.printStackTrace();
            // Manejar el error en caso de que falle el envío del correo
            response.getWriter().println("Hubo un error al enviar el correo. Por favor, inténtalo de nuevo.");
        }
    }
    private File convert(Part filePart) throws IOException {
     String tempDirectory = System.getProperty("java.io.tmpdir");
     String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

     // Verificar que el archivo sea un PDF (opcional) 
     if (!fileName.endsWith(".pdf")) {
         throw new IllegalArgumentException("El archivo seleccionado no es un PDF.");
     }

     File file = new File(tempDirectory, fileName);

     // Guardar el contenido del Part en el archivo
     try (InputStream inputStream = filePart.getInputStream();
          FileOutputStream outputStream = new FileOutputStream(file)) {
         byte[] buffer = new byte[1024];
         int bytesRead;
         while ((bytesRead = inputStream.read(buffer)) != -1) {
             outputStream.write(buffer, 0, bytesRead);
         }
     }

     return file;
 }
    
}