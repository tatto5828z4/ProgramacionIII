/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nomina.de.sueldos;

import java.io.*;

import javax.swing.JOptionPane;
/**
 *
 * @author hp
 */  
    

public class Menu {
     int cant, cantaux;
    
    String[] Titulos =  {"Nombre","Puesto","Sueldo Ord", "Sueldo Ext","Bonificaciones", "Comisiones","Otros", "TOTAL Devengado","IGGS", "ISR","Anticipos", "Desc. Jud","Otros", "TOTAL Desc","TOTAL LIQUIDADO"};
    float totales[] = new float[13];
    String[] nombre = new String[cant];
    String[] puesto = new String[cant];
    float Nomina_salariosArray[][] = new float[cant][13];
    String[] newArray = new String[cantaux+cant];            
    String[] newArray2 = new String[cantaux+cant];
                
  float[][] Nomina_salarios = new float[cantaux+cant][13];
    
   
     

 
public void gotox(int x, String vector[],int y){
    int NumeroLetras[] = new int[cantaux+y];
    int NumeroMayor=0;

    for (int i = 0; i < y; i++) {
        char[] caracteres = vector[i].toCharArray();
        NumeroLetras[i] = caracteres.length;
        
        if(NumeroLetras[i]>NumeroMayor ){
            
                 NumeroMayor = NumeroLetras[i];
           
        }
       
    }
         
   
                    for (int j = 0;j < NumeroMayor-NumeroLetras[x]+8; j++) {
                    System.out.print(" ");
                   
           
                }
                
               
               
}
        
public void gotoxyMatriz( String vector1[], int x, float MatrizFinal[][]){
    for(int i = 0; i < 13;i++){
            float NumeroLetrasMatriz[] = new float[cantaux];
           
            for(int j = 0; j < cantaux;j++){
                NumeroLetrasMatriz[j] = MatrizFinal[j][i];
               String numero = Float.toString(NumeroLetrasMatriz[j]);
                vector1[j] = numero;
               
                
            } 
            if(i == x){
                break;
            }
          
        }
}

      public void ImprimirNomina(int n, float Matriz[][]){
          float auxtotales=0;
          String[] SueldoORD = new String[cantaux+n];
        String[] SueldoEXT = new String[cantaux+n];
        String[] BonificaCION = new String[cantaux+n];
        String[] ComisiON = new String[cantaux+n];
        String[] OtrOS = new String[cantaux+n]; 
        String[] totalDEV = new String[cantaux+n];
        String[] igGS = new String[cantaux+n];
        String[] iSR = new String[cantaux+n]; 
        String[] anticiPOS = new String[cantaux+n];
        String[] DescuenTOS = new String[cantaux+n];
        String[] otrOSDesc = new String[cantaux+n];
        String[] totalDESC = new String[cantaux+n];
        String[] totalLIQ  = new String[cantaux+n];
           
        gotoxyMatriz(SueldoORD,0,Matriz);             
        gotoxyMatriz( SueldoEXT,1,Matriz );
        gotoxyMatriz( BonificaCION,2,Matriz);
        gotoxyMatriz(ComisiON,3 ,Matriz);
        gotoxyMatriz( OtrOS,4,Matriz);
        gotoxyMatriz(totalDEV ,5,Matriz);
        gotoxyMatriz( igGS ,6,Matriz);
        gotoxyMatriz(iSR,7,Matriz);
        gotoxyMatriz(anticiPOS,8 ,Matriz);
        gotoxyMatriz(DescuenTOS,9,Matriz );
        gotoxyMatriz( otrOSDesc ,10,Matriz);
        gotoxyMatriz(totalDESC,11,Matriz );
        gotoxyMatriz( totalLIQ ,12 ,Matriz);
        
         for(int i = 0; i < 15; i++){
              
              System.out.print("\033[36m"+Titulos[i]+"       ");
               
         }
            System.out.println("");
             
         for(int i = 0; i < cantaux+n; i++){
             
                System.out.print("\033[34m. "+"\033[33m "+nombre[i]);
                gotox(i,nombre,cantaux+n);
                System.out.print("\033[37m"+puesto[i]);
                 gotox(i,puesto,cantaux+n);
                System.out.print("\033[37m "+SueldoORD[i]);
                 gotox(i,SueldoORD,cantaux+n);
                System.out.print("\033[37m "+SueldoEXT[i]);
                 gotox(i,SueldoEXT,cantaux+n);          
                System.out.print("\033[37m "+BonificaCION[i]);
                 gotox(i,BonificaCION,cantaux+n);
                System.out.print("\033[37m "+ComisiON[i]);
                 gotox(i,ComisiON,cantaux+n);
                System.out.print("\033[37m "+ OtrOS[i]);
                 gotox(i, OtrOS,cantaux+n);
                System.out.print("\033[37m "+totalDEV[i]);
                 gotox(i,totalDEV,cantaux+n);
                System.out.print("\033[37m "+igGS[i]);
                 gotox(i,igGS,cantaux+n);
                System.out.print("\033[37m "+iSR[i]);
                 gotox(i,iSR,cantaux+n);
                System.out.print("\033[37m "+anticiPOS[i]);
                gotox(i,anticiPOS,cantaux+n);                
                System.out.print("\033[37m "+DescuenTOS[i]);
                gotox(i,DescuenTOS,cantaux+n);                
                System.out.print("\033[37m "+otrOSDesc[i]);
                gotox(i,otrOSDesc,cantaux+n);
                System.out.print("\033[37m "+totalDESC[i]);
                gotox(i,totalDESC,cantaux+n);
                System.out.println("\033[37m "+totalLIQ[i]);
                
                
           }
         
         
         for(int i = 0; i < 13;i++){

            for(int j = 0; j < cantaux+cant;j++){

                auxtotales = auxtotales + Matriz[j][i];
            }
            totales[i] = auxtotales;
            auxtotales=0;
        }
          
         
         System.out.println("");
        
              
               
        System.out.print("\033[35m TOTALES: ");
        for(int j = 0; j < 13;j++){
            System.out.print("\033[37m  "+totales[j]+" ");

        }
         
         
         
         
         
         
         
         
         
         
      }
     
     
       public void LeerEmpleados(){
            
           
           try{
               FileReader Leer = new FileReader("cantidad.txt");
               BufferedReader Buffer = new BufferedReader(Leer);
              
               String temp = "";
               String BfRead;
               
           
             while((BfRead = Buffer.readLine()) != null){
         
                temp = BfRead;
            }
           
            cantaux = Integer.parseInt(temp);
                 
   
          }catch(Exception err){
               cantaux =0;
               //JOptionPane.showMessageDialog(null,":(");
             }
      
            
          nombre = new String[cantaux];
          puesto = new String[cantaux];
         Nomina_salariosArray = new float[cantaux][13];
           
        
         
         try{
               FileReader Leer = new FileReader("nomina.txt");
               BufferedReader Buffer = new BufferedReader(Leer);
              
              int aux1=0,aux2=0;
               String BfRead;
               

        while((BfRead = Buffer.readLine()) != null){
         
                if((aux1 == cantaux-1) && (aux2 == 13-1)){
                         
                           break;
                       }
                 for(int i = 0; i < cantaux;i++){
                  
                   nombre[i] = BfRead;
                   BfRead = Buffer.readLine();
                   puesto[i] = BfRead;
                     BfRead = Buffer.readLine();
                    
                     
                   for(int j = 0; j < 13;j++){
                    
                      Nomina_salariosArray[i][j] = Float.parseFloat(BfRead);
                       BfRead = Buffer.readLine();
                       
                       if((i == cantaux-1) && (j == 13-1)){
                           aux1=cantaux-1;
                           aux2 = 13-1;
                          
                       }
                   
                   }
                   
                 }
                 
               
             }
              
             
             }    catch(Exception err){
             //JOptionPane.showMessageDialog(null,"nomina:(");
             }
         
        
                
                
        
     
         
         
         
         
       }
    public void menu(){
     
          int op;
         float aux_igss=0, aux_totaldev=0,sueldo_ordinario=0,aux_totaldesc=0, igs=0, isr=0,auxtotales=0;
       
         
        do{
              
         LeerEmpleados();
         ImprimirNomina(0, Nomina_salariosArray);
        
      System.out.println(" ");
           
           
               op = Integer.parseInt(JOptionPane.showInputDialog("1. INGRESE DATOS Y VALORES SOLICITADOS/MOSTRAR VITACORA"+"\n"+"2. CERRAR SESION"+"\n"+"3. SALIR"+  "\n\n"  + "DIGITE LA OPCION: "));
               
               switch(op){
                   
          case 1:
            

        
                   cant = Integer.parseInt(JOptionPane.showInputDialog("DIGITE CANT DE EMPLEADOS: "));
                 
                   try{
             
              PrintWriter Esc1 = new PrintWriter("cantidad.txt");
            
              
               Esc1.println(cant+cantaux);
               Esc1.close();
               
               
             
          }catch(Exception err){
             //JOptionPane.showMessageDialog(null,":(");
            }
                        
                 
                 
       try{
              FileWriter Escribir = new FileWriter("nomina.txt",true);
              
              PrintWriter Esc = new  PrintWriter(Escribir);
              
                 newArray = new String[nombre.length + cant];
                 System.arraycopy(nombre, 0, newArray, 0, nombre.length);
                 
                 newArray2 = new String[puesto.length + cant];
                 System.arraycopy(puesto, 0, newArray2, 0, puesto.length);
                 
                  Nomina_salarios = new float[cantaux+cant][13];
                
                  
             for(int i = 0; i < cantaux; i++){
                 for(int j = 0; j < 13;j++){
                      Nomina_salarios[i][j] = Nomina_salariosArray[i][j]; 
                 }
                   
                   }
   
               
               
              for(int i = cantaux; i < cantaux+cant;i++){
              
               newArray[i] = JOptionPane.showInputDialog("DIGITE EL NOMBRE DE LA PERSONA NO. -"+(i+1));Esc.println(newArray[i]);
               newArray2[i] = JOptionPane.showInputDialog("DIGITE EL PUESTO DE LA PERSONA NO. -"+(i+1));Esc.println(newArray2[i]);
                
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
                           Nomina_salarios[i][j]= (float)0;
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
                          Esc.println(Nomina_salarios[i][j]);
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
  
        break;
  
          case 2:
              
              
              break;
        
          
         }      
                  
     }while(op != 3);
    }
        
}
