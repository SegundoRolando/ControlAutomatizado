/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.Barcode39;
import com.itextpdf.text.pdf.PdfWriter;
import ec.edu.ups.modelo.Producto;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author srcti
 */
public class Generapdf {
   String n;
    
     public void crear(Producto producto){  
        try {
             Document doc=new Document();
            PdfWriter pdf= PdfWriter.getInstance(doc,new FileOutputStream("C:\\Users\\srcti\\Desktop\\SoftwareLibre\\ControlAutomatizado\\Codigos\\codigo.pdf"));
            doc.open();
            Barcode39 code=new Barcode39();
            code.setCode(producto.getCodigoBarra());
            Image img=code.createImageWithBarcode(pdf.getDirectContent(), BaseColor.BLACK, BaseColor.BLACK);
            
            doc.add(img);
            
            doc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Generapdf.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Generapdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    
}
