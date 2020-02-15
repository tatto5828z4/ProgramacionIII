
package login_normal;

import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;


public class Recuperar_Password {
 
    public void Recuperar(){
        
        String usuario;
        String recuperar_Password;
        
        
        try{
            usuario=JOptionPane.showInputDialog("Digite Usuario: ");
            recuperar_Password= JOptionPane.showInputDialog("Digite Numero de Telefono: ");
            
            FileReader leer= new FileReader("Usuarios.txt");
            BufferedReader Buffer= new BufferedReader(leer);
            String auxUsername="", auxPassword="", espacio="", aux_Recuperar="";
            String linea;
            
            while((linea= Buffer.readLine())!=null){
                auxUsername=linea;
                auxPassword=Buffer.readLine();
                aux_Recuperar=Buffer.readLine();
                espacio=Buffer.readLine();
                
                if (auxUsername.equals(usuario) && aux_Recuperar.equals(recuperar_Password)) {
                    JOptionPane.showConfirmDialog(null, "USUARIO: "+usuario+"\nPASSWORD: "+auxPassword);
                }
                break;
            }
            
            if (!auxUsername.equals(usuario) && !aux_Recuperar.equals(recuperar_Password)) {
                    JOptionPane.showConfirmDialog(null, "Numero de Telefono Incorrecto");
                }
            
        }catch(Exception e){}
            
        
        
    }
}
