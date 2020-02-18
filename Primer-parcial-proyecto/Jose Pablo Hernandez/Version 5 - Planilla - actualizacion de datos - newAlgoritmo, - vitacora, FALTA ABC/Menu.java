
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
                
               
         return NumeroMayor-NumeroLetras[x]+8;      
}

public void ConvertirMatrizEnVectores( String vector1[], int x, float MatrizFinal[][]){
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
           
        ConvertirMatrizEnVectores(SueldoORD,0,Matriz);             
        ConvertirMatrizEnVectores( SueldoEXT,1,Matriz );
        ConvertirMatrizEnVectores( BonificaCION,2,Matriz);
        ConvertirMatrizEnVectores(ComisiON,3 ,Matriz);
        ConvertirMatrizEnVectores( OtrOS,4,Matriz);
        ConvertirMatrizEnVectores(totalDEV ,5,Matriz);
        ConvertirMatrizEnVectores( igGS ,6,Matriz);
        ConvertirMatrizEnVectores(iSR,7,Matriz);
        ConvertirMatrizEnVectores(anticiPOS,8 ,Matriz);
        ConvertirMatrizEnVectores(DescuenTOS,9,Matriz );
        ConvertirMatrizEnVectores( otrOSDesc ,10,Matriz);
        ConvertirMatrizEnVectores(totalDESC,11,Matriz );
        ConvertirMatrizEnVectores( totalLIQ ,12 ,Matriz);
        
        
        for(int i = 0; i < 15; i++){
              
        System.out.print("\033[36m"+Titulos[i]+"       ");
               
         }
        System.out.println("");
             
          for(int i = 0; i < cantaux+n; i++){
             
          System.out.print("\033[34m. "+"\033[33m "+nombre[i]);gotox(i,nombre,cantaux+n);
          System.out.print("\033[37m"+puesto[i]);gotox(i,puesto,cantaux+n);
          System.out.print("\033[37m "+SueldoORD[i]);gotox(i,SueldoORD,cantaux+n);
          System.out.print("\033[37m "+SueldoEXT[i]); gotox(i,SueldoEXT,cantaux+n);          
          System.out.print("\033[37m "+BonificaCION[i]);gotox(i,BonificaCION,cantaux+n);
          System.out.print("\033[37m "+ComisiON[i]);gotox(i,ComisiON,cantaux+n);
          System.out.print("\033[37m "+ OtrOS[i]); gotox(i, OtrOS,cantaux+n);
          System.out.print("\033[37m "+totalDEV[i]);gotox(i,totalDEV,cantaux+n);
          System.out.print("\033[37m "+igGS[i]);gotox(i,igGS,cantaux+n);
          System.out.print("\033[37m "+iSR[i]);gotox(i,iSR,cantaux+n);
          System.out.print("\033[37m "+anticiPOS[i]);gotox(i,anticiPOS,cantaux+n);                
          System.out.print("\033[37m "+DescuenTOS[i]);gotox(i,DescuenTOS,cantaux+n);                
          System.out.print("\033[37m "+otrOSDesc[i]);gotox(i,otrOSDesc,cantaux+n);
          System.out.print("\033[37m "+totalDESC[i]);gotox(i,totalDESC,cantaux+n);
          System.out.println("\033[37m "+totalLIQ[i]);
                
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
            
                 
        for(int i = 0; i < 15; i++){
              
       
                Esc.print(Titulos[i]+"\t    ");
         }
              
               Esc.println("");
              
              for(int i = 0; i < cantaux+n; i++){
              Esc.print(nombre[i]);
               for(int j = 0; j < gotox(i,nombre,cantaux);j++){
               Esc.print("  ");
              }
               Esc.print(puesto[i]);
               for(int j = 0; j < gotox(i,puesto,cantaux);j++){
               Esc.print("  ");
              
              }
               Esc.print(SueldoORD[i]);
             
               for(int j = 0; j < gotox(i,SueldoORD,cantaux);j++){
               Esc.print("  ");
              
              }
                  Esc.print(SueldoEXT[i]);
                  
              for(int j = 0; j < gotox(i,SueldoEXT,cantaux);j++){
               Esc.print("  ");
              
              }
                  Esc.print(BonificaCION[i]);
                  
                  for(int j = 0; j < gotox(i,BonificaCION,cantaux);j++){
               Esc.print("  ");
              
              }
                  Esc.print(ComisiON[i]);
                  
                  for(int j = 0; j < gotox(i,ComisiON,cantaux);j++){
               Esc.print("  ");
              
              }
                  Esc.print(OtrOS[i]);
                  
                  for(int j = 0; j < gotox(i,OtrOS,cantaux);j++){
               Esc.print("  ");
              
              }
                  Esc.print(totalDEV[i]);
                  
                  
                  for(int j = 0; j < gotox(i,totalDEV,cantaux);j++){
               Esc.print("  ");
              
              }
                  Esc.print(igGS[i]);
                  
                  for(int j = 0; j < gotox(i,igGS,cantaux);j++){
               Esc.print("  ");
              
              }
                  Esc.print(iSR[i]);
                  
        for(int j = 0; j < gotox(i,iSR,cantaux);j++){
               Esc.print("  ");
              
              }
                  Esc.print(anticiPOS[i]);
                  
                  
                  
              for(int j = 0; j < gotox(i,anticiPOS,cantaux);j++){
               Esc.print("  ");
              
              }
                  Esc.print(DescuenTOS[i]);
                  
                  
                  
                    for(int j = 0; j < gotox(i,DescuenTOS,cantaux);j++){
               Esc.print("  ");
              
              }
                  Esc.print(otrOSDesc[i]);
                  
                  
                   for(int j = 0; j < gotox(i,otrOSDesc,cantaux);j++){
               Esc.print("  ");
              
              }
                  Esc.print(totalDESC[i]);
                  
                  for(int j = 0; j < gotox(i,totalDESC,cantaux);j++){
               Esc.print("  ");
              
              }
                  Esc.println(totalLIQ[i]);
     
               
                  
              }
               Esc.println("\nTOTALES: ");
               for(int j = 2; j < 15;j++){
              Esc.print(Titulos[j]);
         
                 
                  Esc.println(":  "+totales[j-2]+"-------");
                   
              }
               String[] Vitacora = new String[4];
               
              
                try{
               FileReader Leer = new FileReader("Usuario_vitacora.txt");
               BufferedReader Buffer = new BufferedReader(Leer);
              
               String temp = "";
               String BfRead;
               
           
             while((BfRead = Buffer.readLine()) != null){
         
                 for(int j = 0; j < 4;j++){
                    
               Vitacora[j] = BfRead;
               BfRead =Buffer.readLine();

              }
                
            }
           
           
                 
   
          }catch(Exception err){
              
               
             }
                 Esc.println("\nUSUARIO QUE REGISTRO NOMINA: ");
                 for(int j = 0; j < 4;j++){
              Esc.println(Vitacora[j]);
         

              }
                
                
               Esc.close();
         }catch(Exception err){
             
         }
       
       
       
         
         
         
      }
   
public void LeerEmpleadosArchivo(){
            
           
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
