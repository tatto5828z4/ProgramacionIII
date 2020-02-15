
package login_normal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Login_Normal {

    public static void main(String[] args) {
        //final String a= "Brayan";
        //final String b= "12345";
        
        int opcion=0;
        String usuario;
        String password;
        String respaldo_Password;
        
       
         JOptionPane.showMessageDialog(null,"SISTEMA NOMINA");
       
        do {
            opcion=Integer.parseInt(JOptionPane.showInputDialog("MENU PRINCIPAL\n"+"1. Ingresar al sistema\n"+"2. Registrarse\n"+"3. Recuperar Password\n"+"4. Salir\n"+"Digite una opcion: "));
                
            switch(opcion){
                case 1:
                       
                    usuario=JOptionPane.showInputDialog("Digite Usuario: ");
                    password=JOptionPane.showInputDialog("Digite Password: ");
                    
                    
                    try{
                        FileReader leer = new FileReader("Usuarios.txt");
                        BufferedReader buffer= new BufferedReader(leer);
                        String Linea;
                        String auxUsuario="", auxPassword="", espacio="";
                        
                        while ((Linea= buffer.readLine())!=null){
                            auxUsuario=Linea; 
                            auxPassword=buffer.readLine();
                            espacio=buffer.readLine();
                            
                            if (auxUsuario.equals(usuario) && auxPassword.equals(password)) {
                                JOptionPane.showConfirmDialog(null, "Ingreso Correcto");
                                
                                //objeto para obtener lo de la otra clase
                                Calculo_Planilla Nomina= new Calculo_Planilla();
                                
                                Nomina.Planilla();
                                
                                break;
                            }
                        }
                        if(!auxUsuario.equals(usuario) || (!auxPassword.equals(password))){
                            JOptionPane.showConfirmDialog(null, "Usuario o Password Incorrecto");
                        }
                      
                        
                    }catch(Exception e){}
        
                        
                    
                       
                    break;
                    
                case 2:
                    
                    try{
                        FileWriter archivo = new FileWriter("C:\\Users\\Brayan Cifuentes\\Documents\\NetBeansProjects\\Login_Normal\\Usuarios.txt", true);
                        PrintWriter escribir = new PrintWriter(archivo);
                                            
                        
                        usuario=JOptionPane.showInputDialog("Crear Usuario: ");
                        password= JOptionPane.showInputDialog("Crear Password: ");
                        respaldo_Password=JOptionPane.showInputDialog("Respaldo si olvida Password\n"+"Digite Numero de Telefono: ");
                        
                        
                        escribir.println(usuario);
                        escribir.println(password);
                        escribir.println(respaldo_Password);
                        escribir.println();
                        
                        archivo.close();
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    break;
                    
                case 3:
                    Recuperar_Password telefono= new Recuperar_Password();
                    telefono.Recuperar();
                    break;
                    
                
                }
            
        } while (opcion!=4);
        
        
    }
    
}
