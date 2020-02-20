package Nomina_de_salarios;

import javax.swing.*;
import java.awt.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class Main {
    public static void main(String[] args) {
        try{
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
          // UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
           // UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            
            UIManager.put( "OptionPane.background", new Color(24, 24, 24));
            UIManager.put("Panel.background",new Color(19, 19, 19));
            UIManager.put("Button.background",new Color(29, 29, 29));
            UIManager.put("Button.foreground", new Color(36, 36, 34));
            UIManager.put("OptionPane.messageForeground",new Color(166, 166, 166));

            UIManager.put("Table.background",new Color(19, 19, 17));
            UIManager.put("Table.foreground",new Color(166, 166, 166));
            UIManager.put("Table.gridColor",new Color(58, 88, 166));
            UIManager.put("Table.selectionForeground",new Color(37, 38, 37));
            UIManager.put("Table.selectionBackground",new Color(243, 239, 243));
            UIManager.put("TableHeader.background",new Color(207, 198, 72));
            UIManager.put("TableHeader.foreground",new Color(7, 6, 7));
            UIManager.put("ScrollPane.background",new Color(83, 166, 74));
            UIManager.put("ScrollPane.foreground",new Color(166, 37, 58));



        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        Login User = new Login();
        int op = 0;
        do{
            Icon icon = new ImageIcon(Main.class.getResource("/Imagenes/Login.png"));
            op = Integer.parseInt((String) JOptionPane.showInputDialog(null, "1. INGRESE A LA PLATAFORMA"+"\n"+"2. REGISTGRO A LA PLATAFORMA"+"\n"+"3. RECUPERAR CONTRASEÑA"+"\n"+"4. SALIR"+"\n\n"+"DIGITE LA OPCION: ","Login", JOptionPane.INFORMATION_MESSAGE,icon, null,""));

            switch(op){
                case 1:
                    User.Ingreso();
                    break;
                case 2:
                    User.registro();
                    break;
                case 3:
                    User.RecuperarUser();
                    break;
            }
        }while(op !=4);
    }
}



