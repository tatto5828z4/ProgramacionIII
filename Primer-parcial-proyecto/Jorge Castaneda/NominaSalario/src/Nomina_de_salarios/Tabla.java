package Nomina_de_salarios;

import javax.swing.*;

import java.awt.*;

public class Tabla extends JFrame{
    int cantaux;
    String[][] Nomina_jtable;
    Object[][]  nomina;
    String[] encabezado;
    public Tabla( String[][] Nomina_jtable, int cantaux){
        this.nomina = new Object[cantaux+1][15];
        this.cantaux= cantaux;
        this.encabezado = new String[15];
        this.Nomina_jtable = new String[cantaux+1][15];

        for(int j =0; j < 15; j++){
           encabezado[j] = Nomina_jtable[0][j];
        }
        for(int i =1; i < cantaux+2;i++){
            for(int j =0; j < 15; j++){
               nomina[i-1][j] = Nomina_jtable[i][j];
            }
        }
        JTable tabla = new JTable(nomina,encabezado);
        JScrollPane scroll = new JScrollPane(tabla);
        setBounds(350,130,500,500);
        setVisible(true);
        setResizable(true);
        setSize(700,600);
        add(new Panel());
        add(scroll);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Icon Table = new ImageIcon(getClass().getResource("/Imagenes/money.png"));
        JOptionPane.showMessageDialog(null, "ACEPTAR PARA CERRAR TABLA ", "TABLA CON VALORES", JOptionPane.INFORMATION_MESSAGE,Table);
        //setVisible(false);
    }
}