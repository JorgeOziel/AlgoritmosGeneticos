/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algoritmosgeneticos;

import funcionSimple.Cruza;
import objetos.Herramientas;
import objetos.Individuo;

/**
 *
 * @author oziel
 */
public class AlgoritmosGeneticos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] g1 = Herramientas.generarArreglo(5);
        int[] g2 = Herramientas.generarArreglo(5);
        int[] mascara = Herramientas.generarArreglo(5);
        Individuo a = new Individuo(g1);
        Individuo b = new Individuo(g2);
        System.out.println("Padres");
        Herramientas.imprimirArreglo(a.getGenotipo());
        Herramientas.imprimirArreglo(b.getGenotipo());
        System.out.println("Máscara");
        Herramientas.imprimirArreglo(mascara);
        Individuo h = Cruza.cruzaMascara(a, b, mascara);
        System.out.println("Hijo final");
        Herramientas.imprimirArreglo(h.getGenotipo());
    }

}
