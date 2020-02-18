import  java.awt. * ;

import  javax.swing.JOptionPane ;
 principal de clase  pública {
    public  static  void  main ( String [] args ) {

int cant = 1 ;

    Cant =  entero . parseInt ( JOptionPane . showInputDialog ( " DIGITE CANT DE EMPLEADOS: " ));

    Cadena [] nombre =  nueva  Cadena [cant];
    Cadena [] puesto =  nueva  Cadena [cant];
    float [] sueldo_ordinario =  nuevo  float [cant];
    float [] sueldo_extraord =  new  float [cant];
    flotar bonificaciones [] =  nuevo  flotador [no puede];
    float [] comisiones =  new  float [cant];
    float [] otros =  new  float [cant];
    float [] totaldev =  new  float [cant];
    double [] igss =  new  double [cant];
    double [] isr =  new  double [cant];
    float [] anticipos =  new  float [cant];
    float [] desc =  new  float [cant];
    float [] otrosdesc =  new  float [cant];
    double [] totaldesc =  new  double [cant];
    double [] totalliq =  new  double [cant];



    for ( int i =  0 ; i < cant; i ++ ) {
       nombre [i] =  JOptionPane . showInputDialog ( " Digite EL NOMBRE DE LA PERSONA NO -. " + (i + 1 ));
       puesto [i] =  JOptionPane . showInputDialog ( " DIGITE EL PUESTO DE LA PERSONA NO. - " + (i + 1 ));
       sueldo_ordinario [i] =  Flotador . parseFloat ( JOptionPane . showInputDialog ( " DIGITE EL SUELDO ORDINARIO: " ));
        sueldo_extraord [i] =  Float . parseFloat ( JOptionPane . showInputDialog ( " DIGITE EL SUELDO EXTRAORDINARIO: " ));
       bonificaciones [i] =  Flotador . parseFloat ( JOptionPane . showInputDialog ( " DIGITE LAS BONIFICACIONES: " ));
       comisiones [i] =  Flotador . parseFloat ( JOptionPane . showInputDialog ( " DIGITE LAS COMISIONES: " ));
       otros [i] =  Flotador . parseFloat ( JOptionPane . showInputDialog ( " DIGITE SI HUBO OTRO TIPO DE MONTO ADICIONAL: " ));
       anticipos [i] =  Float . parseFloat ( JOptionPane . showInputDialog ( " DIGITE SI HUBO ANTICIPOS: " ));
        desc [i] =  Float . parseFloat ( JOptionPane . showInputDialog ( " DIGITE SI HUBO DESC.JUD: " ));
        otrosdesc [i] =  Float . parseFloat ( JOptionPane . showInputDialog ( " DIGITE SI HUBO OTRO TIPO DE DESCUENTOS: " ));

            igss [i] = (sueldo_ordinario [i] + sueldo_extraord [i] + comisiones [i] + otros [i]) * 0.0483 ;

        if (sueldo_ordinario [i] > = 5000 ) {
         isr [i] = sueldo_ordinario [i] * 0.0119966 ;
        }
        más {
            isr [i] = 0 ;
        }
        totaldesc [i] = anticipos [i] + desc [i] + otrosdesc [i] + igss [i] + isr [i];
       totaldev [i] = sueldo_ordinario [i] + sueldo_extraord [i] + bonificaciones [i] + comisiones [i] + otros [i];
       totalliq [i] = totaldev [i] - totaldesc [i];
       }

        flotador totalsueldo = 0 ;
        flotador  Tsueldo_extraord  =  0 ;
        flotador  Tbonificaciones  =  0 ;
        flotador  Tcomisiones  =  0 ;
        flotador  Totros  =  0 ;
        flotador  Ttotaldev  =  0 ;
        doble  Tigss  =  0 ;
        doble  Tisr  =  0 ;
        flotar  Tanticipos  =  0 ;
        flotador  Tdesc  =  0 ;
        flotador  Totrosdesc  =  0 ;
        doble  Ttotaldesc  =  0 ;
        doble  Ttotalliq  =  0 ;


        for ( int i =  0 ; i < cant; i ++ ) {
         totalsueldo = totalsueldo + sueldo_ordinario [i];
         Tsueldo_extraord  =   Tsueldo_extraord + sueldo_extraord [i];
         Tbonificaciones  =  Tbonificaciones + bonificaciones [i];
         Tcomisiones  =   Tcomisiones + comisiones [i];
         Totros  =  Totros + otros [i];
         Ttotaldev  =   Ttotaldev + totaldev [i];
         Tigss  =  Tigss + igss [i];
         Tisr  =  Tisr + isr [i];
         Tanticipos  = Tanticipos + anticipos [i];
         Tdesc  =  Tdesc + desc [i];
         Totrosdesc  =  Totrosdesc + otrosdesc [i];
         Ttotaldesc  =  Ttotaldesc + totaldesc [i];
         Ttotalliq  =  Ttotalliq + totalliq [i];

        Sistema . a cabo . print (i + 1 + " . " + nombre [i]);
        Sistema . a cabo . println ( " -> " + puesto [i]);
        Sistema . a cabo . println ( " SUELDO ORD: " + sueldo_ordinario [i]);
        Sistema . a cabo . println ( " SUELDO EXTRAORD: " + sueldo_extraord [i]);
        Sistema . a cabo . println ( " BONIFICACIONES: " + bonificaciones [i]);
        Sistema . a cabo . println ( " COMISIONES: " + comisiones [i]);
        Sistema . a cabo . println ( " OTROS: " + otros [i]);
        Sistema . a cabo . println ( " TOTAL VEDENGADO: " + totaldev [i]);
        Sistema . a cabo . println ( " --------- DESCUENTOS --------- " );
        Sistema . a cabo . println ( " IGSS: " + igss [i]);
        Sistema . a cabo . println ( " ISR: " + isr [i]);
        Sistema . a cabo . println ( " ANTICIPOS: " + anticipos [i]);
        Sistema . a cabo . println ( " DESC. JUD: " + desc [i]);
        Sistema . a cabo . println ( " OTROS: " + otrosdesc [i]);
        Sistema . a cabo . println ( " TOTAL DESCUENTOS: " + totaldesc [i]);
        Sistema . a cabo . println ( " --------- LIQUIDO TOTAL --------- " );
        Sistema . a cabo . println ( " TOTAL: " + totalliq [i]);




            Sistema . a cabo . println ( "  " );
    }



            Sistema . a cabo . println ( " --------- SUMAS --------- " );
            Sistema . a cabo . println ( " TOTAL SUELDO ORD: " + totalsueldo);
            Sistema . a cabo . println ( " SUELDO EXTRAORD: " + Tsueldo_extraord );
            Sistema . a cabo . println ( " BONIFICACIONES: " + Tbonificaciones );
            Sistema . a cabo . println ( " COMISIONES: " + Tcomisiones );
            Sistema . a cabo . println ( " OTROS: " + Totros );
            Sistema . a cabo . println ( " TOTAL VEDENGADO: " + Ttotaldev );
            Sistema . a cabo . println ( " --------- DESCUENTOS --------- " );
            Sistema . a cabo . println ( " IGSS: " + Tigss );
            Sistema . a cabo . println ( " ISR: " + Tisr );
            Sistema . a cabo . println ( " ANTICIPOS: " + Tanticipos );
            Sistema . a cabo . println ( " DESC. JUD: " + Tdesc );
            Sistema . a cabo . println ( " OTROS: " + Totrosdesc );
            Sistema . a cabo . println ( " TOTAL DESCUENTOS: " + Ttotaldesc );
            Sistema . a cabo . println ( " --------- LIQUIDO TOTAL --------- " );
            Sistema . a cabo . println ( " TOTAL: " + Ttotalliq );


            Sistema . a cabo . println ( "  " );



    }
}
/ * JOptionPane.showMessageDialog (nulo, "NOMBRE" + nombre [i]);
   JOptionPane.showMessageDialog (nulo, "PUESTO:" + puesto [i]); * /
