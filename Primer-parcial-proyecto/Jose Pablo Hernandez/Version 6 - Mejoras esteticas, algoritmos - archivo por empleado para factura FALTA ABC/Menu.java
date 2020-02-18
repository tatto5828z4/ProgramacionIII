
package nomina.de.sueldos;

import java.io.*;

import javax.swing.JOptionPane;
/**
 *
 * @author hp
 */  
    

public class Menu {
    int cant, cantaux, MODandDEL;
    String[] Titulos =  {"Nombre","Puesto","Sueldo Ord", "Sueldo Ext","Bonificaciones", 
    "Comisiones","Otros", "TOTAL Devengado","IGGS", "ISR","Anticipos", "Desc. Jud","Otros", "TOTAL Desc","TOTAL LIQUIDADO"};
    float totales[] = new float[13];
    String[] nombre = new String[cantaux+cant];
    String[] puesto = new String[cantaux+cant];
    float Nomina_salariosArray[][] = new float[cantaux+cant][13];
    
public int gotox(int x, String vector[],int y){
    int NumeroLetras[] = new int[cantaux+y+1];
    int NumeroMayor=0;

    for (int i = 0; i < y+1; i++) {
        char[] caracteres = vector[i].toCharArray();
        NumeroLetras[i] = caracteres.length;
        
     if(NumeroLetras[i]>=NumeroMayor ){
            
      NumeroMayor = NumeroLetras[i];
           
        }
       
    }
         
    for (int j = 0;j < NumeroMayor-NumeroLetras[x]+8; j++) {
    System.out.print(" ");
                   
           
    }
                
               
         return NumeroMayor-NumeroLetras[x]+8;      
}

public void ConvertirMatrizEnVectores( String vector1[], int x, float MatrizFinal[][], String NombredeColumna){
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
}
public void ImprimirNomina(int n, float Matriz[][]){
        float auxtotales=0;
        String[] SueldoOrdinario = new String[cantaux+1];
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
        ConvertirMatrizEnVectores(totalDEV ,5,Matriz,"Total Devengado");
        ConvertirMatrizEnVectores( Iggs ,6,Matriz,"IGGS");
        ConvertirMatrizEnVectores(Isr,7,Matriz,"ISR");
        ConvertirMatrizEnVectores(Anticipos,8 ,Matriz,"Anticipos");
        ConvertirMatrizEnVectores(Descuentos,9,Matriz,"Descuentos" );
        ConvertirMatrizEnVectores( OtrosDescuentos ,10,Matriz,"Otros");
        ConvertirMatrizEnVectores(TotalDesc,11,Matriz,"Total Descuentos" );
        ConvertirMatrizEnVectores( TotalLiquido ,12 ,Matriz,"TOTAL LIQUIDADO");
        
        
             
        for(int i = 0; i < cantaux+1; i++){
             
          System.out.print("\033[34m. "+"\033[33m "+nombre[i]);gotox(i,nombre,cantaux+n);
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
                
         }
         
         for(int i = 0; i < 13;i++){

        for(int j = 0; j < cantaux;j++){

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
               
       try{
             
        
        PrintWriter Esc = new  PrintWriter("Nomina_de_sueldos.txt");
            
                 
       
              
      
              
              for(int i = 0; i < cantaux+n+1; i++){
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
     
              /* if(i ==0){
                     Esc.println("");
               }*/
                  
              }
               Esc.println("\nTOTALES: ");
               for(int j = 2; j < 15;j++){
              Esc.print(Titulos[j]);
         
                 
                  Esc.println(":  "+totales[j-2]+"");
                   
              }
               String[] Vitacora = new String[5];
               
              
                try{
               FileReader Leer = new FileReader("Usuario_vitacora.txt");
               BufferedReader Buffer = new BufferedReader(Leer);
              
               String temp = "";
               String BfRead;
               
           
             while((BfRead = Buffer.readLine()) != null){
         
                 for(int j = 0; j < 5;j++){
                    
               Vitacora[j] = BfRead;
               BfRead =Buffer.readLine();

              }
                
            }
           
           
                 
   
          }catch(Exception err){
              
               
             }
                 Esc.println("\nUSUARIO QUE REGISTRO NOMINA: ");
                 for(int j = 0; j < 5;j++){
                 Esc.println(Vitacora[j]);
         

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
               cantaux =0;
               //JOptionPane.showMessageDialog(null,":(");
             }
      
            
          nombre = new String[cantaux+1];
          puesto = new String[cantaux+1];
         Nomina_salariosArray = new float[cantaux][13];
           
        for(int i = 0; i < 1;i++){
            nombre[i] = "Nombre";
          puesto[i] = "Puesto";
            
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
             //JOptionPane.showMessageDialog(null,"nomina:(");
             }
         
        
         
       }
public void menu(){
     
        int op;
         
       do{
              
          LeerEmpleadosArchivo();
          ImprimirNomina(0, Nomina_salariosArray);
        
          System.out.println(" ");
           
           
          op = Integer.parseInt(JOptionPane.showInputDialog("1. INGRESE DATOS Y VALORES SOLICITADOS/MOSTRAR VITACORA"+"\n"+"2. MOSTRAR VITACORA"+"\n"+"3. MODIFICAR DATOS"+"\n"+"4. ELIMINAR DATOS"+"\n"+"5. SALIR"+ "\n\n"  + "DIGITE LA OPCION: "));
               
         switch(op){
                   
          case 1:
            cant = Integer.parseInt(JOptionPane.showInputDialog("DIGITE CANT DE EMPLEADOS: "));
            MODandDEL = cant;
            Nomina_sueldos Nomina = new Nomina_sueldos(cant,cantaux);  
            Nomina.IngresoDatos(Nomina_salariosArray, nombre,puesto);
            
          break;
  
          case 2:
              LeerEmpleadosArchivo();
              ImprimirNomina(0, Nomina_salariosArray);
          break;
        
          case 3:
              Nomina_sueldos Nomina1 = new Nomina_sueldos(MODandDEL,cantaux);  
              Nomina1.ModificarDatos();
          break;
          
          case 4:
              
          break;
         }      
                  
     }while(op != 5);
    }
        
}