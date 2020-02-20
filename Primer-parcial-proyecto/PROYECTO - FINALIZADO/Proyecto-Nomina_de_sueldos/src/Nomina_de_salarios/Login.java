package Nomina_de_salarios;

import java.applet.AudioClip;
import java.awt.*;
import java.io.*;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class Login {
    /**
     * (String Usuario):Sirve para pedir un Usuario para acceder a la Plataforma
     */
    String Usuario;
    /**
     * (String Contraseña):Sirve para pedir una contraseña para acceder a la Plataforma
     */
    String Contraseña;
    /**
     * (String PreguntaClave):Nos va a servir para pedir un numero telefonico y poder recuperar
     * una contraseña olvidada
     */
    String PreguntaClave;
    /**
     * Crea un objeto de tipo AudioClip para reproducir un sonido de benvenida
     * @param Sonido variable que contiene nomnbre del sonido mas su formato .wav
     * @throws IOException exception
     */
    public static void Sonidos(String Sonido) throws IOException {
        String tono="/Sonidos/"+Sonido;
        AudioClip player;
        player=java.applet.Applet.newAudioClip(Login.class.getResource(tono));
        player.play();


    }
    /**
     * (UsuarioBitacora()):Metodo de mi clase Login para poder Mostrar una Bitacora
     * de empleados al Usuario
     */
    public void UsuarioBitacora(){
        /**
         * (Asteriscos):Nos va a servir para que cuando el usuario ingrese su contraseña
         * despues cuando acceda a la plataforma muestre la contraseña en forma de asteriscos
         */
        String Asteriscos;
        try{
            /**
             * (DateFormat hourdateFormat):Se crea un objeto de mi libreria (java.text.DateFormat) para poder
             * obtener mi (hora,dia,año) de mi ordenador actual
             * (pattern):Formato en que nos mostrara hora y fecha
             */
            DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
            /**
             * (Date date):Se crea un objeto de tipo Date de la libreria (java.util.Date) para sacar
             * hora,minutos,segundos,da,mes,año.
             */
            Date date = new Date();
            /**
             * (PrintWriter Esc1):Crea un archivo o escribe en el en este caso lo crea.
             * (fileName):Lleva el String del nombre que va a tener mi archivo en este caso es(Usuario_Bitacora.txt)
             */
            PrintWriter Esc1 = new  PrintWriter("Usuario_Bitacora.txt");
            /**
             *(char[] caracteres):Este vector nos va a servir para convertir mi (contraseña) a asteriscos
             */
            char[] caracteres = Contraseña.toCharArray();
/**
 * Bucle for nos va a servir para que llenar mi vector (caracteres[]) del tamaño de la cantidad de letras
 * (caracteres)que tiene mi (contraseña), empieza (i=10) por que asi no toma en cuenta en mi archivos
 * la palabra literal (Password:) contando espacios en archivos , asi lo unico que se vuelve asteriscos es
 * la contraseña que ingresa el usuario
 * */
            for(int i = 10; i < caracteres.length; i++){
                caracteres[i] = '*';

            }
            /**
             * ( Asteriscos = String.valueOf(caracteres)):Sirve para que (Asteriscos) solo guarde los caracteres
             * de (caracteres[])
             */

            Asteriscos=String.valueOf(caracteres);
            /**
             * (Esc1.println):Escribe en un archivo el string que uno quiera en este caso guardamos el (Usuario)
             */
            Esc1.println("USER: "+Usuario);
            /**
             * (Esc1.println):Escribe en un archivo el string que uno quiera en este caso guardamos el (Ateriscos)
             */
            Esc1.println(Asteriscos);


            try {
                /**
                 * (InetAddress.getLocalHost()):contiene el nombre y la dirección del host local
                 */
                InetAddress addr = InetAddress.getLocalHost();

                /**
                 * (String hostname):Guarda el nombre de mi computadora osea de mi Host con ayuda de la
                 * libreria (java.util.Date)
                 */
                String hostname = addr.getHostName();
                /**
                 * ("\033[33mUSER):Los numeros("\033[33m):Sirven para agregarle color a mis prints
                 * no necesita de una libreria,en este caso se imprimi el (Usuario)
                 */
                System.out.println("\033[33mUSER : " +"\033[34m" +Usuario);
                /**
                 * ("\033[33mHost):Los numeros("\033[33m):Sirven para agregarle color a mis prints
                 * no necesita de una libreria,en este caso se imprimi el (hostname) osea el nombre de
                 * la computadora
                 */
                System.out.println("\033[33mHost: " +"\033[34m"+ hostname);
                /**
                 * ("\033[33mIP):Los numeros("\033[33m):Sirven para agregarle color a mis prints
                 * no necesita de una libreria,en este caso se imprime el (addr.getHostAddress()) osea la IP de
                 * la computadora el (.getHostAddress()):srive para poder obtener la IP de mi computadora
                 */
                System.out.println("\033[33mIP: " +"\033[34m"+ addr.getHostAddress());
                /**
                 * (HORA / FECHA):Aqui se imprime la hora y fecha con mi obejeto de tipo Dateformat
                 * en esre caso es (hourdateFormat) (.format):es para mostrar el formato que tiene como
                 * parametro un objeto en este caso es (date)
                 */
                System.out.println("HORA / FECHA: "+hourdateFormat.format(date));
                /**
                 * (Esc1.println):Escribe en un archivo el string que uno quiera en este caso guardamos el (hostname)
                 */
                /**
                 * (Esc1.println):Escribe en un archivo el string que uno quiera en este caso guardamos el (hostname)
                 */
                Esc1.println("HOST: " + hostname);
                /**
                 * (Esc1.println):Escribe en un archivo el string que uno quiera en este caso guardamos el (IP)
                 */
                Esc1.println("IP LOCAL: " + addr.getHostAddress());
                /**
                 * (Esc1.println):Escribe en un archivo el string que uno quiera en este caso guardamos el (Fecha y Hora)
                 */
                Esc1.println("HORA / FECHA: " + hourdateFormat.format(date) + "\n");


            } catch (Exception e) {
                /**
                 *  (printStackTrace):Imprime el error junto con otros detalles como el
                 *  número de línea y el nombre de la clase donde ocurrió la excepción.
                 */
                e.printStackTrace();
            }


            Esc1.close();
        }catch(Exception err){

        }
    }
    /**
     * (registro()):Metodo de mi clase Login para poder Registrar un Usuario
     */
    public void registro()
    {
        /**
         * (NombreAux):Sirve para confirmar la contraseña
         */
        String NombreAux;
        /**
         * (Asteriscos):Nos va a servir para que cuando el usuario ingrese su contraseña
         * despues cuando acceda a la plataforma muestre la contraseña en forma de asteriscos
         */
        String Asteriscos;

        /**
         * (Icon pass):Agregamos una Imagen a nuestro JOptionPane
         */
        Icon pass = new ImageIcon(getClass().getResource("/Imagenes/Password.png"));
        /**
         * (Icon user):Agregamos una Imagen a nuestro JOptionPane
         */
        Icon user = new ImageIcon(getClass().getResource("/Imagenes/User.png"));

        /**
         * Bucle do while creado para evitar que se ingrese un mismo nombre  la hora de registrar
         */
        do
        {
            /**
             * (Usuario):Le pide al usuario un Usuario
             * (parentComponent):Agregar un componente(Ejemplo:un objeto) en este caso no utilizamos un componente por lo que colocamos un null
             * (message):Ingresamos un String en este caso nuestros (DIGITE EL NOMBRE DE USUARIO:)
             * (title):Ingresamos un String como Titulo en este caso es (User)
             * (icon):Ingresamos una imagen
             * (selectionValues):Pide un objeto en este caso nosotros no le ponemos por lo que es(null)
             * (initialSelectionValue):Pide un objeto en este caso nosotros no le ponemos por lo que es(null)
             */
            Usuario = (String) JOptionPane.showInputDialog(null, "DIGITE EL NOMBRE DE USUARIO: ", "USER", JOptionPane.INFORMATION_MESSAGE, user, null, "");

            /**
             * Condicional que contiene:
             * (BuscarUser):Metodo Creado en clase (Login)
             * (NombreAuxiliar):Pude ser cualquier String en este caso es(Usuario).
             *
             * Si esta funcion devuelve un (true) muestra lo que hay adentro del if
             */
            if (BuscarUser("USER: " + Usuario) == true)
            {
                /**
                 * (Usuario):Le pide al usuario un Usuario
                 * (parentComponent):Agregar un componente(Ejemplo:un objeto) en este caso no utilizamos un componente por lo que colocamos un null
                 * (message):Ingresamos un String en este caso es USUARIO YA REGISTRADO DIGITE DE NUEVO EL USUARIO
                 * M
                 */
                JOptionPane.showMessageDialog(null, "USUARIO YA REGISTRADO DIGITE DE NUEVO EL USUARIO");
            }

        }
        /**
         * (BuscarUser):Metodo Creado en clase (Login)
         * (NombreAuxiliar):Pude ser cualquier String en este caso es(Usuario).
         *
         * Si esta funcion devuelve un (true) sale de nuestro bucle do while
         */
        while (BuscarUser("USER: " + Usuario) == true);


        /**
         * (Contraseña):Le pide al usuario un Usuario
         * (parentComponent):Agregar un componente(Ejemplo:un objeto) en este caso no utilizamos un componente por lo que colocamos un null
         * (message):Ingresamos un String en este caso nuestros (DIGITE LA CONTRASEÑA:)
         * (title):Ingresamos un String como Titulo en este caso es (PASSWORD)
         * (icon):Ingresamos una imagen
         * (selectionValues):Pide un objeto en este caso nosotros no le ponemos por lo que es(null)
         * (initialSelectionValue):Pide un objeto en este caso nosotros no le ponemos por lo que es(null)
         */
        Contraseña = (String) JOptionPane.showInputDialog(null, "DIGITE LA CONTRASEÑA: ", "PASSWORD", JOptionPane.INFORMATION_MESSAGE, pass, null, "");
        /**
         *(char[] caracteres):Este vector nos va a servir para convertir mi (contraseña) a asteriscos
         */
        char[] caracteres = Contraseña.toCharArray();

        /**
         * Bucle for nos va a servir para que llenar mi vector (caracteres[]) del tamaño de la cantidad de letras
         * (caracteres)que tiene mi (contraseña).
         * */
        for (int i = 0; i < caracteres.length; i++)
        {
            caracteres[i] = '*';

        }
        /**
         * ( Asteriscos = String.valueOf(caracteres)):Sirve para que (Asteriscos) solo guarde los caracteres
         * de (caracteres[])
         */
        Asteriscos = String.valueOf(caracteres);

        do
        {
            /**
             * (NombreAux):Le pide al usuario un String que va a ser la confirmacion de mi contraseña
             * (parentComponent):Agregar un componente(Ejemplo:un objeto) en este caso no utilizamos un componente por lo que colocamos un null
             * (message):Ingresamos un String en este caso nuestros (CONFIRME LA CONTRASEÑA:)
             * (title):Ingresamos un String como Titulo en este caso es (PASSWORD)
             * (icon):Ingresamos una imagen
             * (selectionValues):Pide un objeto en este caso nosotros no le ponemos por lo que es(null)
             * (initialSelectionValue):Pide un objeto en este caso nosotros no le ponemos por lo que es(null)
             */
            NombreAux = (String) JOptionPane.showInputDialog(null, "CONFIRME LA CONTRASEÑA: ", "PASSWORD", JOptionPane.INFORMATION_MESSAGE, pass, null, "");

            /**
             * (!NombreAux.equals(Contraseña)):Si la contraseña es diferente el do while hace que vuelva a pedir la
             * contraseña , sale del do while hasta que las contraseñas sean iguales.
             */
        } while (!NombreAux.equals(Contraseña));

        /**
         * Muestra un JOptionPane los parametros:
         * (parentComponent):Agregar un componente(Ejemplo:un objeto) en este caso no utilizamos un componente por lo que colocamos un null
         * (message):Ingresamos un String en este caso nuestros (USER:)
         * (title):Ingresamos un String como Titulo en este caso es (PASSWORD)
         */
        JOptionPane.showMessageDialog(null, "USER: " + Usuario + "\n" + "PASSWORD: " + Asteriscos);
        /**
         * (PreguntaClave):Le pide al usuario un String que va a ser la confirmacion de mi contraseña
         * (parentComponent):Agregar un componente(Ejemplo:un objeto) en este caso no utilizamos un componente por lo que colocamos un null
         * (message):Ingresamos un String en este caso nuestros (RESPONDA LA SIGUIENTE PREGUNTA: ¿CUAL ES SU NUMERO DE TELEFONO?:)
         * (title):Ingresamos un String como Titulo en este caso es (PREGUNTA CLAVE)
         * (icon):Ingresamos una imagen
         * (selectionValues):Pide un objeto en este caso nosotros no le ponemos por lo que es(null)
         * (initialSelectionValue):Pide un objeto en este caso nosotros no le ponemos por lo que es(null)
         */
        PreguntaClave = (String) JOptionPane.showInputDialog(null, "RESPONDA LA SIGUIENTE PREGUNTA: ¿CUAL ES SU NUMERO DE TELEFONO? ", "PREGUNTA CLAVE", JOptionPane.INFORMATION_MESSAGE, pass, null, "");


        try
        {
            /**
             * (FileWriter Escribir):Sirve para crear un nuevo archivo para escribir con parametros:
             * (fileName):Nombre del archivo a crear en este caso es (Usuarios.txt)
             * (append):Sirve para que se agregen las cosas al final del archivo y siempre
             * se utiliza (true)
             */
            FileWriter Escribir = new FileWriter("Usuarios.txt", true);
            /**
             * (PrintWriter Esc):Sirve para escribir en el archivo sin reemplazar lo que ya
             * hay escrito en el lleva como parametro un FileWriter en este caso es (Escribir)
             */
            PrintWriter Esc = new PrintWriter(Escribir);

            /**
             * (Esc1.println):Escribe en un archivo el string que uno quiera en este caso guardamos el (Usuario)
             */
            Esc.println("USER: " + Usuario);
            /**
             * (Esc1.println):Escribe en un archivo el string que uno quiera en este caso guardamos el (Contraseña)
             */
            Esc.println("PASSWORD: " + Contraseña);
            //Direccion IP Local y MacAddress
            try
            {
                /**
                 * (InetAddress.getLocalHost()):contiene el nombre y la dirección del host local
                 */
                InetAddress addr = InetAddress.getLocalHost();

                /**
                 * (String hostname):Guarda el nombre de mi computadora osea de mi Host con ayuda de la
                 * libreria (java.util.Date)
                 */
                String hostname = addr.getHostName();
                /**
                 * ("\033[34mUSER):Los numeros("\033[34m):Sirven para agregarle color a mis prints
                 * no necesita de una libreria,en este caso se imprime el (hostname) osea el nombre de
                 * la computadora
                 */
                System.out.println("\033[34mHost: " + hostname);

                /**
                 * ("\033[33mIP):Los numeros("\033[33m):Sirven para agregarle color a mis prints
                 * no necesita de una libreria,en este caso se imprime el (addr.getHostAddress()) osea la IP de
                 * la computadora el (.getHostAddress()):srive para poder obtener la IP de mi computadora
                 */
                System.out.println("\033[33mIP: " + addr.getHostAddress());

                /**
                 * (Esc1.println):Escribe en un archivo el string que uno quiera en este caso guardamos el (HOST)
                 */
                Esc.println("HOST: " + hostname);
                /**
                 * (Esc1.println):Escribe en un archivo el string que uno quiera en este caso guardamos el (IP LOCAL)
                 */
                Esc.println("IP LOCAL: " + addr.getHostAddress());
                /**
                 * (Esc1.println):Escribe en un archivo el string que uno quiera en este caso guardamos el (TEL)
                 */
                Esc.println("TEL: " + PreguntaClave + "\n");

            } catch (Exception e)
            {

                /**
                 *  (printStackTrace):Imprime el error junto con otros detalles como el
                 *  número de línea y el nombre de la clase donde ocurrió la excepción.
                 */
                e.printStackTrace();
            }

            /**
             * (Esc.close()):De esta manera se cierra el (PrintWriter) para que escriba todo
             * lo ingresado anteriormente .
             */
            Esc.close();


            /**
             * (try y catch): Sirve para que cuando un proceso entre a mi try y encuentre un error o excepcion
             * en el catch nos muestre el error
             */
        } catch (Exception err)
        {
            /**
             * Muestra un JOptionPane los parametros:
             * (parentComponent):Agregar un componente(Ejemplo:un objeto) en este caso no utilizamos un componente por lo que colocamos un null
             * (message):Ingresamos un String en este caso nuestros (Error no se puedo Crear o Abrir el Archivo)
             */
            JOptionPane.showMessageDialog(null, "Error no se puedo Crear o Abrir el Archivo");
        }
    }
    public void Ingreso()
    {
        /**
         * (Menu acceder):Se crea un Objeto de mi clase Menu para poder acceder
         * uno o mas de sus metodos
         */
        Menu acceder = new Menu();
        /**
         * (Icon pass):Objeto de librera (javax.swing.Icon) y (javax.swing.ImageIcon)
         * que nos sirve para poder ingresar una imagen en un JOptionPane
         */
        Icon pass = new ImageIcon(getClass().getResource("/Imagenes/Password.png"));
        /**
         * (Icon user):Objeto de librera (javax.swing.Icon) y (javax.swing.ImageIcon)
         * que nos sirve para poder ingresar una imagen en un JOptionPane
         */
        Icon user = new ImageIcon(getClass().getResource("/Imagenes/User.png"));
        /**
         * (Usuario):Le pide al usuario un String
         * (parentComponent):Agregar un componente(Ejemplo:un objeto) en este caso no utilizamos un componente por lo que colocamos un null
         * (message):Ingresamos un String en este caso nuestros (DIGITE EL NOMBRE DE USUARIO:)
         * (title):Ingresamos un String como Titulo en este caso es (USER)
         * (icon user):Ingresamos una imagen
         * (selectionValues):Pide un objeto en este caso nosotros no le ponemos por lo que es(null)
         * (initialSelectionValue):Pide un objeto en este caso nosotros no le ponemos por lo que es(null)
         */
        Usuario = "USER: " + JOptionPane.showInputDialog(null, "DIGITE EL NOMBRE DE USUARIO: ", "USER", JOptionPane.INFORMATION_MESSAGE, user, null, "");
        /**
         * (PASSWORD):Le pide al usuario un String
         * (parentComponent):Agregar un componente(Ejemplo:un objeto) en este caso no utilizamos un componente por lo que colocamos un null
         * (message):Ingresamos un String en este caso nuestros (DIGITE LA CONTRASEÑA:)
         * (title):Ingresamos un String como Titulo en este caso es (PASSWORD)
         * (icon pass):Ingresamos una imagen
         * (selectionValues):Pide un objeto en este caso nosotros no le ponemos por lo que es(null)
         * (initialSelectionValue):Pide un objeto en este caso nosotros no le ponemos por lo que es(null)
         */
        Contraseña = "PASSWORD: " + JOptionPane.showInputDialog(null, "DIGITE LA CONTRASEÑA: ", "PASSWORD", JOptionPane.INFORMATION_MESSAGE, pass, null, "");

        try
        {
            /**
             * (FileReader Leer):Sirve para crear un nuevo archivo para leer en este caso
             * es (Leer) con un parametro:
             * (fileName):Se le da un nombre al nuevo archivo creado en este caso es
             * (Usuarios.txt)
             */
            FileReader Leer = new FileReader("Usuarios.txt");
            /**
             * (BufferedReader Buffer):Sirve para leer una secuencia de caracteres con un parametro:
             * (FileReader):En este caso utilizamos el archivo de lectura llamado (Leer)
             *
             */
            BufferedReader Buffer = new BufferedReader(Leer);
            /**
             * (String temp):Nos va a servir para Guardar el nombre de el archivo a leer
             * en este caso de mi (Buffer), por que necesitamos saber si el nombre que el
             * usuario ingreso existe en mi archivo en este caso (Leer)
             */
            String temp = "";
            /**
             * (String temp2):Nos va a servir para Guardar la contraeña de el archivo a leer
             * en este caso de mi (Buffer), por que necesitamos saber si la contraseña que el
             * usuario ingreso existe en mi archivo en este caso (Leer)
             */
            String temp2 = "";
            /**
             * (String BfRead):Nos va a servir parapara poder ir leyendo mi
             * usuario y contraseña
             */
            String BfRead;
            /**
             * Bucle While que nos va a decir primero que ((BfRead = Buffer.readLine())):Nos Indica que
             * mi String (BfRead) nos va a leer siempre la primera linea de mi archivo y segundo que
             * ((BfRead = Buffer.readLine()) != null):El blucle va a seguir hasta que mi que archivo este
             * vacio osea hasta que mi archivo ya no tenga ningun caracter , mi archivo este vacio osea
             * hasta que mi archivo llegue a (null)
             */
            while ((BfRead = Buffer.readLine()) != null)
            {
                /**
                 * (temp):Como se dijo antes va a contener la primera linea de mi archivo
                 * osea mi nombre de (Usuario)
                 */
                temp = BfRead;

                /**
                 * (temp2):Este String va a contener la contraseña de mi Usuario
                 * lo que vendria siendo la segunda linea de mi archivo a leer
                 *
                 */
                temp2 = Buffer.readLine();
                /**
                 * Ciclo for que nos va a servir para saltar 4 espacios abajo para llegar de nuevo a
                 * leer mi (Usuario) y despues mi (Contraseña), se preguntaran porque se saltan 4 espacios?
                 * La razon es por que asi podemos hacer que salte a que lea un Usuario y contraseña si que pase por
                 * los otros Strings que no son necesarios para ingresar a nuestra plataforma.
                 *
                 * Ejemplo: Nuestro documento en este caso (Usuarios.txt) tiene tiene guardados 5 Strings que son:
                 * 1.Usuario,2.Contraseña,3.IP,4.Host,5.Telefono.
                 * Entonces como se guardarian en nuestro archivos?
                 * Se guardarian verticalmente asi:
                 *
                 * Usuario
                 * Contraseña
                 * IP
                 * Host
                 * Telefono
                 * Usuario
                 * Contraseña
                 *
                 * El for entonces sirve para esto si se dan cuenta solo necesitamos 2 parametros (Usuario)y(Contraseña)
                 * por lo que los demas no nos sirven en este caso, entonces para evitar que mi (Buffer) pase por los parametros
                 * que no neesitamos hacemos 4 saltos de linea en mi archivo hasta llergar de nuevo a (Usuario) y por consiguiente
                 * a (Contraseña), asi se repite este buble hasta que el archivo este vacio
                 * */
                for (int i = 0; i < 4; i++)
                {
                    /**
                     * (BfRead):Adentro de este for sirve para leer rapidamente los parametros que no deseamos
                     * obtener en este caso.
                     */
                    BfRead = Buffer.readLine();
                }
                /**
                 * Condicional que nos sirve para verificar que el usuario y contraseña que ingrese el Usuario
                 * es el mismo que el Usuario registrado en mi archivo(Leer) osea que (temp = Usuario) y (temp2 = contraseña)
                 */
                if (temp.equals(Usuario) && temp2.equals(Contraseña))
                {
                    /**
                     * (Sonidos): Reproduce el sonido de bienvenida
                     */
                    Sonidos("Inicio_de_programa.wav");
                    /**
                     * (Mensaje()):Metodo de la clase Login
                     */
                    Mensaje();
                    /**
                     * (UsuarioBitacora()):Metodo de la clase Login
                     */
                    UsuarioBitacora();
                    /**
                     * (acceder.menu()):Mandamos a llamar un metodo de la clase Menu con ayuda de nuestro
                     * objeto llamado en este caso (acceder)
                     */
                    acceder.menu();
                    /**
                     * (break):Sirve para salir del bucle una vez se cumpla mi condicional
                     */
                    break;
                }
            }
            /**
             * Condicional donde se mira si el usuario ingresado o contraseña ingresado son
             * diferentes y no iguales osea (!temp.equals(Usuario) || !temp2.equals(Contraseña)):
             * Si me usuario ingresado es diferente a mi Usuario registrado en mi archivos(Leer)
             * o si mi contraseña ingresada es difrente a mi contraseña registrada en el archivo(Leer)
             * que entre a mi condicional
             */
            if (!temp.equals(Usuario) || !temp2.equals(Contraseña))
            {
                /**
                 * Muestra un JOptionPane los parametros:
                 * (parentComponent):Agregar un componente(Ejemplo:un objeto) en este caso no utilizamos un componente por lo que colocamos un null
                 * (message):Ingresamos un String en este caso nuestros (USUARIO NO REGISTRADO O USUARIO Y/O PASSWORD INCORRECTAS + Usuario+Contraseña)
                 */
                JOptionPane.showMessageDialog(null, "USUARIO NO REGISTRADO O USUARIO Y/O PASSWORD INCORRECTAS: " + Usuario + " -> " + Contraseña);
            }

            /**
             * (try y catch): Sirve para que cuando un proceso entre a mi try y encuentre un error o excepcion
             * en el catch nos muestre el error
             */
        } catch (Exception err) {
            //JOptionPane.showMessageDialog(null,"Error no se puedo Crear o Abrir el Archivo");
        }
    }

    /**
     * (public boolean BuscarUser):Metodo booleano de mi clase Login que nos va a servir para
     * buscar un Usuario pidiendole al Uusuario que ingrese un parametro Stinrg:
     * (String NombreAuxiliar):Nombre que se le va a Pedir al Usuario que ingrese para
     * Buscarlo
     */
    public boolean BuscarUser(String NombreAuxiliar)
    {
        try
        {
            /**
             * (FileReader Leer):Sirve para crear un nuevo archivo para leer en este caso
             * es (Leer) con un parametro:
             * (fileName):Se le da un nombre al nuevo archivo creado en este caso es
             * (Usuarios.txt)
             */
            FileReader Leer = new FileReader("Usuarios.txt");
            /**
             * (BufferedReader Buffer):Sirve para leer una secuencia de caracteres con un parametro:
             * (FileReader):En este caso utilizamos el archivo de lectura llamado (Leer)
             *
             */
            BufferedReader Buffer = new BufferedReader(Leer);

            /**
             * (String temp):Nos va a servir para Guardar el nombre de el archivo a leer
             * en este caso de mi (Buffer), por que necesitamos saber si el nombre que el
             * usuario ingreso existe en mi archivo en este caso (Leer)
             */
            String temp = " ";
            /**
             * (String BfRead):Nos va a servir parapara poder ir leyendo mi
             * usuario y contraseña
             */
            String BfRead;


            /**
             * Bucle While que nos va a decir primero que ((BfRead = Buffer.readLine())):Nos Indica que
             * mi String (BfRead) nos va a leer siempre la primera linea de mi archivo y segundo que
             * ((BfRead = Buffer.readLine()) != null):El blucle va a seguir hasta que mi que archivo este
             * vacio osea hasta que mi archivo ya no tenga ningun caracter , mi archivo este vacio osea
             * hasta que mi archivo llegue a (null)
             */
            while ((BfRead = Buffer.readLine()) != null)
            {
                /**
                 * (temp):Como se dijo antes va a contener la primera linea de mi archivo
                 * osea mi nombre de (Usuario)
                 */
                temp = BfRead;
                /**
                 * Condicional que nos sirve para verificar que el usuario  ingrese el Usuario
                 * es el mismo que el Usuario registrado en mi archivo(Leer) osea que (temp = Usuario)
                 */
                if (temp.equals(NombreAuxiliar))
                {
                    //JOptionPane.showMessageDialog(null,"NOMBRE ENCONTRADO");
                    /**
                     * Si se cumple nuestro condicional significa que el nombre ingresado y el nombre de mi Arhivo(Leer)
                     * son los mismos, por lo que la funcion nos retorna un (true)
                     */
                    return true;
                }
                /**
                 * (else):Si mi condicion no se cumple.
                 */
                else
                {
                    /**
                     * Ciclo for que nos va a servir para saltar 5 espacios abajo para llegar de nuevo a
                     * leer mi (Usuario) , se preguntaran porque se saltan 5 espacios?
                     * La razon es por que asi podemos hacer que salte a que lea un Usuario, sin que pase por
                     * los otros Strings que no son necesarios para ingresar a nuestra plataforma.
                     *
                     * Ejemplo: Nuestro documento en este caso (Usuarios.txt) tiene tiene guardados 5 Strings que son:
                     * 1.Usuario,2.Contraseña,3.IP,4.Host,5.Telefono.
                     * Entonces como se guardarian en nuestro archivos?
                     * Se guardarian verticalmente asi:
                     *
                     * Usuario
                     * Contraseña
                     * IP
                     * Host
                     * Telefono
                     * Usuario
                     * Contraseña
                     *
                     * El for entonces sirve para esto si se dan cuenta solo necesitamos 1 parametros (Usuario)
                     * por lo que los demas no nos sirven en este caso, entonces para evitar que mi (Buffer) pase por los parametros
                     * que no neesitamos hacemos 5 saltos de linea en mi archivo hasta llergar de nuevo a (Usuario)
                     * , asi se repite este buble hasta que el archivo este vacio
                     * */
                    for (int i = 0; i < 5; i++)
                    {
                        /**
                         * (BfRead):Adentro de este for sirve para leer rapidamente los parametros que no deseamos
                         * obtener en este caso.
                         */
                        BfRead = Buffer.readLine();
                    }
                }


            }

        }
        /**
         * (try y catch): Sirve para que cuando un proceso entre a mi try y encuentre un error o excepcion
         * en el catch nos muestre el error
         */
        catch (Exception err)
        {
            /**
             * (return false):Si mi Programa encuntra algun problema que me retorne un (false) como que si no
             * hubiera encontrado mi usuario
             */
            return false;
        }
        /**
         * (return false):Si mi Programa no encuntra mi usuario en el registro (Leer) wur  retorne un (false)
         */
        return false;
    }

    /**
     * (RecuperarUser()):Metodo de la Clase Login que sirve para recuperar mi contraseña en caso de
     * que la olvide
     */
    public void RecuperarUser()
    {
        /**
         * (String usuario):Sirve para pedir un Usuario para poder Recuperar mi contraseña
         */
        String usuario;
        /**
         * (String recuperar_Password):Nos va a servir para pedir un numero telefonico y poder recuperar
         * una contraseña olvidada
         */
        String recuperar_Password;

        try
        {
            /**
             * (Icon tel):Objeto de librera (javax.swing.Icon) y (javax.swing.ImageIcon)
             * que nos sirve para poder ingresar una imagen en un JOptionPane
             */
            Icon tel = new ImageIcon(getClass().getResource("/Imagenes/Telefono.png"));
            /**
             * (Icon user):Objeto de librera (javax.swing.Icon) y (javax.swing.ImageIcon)
             * que nos sirve para poder ingresar una imagen en un JOptionPane
             */
            Icon user = new ImageIcon(getClass().getResource("/Imagenes/User.png"));

            /**
             * (User):Le pide al usuario un String
             * (parentComponent):Agregar un componente(Ejemplo:un objeto) en este caso no utilizamos un componente por lo que colocamos un null
             * (message):Ingresamos un String en este caso nuestros (DIGITE EL NOMBRE DE USUARIO:)
             * (title):Ingresamos un String como Titulo en este caso es (USER)
             * (icon user):Ingresamos una imagen
             * (selectionValues):Pide un objeto en este caso nosotros no le ponemos por lo que es(null)
             * (initialSelectionValue):Pide un objeto en este caso nosotros no le ponemos por lo que es(null)
             */
            usuario = "USER: " + JOptionPane.showInputDialog(null, "DIGITE EL NOMBRE DE USUARIO: ", "USER", JOptionPane.INFORMATION_MESSAGE, user, null, "");

            /**
             * (recuperar_Password):Le pide al usuario un String que va a ser la confirmacion de mi contraseña
             * (parentComponent):Agregar un componente(Ejemplo:un objeto) en este caso no utilizamos un componente por lo que colocamos un null
             * (message):Ingresamos un String en este caso nuestros (DIGITE SU NUMERO DE TELEFONO:)
             * (title):Ingresamos un String como Titulo en este caso es (RECUPERAR)
             * (icon tel):Ingresamos una imagen
             * (selectionValues):Pide un objeto en este caso nosotros no le ponemos por lo que es(null)
             * (initialSelectionValue):Pide un objeto en este caso nosotros no le ponemos por lo que es(null)
             */
            recuperar_Password = "TEL: " + JOptionPane.showInputDialog(null, "DIGITE SU NUMERO DE TELEFONO: ", "RECUPERAR", JOptionPane.INFORMATION_MESSAGE, tel, null, "");

            /**
             * (FileReader leer):Sirve para crear un nuevo archivo para leer en este caso
             * es (Leer) con un parametro:
             * (fileName):Se le da un nombre al nuevo archivo creado en este caso es
             * (Usuarios.txt)
             */
            FileReader leer = new FileReader("Usuarios.txt");
            /**
             * (BufferedReader Buffer):Sirve para leer una secuencia de caracteres con un parametro:
             * (FileReader):En este caso utilizamos el archivo de lectura llamado (Leer)
             *
             */
            BufferedReader Buffer = new BufferedReader(leer);

            /**
             * (String auxUsername):Sirve para guardar el Nombre de Usuario de nuestro archivo en este
             * caso (leer)
             */
            String auxUsername = "";
            /**
             * (String auxPassword):Sirve para guardar la contraseña de Usuario de nuestro archivo en este
             * caso (leer)
             */
            String auxPassword = "";
            /**
             * (String espacio):Sirve para dar espacios en los parametros que no deseamos guardar
             */
            String espacio = "";
            /**
             * (String aux_Recuperar):Sirve para guardar el telefono que contiene mi archivo en este case
             * caso (leer)
             */
            String aux_Recuperar = "";
            /**
             * (String linea):Nos va a servir parapara poder ir leyendo mi
             * usuario
             */
            String linea;

            /**
             * Bucle While que nos va a decir primero que ((linea = Buffer.readLine())):Nos Indica que
             * mi String (lina) nos va a leer siempre la primera linea de mi archivo y segundo que
             * ((linea = Buffer.readLine()) != null):El blucle va a seguir hasta que mi que archivo este
             * vacio osea hasta que mi archivo ya no tenga ningun caracter , mi archivo este vacio osea
             * hasta que mi archivo llegue a (null)
             */
            while ((linea = Buffer.readLine()) != null)
            {
                /**
                 * (auxUsername):Como se dijo antes va a contener la primera linea de mi archivo
                 * osea mi nombre de (Usuario)
                 */
                auxUsername = linea;
                /**
                 * (auxPassword):Este String va a contener la contraseña de mi Usuario
                 * lo que vendria siendo la segunda linea de mi archivo a leer
                 *
                 */
                auxPassword = Buffer.readLine();

                /**
                 * Ciclo for que nos va a servir para saltar 2 espacios abajo para llegar de nuevo a
                 * leer mi (Usuario) , se preguntaran porque se saltan 2 espacios?
                 * La razon es por que asi podemos hacer que salte a que lea un Usuario, sin que pase por
                 * los otros Strings que no son necesarios para ingresar a nuestra plataforma.
                 *
                 * Ejemplo: Nuestro documento en este caso (Usuarios.txt)  tiene guardados 5 Strings que son:
                 * 1.Usuario,2.Contraseña,3.IP,4.Host,5.Telefono.
                 * Entonces como se guardarian en nuestro archivos?
                 * Se guardarian verticalmente asi:
                 *
                 * Usuario
                 * Contraseña
                 * IP
                 * Host
                 * Telefono
                 * Usuario
                 * Contraseña
                 *
                 * El for entonces sirve para esto si se dan cuenta solo necesitamos 2 parametros (Usuario)y(contraseña)
                 * por lo que los demas no nos sirven en este caso, entonces para evitar que mi (Buffer) pase por los parametros
                 * que no neesitamos hacemos 2 saltos de linea en mi archivo hasta llergar  (Tel)que es parte de mi archivo(leer),
                 * , asi se repite este buble hasta que el archivo este vacio
                 * */
                for (int i = 0; i < 2; i++)
                {
                    linea = Buffer.readLine();
                }

                /**
                 * (aux_Recuperar):Como se dijo antes va a contener el telefono ingresado en mi archivo (leer)
                 */
                aux_Recuperar = Buffer.readLine();

                /**
                 * ( espacio):Sirve para dar 1 espacio mas y poder regresar hasta (Usuario) en mi
                 * archivo(leer)
                 */
                espacio = Buffer.readLine();

                /**
                 * Condicional donde se mira si el (auxUsername) ingresado es igual al Usuario ingresado en
                 * mi archivo(leer) y donde mi (aux_Recuperar) sea igual a (recuperar_Password) en mi
                 * arvhivo(leer) , entra a mi condicional
                 */
                if (auxUsername.equals(usuario) && aux_Recuperar.equals(recuperar_Password))
                {
                    /**
                     * Muestra un JOptionPane los parametros:
                     * (parentComponent):Agregar un componente(Ejemplo:un objeto) en este caso no utilizamos un componente por lo que colocamos un null
                     * (message):Ingresamos un String en este caso nuestros (USUARIO: + PASSWORD: + auxPassword)
                     */
                    JOptionPane.showConfirmDialog(null, "USUARIO: " + auxUsername + "\nPASSWORD: " + auxPassword);
                    /**
                     * (break):Sirve para salir del bucle una vez se cumpla mi condicional
                     */
                    break;
                }

            }

            /**
             * Condicional donde se mira si el (auxUsername) ingresado es diferente al Usuario ingresado en
             * mi archivo(leer) y donde mi (aux_Recuperar) sea diferente a (recuperar_Password) en mi
             * arvhivo(leer) , entra a mi condicional
             */
            if (!auxUsername.equals(usuario) && !aux_Recuperar.equals(recuperar_Password))
            {
                /**
                 * Muestra un JOptionPane los parametros:
                 * (parentComponent):Agregar un componente(Ejemplo:un objeto) en este caso no utilizamos un componente por lo que colocamos un null
                 * (message):Ingresamos un String en este caso nuestros (Numero de Telefono Incorrecto)
                 */
                JOptionPane.showConfirmDialog(null, "Numero de Telefono Incorrecto");

            }

        }
        /**
         * (try y catch): Sirve para que cuando un proceso entre a mi try y encuentre un error o excepcion
         * en el catch nos muestre el error
         */
        catch (Exception e)
        {

        }
    }
    public void Mensaje()
    {
        /**
         * (Icon icon):Objeto de librera (javax.swing.Icon) y (javax.swing.ImageIcon)
         * que nos sirve para poder ingresar una imagen en un JOptionPane
         */
        Icon icon = new ImageIcon(getClass().getResource("/Imagenes/Logo_del_grupo.gif"));
        /**
         * Muestra un JOptionPane los parametros:
         * (parentComponent):Agregar un componente(Ejemplo:un objeto) en este caso no utilizamos un componente por lo que colocamos un null
         * (message):Ingresamos un String en este caso nuestros (GRUPO DE PROGRAMACION III + PROYECTO - PLANILLA DE SALARIOS)
         * (title):Ingresamos un String de titulo en este caso(USUARIO CON ACCESO)
         * (icon icon): Ingresamos una imagen
         */
        JOptionPane.showMessageDialog(null, "GRUPO DE PROGRAMACION III\n" + "PROYECTO - PLANILLA DE SALARIOS", "USUARIO CON ACCESO", JOptionPane.INFORMATION_MESSAGE, icon);
    }


}



