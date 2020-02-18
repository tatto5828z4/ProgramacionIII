
package nomina.de.sueldos;
/**
 *
 * @author Langas
 */
import java.io.*;
import javax.swing.JOptionPane;
public class Nomina_sueldos {
int cant, cantaux;
String[] Titulos =  {"Nombre","Puesto","Sueldo Ord", "Sueldo Ext","Bonificaciones", 
"Comisiones","Otros", "TOTAL Devengado","IGGS", "ISR","Anticipos", "Desc. Jud","Otros", "TOTAL Desc","TOTAL LIQUIDADO"};
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
              
                   
               ID= JOptionPane.showInputDialog("DIGITE EL ID DE LA PERSONA. -"+(i+1));
               
               do{
                            newArray[i] = JOptionPane.showInputDialog("DIGITE EL NOMBRE DE LA PERSONA NO. -"+(i+1));
                            if(BuscarRegistro(newArray[i]) == true){
                                JOptionPane.showMessageDialog(null,"EMPLEADO YA REGISTRADO DIGITE DE NUEVO EL NOMBRE");
                            }
                           
                        }
                        while(BuscarRegistro(newArray[i]) == true);
                Esc.println(newArray[i]);
               newArray2[i] = JOptionPane.showInputDialog("DIGITE EL PUESTO DE LA PERSONA NO. -"+(i+1));Esc.println(newArray2[i]);
               FileWriter ArchivoPorPersona = new FileWriter(newArray[i]+".txt",true);               
               PrintWriter EscribirEnArchivo = new  PrintWriter(ArchivoPorPersona);
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
                         EscribirEnArchivo.println("\nTOTALES\n");
                                
                        EscribirEnArchivo.println("Total descuentos: "+Nomina_salarios[i][j]);
                        break;
                    case 12:

                       Nomina_salarios[i][j]=  (aux_igss + aux_totaldev)-(aux_totaldesc+ igs+isr);
                        aux_igss=0;aux_totaldev=0;sueldo_ordinario=0;aux_totaldesc=0; igs=0; isr=0;
                          Esc.println(Nomina_salarios[i][j]);
                          
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
    
public void ModificarDatos(){
         try{
             
              FileWriter Escribir = new FileWriter("Nomina.txt",true);
              
              PrintWriter Esc = new  PrintWriter(Escribir);
               
               
               int op;
         
                 do{
              
         
        
                  op = Integer.parseInt(JOptionPane.showInputDialog("1. NOMBRE"+"\n"+"2. PUESTO"+"\n"+"3. SUELDO ORDINARIO"+"\n"+"4. SUELDO EXTRAORDNARIO"+"\n"
                  +"5. BONIFICACIONES"+"\n"+"6. COMISIONES"+"\n"+"7. OTROS"+"\n"+"8. ANTICIPOS"+"\n"+"9. DESCUENTOS JUDICIALES"+"\n"+"10. OTROS DESCUENTOS"+"\n"
                   +"11. SALIR"+  "\n\n"  + "DIGITE LA OPCION: "));
               
                  switch(op){
                   
                   case 1:         
                   break;  
                   case 2:             
                   break;                 
                   case 3:             
                   break;         
                   case 4:             
                   break;                  
                   case 5:             
                   break;
                   case 6:             
                   break;
                   case 7:             
                   break;
                   case 8:             
                   break;
                   case 9:             
                   break;
                   case 10:              
                   break;
                    
          
                    }      
                  
                 }while(op != 11);
              
             Esc.close();
              }catch(Exception err){
             
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
    
}