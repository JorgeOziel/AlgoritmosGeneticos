/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

/**
 *
 * @author oziel
 */
public class Individuo {
    private int[] genotipo;
    private int fenotipo;
    private int fitness;
    
    public Individuo(){
        this.genotipo = Herramientas.generarArreglo(24);
        calcularFenotipo();
        calcularFitness();
    }
    
    //creación aleatoria
    public Individuo(int[] genotipo){
        this.genotipo = genotipo.clone();
        //hacer los cálculos de fenotipo/fitness
        calcularFenotipo();
        calcularFitness();
    }
    
    public void calcularFenotipo(){
        //hacer un corrimiento del arreglo y pasar a entero
        int suma=0;
        for(int i=0;i<getGenotipo().length;i++){
            suma = (int) (suma + (getGenotipo()[i]*Math.pow(2, (getGenotipo().length-1-i))));
        }
        this.fenotipo = suma;
    }
    public void calcularFitness(){
        this.fitness = 2*(this.fenotipo);
    }
    public void actualizar(){
        calcularFenotipo();
        calcularFitness();
    }

    /**
     * @return the genotipo
     */
    public int[] getGenotipo() {
        return this.genotipo;
    }

    /**
     * @return the fenotipo
     */
    public int getFenotipo() {
        return this.fenotipo;
    }

    /**
     * @return the fitness
     */
    public int getFitness() {
        return this.fitness;
    }
    
}
