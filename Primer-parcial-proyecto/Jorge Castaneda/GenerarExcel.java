/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba_xd;

import prueba_xd.Generar;

/**
 *
 * @author jorgi
 */
public class GenerarExcel {
    
    public static Generar g = new Generar();
    
    public static void main(String[] args){
        String [][] entrada =  new String[4][4]; 
        entrada [0][0]= "Nombre";
        entrada [0][1]= "Ap. paterno";
        entrada [0][2]= "Ap. materno";
        entrada [0][3]= "EDAD";
        
        String ruta = "/Users/jorgi/Salida.xls";
        
        g.generarExcel(entrada, ruta);
        
    }
}
