/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tsp;

import java.util.Random;
import objetos.IndividuoTSP;

/**
 *
 * @author oziel
 */
public class Muta {
     public static void muta (IndividuoTSP i){
        //necesitamos dos posiciones para moder modificar
        Random ran = new Random();
        int pos1, pos2;
        do{
            pos1 = ran.nextInt(i.getGenotipo().length);
            pos2 = ran.nextInt(i.getGenotipo().length);
        }while(pos1 == pos2);
        
        int aux;
        aux = i.getGenotipo()[pos1];
        i.getGenotipo()[pos1] = i.getGenotipo()[pos2];
        i.getGenotipo()[pos2] = aux;
        //actualizar el fenotipo y el fitness
        i.actualizar();
    }

    static boolean evaluarMuta(double prob) {
        return Math.random()<=prob;
    }
}
