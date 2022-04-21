/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import modelo.beans.Notificacion;
import modelo.beans.Usuario;
import modelo.logic.NotificacionLogic;
import modelo.logic.PersonaLogic;
import modelo.logic.UsuarioLogic;

/**
 *
 * @author phraymus
 */
public class Utilities {

    /*INTERFACES DE MENSAJES DE TEXTO
    GC=GENERAR_CODIGO
    PA=PROYECTO_ASIGNADO
    MT=MODULO_TERMINADO
    PT=PROYECTO_TERMINADO
    TT=TAREA_TERMINADA
    
    FIR=FECHA_INICIO_REQUERIMIENTO
    FFR=FECHA_FIN_REQUERIMIENTO
    FIP=FECHA_INICIO_PROYECTO
    FFP=FECHA_FIN_PROYECTO
    
    
     */
 /*INTERFACES DE MENSAJES DE TEXTO*/
    static NotificacionLogic notificacionLogic = new NotificacionLogic();

    static PersonaLogic personaLogic = new PersonaLogic();

    static UsuarioLogic usuarioLogic = new UsuarioLogic();
    static HashMap<String, String> msgTexto = new HashMap<>();

    /*INTERFACES DE MENSAJES DE ASUNTOS CORREO*/
    static HashMap<String, String> msgAsunto = new HashMap<>();

    /*INTERFACES DE MENSAJES DE CORREO*/
    static HashMap<String, String> msgCorreo = new HashMap<>();

    private static void inicializar() {
        //MENSAJES DE TEXTO
        msgTexto.put("GC", "Codigo de seguridad GARZASOFT-PROJECT: ");
        msgTexto.put("PA", "Hola %s, se te ha asignado el proyecto %s por favor revise su cuenta de GARZASOFT-PROYECT para obtener más información.");
        msgTexto.put("MT", "Hola %s, se ha culminado un nuevo modulo del proyecto %s por favor revise su cuenta de GARZASOFT-PROYECT para obtener más información.");
        msgTexto.put("PT", "Hola %s, el proyecto %s ha cambiado su estado a 'TERMINADO', puede ver el avance del proyecto desde su cuenta de GARZASOFT-PROJECT ,por favor revise su cuenta para obtener más información.");
        msgTexto.put("TI", "Hola %s, hoy se inicia la tarea del proyecto de soporte %s, puede ver el avance del proyecto desde su cuenta de GARZASOFT-PROJECT, por favor revise su cuenta para obtener más información.");
        msgTexto.put("TT", "Hola %s, la tarea del proyecto de soporte %s ha culminado, puede ver el avance del proyecto desde su cuenta de GARZASOFT-PROJECT, por favor revise su cuenta para obtener más información.");

        msgTexto.put("FIR", "Hola %s, la fecha para empezar un nuevo requerimiento del proyecto %s empieza hoy, puede ver el avance del proyecto desde su cuenta de GARZASOFT-PROJECT, por favor revise su cuenta para obtener más información.");
        msgTexto.put("FFR", "Hola %s, hoy es el ultimo dia para terminar un requerimiento del proyecto %s, puede ver el avance del proyecto desde su cuenta de GARZASOFT-PROJECT, por favor revise su cuenta para obtener más información.");

        msgTexto.put("FIP", "Hola %s, la fecha para iniciar con el desarrollo del proyecto %s es hoy, puede ver el avance del proyecto desde su cuenta de GARZASOFT-PROJECT, por favor revise su cuenta para obtener más información.");
        msgTexto.put("FFP", "Hola %s, hoy es el ultimo dia para la entrega del proyecto %s, puede ver el avance del proyecto desde su cuenta de GARZASOFT-PROJECT, por favor revise su cuenta para obtener más información.");

        //MENSAJES DE ASUNTO
        msgAsunto.put("PA", "ASIGNACION DE PROYECTO");
        msgAsunto.put("MT", "MODULO TERMINADO");
        msgAsunto.put("PT", "PROYECTO TERMINADO");
        msgAsunto.put("TI", "INICIO DE TAREA");
        msgAsunto.put("TT", "FIN DE TAREA");

        msgAsunto.put("FIR", "FECHA INICIO DE REQUERIMIENTO");
        msgAsunto.put("FFR", "FECHA FIN DE REQUERIMIENTO");

        msgAsunto.put("FIP", "FECHA DE INICIO DE PROYECTO");
        msgAsunto.put("FFP", "FECHA DE FIN DE PROYECTO");

        //MENSAJES DE CORREO
        msgCorreo.put("PA", "Hola %s, se te ha asignado el proyecto %s, en su cuenta de GARZASOFT-PROJECT podrá ver el nuevo proyecto que se la ha asignado junto con todas las indicaciones que debe seguir, por favor revise su cuenta de GARZASOFT-PROYECT para obtener más información.");
        msgCorreo.put("MT", "Hola %s, se ha culminado un nuevo modulo del proyecto %s usted puede verificar el proceso desde la aplicacion web de GARZASOFT-PROJECT, por favor revise su cuenta de GARZASOFT-PROYECT para obtener más información.");
        msgCorreo.put("PT", "Hola %s, el proyecto %s ha cambiado su estado a 'TERMINADO', se recomienda verificar el correcto desarrollo del proyecto, puede ver el avance del proyecto desde su cuenta de GARZASOFT-PROJECT ,por favor revise su cuenta para obtener más información.");
        msgCorreo.put("TI", "Hola %s, hoy se inicia la tarea del proyecto de soporte %s, puede ver el avance del proyecto desde su cuenta de GARZASOFT-PROJECT, por favor revise su cuenta para obtener más información.");
        msgCorreo.put("TT", "Hola %s, la tarea del proyecto de soporte %s ha culminado, puede ver el avance del proyecto desde su cuenta de GARZASOFT-PROJECT, por favor revise su cuenta para obtener más información.");

        msgCorreo.put("FIR", "Hola %s, la fecha para empezar un nuevo requerimiento del proyecto %s empieza hoy, al comenzar el proceso puede indicarnos cambiando el estado a 'En proceso', si usted ya termino el requerimiento puede cambiar el estado a 'TERMINADO', puede ver el avance del proyecto desde su cuenta de GARZASOFT-PROJECT, por favor revise su cuenta para obtener más información.");
        msgCorreo.put("FFR", "Hola %s, hoy es el ultimo dia para terminar un requerimiento del proyecto %s, al finalizar la actividad deberá cambiar el estado del requerimiento a 'TERMINADO', puede ver el avance del proyecto desde su cuenta de GARZASOFT-PROJECT, por favor revise su cuenta para obtener más información.");

        msgCorreo.put("FIP", "Hola %s, la fecha para iniciar con el desarrollo del proyecto %s es hoy,puede gestionar los estados del proyecto y del requerimiento desde GARZASOFT-PROJECT, puede ver el avance del proyecto desde su cuenta de GARZASOFT-PROJECT, por favor revise su cuenta para obtener más información.");
        msgCorreo.put("FFP", "Hola %s, hoy es el ultimo dia para la entrega del proyecto %s, al finalizar la actividad deberá cambiar el estado del proyecto a 'TERMINADO', puede ver el avance del proyecto desde su cuenta de GARZASOFT-PROJECT, por favor revise su cuenta para obtener más información.");

    }

    public static String getURL(String ruta) throws MalformedURLException, IOException {
        URL url = new URL(ruta);
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(url.openStream()));
        } catch (Throwable t) {
        }

        String inputText = "";
        String inputLine = "";

        while ((inputLine = in.readLine()) != null) {
            inputText = inputText + inputLine;
        }
        return inputText;
    }

    public static String getParameter(String cadena) {
        StringBuilder retorno = new StringBuilder(cadena);
        while (retorno.lastIndexOf(" ") != -1) {
            retorno.replace(retorno.lastIndexOf(" "), retorno.lastIndexOf(" ") + 1, "+");
        }
        return String.valueOf(retorno);
    }
    public static final String ACCOUNT_SID = "ACb3351892466f469eee512e19a7af2ed3";
    public static final String AUTH_TOKEN = "8233ffbf232f746059d53ad87ec8be08";

    public static String enviarMensaje(String usuario, String proyecto, String tipo, Timestamp fecha, String correo, String telefono, String color) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        inicializar();
        if (tipo.equals("GC")) {
            String mensaje = "";
            for (int i = 0; i < 6; i++) {
                mensaje += Math.round(Math.random() * 8 + 1);
            }
            Message message = Message.creator(new PhoneNumber("+51" + telefono),
                    new PhoneNumber("+18335800845"), "Codigo de seguridad GARZASOFT-PROJECT: " + mensaje).create();
            message.getSid();
            return mensaje;
        } else {
            try {
                String texto = String.format(msgTexto.get(tipo), usuario, proyecto);
                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                System.out.println("Entro");

                String mensaje = String.format("%s\n"
                        + "========================\n"
                        + "%s\n"
                        + "========================\n"
                        + "Fecha: %s", msgAsunto.get(tipo), texto, formatoFecha.format(new Date(fecha.getTime())));

                System.out.println("Salio");
                Message message = Message.creator(new PhoneNumber("+51" + telefono),
                        new PhoneNumber("+18335800845"), mensaje).create();
                message.getSid();

                enviarCorreo(usuario, proyecto, tipo, fecha, correo, telefono, color);
                return "true";
            } catch (Exception e) {
            }
        }
        return "";
    }

    public static void enviarCorreo(String usuario, String proyecto, String tipo, Timestamp fecha, String correo, String telefono, String color) {

        Properties propiedad = new Properties();
        propiedad.setProperty("mail.smtp.host", "mail.phraymus.com");
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "25");
        propiedad.setProperty("mail.smtp.auth", "true");

        Session sesion = Session.getDefaultInstance(propiedad);
        String correoEnvia = "GarzasoftProject@phraymus.com";
        String contrasena = "GarzasoftProject1234";
        String receptor = correo;
        String asunto = msgAsunto.get(tipo);
        String mensaje = String.format(msgCorreo.get(tipo), usuario, proyecto);

        MimeMessage mail = new MimeMessage(sesion);
        try {
            mail.setFrom(new InternetAddress(correoEnvia));
            mail.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(receptor));
            mail.setSubject(asunto);
            mail.setText(mensaje);

            Transport transportar = sesion.getTransport("smtp");
            transportar.connect(correoEnvia, contrasena);
            transportar.sendMessage(mail, mail.getRecipients(javax.mail.Message.RecipientType.TO));
            transportar.close();

            Usuario usuarioEncontrado = usuarioLogic.buscar(usuarioLogic.buscar(usuario));
            Notificacion notificacion = new Notificacion(0, usuarioEncontrado.getIdtb_usuario(), tipo, msgAsunto.get(tipo), msgCorreo.get(tipo), tipo, color, fecha);
            
            notificacionLogic.insertar(notificacion);
            System.out.println("Listo, revise su correo");

        } catch (AddressException ex) {
            System.out.println(ex);
        } catch (MessagingException ex) {
            System.out.println(ex);
        }
    }
}
