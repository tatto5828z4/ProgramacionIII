package Paquete_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Nomina {

    //Atributos
    String nombre;
    String puesto;

    float sueldo;
    float sueldoEx;
    float bonificaciones;
    float comisiones;
    float otroB;
    float totalDev;
    float igss;
    float isr;
    float anticipo;
    float descJudiciales;
    float otrosDesc;
    float totalDesc;
    float totalLiquido;
    float planillaT;
    

    //Metodos
    public Nomina(String nombre, String puesto, float sueldo, float sueldoEx, float bonificaciones, float comisiones, float otroB, float totalDev, float igss, float isr, float anticipo, float descJudiciales, float otrosDesc, float totalDesc, float totalLiquido, float planillaT) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.sueldo = sueldo;
        this.sueldoEx = sueldoEx;
        this.bonificaciones = bonificaciones;
        this.comisiones = comisiones;
        this.otroB = otroB;
        this.totalDev = totalDev;
        this.igss = igss;
        this.isr = isr;
        this.anticipo = anticipo;
        this.descJudiciales = descJudiciales;
        this.otrosDesc = otrosDesc;
        this.totalDesc = totalDesc;
        this.totalLiquido = totalLiquido;
        this.planillaT = planillaT;
    }

    public float getDevengado() {
        totalDev = sueldo + sueldoEx + bonificaciones + comisiones + otroB;
        return totalDev;
    }

    public float getIgss() {
        igss = totalDev * 0.048f;
        return igss;
    }

    public float getDesc() {
        totalDesc = igss + anticipo + descJudiciales + otrosDesc;
        return totalDesc;
    }

    public void MostrarN(Nomina nomina[][], int cant) {
        try {
            FileWriter escribir = new FileWriter("C:\\Users\\Langas\\Desktop\\Nuevo.txt", true);
            PrintWriter escribiendo = new PrintWriter(escribir, true);
            FileReader leer = new FileReader("C:\\Users\\Langas\\Desktop\\Nuevo.txt");
            BufferedReader buf_leer = new BufferedReader(leer);

            String linea = null, buf;

            while ((buf = buf_leer.readLine()) != null) {
                linea = buf;
            }

            if (linea == null) {
                escribiendo.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                escribiendo.println("    Empleado." + "       Puesto." + "      Sueldo." + "        Sueldo Extraor." + "        Bonificaciones." + "       Comisiones." + "             OtrosB." + "                 Sueldo Bruto." + "       IGSS." + "      ISR." + "       Anticipos." + "               Desc Judc." + "          Otros Descuentos." + "       Total Descuentos." + "       Total Liquido.");
                escribiendo.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            }

            for (int i = 0; i < cant; i++) {
                for (int j = 0; j < 1; j++) {
                    escribiendo.print("|" + "Empleado: " + nomina[i][j].nombre + "|");
                    escribiendo.print("Puesto:" + nomina[i][j].puesto + " " + "|");
                    escribiendo.print("Sueldo: " + nomina[i][j].sueldo + " " + "|");
                    escribiendo.print("Sueldo Extraordinario: " + nomina[i][j].sueldoEx + " " + "|");
                    escribiendo.print("Bonificaciones: " + nomina[i][j].bonificaciones + " " + "|");
                    escribiendo.print("Comisiones: " + nomina[i][j].comisiones + " " + "|");
                    escribiendo.print("Otros Beneficios: " + nomina[i][j].otroB + " " + "|");
                    escribiendo.print("Sueldo Bruto: " + nomina[i][j].totalDev + " " + "|");
                    escribiendo.print("IGSS: " + nomina[i][j].igss + " " + "|");
                    escribiendo.print("ISR: " + nomina[i][j].isr + " " + "|");
                    escribiendo.print("Anticipos: " + nomina[i][j].anticipo + " " + "|");
                    escribiendo.print("Descuentos Judiciales: " + nomina[i][j].descJudiciales + " " + "|");
                    escribiendo.print("Otros Descuentos: " + nomina[i][j].otrosDesc + " " + "|");
                    escribiendo.print("Total Descuentos: " + nomina[i][j].totalDesc + " " + "|");
                    escribiendo.print("Total Liquido: " + nomina[i][j].totalLiquido + " " + "|");
                }
                escribiendo.println();
            }
            escribir.close();
            escribiendo.close();
            leer.close();
            Main.Leer();

        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public void Modificar(Nomina nomina[][]) 
    {
       
    }
    
    
    public void menu()
    {
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
