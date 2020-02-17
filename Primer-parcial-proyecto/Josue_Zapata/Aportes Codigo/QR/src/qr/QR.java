/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qr;

import com.barcodelib.barcode.QRCode;
import java.awt.Desktop;
import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Langas
 */
public class QR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner entrada = new Scanner(System.in);
        
            String campo = JOptionPane.showInputDialog("Ingrese Texto");
            GenerarQR(campo);
        
    }
    
    public static void GenerarQR(String dato)
    {
        int udm= 0,resolucion=72, rotacion=0;
        float mi=0.000f,md=0.000f,ms=0.000f,min=0.000f,tam=5.00f;
        
        try
        {
            QRCode c = new QRCode();
            c.setData(dato);
            c.setDataMode(QRCode.MODE_BYTE);
            c.setUOM(udm);
            c.setLeftMargin(mi);
            c.setRightMargin(md);
            c.setTopMargin(ms);
            c.setBottomMargin(min);
            c.setResolution(resolucion);
            c.setRotate(rotacion);
            c.setModuleSize(tam);
            
            //Mostrando
            String archivo = System.getProperty("user.home")+"/qrsistemas.gif";
            c.renderBarcode(archivo);
            
            Desktop d = Desktop.getDesktop();
            d.open(new File(archivo));
            
        }catch(Exception e)
        {
            System.out.println("Error " + e);
        }
    }
    
}
