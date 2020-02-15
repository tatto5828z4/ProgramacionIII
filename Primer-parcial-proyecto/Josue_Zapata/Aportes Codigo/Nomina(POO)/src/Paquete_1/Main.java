package Paquete_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Main {

    //Metodo
    public static float ISR(float Sueldo) {
        float ISRT = 0, isr = 0;

        if (Sueldo > 6000 && Sueldo < 7000) {
            isr = 0.05f;
            ISRT = Sueldo * isr;
        }

        if (Sueldo > 7500 && Sueldo < 9000) {
            isr = 0.06f;
            ISRT = Sueldo * isr;
        }

        if (Sueldo > 9000) {
            isr = 0.08f;
            ISRT = Sueldo * isr;
        }

        return ISRT;
    }

    public static float TL(float Sueldo, float Descuentos) {
        float Total_Liquido = Sueldo - Descuentos;

        if (Total_Liquido < 2800) {
            Total_Liquido += 2800;
        }

        return Total_Liquido;
    }

    public static void Leer_Principio(Nomina nomina[][], int cant) {

        int nueva_C_Matriz = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Cantidad de Empleados."));
        Nomina N2[][] = new Nomina[cant + nueva_C_Matriz][1];
        try {
            FileReader leer = new FileReader("C:\\Users\\Langas\\Desktop\\Nuevo.txt");
            BufferedReader buf = new BufferedReader(leer);

            String temp = "";
            String bfRead;

            while ((bfRead = buf.readLine()) != null) {
                temp = bfRead;
            }

            nueva_C_Matriz = Integer.parseInt(temp);

        } catch (Exception e) {
            System.out.println("Error");
        }

        N2 = new Nomina[nueva_C_Matriz][1];

        try {
            FileReader leer = new FileReader("C:\\Users\\Langas\\Desktop\\Nuevo.txt");
            BufferedReader buf = new BufferedReader(leer);

            int auxI = 0;
            int auxJ = 0;

            String bfRead;

            while ((bfRead = buf.readLine()) != null) {
                if ((auxI == nueva_C_Matriz - 2) && (auxJ == 1)) {
                    break;
                }

                for (int i = 0; i < nueva_C_Matriz; i++) {
                    for (int j = 0; j < 1; j++) {
                        N2[i][j].nombre = bfRead;
                        N2[i][j].puesto = bfRead;
                        N2[i][j].sueldo = Float.parseFloat(bfRead);
                        N2[i][j].sueldoEx = Float.parseFloat(bfRead);
                        N2[i][j].bonificaciones = Float.parseFloat(bfRead);
                        N2[i][j].comisiones = Float.parseFloat(bfRead);
                        N2[i][j].otroB = Float.parseFloat(bfRead);
                        N2[i][j].totalDev = Float.parseFloat(bfRead);
                        N2[i][j].igss = Float.parseFloat(bfRead);
                        N2[i][j].isr = Float.parseFloat(bfRead);
                        N2[i][j].anticipo = Float.parseFloat(bfRead);
                        N2[i][j].descJudiciales = Float.parseFloat(bfRead);
                        N2[i][j].otrosDesc = Float.parseFloat(bfRead);
                        N2[i][j].totalDesc = Float.parseFloat(bfRead);
                        N2[i][j].totalLiquido = Float.parseFloat(bfRead);
                        N2[i][j].planillaT = Float.parseFloat(bfRead);
                        bfRead = buf.readLine();

                        if ((i == nueva_C_Matriz - 2) && (j == 1)) {
                            auxI = nueva_C_Matriz - 2;
                        }

                    }
                }

            }
        } catch (Exception e) {

            System.out.println("Error");
        }

    }

    //Archivos Leer
    public static void Leer() {
        //Emieza El leer
        try {
            FileReader entrada = new FileReader("C:\\Users\\Langas\\Desktop\\Nuevo.txt");

            BufferedReader miBuffer = new BufferedReader(entrada);//Descarga mientras vez

            String linea = "";

            while (linea != null)//Mientras que cada linea de mi archivo no sea nula
            {
                linea = miBuffer.readLine();//Linea va acontener cada linea de mi archivo
                if (linea != null) {
                    System.out.println(linea);
                }
            }
            System.out.println("");
            entrada.close();

        } catch (IOException e)//Super clase de FileReader
        {
            System.out.println("No se Ha encontrado el Archivo");
        }
        //Termina el Leer
    }

    public static void main(String[] args) {
        String nombre = "";
        String puesto = "";

        float sueldo = 0;
        float sueldoEx = 0;
        float bonificaciones = 0;
        float comisiones = 0;
        float otroB = 0;
        float totalDev = 0;
        float igss = 0;
        float isr = 0;
        float anticipo = 0;
        float descJudiciales = 0;
        float otrosDesc = 0;
        float totalDesc = 0;
        float totalLiquido = 0;
        float planillaT = 0;

        JOptionPane.showMessageDialog(null, "Bienvenido Al Programa de Nomina de Salarios");
        int nCantidad_Matriz = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Cantidad de Empleados."));

        Nomina[][] N1 = new Nomina[nCantidad_Matriz][1];

        for (int i = 0; i < nCantidad_Matriz; i++) {
            for (int j = 0; j < 1; j++) {

                nombre = JOptionPane.showInputDialog("Ingrese Nombre");
                puesto = JOptionPane.showInputDialog("Ingrese Puesto");
                sueldo = Float.parseFloat(JOptionPane.showInputDialog("Ingrese Sueldo empleado "));
                sueldoEx = Float.parseFloat(JOptionPane.showInputDialog("Ingrese Sueldo Extraordinario"));
                bonificaciones = Float.parseFloat(JOptionPane.showInputDialog("Ingrese Bonificaciones "));
                comisiones = Float.parseFloat(JOptionPane.showInputDialog("Ingrese Comisiones "));
                otroB = Float.parseFloat(JOptionPane.showInputDialog("Ingrese Otros Beneficios "));
                isr = Main.ISR(totalDev);
                anticipo = Float.parseFloat(JOptionPane.showInputDialog("Ingrese Anticipo"));
                descJudiciales = Float.parseFloat(JOptionPane.showInputDialog("Ingrese Descuentos Judiciales "));
                otrosDesc = Float.parseFloat(JOptionPane.showInputDialog("Ingrese Otros Descuentos "));
                totalLiquido = Main.TL(totalDev, totalDesc);
                planillaT += totalLiquido;

                //Declarar Objeto
                N1[i][j] = new Nomina(nombre, puesto, sueldo, sueldoEx, bonificaciones, comisiones, otroB, totalDev, igss, isr, anticipo, descJudiciales, otrosDesc, totalDesc, totalLiquido, planillaT);
                totalDev = N1[i][j].getDevengado();
                igss = N1[i][j].getIgss();
                totalDesc = N1[i][j].getDesc();
            }
        }
        //Inicializo Ciclo
        int inicioI = 0, inicioJ = 0;
        N1[inicioI][inicioJ].MostrarN(N1, nCantidad_Matriz);

        int opc = 0;
        do {
            menu();
            opc = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Opcion"));

            if (opc == 1) {
                Leer_Principio(N1, nCantidad_Matriz);
            }
        } while (opc != 2);

        System.out.println("La Planilla Total es:" + planillaT);
    }

    public static void menu() {

        System.out.println("--------Menu de modificaciones de productos -------");
        System.out.println("1. Modificar Sueldo");
        System.out.println("2. Guardar ");
        System.out.println("3. Modificar precio");
        System.out.println("4. Modificar cantidad");
        System.out.println("5. Guardar");
        System.out.println("6. Dar de bajar un proudcto existente");
        System.out.println("7. Salir");

    }
}
