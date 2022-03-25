/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tsp;

import java.util.ArrayList;
import objetos.IndividuoTSP;

/**
 *
 * @author oziel
 */
public class Cruza {
    public static IndividuoTSP cruzaMascara (IndividuoTSP m, IndividuoTSP p, int[] mascara){
        
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
               IndividuoTSP h1 = new IndividuoTSP(g1);
               IndividuoTSP h2 = new IndividuoTSP(g2);
               if(h1.getFitness()>h2.getFitness() ){
                 if(validarIndividuoTSP(h1)==true)  return h1;
               }
               else if(validarIndividuoTSP(h2)==true){
                     return h2;
               }
               else if(m.getFitness()>p.getFitness()){
                     return m;
               }
               return p;
    }
    
    public static boolean validarIndividuoTSP(IndividuoTSP aux){
        ArrayList<Integer> control = new ArrayList();
        int contador = 1;
        control.add(aux.getGenotipo()[0]);
        for(int x=1;x<aux.getGenotipo().length;x++){
           if(!control.contains(aux.getGenotipo()[x])){
               control.add(aux.getGenotipo()[x]);
               contador++;
           }
        } 
        if(contador == aux.getGenotipo().length-1) return true;
        else return false;
        
    }
}
