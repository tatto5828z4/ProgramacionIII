
package nomina.de.sueldos;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.*;


       
public class Login {

      String Usuario;
      String Contraseña;
    

      private void registro(){
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
               Esc.close();
                 
    
              
          }catch(Exception err){
              JOptionPane.showMessageDialog(null,"Error no se puedo Crear o Abrir el Archivo");
          }
      }
      
      
      
      private void Ingreso(){
           Usuario = "USER: "+JOptionPane.showInputDialog("DIGITE EL NOMBRE DE LA PERSONA: ");
           Contraseña = "PASSWORD: "+JOptionPane.showInputDialog("DIGITE LA CONTRASEÑA: ");
          try{
               FileReader Leer = new FileReader("Usuarios.txt");
               BufferedReader Buffer = new BufferedReader(Leer);
               String temp = "", temp2="";
               String BfRead;
               
            
             
             while((BfRead = Buffer.readLine()) != null){
         
                
                 temp = BfRead;
                 temp2 = Buffer.readLine();
                
                 if( temp.equals(Usuario) && temp2.equals(Contraseña)){
                     
                  JOptionPane.showMessageDialog(null,"USUARIO CON ACCESO");
                 break;
                 }
                     
                 
             }
              if(!temp.equals(Usuario) || !temp2.equals(Contraseña)){
   
                  JOptionPane.showMessageDialog(null,"USUARIO NO REGISTRADO O USUARIO Y/O PASSWORD INCORRECTAS: "+temp+" -> "+temp2);
                 }
            
                 
   
          }catch(Exception err){
              JOptionPane.showMessageDialog(null,"Error no se puedo Crear o Abrir el Archivo");
          }
        
        
         
         }
      
      
  
         
         
    public static void main(String[] args) {
        
      Login User = new Login();
       Scanner teclado = new Scanner (System.in);
      int op = 0;
         
           
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


