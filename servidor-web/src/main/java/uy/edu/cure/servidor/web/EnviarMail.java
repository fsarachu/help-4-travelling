package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.Factura;
import uy.edu.cure.servidor.central.dto.Reserva;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;


public class EnviarMail {
    private Date fecha;

    public EnviarMail() {
    }


    public void envio(Factura factura) {
        try {

            String url = "http://localhost:8080/servidor-central-webapp/rest/api/reserva/obtener/"+factura.getId();
            RestController rest = new RestController();
            Reserva u = rest.doGET(url, Reserva.class);

            // Propiedades de la conexión

            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "helpfortravelling@gmail.com");
            props.setProperty("mail.smtp.auth", "true");

            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);

            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("helpfortravelling@gmail.com"));
            message.addRecipient(
                    Message.RecipientType.TO,
                    new InternetAddress("tricovictor@gmail.com"));
/*
            message.addRecipient(
                    Message.RecipientType.TO,
                    new InternetAddress(u.getCliente().getCorreo()));
*/
            message.setSubject("[help4Travelling] ["+fecha+"]");
            message.setText(
                    "Estimado "+u.getCliente().getNombre()+". Su compra ha sido facturada con exito: <br>"+
            "<b>Detalles de la compra</b><b>Servicios: </b>"+
            "Nombre" + u.getCarrito().getItems().get(0).getProducto().getNombre()+"  Cantidad: "+
                            u.getCarrito().getItems().get(0).getCantidad()+ "Proveedor: " +
            u.getCarrito().getItems().get(0).getProducto().getProveedor().getNombreEmpresa() +
                    "Gracias por Preferirnos<br>Saludos </br> <br>help4Travelling</br>","ISO-8859-1","html");

            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect("helpfortravelling@gmail.com", "aplicacion");
            t.sendMessage(message, message.getAllRecipients());

            // Cierre.
            t.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}