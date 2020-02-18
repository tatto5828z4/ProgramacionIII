/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectonomina;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
/**
 *
 * @author jorgi
 */
public class Nomina_Sueldos {
       int cant;
       String[] Titulos =  {"Sueldo Ordinario", "Sueldo Extraordinario","Bonificaciones", "Comisiones","Otros", "TOTAL Devengado","IGGS", "ISR","Anticipos", "Desc. Jud","Otros", "TOTAL descuentos","TOTAL LIQUIDADO"};
      String[] nombre = new String[cant];
      String[] puesto = new String[cant];
       float Nomina_salarios[][] = new float[cant][13];
       float totales[] = new float[13];
       
    public Nomina_Sueldos(int cant){
            

    this.cant = cant;
    this.nombre = new String[cant];
    this.puesto = new String[cant];
    this.Nomina_salarios = new float[cant][13];
    this.totales = new float[13];
    
}
    
    
   
    
    public void Imprimir(){
         for(int i = 0; i < cant; i++){
            System.out.print(i+1+"\033[34m. Nombre: "+nombre[i]);
            System.out.println("\033[33m -> CARGO -- "+puesto[i]+"  ");

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


    
    }
    
    
    
    public void InfValoresPersonales(){
  float aux_igss=0, aux_totaldev=0,sueldo_ordinario=0,aux_totaldesc=0, igs=0, isr=0,auxtotales=0;
             
         try{
              FileWriter Escribir = new FileWriter("Nomina.txt", true);
              PrintWriter Esc = new  PrintWriter(Escribir);
              
              
              for(int i = 0; i < cant;i++){
              
      
       nombre[i] = JOptionPane.showInputDialog("DIGITE EL NOMBRE DE LA PERSONA NO. -"+(i+1));Esc.println(nombre[i]);
       puesto[i] = JOptionPane.showInputDialog("DIGITE EL PUESTO DE LA PERSONA NO. -"+(i+1));Esc.println(puesto[i]);
       
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
                        break;
                    case 1:
                        Nomina_salarios[i][j] = Float.parseFloat(JOptionPane.showInputDialog("DIGITE EL SUELDO EXTRAORDINARIO: "));
                        aux_igss = aux_igss + Nomina_salarios[i][j];
                          Esc.println(Nomina_salarios[i][j]);
                        break;
                    case 2:
                       Nomina_salarios[i][j]= Float.parseFloat(JOptionPane.showInputDialog("DIGITE LAS BONIFICACIONES: "));
                        aux_totaldev= Nomina_salarios[i][j];
                          Esc.println(Nomina_salarios[i][j]);
                            
                        break;
                    case 3:
                        Nomina_salarios[i][j]= Float.parseFloat(JOptionPane.showInputDialog("DIGITE LAS COMISIONES: "));
                        aux_igss = aux_igss +Nomina_salarios[i][j];
                          Esc.println(Nomina_salarios[i][j]);
                        break;

                    case 4:
                       Nomina_salarios[i][j]= Float.parseFloat(JOptionPane.showInputDialog("DIGITE SI HUBO OTRO TIPO DE MONTO ADICIONAL : "));
                        aux_igss = aux_igss +Nomina_salarios[i][j];
                          Esc.println(Nomina_salarios[i][j]);
                        break;

                    case 5:

                       Nomina_salarios[i][j] = aux_igss + aux_totaldev;
                         Esc.println(Nomina_salarios[i][j]);
                        break;

                    case 6:
                       Nomina_salarios[i][j] = (float) (aux_igss*(0.0483));
                        igs = Nomina_salarios[i][j];
                          Esc.println(Nomina_salarios[i][j]);
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
                           Nomina_salarios[i][j]= 0;
                             Esc.println(Nomina_salarios[i][j]);
                        }
                        isr = Nomina_salarios[i][j];
                        break;

                    case 8:
                        Nomina_salarios[i][j]= Float.parseFloat(JOptionPane.showInputDialog("DIGITE SI HUBO ANTICIPOS : "));
                        aux_totaldesc = aux_totaldesc + Nomina_salarios[i][j];
                          Esc.println(Nomina_salarios[i][j]);
                        break;

                    case 9:
                        Nomina_salarios[i][j]= Float.parseFloat(JOptionPane.showInputDialog("DIGITE SI HUBO DESC.JUD : "));
                        aux_totaldesc = aux_totaldesc + Nomina_salarios[i][j];
                          Esc.println(Nomina_salarios[i][j]);
                        break;

                    case 10:
                       Nomina_salarios[i][j]=Float.parseFloat(JOptionPane.showInputDialog("DIGITE SI HUBO OTRO TIPO DE DESCUENTOS : "));
                        aux_totaldesc = aux_totaldesc + Nomina_salarios[i][j];
                          Esc.println(Nomina_salarios[i][j]);
                        break;

                    case 11:

                        Nomina_salarios[i][j]= aux_totaldesc+ igs+isr;
                          Esc.println(Nomina_salarios[i][j]);

                        break;
                    case 12:

                       Nomina_salarios[i][j]=  (aux_igss + aux_totaldev)-(aux_totaldesc+ igs+isr);
                        aux_igss=0;aux_totaldev=0;sueldo_ordinario=0;aux_totaldesc=0; igs=0; isr=0;
                          Esc.println(Nomina_salarios[i][j]+"\n");
                        break;
                }
            }
        }         
          
           for(int i = 0; i < 13;i++){

            for(int j = 0; j < cant;j++){

                auxtotales = auxtotales + Nomina_salarios[j][i];
            }
            totales[i] = auxtotales;
            auxtotales=0;
        }
                Esc.close();
                 
          }catch(Exception err){
              JOptionPane.showMessageDialog(null,"Error no se puedo Crear o Abrir el Archivo");
          }
}
    
}
