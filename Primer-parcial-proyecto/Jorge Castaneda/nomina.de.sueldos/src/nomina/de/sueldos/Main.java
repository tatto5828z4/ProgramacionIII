/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nomina.de.sueldos;
import javax.swing.JOptionPane;
/**
 *
 * @author jorgi
 */
public class Main {
  
public static void main(String[] args) {
        
      Login User = new Login();
     
      
      int op = 0;
         
          
           do{
               
                    
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


