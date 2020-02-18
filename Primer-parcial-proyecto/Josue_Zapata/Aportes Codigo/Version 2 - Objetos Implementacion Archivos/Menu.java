/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nomina.de.sueldos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import javax.swing.JOptionPane;

/**
 *
 * @author Langas
 */
public class Menu {
    
    int cantidad, aux;
    
    
    public void menu(){
       
        int op;
        
        do{
               
                    
  
             /* System.out.println("\033[34m<<<"+"\033[33mMENU"+"\033[34m>>>");System.out.println(" ");
              System.out.println("\033[37m["+"\033[33m1"+"\033[37m]"+"\033[31m. "+ "\033[37mINGRESE A LA PLATAFORMA");
              System.out.println("\033[37m["+"\033[33m2"+"\033[37m]"+"\033[31m. "+ "\033[37mREGISTRO A LA PLATAFORMA");
              System.out.println("\033[37m["+"\033[33m3"+"\033[37m]"+"\033[31m. "+ "\033[37mUSUARIOS");
              System.out.println("\033[37m["+"\033[33m4"+"\033[37m]"+"\033[31m. "+ "\033[37mSALIR");System.out.println(" ");
            
               System.out.print("\033[37m DIGITE LA OPCION SELECCIONADA: ");
        
                 op = teclado.nextInt();*/
             
               op = Integer.parseInt(JOptionPane.showInputDialog("1. INGRESE DATOS Y VALORES SOLICITADOS/MOSTRAR VITACORA"+"\n"+"2. CERRAR SESION"+"\n"+"3. SALIR"+  "\n\n"  +   "DIGITE LA OPCION: "));
               switch(op){
                   
                   case 1:
                       
                       cantidad = Integer.parseInt(JOptionPane.showInputDialog("DIGITE CANT DE EMPLEADOS: "));
                       Nomina_sueldos Nomina = new Nomina_sueldos(cantidad);
                       
                       try{
              FileWriter Escribir = new FileWriter("cantidad.txt", true);
              PrintWriter Esc = new  PrintWriter(Escribir);
                Esc.println(cantidad);
                Esc.close();
                 
          }catch(Exception err){
              JOptionPane.showMessageDialog(null,"Error no se puedo Crear o Abrir el Archivo");
          }
                       
                       Nomina.InfValoresPersonales();
                       Nomina.Imprimir();
                       
                   case 2:
                           
                       
                      
                   break;
                       
                        
                   
                   case 4:
                   
                   
                   break;
    
                       
               }
               
           }while(op != 3);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
                    
    }
}
