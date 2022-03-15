/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tsp;

import objetos.Herramientas;

/**
 *
 * @author oziel
 */
public class Individuo {
    private int[] genotipo;
    private int fitness;
    
    public Individuo(int ci, int nc){
        this.genotipo = Herramientas.generarArreglo(ci, nc);
        calcularFitness();
    }
    public Individuo(int[] genotipo){
        this.genotipo = genotipo;
        calcularFitness();
    }
    
    public void calcularFitness(){
        //recorrer el genotipo y consultar la matriz de distancias
        for(int x=0;x<this.genotipo.length-1;x++){
            this.fitness += Matriz.matrizDistancias[this.genotipo[x]][this.genotipo[x+1]];
        }
        this.fitness+=Matriz.matrizDistancias[this.genotipo[this.genotipo.length-1]][this.genotipo[0]];
    }
    
    public void actualizar(){
        calcularFitness();
    }

    /**
     * @return the genotipo
     */
    public int[] getGenotipo() {
        return this.genotipo;
    }

    /**
     * @return the fitness
     */
    public int getFitness() {
        return this.fitness;
    }
    
}
