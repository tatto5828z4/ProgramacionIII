/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectonomina;

//import java.util.Scanner;
import javax.swing.JOptionPane;


/**
 *
 * @author jorgi
 */
public class Main {
   

        public static void main(String[] args) {
        
      Login User = new Login();
     
      
      
                      
       //canner teclado = new Scanner (System.in);
      int op = 0;
         
           int cantidad;
           do{
               
                    
  
             /* System.out.println("\033[34m<<<"+"\033[33mMENU"+"\033[34m>>>");System.out.println(" ");
              System.out.println("\033[37m["+"\033[33m1"+"\033[37m]"+"\033[31m. "+ "\033[37mINGRESE A LA PLATAFORMA");
              System.out.println("\033[37m["+"\033[33m2"+"\033[37m]"+"\033[31m. "+ "\033[37mREGISTRO A LA PLATAFORMA");
              System.out.println("\033[37m["+"\033[33m3"+"\033[37m]"+"\033[31m. "+ "\033[37mUSUARIOS");
              System.out.println("\033[37m["+"\033[33m4"+"\033[37m]"+"\033[31m. "+ "\033[37mSALIR");System.out.println(" ");
            
               System.out.print("\033[37m DIGITE LA OPCION SELECCIONADA: ");
        
                 op = teclado.nextInt();*/
             
               op = Integer.parseInt(JOptionPane.showInputDialog("1. INGRESE A LA PLATAFORMA"+"\n"+"2. REGISTGRO A LA PLATAFORMA"+"\n"+"3. SALIR"+"\n\n"+"DIGITE LA OPCION: "));
               switch(op){
                   case 1:
                       
                    User.Ingreso();
                    
                   
                     break;
                       
                   case 2:
                    User.registro();
                      
                   break;
                   
    
                       
               }
               
           }while(op != 3);
           
           
      
        
    }
}


