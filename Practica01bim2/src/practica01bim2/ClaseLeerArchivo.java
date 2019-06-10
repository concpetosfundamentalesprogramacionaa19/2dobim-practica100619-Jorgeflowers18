/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica01bim2;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Jorgeso
 */
public class ClaseLeerArchivo {

    public static void leerArchivo() {

        try {
            Scanner sc = new Scanner(new File("data/tabula-FWC_2018_Squadlists_4.csv"));
            double goals; // variable para acumular los goles
            double hht; // variable para acumular la altura de los jugadores
            double promgoal = 0; // promedio de goles
            double promhht = 0; // promedio de altura
            int cont = 1; // promedio de contador

            while (sc.hasNext()) {
                String cadena = sc.nextLine();
                ArrayList<String> fwcreg = new ArrayList<>(
                        Arrays.asList(cadena.split("\\|")));

                goals = Double.parseDouble(fwcreg.get(11)); // lectura de goles
                hht = Double.parseDouble(fwcreg.get(9)); // lectura de altura

                promgoal = promgoal + goals; // acumulacion de goles
                promhht = promhht + hht; // acumulacion de altura
                cont++; // contador aumetnando en 1
            }
            sc.close(); // cierre de escaner

            promgoal = promgoal / cont; // cálculo de promedio de goles
            promhht = promhht / cont; // cálculo de promedio de altura
            System.out.printf("El promedio de goles fue por %.2f, y el promedio"
                    + " de altura %.2f", promgoal, promhht); // presentacion
        } catch (Exception e) {
            // en caso de error se expide el siguiente mensaje
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        }

    }

}
