package laboratorio_2;

import javax.swing.JOptionPane;

public class Laboratorio_2 
{
    //Metodo
         public static float ISR(float Sueldo)
         { 
             float ISRT = 0,isr = 0;
             
             if(Sueldo>6000 && Sueldo<7000)
             {
                 isr = 0.05f;
                 ISRT = Sueldo * isr;
             }
             
             if(Sueldo>7500 && Sueldo<9000)
             {
                 isr = 0.06f;
                 ISRT = Sueldo * isr;
             }
             
             if(Sueldo > 9000)
             {
                 isr = 0.08f;
                 ISRT = Sueldo * isr;
             }
             
             return ISRT;
         }
         
         public static float TL(float Sueldo,float Descuentos)
         {
             float Total_Liquido = Sueldo - Descuentos;
             
                   if(Total_Liquido<2800)
                   {
                       Total_Liquido += 2800;
                   }
             
             return Total_Liquido;
         }

    public static void main(String[] args) 
    {
         JOptionPane.showMessageDialog(null,"Bienvenido Al Programa de Nomina de Salarios");
        int nCantidad_Matriz = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Cantidad de Empleados."));
        String[][] Nombre = new String[nCantidad_Matriz][16];
        String[][] Puesto = new String[nCantidad_Matriz][16];
        float PlanillaT =0;
        float Igss = 0.048f;
        float Matriz[][] = new float[nCantidad_Matriz][16];
        
       
    
        //Pidiendo Nombres con Strings
         for(int i=0; i<nCantidad_Matriz;i++)
         {
           for(int j=0; j<16;j++)
           {
               //Nombres
               if(i<nCantidad_Matriz && j==0)
               {  
                       Nombre[i][j] = JOptionPane.showInputDialog("Ingrese Nombre"); 
               }
               
               //Puesto
               if(i<nCantidad_Matriz && j==0)
               {
                  Puesto[i][j]=JOptionPane.showInputDialog("Ingrese Puesto");
               }
               
               //Sueldos
               if(i<nCantidad_Matriz && j==0)
               {
                   Matriz[i][j] = Float.parseFloat(JOptionPane.showInputDialog("Ingrese Sueldo empleado "));
               }
               
               //Sueldo Extraordinario
               if(i<nCantidad_Matriz && j ==1)
               {
                   Matriz[i][j] = Float.parseFloat(JOptionPane.showInputDialog("Ingrese Sueldo Extraordinario"));
               }
               
               //Bonificaciones
               if(i<nCantidad_Matriz && j ==2)
               {
                   Matriz[i][j] = Float.parseFloat(JOptionPane.showInputDialog("Ingrese Bonificaciones "));
               }
               
               //Comisiones
               if(i<nCantidad_Matriz && j ==3)
               {
                   Matriz[i][j] = Float.parseFloat(JOptionPane.showInputDialog("Ingrese Comisiones "));
               }
               
               //Otros Beneficios
               if(i<nCantidad_Matriz && j ==4)
               {
                   Matriz[i][j] = Float.parseFloat(JOptionPane.showInputDialog("Ingrese Otros Beneficios "));
               }
               
               //Total Devengado
                if(i<nCantidad_Matriz && j ==5)
               {
                   Matriz[i][j] = Matriz[i][0] + Matriz[i][1] + Matriz[i][2] + Matriz[i][3] +Matriz[i][4];
               }
                
                //IGSS
                if(i<nCantidad_Matriz && j ==6)
               {
                   Matriz[i][j] = Matriz[i][5] * Igss;
               }
                
               //ISR
               if(i<nCantidad_Matriz && j ==7)
               {
                   Matriz[i][j] = Laboratorio_2.ISR(Matriz[i][0]);
               }
               
               //Anticipos
                if(i<nCantidad_Matriz && j ==8)
               {
                   Matriz[i][j] = Float.parseFloat(JOptionPane.showInputDialog("Ingrese Anticipos"));
               }
                
                //Descuentos Judiciales
                 if(i<nCantidad_Matriz && j ==9)
               {
                   Matriz[i][j] = Float.parseFloat(JOptionPane.showInputDialog("Ingrese Descuentos Judiciales "));
               }
                 
                //Otros descuentos
                  if(i<nCantidad_Matriz && j ==10)
               {
                   Matriz[i][j] = Float.parseFloat(JOptionPane.showInputDialog("Ingrese Otros Descuentos "));
               }
                  
                  //Total Descuentos
                   if(i<nCantidad_Matriz && j ==11)
               {
                   Matriz[i][j] = Matriz[i][6] + Matriz[i][7] + Matriz[i][8] + Matriz[i][9] + Matriz[i][10];
               }
                   
                 //Total Liquido
                  if(i<nCantidad_Matriz && j ==12)
               {
                   Matriz[i][j] = Laboratorio_2.TL(Matriz[i][5],Matriz[i][11]);
                   
                   
                   
                   //Planilla Total
                   PlanillaT +=Matriz[i][j];
               }
              
           }
             System.out.println("");
         }
         
          System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
         System.out.println("    Empleado." + "       Puesto." + "      Sueldo." + "        Sueldo Extraor." + "        Bonificaciones."+"       Comisiones."+ "             OtrosB." +"                 Sueldo Bruto." + "       IGSS." + "      ISR." + "       Anticipos." + "               Desc Judc." + "          Otros Descuentos." + "       Total Descuentos." + "       Total Liquido.");
         System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
         for(int i=0; i<nCantidad_Matriz;i++)
         {
           for(int j=0; j<16;j++)
           {
               if(i<nCantidad_Matriz && j==0)
               {  
                   System.out.print("|" + "Empleado: " +Nombre[i][j] + "|" );
               }
                
                if(i<nCantidad_Matriz && j==0)
               {
                   System.out.print("Puesto:" + Puesto[i][j]+ " "+ "|"  );
               }
                
                
                if(i<nCantidad_Matriz && j==0)
               {
                    System.out.print("Sueldo: " + Matriz[i][j] +" "+ "|"  );
               }
                
                if(i<nCantidad_Matriz && j ==1)
               {
                   System.out.print("Sueldo Extraordinario: " + Matriz[i][j] +" "+ "|"  );
               }
                
                if(i<nCantidad_Matriz && j ==2)
               {
                    System.out.print("Bonificaciones: " + Matriz[i][j] +" " + "|" );
               }
                
                 if(i<nCantidad_Matriz && j ==3)
               {
                  System.out.print("Comisiones: " + Matriz[i][j] +" "+ "|"  );
               }
                 
                   if(i<nCantidad_Matriz && j ==4)
               {
                   System.out.print("Otros Beneficios: " + Matriz[i][j] +" "+ "|"  );
               }
                    if(i<nCantidad_Matriz && j ==5)
               {
                   System.out.print("Sueldo Bruto: " + Matriz[i][j] +" "+ "|"  );
               }
                    
                 if(i<nCantidad_Matriz && j ==6)
               {
                   System.out.print("IGSS: " + Matriz[i][j] +" " + "|" );
               }
                 
                 if(i<nCantidad_Matriz && j ==7)
               {
                    System.out.print("ISR: " + Matriz[i][j] +" " + "|" );
               }
                 
                 if(i<nCantidad_Matriz && j ==8)
               {
                    System.out.print("Anticipos: " + Matriz[i][j] +" " + "|" );
               }
                    
                 if(i<nCantidad_Matriz && j ==9)
               {
                   System.out.print("Descuentos Judiciales: " + Matriz[i][j] +" "+ "|"  );
               } 
                  
                 if(i<nCantidad_Matriz && j ==10)
               {
                   System.out.print("Otros Descuentos: " + Matriz[i][j] +" "+ "|"  );
               }
                    
                 if(i<nCantidad_Matriz && j ==11)
               {
                   System.out.print("Total Descuentos: " + Matriz[i][j] +" " + "|" );
               }
                 
                  if(i<nCantidad_Matriz && j ==12)
               {
                   System.out.print("Total Liquido: " + Matriz[i][j] +" " + "|" );
               }
                    
           }
             System.out.println("");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
         }
         
         System.out.println("La Planilla Total es: " + PlanillaT);    
    }
}


