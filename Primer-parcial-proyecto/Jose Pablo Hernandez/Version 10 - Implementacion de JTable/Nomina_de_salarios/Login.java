package Nomina_de_salarios;

import java.awt.*;
import java.io.*;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login {
    String Usuario;
    String Contraseña;

    public void UsuarioBitacora(){
        try{
            DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
            Date date = new Date();
            PrintWriter Esc1 = new  PrintWriter("Usuario_Bitacora.txt");
            Esc1.println("USER: "+Usuario);
            Esc1.println("PASSWORD: "+Contraseña);

            try {

                InetAddress addr = InetAddress.getLocalHost();




                String hostname = addr.getHostName();
                System.out.println("\033[33mUSER : " +"\033[34m" +Usuario);

                System.out.println("\033[33mHost: " +"\033[34m"+ hostname);

                System.out.println("\033[33mIP: " +"\033[34m"+ addr.getHostAddress());

                System.out.println("HORA / FECHA: "+hourdateFormat.format(date));

                Esc1.println("HOST: "+hostname);
                Esc1.println("IP LOCAL: "+addr.getHostAddress());
                Esc1.println("HORA / FECHA: "+hourdateFormat.format(date)+"\n");

            } catch (Exception e) {

                e.printStackTrace();
            }


            Esc1.close();
        }catch(Exception err){

        }
    }
    public void registro(){
        String NombreAux, Asteriscos;
        Icon pass = new ImageIcon(getClass().getResource("/Imagenes/Password.png"));
        Icon user = new ImageIcon(getClass().getResource("/Imagenes/User.png"));


        do{
            Usuario = (String) JOptionPane.showInputDialog(null,"DIGITE EL NOMBRE DE USUARIO: ","USER", JOptionPane.INFORMATION_MESSAGE,user, null,"");
            if(BuscarUser("USER: "+Usuario) == true){
                JOptionPane.showMessageDialog(null,"USUARIO YA REGISTRADO DIGITE DE NUEVO EL USUARIO");
            }

        }
        while(BuscarUser("USER: "+Usuario) == true);


        Contraseña = (String) JOptionPane.showInputDialog(null,"DIGITE LA CONTRASEÑA: ","PASSWORD", JOptionPane.INFORMATION_MESSAGE,pass, null,"");
        char[] caracteres = Contraseña.toCharArray();

        for(int i = 0; i < caracteres.length; i++){
            caracteres[i] = '*';

        }
        Asteriscos=String.valueOf(caracteres);

        do{

            NombreAux = (String) JOptionPane.showInputDialog(null,"CONFIRME LA CONTRASEÑA: ","PASSWORD", JOptionPane.INFORMATION_MESSAGE,pass, null,"");

        }while(!NombreAux.equals(Contraseña));

        JOptionPane.showMessageDialog(null,"USER: "+Usuario+"\n"+"PASSWORD: "+Asteriscos);



        try{
            FileWriter Escribir = new FileWriter("Usuarios.txt", true);
            PrintWriter Esc = new  PrintWriter(Escribir);

            Esc.println("USER: "+Usuario);
            Esc.println("PASSWORD: "+Contraseña);
            //Direccion IP Local y MacAddress
            try {

                InetAddress addr = InetAddress.getLocalHost();

                String hostname = addr.getHostName();

                System.out.println("\033[34mHost: " + hostname);

                System.out.println("\033[33mIP: " + addr.getHostAddress());

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
        Icon pass = new ImageIcon(getClass().getResource("/Imagenes/Password.png"));
        Icon user = new ImageIcon(getClass().getResource("/Imagenes/User.png"));
        Usuario = "USER: "+JOptionPane.showInputDialog(null,"DIGITE EL NOMBRE DE USUARIO: ","USER", JOptionPane.INFORMATION_MESSAGE,user, null,"");
        Contraseña = "PASSWORD: "+JOptionPane.showInputDialog(null,"DIGITE LA CONTRASEÑA: ","PASSWORD", JOptionPane.INFORMATION_MESSAGE,pass, null,"");

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


                   Mensaje();
                  // ProgressBarCircular barra= new ProgressBarCircular();
                  // barra.setVisible(true);
                   UsuarioBitacora();

                    acceder.menu();
                    break;
                }
            }
            if(!temp.equals(Usuario) || !temp2.equals(Contraseña)){
                JOptionPane.showMessageDialog(null,"USUARIO NO REGISTRADO O USUARIO Y/O PASSWORD INCORRECTAS: "+Usuario+" -> "+Contraseña);
            }

        }          catch(Exception err){
            //JOptionPane.showMessageDialog(null,"Error no se puedo Crear o Abrir el Archivo");
        }
    }
    public boolean BuscarUser(String NombreAuxiliar){
        try{


            FileReader Leer = new FileReader("Usuarios.txt");
            BufferedReader Buffer = new BufferedReader(Leer);

            String temp = " ";
            String BfRead;


            while((BfRead = Buffer.readLine()) != null){

                temp = BfRead;


                if(temp.equals(NombreAuxiliar)){

                    //JOptionPane.showMessageDialog(null,"NOMBRE ENCONTRADO");
                    return true;


                }else{
                    for(int i =0; i < 4;i++){
                        BfRead = Buffer.readLine();
                    }
                }


            }

        }catch(Exception err){

            return false;
        }
        return false;
    }
    public void Mensaje()
    {
        Icon icon = new ImageIcon(getClass().getResource("/Imagenes/Logo_del_grupo.gif"));
        JOptionPane.showMessageDialog(null, "GRUPO DE PROGRAMACION III\n"+"PROYECTO - PLANILLA DE SALARIOS", "USUARIO CON ACCESO", JOptionPane.INFORMATION_MESSAGE,icon);
    }

}



