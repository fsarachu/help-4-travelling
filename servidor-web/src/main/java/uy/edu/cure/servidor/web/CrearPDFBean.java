package uy.edu.cure.servidor.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CrearPDFBean implements Serializable {

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
}
