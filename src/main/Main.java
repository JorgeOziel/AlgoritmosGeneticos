/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import funcionSimple.Cruza;
import funcionSimple.GeneticoSimple;
import funcionSimple.Muta;
import funcionSimple.Seleccion;
import herramientas.Grafica;
import herramientas.crearGrafica;
import java.io.IOException;
import java.util.ArrayList;
import objetos.Herramientas;
import tsp.Individuo;
import tsp.Matriz;

/**
 *
 * @author oziel
 */
public class Main {
    
    public static void main(String[] args) throws IOException {
        Matriz.matrizDistancias = new int[][]{{0,34,6,12},
                                              {34,0,40,8},
                                              {6,40,0,7},
                                              {12,8,7,0}};
        
        Individuo aux = new Individuo(new int[]{3,1,2,0});
        System.out.println(aux.getFitness());
        
        //crearGrafica cG = new crearGrafica(1000,20,0.1);
        //cG.crearGrafica();
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
