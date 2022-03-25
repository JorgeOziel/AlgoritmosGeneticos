/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

/**
 *
 * @author oziel
 */
public class IndividuoTSP {
    private int[] genotipo;
    private int fitness;
    
    public IndividuoTSP(int ci, int nc){
        this.genotipo = Herramientas.generarArreglo(ci, nc);
        calcularFitness();
    }
    public IndividuoTSP(int[] genotipo){
        this.genotipo = genotipo;
        calcularFitness();
    }
    
    public void calcularFitness(){
        //recorrer el genotipo y consultar la matriz de distancias
        for(int x=0;x<this.genotipo.length-1;x++){
            this.fitness += objetos.Matriz.matrizDistancias[this.genotipo[x]][this.genotipo[x+1]];
        }
        this.fitness+=objetos.Matriz.matrizDistancias[this.genotipo[this.genotipo.length-1]][this.genotipo[0]];
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
