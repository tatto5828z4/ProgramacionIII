
package login_normal;

import javax.swing.JOptionPane;


public class Calculo_Planilla {
    
    public void Planilla(){
        int cantidad;
        float Suma_SO=0, Suma_SE=0, Suma_B = 0, Suma_C=0, Suma_Otros=0, Suma_TD=0;
        float Suma_IGSS=0, Suma_ISR=0, Suma_An=0, Suma_Jud=0, Suma_OD=0, Suma_Total_Descuentos=0, Suma_Total_Liquido=0;
        
        cantidad = Integer.parseInt(JOptionPane.showInputDialog("Digite el No. de Registros: "));
        
        float [][] Matriz= new float[cantidad][13];
        String [] Nombre= new String[cantidad];
        String [] Puesto= new String[cantidad];
        
        for (int i = 0; i < cantidad; i++) { //filas
            
            Nombre[i]= JOptionPane.showInputDialog("Digite Nombre del Empleado: ");
            Puesto[i]= JOptionPane.showInputDialog("Digite Puesto: ");
            
            for (int j = 0; j < 13; j++) { //columnas
                
                if(j == 0 ){
                    Matriz[i][j]=Float.parseFloat(JOptionPane.showInputDialog("Digite Sueldo Ordinario: "));
                    
                    //condicion para sueldo minimo
                    if (Matriz[i][j]<2800) {
                    JOptionPane.showInputDialog("La ley establece que el Salario Minimo es de Q. 2800");
                    Matriz[i][j]=2800;
                    }
                    
                    Suma_SO+=Matriz[i][j];
                    
                }else if(j ==1){
                    Matriz[i][j]=Float.parseFloat(JOptionPane.showInputDialog("Digite Sueldo Extraordinario:"));
                    Suma_SE+=Matriz[i][j];
                   
                }else if(j ==2){
                    Matriz[i][j]=Float.parseFloat(JOptionPane.showInputDialog("Digite Bonificacion: "));
                    Suma_B+=Matriz[i][j];
                    
                }else if(j ==3){
                    Matriz[i][j]=Float.parseFloat(JOptionPane.showInputDialog("Digite Comision: "));
                    Suma_C+=Matriz[i][j];
                    
                }else if(j ==4){
                    Matriz[i][j]=Float.parseFloat(JOptionPane.showInputDialog("Digite otros Ingresos: "));
                    Suma_Otros+=Matriz[i][j];
                    
                }else if (j==5) {
                    
                    //Total Devengado
                    Matriz[i][j]= Matriz[i][j-5]+Matriz[i][j-4]+Matriz[i][j-3]+Matriz[i][j-2]+Matriz[i][j-1];
                    JOptionPane.showConfirmDialog(null, "TOTAL DEVENGADO: "+Matriz[i][j]);
                    
                    Suma_TD+=Matriz[i][j];
                    
                }else if (j==6) {
                    
                    //IGSS
                    Matriz[i][j] = (float) ((Matriz[i][j-1])*(0.0483));
                    JOptionPane.showConfirmDialog(null, "IGSS: "+Matriz[i][j]);
                    
                    Suma_IGSS+=Matriz[i][j];
                    
                }else if (j==7) {
                    
                    //ISR
                    if (Matriz[i][j-2]>6000 && Matriz[i][j-2]<7500) {
                    Matriz[i][j]= (float) ((Matriz[i][j-2])*(0.05));
                    JOptionPane.showConfirmDialog(null,"ISR: "+Matriz[i][j]);
                    }
                    else if (Matriz[i][j-2]>7500 && Matriz[i][j-2]<9000) {
                    Matriz[i][j]= (float) ((Matriz[i][j-2])*(0.06));
                    JOptionPane.showConfirmDialog(null,"ISR: "+Matriz[i][j]);

                    }else if (Matriz[i][j-2]>9000){
                    Matriz[i][j]= (float) ((Matriz[i][j])*(0.08));
                    JOptionPane.showConfirmDialog(null, "ISR: "+Matriz[i][j]);
                    }else{
                    JOptionPane.showMessageDialog(null, "No Paga ISR");
                    Matriz[i][j]=0;
                }
                    Suma_ISR+=Matriz[i][j];
                    
                }else if (j==8) {
                    Matriz[i][j]= Float.parseFloat(JOptionPane.showInputDialog("Digite su Anticipo: "));
                    Suma_An+=Matriz[i][j];
                    
                }else if (j==9) {
                    Matriz[i][j]= Float.parseFloat(JOptionPane.showInputDialog("Digite Descuento Judicial: "));
                    Suma_Jud+=Matriz[i][j];
                    
                }else if (j==10) {
                    Matriz[i][j]= Float.parseFloat(JOptionPane.showInputDialog("Digite Otro Descuento: "));
                    Suma_OD+=Matriz[i][j];
                    
                }else if (j==11) {
                    //Total Descuentos
                    Matriz[i][j]= Matriz[i][j-5]+Matriz[i][j-4]+Matriz[i][j-3]+Matriz[i][j-2]+Matriz[i][j-1];
                    Suma_Total_Descuentos+=Matriz[i][j];
                    
                }else if (j==12) {
                     //Total Liquido
                    Matriz[i][j]= Matriz[i][j-7] - Matriz[i][j-1];
                    Suma_Total_Liquido+=Matriz[i][j];
                }
            }        
        }        
        
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Nombre:   Puesto:   Sueldo Ord:   Sueldo ExtraOrd:   Bonif:   Comision:   Otros:   T_Devengado:   IGSS:   ISR:   Antic:   Jud:   Otros:  Otros Desc: Total Liquido:" );
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        
        for (int i = 0; i < cantidad; i++) {
            System.out.print(Nombre[i]+"   ");
            System.out.print(Puesto[i]+"   ");
            
            for (int j = 0; j <13; j++) {  
                System.out.print("     "+Matriz[i][j]);
            }
            System.out.println("\n");
        }
        
        System.out.println("\n");
        System.out.println("\nRESUMEN PLANILLA ------> SUMAS");
        
        System.out.println("Total Sueldos Ordinarios Trabajadores: "+Suma_SO);
        System.out.println("Total Sueldos Extraordinarios Trabajadores: "+Suma_SE);
        System.out.println("Total Bonificaciones Trabajadores: "+Suma_B);
        System.out.println("Total Comisiones Trabajadores: "+Suma_C);
        System.out.println("Total Otros Ingresos Trabajadores: "+Suma_Otros);
        System.out.println("Total Devengado de los Trabajadores: "+Suma_TD);
        
        System.out.println("\nTotal IGSS Trabajadores: "+Suma_IGSS);
        System.out.println("Total ISR Trabajadores: "+Suma_ISR);
        System.out.println("Total Anticipos Trabajadores: "+Suma_An);
        System.out.println("Total Judiciales: "+Suma_Jud);
        System.out.println("Total Otros Descuentos: "+Suma_OD);
        
        System.out.println("Total De Descuentos Todos los trabajadores: "+Suma_Total_Descuentos);
        
        System.out.println("------------------------------------------------------------");
        System.out.println("| TOTAL LIQUIDO DE TODA LA PLANILLA ----------> Q."+Suma_Total_Liquido+" |");
        System.out.println("------------------------------------------------------------");
        
        System.out.println("\n");
    }
}