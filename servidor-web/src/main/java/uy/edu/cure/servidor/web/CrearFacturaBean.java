package uy.edu.cure.servidor.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.lib.controllers.RestController;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CrearFacturaBean implements Serializable {

    @ManagedProperty("loginClienteBean")
    private LoginClienteBean loginClienteBean;
    @ManagedProperty("reservaBean")
    private ReservaBean reservaBean;

    public static void nuevaFactura (){
        try {
            //OutputStream file = new FileOutputStream(new File("C:\\factura.pdf"));
            OutputStream file = new FileOutputStream(new File("C:\\Users\\Viviana\\Desktop\\help-4-travelling2\\servidor-web\\src\\main\\webapp\\secured\\factura.pdf"));


            Document document = new Document();
            PdfWriter.getInstance(document, file);

            document.open();
            document.add(new Paragraph("Hello World, iText"));
            document.add(new Paragraph(new Date().toString()));

            document.close();
            file.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    public void guardarFactura() {
        obtenerRest(loginClienteBean.getCliente().getId());
    }

    public Cliente obtenerRest(Integer cliente) {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/cliente/obtener/" + cliente;
        RestController rest = new RestController();
        Cliente u = rest.doGET(url, Cliente.class);
        return u;
    }


    public LoginClienteBean getLoginClienteBean() {
        return loginClienteBean;
    }

    public void setLoginClienteBean(LoginClienteBean loginClienteBean) {
        this.loginClienteBean = loginClienteBean;
    }

    public ReservaBean getReservaBean() {
        return reservaBean;
    }

    public void setReservaBean(ReservaBean reservaBean) {
        this.reservaBean = reservaBean;
    }
}
