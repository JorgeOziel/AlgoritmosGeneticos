/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tsp;

import java.util.ArrayList;
import java.util.Random;
import objetos.IndividuoTSP;

/**
 *
 * @author oziel
 */
public class Seleccion {
    public static IndividuoTSP seleccionTorneo (ArrayList<IndividuoTSP> poblacion){
        IndividuoTSP mejor = poblacion.get(0);
        for(IndividuoTSP i: poblacion){
            if(i.getFitness()>mejor.getFitness()){
                mejor = i;
            }
        }
        return new IndividuoTSP(mejor.getGenotipo());
    }
    
    public static IndividuoTSP seleccionAleatoria (ArrayList<IndividuoTSP> poblacion){
        Random ran = new Random();
        int pos = ran.nextInt(poblacion.size());
        
        return new IndividuoTSP(poblacion.get(pos).getGenotipo());
    }
}
