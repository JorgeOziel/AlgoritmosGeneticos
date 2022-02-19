/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import funcionSimple.Cruza;
import funcionSimple.Muta;
import objetos.Herramientas;
import objetos.Individuo;

/**
 *
 * @author oziel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] g = Herramientas.generarArreglo(5);
        Individuo a = new Individuo(g);
        Muta z = new Muta();
        Herramientas.imprimirArreglo(a.getGenotipo());
        System.out.println(a.getFenotipo());
        System.out.println(a.getFitness());
        z.muta(a);
        Herramientas.imprimirArreglo(a.getGenotipo());
        System.out.println(a.getFenotipo());
        System.out.println(a.getFitness());
        /*
        int[] g1 = Herramientas.generarArreglo(24);
        int[] g2 = Herramientas.generarArreglo(24);
        int[] mascara = Herramientas.generarMascara2punto(24, 8,16);
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
        */
}

}
