/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcionSimple;

import java.util.ArrayList;
import java.util.Random;
import objetos.Individuo;

/**
 *
 * @author oziel
 */
public class Seleccion {
    
    public static Individuo seleccionTorneo (ArrayList<Individuo> poblacion){
        Individuo mejor = poblacion.get(0);
        for(Individuo i: poblacion){
            if(i.getFitness()>mejor.getFitness()){
                mejor = i;
            }
        }
        return new Individuo(mejor.getGenotipo());
    }
    
    public static Individuo seleccionAleatoria (ArrayList<Individuo> poblacion){
        Random ran = new Random();
        int pos = ran.nextInt(poblacion.size());
        
        return new Individuo(poblacion.get(pos).getGenotipo());
    }
}
