package uy.edu.cure.servidor.central.lib.controllers;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import uy.edu.cure.servidor.central.dto.EstadoFactura;
import uy.edu.cure.servidor.central.dto.Factura;
import uy.edu.cure.servidor.central.lib.servicios.FacturaService;
//import uy.edu.cure.servidor.central.lib.servicios.ReservaService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;

public class FacturaController {

    private FacturaService facturaService;
    //private ReservaService reservaService;

    public FacturaController(){
        this.facturaService = ServiceFactory.getFacturaService();
        //this.reservaService = ServiceFactory.getReservaService();
    }

    public void nueva(Factura factura){

        factura.setFecha(new Date());
        factura.setEstado(EstadoFactura.facturada);

        this.facturaService.agregar(-1, factura);
    }

    public File generarPDF(/*Factura factura*/) {
        String sFile = null;
        File file = null;
        try {
            //OutputStream file = new FileOutputStream(new File("C:\\factura.pdf"));

            //sFile = "C:\\Users\\Viviana\\Desktop\\help-4-travelling2\\servidor-web\\src\\main\\webapp\\secured\\factura.pdf";
            sFile = "factura.pdf";
            //sFile = "c:\\factura.pdf";
            file = new File(sFile);
            OutputStream oFile = new FileOutputStream( file );

            Document document = new Document();
            PdfWriter.getInstance(document, oFile);

            document.open();
            document.add(new Paragraph("Hello World, iText"));
            document.add(new Paragraph(new Date().toString()));

            document.close();
            oFile.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }
}
