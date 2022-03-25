/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcionSimple;

import java.util.Random;
import objetos.Individuo;

/**
 *
 * @author oziel
 */
public class Muta {
    public static void muta (Individuo i){
        //necesitamos una posición para moder modificar
        Random ran = new Random();
        int pos = ran.nextInt(i.getGenotipo().length);
        //Se modifica el valor del genotipo
        if(i.getGenotipo()[pos]==0){
            i.getGenotipo()[pos]=1;
        }else{
            i.getGenotipo()[pos]=0;
        }
        //actualizar el fenotipo y el fitness
        i.actualizar();
    }

    static boolean evaluarMuta(double prob) {
        return Math.random()<=prob;
    }
}
