/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectonomina;
import javax.swing.JOptionPane;
//import java.util.Scanner;
import java.io.*;
import java.net.InetAddress;


/**
 *
 * @author jorgi
 */


       
public class Login {

      String Usuario;
      String Contraseña;
    

      public void registro(){
          String NombreAux; 
           Usuario = JOptionPane.showInputDialog("DIGITE EL NOMBRE DE LA PERSONA: ");
           Contraseña = JOptionPane.showInputDialog("DIGITE LA CONTRASEÑA: ");
          do{
          
             NombreAux = JOptionPane.showInputDialog("CONFIRME LA CONTRASEÑA: ");
             
          }while(!NombreAux.equals(Contraseña));
            
              JOptionPane.showMessageDialog(null,"USER: "+Usuario+"\n"+"PASSWORD: "+Contraseña);
             
         
          try{
              FileWriter Escribir = new FileWriter("Usuarios.txt", true);
              PrintWriter Esc = new  PrintWriter(Escribir);
              
                Esc.println("USER: "+Usuario);
               Esc.println("PASSWORD: "+Contraseña);
                 //Direccion IP Local y MacAddress
          try {

            InetAddress addr = InetAddress.getLocalHost();

            String hostname = addr.getHostName();
            
            System.out.println("\033[36mHost: " + hostname);

            System.out.println("\033[36mIP: " + addr.getHostAddress());
             
                Esc.println("HOST: "+hostname);
                Esc.println("IP LOCAL: "+addr.getHostAddress()+"\n");

        } catch (Exception e) {
            
            e.printStackTrace();
        }
                
                 
               
               Esc.close();
                 
    
              
          }catch(Exception err){
              JOptionPane.showMessageDialog(null,"Error no se puedo Crear o Abrir el Archivo");
          }
      }
      
      
      
      public void Ingreso(){
           Menu acceder = new Menu();
           Usuario = "USER: "+JOptionPane.showInputDialog("DIGITE EL NOMBRE DE LA PERSONA: ");
           Contraseña = "PASSWORD: "+JOptionPane.showInputDialog("DIGITE LA CONTRASEÑA: ");
          try{
               FileReader Leer = new FileReader("Usuarios.txt");
               BufferedReader Buffer = new BufferedReader(Leer);
               String temp = "", temp2="", temp3="", temp4="",temp5="";
               String BfRead;
               
            
             
             while((BfRead = Buffer.readLine()) != null){
         
                
                 temp = BfRead;temp2 = Buffer.readLine();
                 temp3 = Buffer.readLine();temp4 = Buffer.readLine();
                 temp5 = Buffer.readLine();
                 
                 if( temp.equals(Usuario) && temp2.equals(Contraseña)){
                      
                  JOptionPane.showMessageDialog(null,"USUARIO CON ACCESO");
                 acceder.menu();
                 break;
                 }
                     
                 
             }
              if(!temp.equals(Usuario) || !temp2.equals(Contraseña)){
   
                  JOptionPane.showMessageDialog(null,"USUARIO NO REGISTRADO O USUARIO Y/O PASSWORD INCORRECTAS: "+Usuario+" -> "+Contraseña);
                 }
            
                 
   
          }catch(Exception err){
              JOptionPane.showMessageDialog(null,"Error no se puedo Crear o Abrir el Archivo");
          }        
         }   
}