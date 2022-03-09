/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcionSimple;

import java.util.Random;
import objetos.Herramientas;
import objetos.Individuo;

/**
 *
 * @author oziel
 */
public class Cruza {
    
    // método de cruza en base a máscara, y retorna el mejor 
    public static Individuo cruzaMascara (Individuo m,
            Individuo p, int[] mascara){
               int[] g1 = new int[m.getGenotipo().length];
               int[] g2 = new int[m.getGenotipo().length];
               //recorremos la máscara
               for(int x=0;x<mascara.length;x++){
                   // coias genotípicas en los genes de los hijos
                   if(mascara[x]==1){
                       g1[x] = m.getGenotipo()[x];
                       g2[x] = p.getGenotipo()[x];
                   }else{
                       g1[x] = p.getGenotipo()[x];
                       g2[x] = m.getGenotipo()[x];
                   }
               }
               Individuo h1 = new Individuo(g1);
               Individuo h2 = new Individuo(g2);
               if(h1.getFenotipo()>h2.getFenotipo()) return h1;
               
               return h2;
    }
    
    
}
