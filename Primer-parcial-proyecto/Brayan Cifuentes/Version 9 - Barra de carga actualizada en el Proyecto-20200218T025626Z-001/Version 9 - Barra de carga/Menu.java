package Nomina_de_salarios;

import java.io.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import org.jfree.chart.*;
import org.jfree.data.category.*;
import org.jfree.chart.plot.*;


public class Menu {
    public static Menu g = new Menu();
    int cant, cantaux, MODandDEL;
    String[] Titulos =  {"Nombre","Puesto","Sueldo Ord", "Sueldo Ext","Bonificaciones",
            "Comisiones","Otros", "TOTAL DEVENGADO","IGGS", "ISR","Anticipos", "Desc. Jud","Otros", "TOTAL DESCUENTOS","TOTAL LIQUIDADO"};
    float totales[] = new float[13];
    String[] nombre = new String[cantaux+cant];
    String[] puesto = new String[cantaux+cant];
    float Nomina_salariosArray[][] = new float[cantaux+cant][13];


    public int gotoxMatriz(String Matrix[][],int x,int y){
        int NumeroLetras[] = new int[cantaux+2];
        int NumeroMayor=0;

        for (int i = x; i < x+1 ; i++) {

            for (int j = 0; j < cantaux+2 ; j++) {
                char[] caracteres = Matrix[j][i].toCharArray();
                NumeroLetras[j] = caracteres.length;
                if(NumeroLetras[j]>=NumeroMayor ){

                    NumeroMayor = NumeroLetras[j];

                }
            }


        }



return NumeroMayor-NumeroLetras[y]+5;

    }
   /* public int gotox(int x, String vector[],int y){
        int NumeroLetras[] = new int[cantaux+y+1];
        int NumeroMayor=0;

        for (int i = 0; i < y+1; i++) {
            char[] caracteres = vector[i].toCharArray();
            NumeroLetras[i] = caracteres.length;

            if(NumeroLetras[i]>=NumeroMayor ){

                NumeroMayor = NumeroLetras[i];

            }

        }

        for (int j = 0;j < NumeroMayor-NumeroLetras[x]+5; j++) {
            System.out.print(" ");


        }


        return NumeroMayor-NumeroLetras[x]+5;
    }*/
    public void llenarMatriz(String NuevaNomina[][], float NominaFlotante[][], float TotalesdeNomina[]){
        for (int i = 0; i < 15; i++) {

            NuevaNomina[0][i] = Titulos[i];

        }
        for (int i = 1; i <  NuevaNomina.length-1; i++) {


            NuevaNomina[i][0] = nombre[i];
            NuevaNomina[i][1] = puesto[i];

        }

        for (int i = 1; i <  NuevaNomina.length-1; i++) {

            for (int j = 2;j < 15; j++) {

                NuevaNomina[i][j] = Float.toString(NominaFlotante[i-1][j-2]);


            }



            NuevaNomina[ NuevaNomina.length-1][0] ="";
            NuevaNomina[ NuevaNomina.length-1][1] ="TOTALES";



            for (int j = 2;j < 15; j++) {

                NuevaNomina[ NuevaNomina.length-1][j] =Float.toString(TotalesdeNomina[j-2]);


            }

        }


    }
   /* public void ConvertirMatrizEnVectores( String vector1[], int x, float MatrizFinal[][], String NombredeColumna){
        for(int i = 0; i < 1;i++){

            vector1[i] = NombredeColumna;
        }
        for(int i = 0; i < 13;i++){
            float NumeroLetrasMatriz[] = new float[cantaux];


            for(int j = 1; j < cantaux+1;j++){
                NumeroLetrasMatriz[j-1] = MatrizFinal[j-1][i];
                String numero = Float.toString(NumeroLetrasMatriz[j-1]);
                vector1[j] = numero;


            }
            if(i == x){
                break;
            }

        }
    }*/
    public void ImprimirNomina(int n, float Matriz[][]){
        float auxtotales=0;
       /* String[] SueldoOrdinario = new String[cantaux+1];
        String[] SueldoExtraOrdinario = new String[cantaux+1];
        String[] Bonificacion = new String[cantaux+1];
        String[] Comision = new String[cantaux+1];
        String[] Otros = new String[cantaux+1];
        String[] totalDEV = new String[cantaux+1];
        String[] Iggs = new String[cantaux+1];
        String[] Isr = new String[cantaux+1];
        String[] Anticipos = new String[cantaux+1];
        String[] Descuentos = new String[cantaux+1];
        String[] OtrosDescuentos = new String[cantaux+1];
        String[] TotalDesc = new String[cantaux+1];
        String[] TotalLiquido  = new String[cantaux+1];

        ConvertirMatrizEnVectores(SueldoOrdinario,0,Matriz,"Sueldo Ord");
        ConvertirMatrizEnVectores( SueldoExtraOrdinario,1,Matriz,"Sueldo Ext" );
        ConvertirMatrizEnVectores( Bonificacion,2,Matriz,"Bonificaciones");
        ConvertirMatrizEnVectores(Comision,3 ,Matriz,"Comision");
        ConvertirMatrizEnVectores( Otros,4,Matriz, "Otros");
        ConvertirMatrizEnVectores(totalDEV ,5,Matriz,"TOTAL DEVENGADO");
        ConvertirMatrizEnVectores( Iggs ,6,Matriz,"IGGS");
        ConvertirMatrizEnVectores(Isr,7,Matriz,"ISR");
        ConvertirMatrizEnVectores(Anticipos,8 ,Matriz,"Anticipos");
        ConvertirMatrizEnVectores(Descuentos,9,Matriz,"Descuentos" );
        ConvertirMatrizEnVectores( OtrosDescuentos ,10,Matriz,"Otros");
        ConvertirMatrizEnVectores(TotalDesc,11,Matriz,"TOTAL DESCUENTOS" );
        ConvertirMatrizEnVectores( TotalLiquido ,12 ,Matriz,"TOTAL LIQUIDADO");*/

      /* for(int i = 0; i < cantaux+1; i++){

            System.out.print("\033[37m. "+"\033[37m "+nombre[i]);gotox(i,nombre,cantaux+n);
            System.out.print("\033[37m"+puesto[i]);gotox(i,puesto,cantaux+n);
            System.out.print("\033[37m "+SueldoOrdinario[i]);gotox(i,SueldoOrdinario,cantaux+n);
            System.out.print("\033[37m "+SueldoExtraOrdinario[i]); gotox(i,SueldoExtraOrdinario,cantaux+n);
            System.out.print("\033[37m "+Bonificacion[i]);gotox(i,Bonificacion,cantaux+n);
            System.out.print("\033[37m "+Comision[i]);gotox(i,Comision,cantaux+n);
            System.out.print("\033[37m "+ Otros[i]); gotox(i, Otros,cantaux+n);
            System.out.print("\033[37m "+totalDEV[i]);gotox(i,totalDEV,cantaux+n);
            System.out.print("\033[37m "+Iggs[i]);gotox(i,Iggs,cantaux+n);
            System.out.print("\033[37m "+Isr[i]);gotox(i,Isr,cantaux+n);
            System.out.print("\033[37m "+Anticipos[i]);gotox(i,Anticipos,cantaux+n);
            System.out.print("\033[37m "+Descuentos[i]);gotox(i,Descuentos,cantaux+n);
            System.out.print("\033[37m "+OtrosDescuentos[i]);gotox(i,OtrosDescuentos,cantaux+n);
            System.out.print("\033[37m "+TotalDesc[i]);gotox(i,TotalDesc,cantaux+n);
            System.out.println("\033[37m "+TotalLiquido[i]);

        }*/

      /*for(int i = 0; i < cantaux+n+1; i++){
                Esc.print(nombre[i]);
                for(int j = 0; j < gotox(i,nombre,cantaux);j++){
                    Esc.print(" ");
                }
                Esc.print(puesto[i]);
                for(int j = 0; j < gotox(i,puesto,cantaux);j++){
                    Esc.print(" ");

                }
                Esc.print(SueldoOrdinario[i]);

                for(int j = 0; j < gotox(i,SueldoOrdinario,cantaux);j++){
                    Esc.print(" ");

                }
                Esc.print(SueldoExtraOrdinario[i]);

                for(int j = 0; j < gotox(i,SueldoExtraOrdinario,cantaux);j++){
                    Esc.print(" ");

                }
                Esc.print(Bonificacion[i]);

                for(int j = 0; j < gotox(i,Bonificacion,cantaux);j++){
                    Esc.print(" ");

                }
                Esc.print(Comision[i]);

                for(int j = 0; j < gotox(i,Comision,cantaux);j++){
                    Esc.print(" ");

                }
                Esc.print(Otros[i]);

                for(int j = 0; j < gotox(i,Otros,cantaux);j++){
                    Esc.print(" ");

                }
                Esc.print(totalDEV[i]);


                for(int j = 0; j < gotox(i,totalDEV,cantaux);j++){
                    Esc.print(" ");

                }
                Esc.print(Iggs[i]);

                for(int j = 0; j < gotox(i,Iggs,cantaux);j++){
                    Esc.print(" ");

                }
                Esc.print(Isr[i]);

                for(int j = 0; j < gotox(i,Isr,cantaux);j++){
                    Esc.print(" ");

                }
                Esc.print(Anticipos[i]);



                for(int j = 0; j < gotox(i,Anticipos,cantaux);j++){
                    Esc.print(" ");

                }
                Esc.print(Descuentos[i]);



                for(int j = 0; j < gotox(i,Descuentos,cantaux);j++){
                    Esc.print(" ");

                }
                Esc.print(OtrosDescuentos[i]);


                for(int j = 0; j < gotox(i,OtrosDescuentos,cantaux);j++){
                    Esc.print(" ");

                }
                Esc.print(TotalDesc[i]);

                for(int j = 0; j < gotox(i,TotalDesc,cantaux);j++){
                    Esc.print(" ");

                }
                Esc.println(TotalLiquido[i]);

               if(i ==0){
                     Esc.println("");
               }

            }*/
        String[][] Nominastring = new String[cantaux+2][15];
        llenarMatriz(Nominastring,Matriz,totales);

          if(cantaux > 0){
              System.out.println("\033[33m<< "+"\033[37m---PLANILLA---"+"\033[33m >>");
              for(int i = 0; i < 13;i++){

                  for(int j = 0; j < cantaux;j++){

                      auxtotales = auxtotales + Matriz[j][i];
                  }
                  totales[i] = auxtotales;
                  auxtotales=0;
              }



              for(int i = 0; i < 15;i++) {
                  System.out.print("\033[33m" + Nominastring[0][i]);
                  for (int l = 0;l <  gotoxMatriz(Nominastring,i,0); l++) {
                      System.out.print(" ");


                  }
              }
              System.out.println("");
              for(int i = 1; i < cantaux+2;i++) {

                  for (int j = 0; j < 15; j++) {

                      System.out.print("\033[37m" + Nominastring[i][j]);

                      for (int l = 0;l <  gotoxMatriz(Nominastring,j,i); l++) {
                          System.out.print(" ");


                      }


                  }
                  System.out.println("");
              }



              for(int j = 0; j < 265;j++){

                  System.out.print("\033[35m-");
              }
              System.out.println("");

              System.out.print("\033[33m TOTALES: ");
              for(int j = 0; j < 13;j++){
                  System.out.print("\033[34m  "+totales[j]+" ");

              }



          }
          else{
              MensajeNO();
          }
        try{


            PrintWriter Esc = new  PrintWriter("Nomina_de_sueldos.txt");


            for(int i = 0; i < 107; i++){
                Esc.print("-");
            }

            Esc.print("PLANILLA");
            for(int i = 0; i < 135; i++){
                Esc.print("-");
            }
            Esc.println("");

            for(int i = 0; i < cantaux+2;i++){

                for(int j = 0; j < 15;j++){

                    Esc.print(""+Nominastring[i][j]);

                    for(int k = 0; k < gotoxMatriz(Nominastring,j,i);k++){
                        Esc.print(" ");
                    }


                }
                Esc.println("");
            }


            for(int j = 0; j < 250;j++){

                Esc.print("-");
            }


            Esc.println("\nTOTALES: ");
            for(int j = 2; j < 15;j++){
                Esc.print(Titulos[j]);


                Esc.println(":  "+totales[j-2]+"");

            }
            String[] Bitacora = new String[5];


            try{
                FileReader Leer = new FileReader("Usuario_Bitacora.txt");
                BufferedReader Buffer = new BufferedReader(Leer);

                String temp = "";
                String BfRead;


                while((BfRead = Buffer.readLine()) != null){

                    for(int j = 0; j < 5;j++){

                        Bitacora[j] = BfRead;
                        BfRead =Buffer.readLine();

                    }

                }




            }catch(Exception err){


            }
            Esc.println("\nUSUARIO QUE REGISTRO NOMINA: ");
            for(int j = 0; j < 5;j++){
                Esc.println(Bitacora[j]);


            }


            Esc.close();
        }catch(Exception err){

        }


    }
    public void LeerEmpleadosArchivo(){


        try{
            FileReader Leer = new FileReader("Cantidad.txt");
            BufferedReader Buffer = new BufferedReader(Leer);

            String temp = "";
            String BfRead;


            while((BfRead = Buffer.readLine()) != null){

                temp = BfRead;
            }

            cantaux = Integer.parseInt(temp);


        }catch(Exception err){
            cantaux = 0;

        }


        nombre = new String[cantaux+1];
        puesto = new String[cantaux+1];
        Nomina_salariosArray = new float[cantaux][13];

        for(int i = 0; i < 1;i++){
            nombre[i] = "NOMBRE";
            puesto[i] = "PUESTO";

        }

        try{
            FileReader Leer = new FileReader("Nomina.txt");
            BufferedReader Buffer = new BufferedReader(Leer);

            int aux1=0,aux2=0;
            String BfRead;


            while((BfRead = Buffer.readLine()) != null){

                if((aux1 == cantaux-2) && (aux2 == 13-1)){

                    break;
                }
                for(int i = 1; i < cantaux+1;i++){

                    nombre[i] = BfRead;
                    BfRead = Buffer.readLine();
                    puesto[i] = BfRead;
                    BfRead = Buffer.readLine();


                    for(int j = 0; j < 13;j++){

                        Nomina_salariosArray[i-1][j] = Float.parseFloat(BfRead);
                        BfRead = Buffer.readLine();

                        if((i == cantaux-2) && (j == 13-1)){
                            aux1=cantaux-2;
                            aux2 = 13-1;

                        }

                    }

                }


            }


        }    catch(Exception err){


        }



    }
    public void menu(){

        int op;

        do{

            LeerEmpleadosArchivo();
            ImprimirNomina(0, Nomina_salariosArray);
            String [][] NominaParaFormato=  new String[cantaux+2][15];

            String ruta = "Nomina_formato.xls";
            llenarMatriz( NominaParaFormato,Nomina_salariosArray,totales);

            g.generarExcel( NominaParaFormato, ruta);
            System.out.println(" ");


            op = Integer.parseInt(JOptionPane.showInputDialog("1. INGRESE DATOS Y VALORES SOLICITADOS/MOSTRAR BITACORA"+"\n"+"2. MOSTRAR BITACORA"+"\n"+"3. MODIFICAR DATOS"+"\n"+"4. ELIMINAR DATOS"+"\n"+"5. GRAFICAR"+"\n"+"6. SALIR"+ "\n\n"  + "DIGITE LA OPCION: "));

            switch(op){

                case 1:
                    cant = Integer.parseInt(JOptionPane.showInputDialog("DIGITE CANTIDAD DE EMPLEADOS: "));
                    MODandDEL = cant;
                    Nomina_sueldos Nomina = new Nomina_sueldos(cant,cantaux);
                    Nomina.IngresoDatos(Nomina_salariosArray, nombre,puesto);

                    break;

                case 2:

                    break;
                case 3:

                    Nomina_sueldos Modificar = new Nomina_sueldos(MODandDEL,cantaux);
                    Modificar.ModificarDatos(Nomina_salariosArray, nombre,puesto);
                    break;

                case 4:
                    if(cantaux > 0){
                        do{
                            cant = Integer.parseInt(JOptionPane.showInputDialog("DIGITE CANTIDAD DE EMPLEADOS: "));
                        }while(cant > cantaux );
                    }

                    Nomina_sueldos Eliminar = new Nomina_sueldos(cant,cantaux);
                    Eliminar.EliminarDatos(Nomina_salariosArray, nombre,puesto);
                    break;

                case 5:
                    Graficar(totales);
                    break;
            }

        }while(op != 6);
    }
    public void Graficar(float Totales[]){
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        final String VIDEO1= "TOTAL";
        final String VIDEO2= "TOTAL";
        final String VIDEO3= "TOTAL";
        final String VIDEO4= "TOTAL";



        data.addValue(Totales[0], VIDEO1, "SUELDO ORDINARIO");
        data.addValue(Totales[1], VIDEO2, "SUELDO EXTRAORDINARIO");
        data.addValue(Totales[4], VIDEO3, "BONIFICAIONES");
        data.addValue(Totales[2], VIDEO4, "COMISIONES");

        JFreeChart grafica =  ChartFactory.createBarChart3D("VIDEOS", "DIAS", "Reproducciones", data, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel contenedor = new ChartPanel(grafica);
        JFrame ventana = new JFrame("Graficas en java");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(contenedor);
        ventana.setSize(300, 200);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
    }
    public void generarExcel (String[][] entrada, String ruta)

    {
        try
        {
            WorkbookSettings conf = new WorkbookSettings();
            conf.setEncoding("ISO-8859-1");
            WritableWorkbook woorbook = Workbook.createWorkbook(new File(ruta),conf);

            WritableSheet sheet = woorbook.createSheet("RESULTADO", 0);
            WritableFont h = new WritableFont(WritableFont.COURIER, 16,WritableFont.NO_BOLD);
            WritableCellFormat hFormat = new WritableCellFormat(h);

            for(int i = 0; i < entrada.length; i++)  // filas
            {
                for(int j = 0; j< entrada[i].length;j++)  // columnas
                {


                    sheet.addCell(new jxl.write.Label(j,i, entrada[i][j], hFormat));

                }
            }
            woorbook.write();
            woorbook.close();


        }catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);

        }  catch (WriteException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void MensajeNO()
    {
        Icon icon = new ImageIcon(getClass().getResource("/Nomina_de_salarios/GS20200124005859.gif"));
        JOptionPane.showMessageDialog(null, "SIN REGISTROS\n"+"POR FAVOR INGRESE DATA ", "PLANILLA VACIA", JOptionPane.INFORMATION_MESSAGE,icon);
    }
}
