import javax.swing.JOptionPane;
public class Main {
    public static void main(String[] args) {

        int cant = 1;
        float aux_igss=0, aux_totaldev=0,sueldo_ordinario=0,aux_totaldesc=0, igs=0, isr=0,auxtotales=0;

        cant = Integer.parseInt(JOptionPane.showInputDialog("DIGITE CANT DE EMPLEADOS: "));
        String[] Titulos =  {"Sueldo Ordinario", "Sueldo Extraordinario","Bonificaciones", "Comisiones","Otros", "TOTAL Devengado","IGGS", "ISR","Anticipos", "Desc. Jud","Otros", "TOTAL descuentos","TOTAL LIQUIDADO"};
        String[] nombre = new String[cant];
        String[] puesto = new String[cant];

       float Nomina_sueldos[][]= new float[cant][13];
        float totales[] = new float[13];


        for(int i = 0; i < cant;i++){
            nombre[i] = JOptionPane.showInputDialog("DIGITE EL NOMBRE DE LA PERSONA NO. -"+(i+1));
            puesto[i] = JOptionPane.showInputDialog("DIGITE EL PUESTO DE LA PERSONA NO. -"+(i+1));
            for(int j = 0; j < 13;j++){
                switch (j){
                    case 0:
                        Nomina_sueldos[i][j] = Float.parseFloat(JOptionPane.showInputDialog("DIGITE EL SUELDO ORDINARIO: "));


                        aux_igss = aux_igss + Nomina_sueldos[i][j];
                         sueldo_ordinario = Nomina_sueldos[i][j];
                         
                        break;
                    case 1:
                        Nomina_sueldos[i][j] = Float.parseFloat(JOptionPane.showInputDialog("DIGITE EL SUELDO EXTRAORDINARIO: "));
                        aux_igss = aux_igss + Nomina_sueldos[i][j];
                        break;
                    case 2:
                        Nomina_sueldos[i][j]= Float.parseFloat(JOptionPane.showInputDialog("DIGITE LAS BONIFICACIONES: "));
                        aux_totaldev= Nomina_sueldos[i][j];
                        break;
                    case 3:
                        Nomina_sueldos[i][j]= Float.parseFloat(JOptionPane.showInputDialog("DIGITE LAS COMISIONES: "));
                        aux_igss = aux_igss + Nomina_sueldos[i][j];
                        break;

                    case 4:
                        Nomina_sueldos[i][j]= Float.parseFloat(JOptionPane.showInputDialog("DIGITE SI HUBO OTRO TIPO DE MONTO ADICIONAL : "));
                        aux_igss = aux_igss + Nomina_sueldos[i][j];
                        break;

                    case 5:

                        Nomina_sueldos[i][j] = aux_igss + aux_totaldev;
                        break;

                    case 6:
                        Nomina_sueldos[i][j] = (float) (aux_igss*(0.0483));
                        igs = Nomina_sueldos[i][j];
                        break;


                    case 7:
                        if(sueldo_ordinario >= 6000 && sueldo_ordinario <= 7500){
                            Nomina_sueldos[i][j]= (float)(sueldo_ordinario*0.05);
                        }
                        else if(sueldo_ordinario >= 7500 && sueldo_ordinario <= 9000){
                            Nomina_sueldos[i][j]= (float)(sueldo_ordinario*0.06);
                        }
                        else if(sueldo_ordinario >= 9000){
                            Nomina_sueldos[i][j]= (float)(sueldo_ordinario*0.08);
                    }
                        else{
                            Nomina_sueldos[i][j]= 0;
                        }
                        isr = Nomina_sueldos[i][j];
                        break;

                    case 8:
                        Nomina_sueldos[i][j]= Float.parseFloat(JOptionPane.showInputDialog("DIGITE SI HUBO ANTICIPOS : "));
                        aux_totaldesc = aux_totaldesc + Nomina_sueldos[i][j];
                        break;

                    case 9:
                        Nomina_sueldos[i][j]= Float.parseFloat(JOptionPane.showInputDialog("DIGITE SI HUBO DESC.JUD : "));
                        aux_totaldesc = aux_totaldesc + Nomina_sueldos[i][j];
                        break;

                    case 10:
                        Nomina_sueldos[i][j]=Float.parseFloat(JOptionPane.showInputDialog("DIGITE SI HUBO OTRO TIPO DE DESCUENTOS : "));
                        aux_totaldesc = aux_totaldesc + Nomina_sueldos[i][j];
                        break;

                    case 11:

                        Nomina_sueldos[i][j]= aux_totaldesc+ igs+isr;

                        break;
                    case 12:

                        Nomina_sueldos[i][j]=  (aux_igss + aux_totaldev)-(aux_totaldesc+ igs+isr);
                        aux_igss=0;aux_totaldev=0;sueldo_ordinario=0;aux_totaldesc=0; igs=0; isr=0;
                        break;


                }


            }

        }

        for(int i = 0; i < 13;i++){

            for(int j = 0; j < cant;j++){

                auxtotales = auxtotales + Nomina_sueldos[j][i];
            }
            totales[i] = auxtotales;
            auxtotales=0;
        }






        for(int i = 0; i < cant; i++){
            System.out.print(i+1+". Nombre: "+nombre[i]);
            System.out.println(" -> CARGO -- "+puesto[i]+"  ");

            for(int j = 0; j < 13;j++){
                System.out.print("   "+Titulos[j]+": ");
                System.out.println(+Nomina_sueldos[i][j]);

            }

            System.out.println(" ");
        }
        System.out.print("TOTALES: ");
        for(int j = 0; j < 13;j++){
            System.out.print("   "+totales[j]);

        }
        System.out.println(" ");


    }
}


