package Nomina_de_salarios;
import java.io.*;
import javax.swing.JOptionPane;
import com.barcodelib.barcode.QRCode;
import java.awt.Desktop;
import javax.swing.Icon;
import javax.swing.ImageIcon;
public class Nomina_sueldos {
    int cant, cantaux;
    String[] Titulos =  {"Nombre","Puesto","Sueldo Ord", "Sueldo Ext","Bonificaciones",
            "Comisiones","Otros", "TOTAL DEVENGADO","IGGS", "ISR","Anticipos", "Desc. Jud","Otros", "TOTAL DESCUENTOS","TOTAL LIQUIDADO"};
    float totales[] = new float[13];
    String[] newArray = new String[cantaux+cant];
    String[] newArray2 = new String[cantaux+cant];
    String ID;
    float[][] Nomina_salarios = new float[cantaux+cant][13];
    //Constructor
    public Nomina_sueldos(int cant, int cantaux){


        this.cant = cant;
        this.cantaux = cantaux;
        this.newArray = new String[cant+cantaux];
        this.newArray2 = new String[cant+cantaux];
        this.ID = ID;
        this.Nomina_salarios = new float[cant+cantaux][13];
        this.totales = new float[13];

    }

    public void IngresoDatos(float Nomina_salariosArray[][], String nombre[], String puesto[]){
        float aux_igss=0, aux_totaldev=0,sueldo_ordinario=0,aux_totaldesc=0, igs=0, isr=0,auxtotales=0;
        try{

            PrintWriter Esc1 = new PrintWriter("Cantidad.txt");


            Esc1.println(cant+cantaux);
            Esc1.close();

        }catch(Exception err){

        }

        try{

            FileWriter Escribir = new FileWriter("Nomina.txt",true);

            PrintWriter Esc = new  PrintWriter(Escribir);

            newArray = new String[nombre.length-1 + cant];
            System.arraycopy(nombre, 1, newArray, 0, nombre.length-1);

            newArray2 = new String[puesto.length-1 + cant];
            System.arraycopy(puesto, 1, newArray2, 0, puesto.length-1);

            Nomina_salarios = new float[cantaux+cant][13];


            for(int i = 0; i < cantaux; i++){

                for(int j = 0; j < 13;j++){

                    Nomina_salarios[i][j] = Nomina_salariosArray[i][j];

                }

            }



            for(int i = cantaux; i < cantaux+cant;i++){


                ID= JOptionPane.showInputDialog("DIGITE EL ID DE LA PERSONA. -"+(i+1));

                do{
                    newArray[i] = JOptionPane.showInputDialog("DIGITE EL NOMBRE DE LA PERSONA NO. -"+(i+1));
                    if(BuscarRegistro(newArray[i]) == true){
                        JOptionPane.showMessageDialog(null,"EMPLEADO YA REGISTRADO DIGITE DE NUEVO EL NOMBRE");
                    }

                }
                while(BuscarRegistro(newArray[i]) == true);
                Esc.println(newArray[i]);
                GenerarQR(ID,newArray[i]);
                newArray2[i] = JOptionPane.showInputDialog("DIGITE EL PUESTO DE LA PERSONA NO. -"+(i+1));Esc.println(newArray2[i]);

                PrintWriter EscribirEnArchivo = new  PrintWriter(newArray[i]+".txt");
                EscribirEnArchivo.println("DATOS PERSONALES"+"\n");
                EscribirEnArchivo.println("ID: "+ID);
                EscribirEnArchivo.println("Nombre: "+newArray[i]);
                EscribirEnArchivo.println("Puesto: "+newArray2[i]);

                for(int j = 0; j < 13;j++){
                    switch (j){

                        case 0:


                            do{
                                Nomina_salarios[i][j] = Float.parseFloat(JOptionPane.showInputDialog("DIGITE EL SUELDO ORDINARIO: "));
                                if(Nomina_salarios[i][j] < 2800){
                                    JOptionPane.showMessageDialog(null,"DIGITE DE NUEVO EL SUELDO ORDINARIO ");
                                }
                            }
                            while(Nomina_salarios[i][j] < 2800);


                            aux_igss = aux_igss + Nomina_salarios[i][j];
                            sueldo_ordinario = Nomina_salarios[i][j];
                            Esc.println(Nomina_salarios[i][j]);
                            EscribirEnArchivo.println("\nDEVENGADO\n");

                            EscribirEnArchivo.println("Salario Ordinario: "+Nomina_salarios[i][j]);
                            break;
                        case 1:
                            Nomina_salarios[i][j] = Float.parseFloat(JOptionPane.showInputDialog("DIGITE EL SUELDO EXTRAORDINARIO: "));
                            aux_igss = aux_igss + Nomina_salarios[i][j];
                            Esc.println(Nomina_salarios[i][j]);
                            EscribirEnArchivo.println("Salario Extraordinario: "+Nomina_salarios[i][j]);
                            break;
                        case 2:
                            Nomina_salarios[i][j]= Float.parseFloat(JOptionPane.showInputDialog("DIGITE LAS BONIFICACIONES: "));
                            aux_totaldev= Nomina_salarios[i][j];
                            Esc.println(Nomina_salarios[i][j]);
                            EscribirEnArchivo.println("Bonificaciones: "+Nomina_salarios[i][j]);
                            break;
                        case 3:
                            Nomina_salarios[i][j]= Float.parseFloat(JOptionPane.showInputDialog("DIGITE LAS COMISIONES: "));
                            aux_igss = aux_igss +Nomina_salarios[i][j];
                            Esc.println(Nomina_salarios[i][j]);
                            EscribirEnArchivo.println("Comisiones: "+Nomina_salarios[i][j]);
                            break;

                        case 4:
                            Nomina_salarios[i][j]= Float.parseFloat(JOptionPane.showInputDialog("DIGITE LA CANTIDAD DE OTRO TIPO DE MONTO ADICIONAL : "));
                            aux_igss = aux_igss +Nomina_salarios[i][j];
                            Esc.println(Nomina_salarios[i][j]);
                            EscribirEnArchivo.println("OTros: "+Nomina_salarios[i][j]);
                            break;

                        case 5:

                            Nomina_salarios[i][j] = aux_igss + aux_totaldev;
                            Esc.println(Nomina_salarios[i][j]);
                            EscribirEnArchivo.println("\nTotal Devengado: "+Nomina_salarios[i][j]);


                            break;

                        case 6:
                            Nomina_salarios[i][j] = (float) (aux_igss*(0.0483));
                            igs = Nomina_salarios[i][j];

                            Esc.println(Nomina_salarios[i][j]);
                            EscribirEnArchivo.println("\nDESCUENTOS\n");

                            EscribirEnArchivo.println("Iggs: "+Nomina_salarios[i][j]);
                            break;


                        case 7:
                            if(sueldo_ordinario >= 6000 && sueldo_ordinario <= 7500){
                                Nomina_salarios[i][j]= (float)(sueldo_ordinario*0.05);
                                Esc.println(Nomina_salarios[i][j]);
                            }
                            else if(sueldo_ordinario >= 7500 && sueldo_ordinario <= 9000){
                                Nomina_salarios[i][j]= (float)(sueldo_ordinario*0.06);
                                Esc.println(Nomina_salarios[i][j]);
                            }
                            else if(sueldo_ordinario >= 9000){
                                Nomina_salarios[i][j]= (float)(sueldo_ordinario*0.08);
                                Esc.println(Nomina_salarios[i][j]);
                            }
                            else{
                                Nomina_salarios[i][j]= (float)0;
                                Esc.println(Nomina_salarios[i][j]);
                            }
                            EscribirEnArchivo.println("Isr: "+Nomina_salarios[i][j]);
                            isr = Nomina_salarios[i][j];
                            break;

                        case 8:
                            Nomina_salarios[i][j]= Float.parseFloat(JOptionPane.showInputDialog("DIGITE LA CANTIDAD DE  ANTICIPOS : "));
                            aux_totaldesc = aux_totaldesc + Nomina_salarios[i][j];
                            Esc.println(Nomina_salarios[i][j]);
                            EscribirEnArchivo.println("Anticipos: "+Nomina_salarios[i][j]);
                            break;

                        case 9:
                            Nomina_salarios[i][j]= Float.parseFloat(JOptionPane.showInputDialog("DIGITE LA CANTIDAD DE DESC.JUD : "));
                            aux_totaldesc = aux_totaldesc + Nomina_salarios[i][j];
                            Esc.println(Nomina_salarios[i][j]);
                            EscribirEnArchivo.println("Descuentos Judiciales: "+Nomina_salarios[i][j]);
                            break;

                        case 10:
                            Nomina_salarios[i][j]=Float.parseFloat(JOptionPane.showInputDialog("DIGITE LA CANTIDAD DE OTRO TIPO DE DESCUENTOS : "));
                            aux_totaldesc = aux_totaldesc + Nomina_salarios[i][j];
                            Esc.println(Nomina_salarios[i][j]);
                            EscribirEnArchivo.println("Otros descuentos: "+Nomina_salarios[i][j]);
                            break;

                        case 11:

                            Nomina_salarios[i][j]= aux_totaldesc+ igs+isr;
                            Esc.println(Nomina_salarios[i][j]);


                            EscribirEnArchivo.println("Total descuentos: "+Nomina_salarios[i][j]);
                            break;
                        case 12:

                            Nomina_salarios[i][j]=  (aux_igss + aux_totaldev)-(aux_totaldesc+ igs+isr);
                            aux_igss=0;aux_totaldev=0;sueldo_ordinario=0;aux_totaldesc=0; igs=0; isr=0;
                            Esc.println(Nomina_salarios[i][j]);
                            EscribirEnArchivo.println("\nTOTALES\n");
                            EscribirEnArchivo.println("TOTAL LIQUIDADO: "+Nomina_salarios[i][j]);
                            EscribirEnArchivo.close();
                            break;


                    }

                }

            }


            for(int i = 0; i < 13;i++){

                for(int j = 0; j < cantaux+cant;j++){

                    auxtotales = auxtotales + Nomina_salarios[j][i];
                }
                totales[i] = auxtotales;
                auxtotales=0;
            }

            System.out.println(" ");

            for(int i = 0; i < cant+cantaux; i++){
                System.out.print(i+1+"\033[34m. Nombre: "+newArray[i]);
                System.out.println("\033[33m -> CARGO -- "+newArray2[i]+"  ");

                for(int j = 0; j < 13;j++){
                    System.out.print("\033[37m   "+Titulos[j]+": ");
                    System.out.println("\033[36m"+Nomina_salarios[i][j]);

                }

                System.out.println(" ");
            }


            System.out.print("\033[35m   TOTALES: ");
            for(int j = 0; j < 13;j++){
                System.out.print("\033[37m  "+totales[j]);

            }

            System.out.println("\033[36m");




            Esc.close();

        }
        catch(Exception err){



        }
    }
    public void ModificarDatos(float NominaAModificar[][], String nombre[], String puesto[]){
        float aux_igss=0, aux_totaldev=0,sueldo_ordinario=0,aux_totaldesc=0, igs=0, isr=0,auxtotales=0;
        int op, posicion=0;
        String PersonaAModificar = JOptionPane.showInputDialog("DIGITE EL NOMBRE DE LA PERSONA. -");
        String NuevoNombre=null;
        for(int l = 0;l < cantaux; l++){
           newArray[l]=  nombre[l+1];
            newArray2[l]=  puesto[l+1];

            for(int j = 0; j < 13;j++){

                Nomina_salarios[l][j] = NominaAModificar[l][j];

            }

        }

        for(int i = 0; i < cantaux; i++){

            if(PersonaAModificar.equals(newArray[i])){
               posicion = i;

                do{


                    op = Integer.parseInt(JOptionPane.showInputDialog("1. NOMBRE"+"\n"+"2. PUESTO"+"\n"+"3. SUELDO ORDINARIO"+"\n"+"4. SUELDO EXTRAORDNARIO"+"\n"
                            +"5. BONIFICACIONES"+"\n"+"6. COMISIONES"+"\n"+"7. OTROS"+"\n"+"8. ANTICIPOS"+"\n"+"9. DESCUENTOS JUDICIALES"+"\n"+"10. OTROS DESCUENTOS"+"\n"
                            +"11. SALIR"+  "\n\n"  + "DIGITE LA OPCION: "));
                    Nomina_salarios[posicion][5] =  Nomina_salarios[posicion][0]+Nomina_salarios[posicion][1]+Nomina_salarios[posicion][2]+Nomina_salarios[posicion][3]+Nomina_salarios[posicion][4];
                    Nomina_salarios[posicion][6] = (float)( Nomina_salarios[posicion][5]*0.0483);

                    if(Nomina_salarios[posicion][0] >= 6000 && Nomina_salarios[posicion][0] <= 7500){
                        Nomina_salarios[posicion][7]= (float)( Nomina_salarios[posicion][0]*0.05);

                    }
                    else if(Nomina_salarios[posicion][0] >= 7500 && Nomina_salarios[posicion][0] <= 9000){
                        Nomina_salarios[posicion][7]= (float)(Nomina_salarios[posicion][0]*0.06);

                    }
                    else if(Nomina_salarios[posicion][0] >= 9000){
                        Nomina_salarios[posicion][7]= (float)(Nomina_salarios[posicion][0]*0.08);

                    }
                    else{
                        Nomina_salarios[posicion][7]= (float)0;

                    }
                    Nomina_salarios[posicion][11]= Nomina_salarios[posicion][5]+ Nomina_salarios[posicion][6]+ Nomina_salarios[posicion][7]
                            + Nomina_salarios[posicion][8]+ Nomina_salarios[posicion][9]+ Nomina_salarios[posicion][10];
                    Nomina_salarios[posicion][12] =   Nomina_salarios[posicion][5]-Nomina_salarios[posicion][11];
                    switch(op){

                        case 1:
                            for(int j = 0; j < cantaux; j++) {
                                if(j == posicion){
                                    do{
                                        NuevoNombre = JOptionPane.showInputDialog("DIGITE EL NUEVO NOMBRE DE LA PERSONA. -");
                                        if(BuscarRegistro( NuevoNombre) == true){
                                            JOptionPane.showMessageDialog(null,"EMPLEADO YA REGISTRADO DIGITE DE NUEVO EL NOMBRE");
                                        }

                                    }  while(BuscarRegistro( NuevoNombre) == true);


                                    newArray[j] = NuevoNombre;

                                }
                            }
                            break;
                        case 2:
                            for(int j = 0; j < cantaux; j++) {
                                if(j ==posicion){
                                    String NuevoPuesto = JOptionPane.showInputDialog("DIGITE EL NUEVO PUESTO DE LA PERSONA. -");
                                    newArray2[j] = NuevoPuesto;
                                }
                            }
                            break;
                        case 3:
                            do{
                                Nomina_salarios[posicion][0] = Float.parseFloat(JOptionPane.showInputDialog("DIGITE EL NUEVO SUELDO ORDINARIO: "));
                                if(Nomina_salarios[posicion][0] < 2800){
                                    JOptionPane.showMessageDialog(null,"DIGITE DE NUEVO EL SUELDO ORDINARIO ");
                                }
                            }
                            while(Nomina_salarios[posicion][0] < 2800);



                            break;
                        case 4:
                            Nomina_salarios[posicion][1] = Float.parseFloat(JOptionPane.showInputDialog("DIGITE EL NUEVO SUELDO EXTRAORDINARIO: "));

                            break;
                        case 5:

                            Nomina_salarios[posicion][2] = Float.parseFloat(JOptionPane.showInputDialog("DIGITE LA NUEVA BONIFICACION: "));

                            break;
                        case 6:
                            Nomina_salarios[posicion][3] = Float.parseFloat(JOptionPane.showInputDialog("DIGITE LA NUEVA COMISION: "));

                            break;
                        case 7:
                            Nomina_salarios[posicion][4] = Float.parseFloat(JOptionPane.showInputDialog("DIGITE EL NUEVO OTROS: "));

                            break;
                        case 8:
                            Nomina_salarios[posicion][8] = Float.parseFloat(JOptionPane.showInputDialog("DIGITE LOS NUEVOS ANTICIPOS: "));

                            break;
                        case 9:
                            Nomina_salarios[posicion][9] = Float.parseFloat(JOptionPane.showInputDialog("DIGITE LOS NUEVOS DESCUENTOS JUDICIALES: "));

                            break;
                        case 10:
                            Nomina_salarios[posicion][10] = Float.parseFloat(JOptionPane.showInputDialog("DIGITE LOS OTROS NUEVOS DESCUENTOS "));

                            break;


                    }


                }while(op != 11);



            }else{

            }

        }
        BorraArchivo(PersonaAModificar);
        try{
            if( NuevoNombre == null){
                NuevoNombre = PersonaAModificar;
            }


            PrintWriter Esc1 = new PrintWriter("Nomina.txt");

            PrintWriter  EscribirEnArchivo = new  PrintWriter(NuevoNombre+".txt");

            EscribirEnArchivo.println("DATOS PERSONALES"+"\n");
            EscribirEnArchivo.println("ID: "+ID);
            EscribirEnArchivo.println("Nombre: "+newArray[posicion]);
            EscribirEnArchivo.println("Puesto: "+newArray2[posicion]);
            EscribirEnArchivo.println("\nDEVENGADO\n");
            EscribirEnArchivo.println("Salario Ordinario: "+Nomina_salarios[posicion][0]);
            EscribirEnArchivo.println("Salario Extraordinario: "+Nomina_salarios[posicion][1]);
            EscribirEnArchivo.println("Bonificaciones: "+Nomina_salarios[posicion][2]);
            EscribirEnArchivo.println("Comisiones: "+Nomina_salarios[posicion][3]);
            EscribirEnArchivo.println("Otros: "+Nomina_salarios[posicion][4]);
            EscribirEnArchivo.println("\nTotal Devengado: "+Nomina_salarios[posicion][5]);
            EscribirEnArchivo.println("\nDESCUENTOS\n");
            EscribirEnArchivo.println("Iggs: "+Nomina_salarios[posicion][6]);
            EscribirEnArchivo.println("Isr: "+Nomina_salarios[posicion][7]);
            EscribirEnArchivo.println("Anticipos: "+Nomina_salarios[posicion][8]);
            EscribirEnArchivo.println("Descuentos Judiciales: "+Nomina_salarios[posicion][9]);
            EscribirEnArchivo.println("Otros descuentos: "+Nomina_salarios[posicion][10]);
            EscribirEnArchivo.println("Total descuentos: "+Nomina_salarios[posicion][11]);
            EscribirEnArchivo.println("\nTOTALES\n");
            EscribirEnArchivo.println("TOTAL LIQUIDADO: "+Nomina_salarios[posicion][12]);


            for(int j= 0; j < cantaux; j++) {
                Esc1.println(newArray[j]);
                Esc1.println(newArray2[j]);

                for(int k= 0; k < 13; k++) {


                    Esc1.println(Nomina_salarios[j][k]);
                }
            }

            Esc1.close();
            EscribirEnArchivo.close();
        }catch(Exception err) {

        }




    }
    public boolean BuscarRegistro(String NombreAuxiliar){
        try{


            FileReader Leer = new FileReader("Nomina.txt");
            BufferedReader Buffer = new BufferedReader(Leer);

            String temp = " ";
            String BfRead;


            while((BfRead = Buffer.readLine()) != null){

                temp = BfRead;


                if(temp.equals(NombreAuxiliar)){

                    //JOptionPane.showMessageDialog(null,"NOMBRE ENCONTRADO");
                    return true;


                }else{
                    for(int i =0; i < 14;i++){
                        BfRead = Buffer.readLine();
                    }
                }


            }
            //Leer.close();
        }catch(Exception err){

            return false;
        }
        return false;
    }
    public static void GenerarQR(String dato, String name)
    {
        int udm= 0,resolucion=72, rotacion=0;
        float mi=0.000f,md=0.000f,ms=0.000f,min=0.000f,tam=5.00f;

        try
        {
            QRCode c = new QRCode();
            c.setData(dato);
            c.setDataMode(QRCode.MODE_BYTE);
            c.setUOM(udm);
            c.setLeftMargin(mi);
            c.setRightMargin(md);
            c.setTopMargin(ms);
            c.setBottomMargin(min);
            c.setResolution(resolucion);
            c.setRotate(rotacion);
            c.setModuleSize(tam);

            //Mostrando

            String archivo = System.getProperty("User.Nomina_de_salarios")+name+".png";
            c.renderBarcode(archivo);

            // Desktop d = Desktop.getDesktop();
            //d.open(new File(archivo));

        }catch(Exception e)
        {
            System.out.println("Error " + e);
        }
    }
public void BorraArchivo(String NombreArchivo){
    try{
        File Leer = new File(NombreArchivo+".txt");


    Leer.delete();


    }catch(Exception err){

    }
    }
}
