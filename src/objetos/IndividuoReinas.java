/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

/**
 *
 * @author Alumno
 */
public class IndividuoReinas {
    private int[] genotipo;
    private int fitness;
    private int[][] tablero;
    public IndividuoReinas(int n){
        this.genotipo = Herramientas.generarArreglo(n);
        calcularFitness();
    }
    public IndividuoReinas(int[] genotipo){
        this.genotipo = genotipo;
        calcularFitness();
    }
    
    public void calcularFitness(){
        
        for(int i=0; i < this.genotipo.length ; i++){
            for(int j=0; j < this.genotipo.length; j++){
                if(i != j){
                    if(genotipo[j] == genotipo[i]){
                    this.fitness++;
                    }
                }
            }
        }
        
        //Sumar en la diagonal
        int control=0;
        for(int i=0; i < this.genotipo.length ; i++){
            for(int j=0; j < this.genotipo.length; j++){
                if( i != j){
                    if(j < i){
                        control = i-j;
                    }else{
                        control = j-i;
                    }
                    if((genotipo[i] == genotipo[j]+control) || (genotipo[i] == genotipo[j]-control)){
                            this.fitness++;
                    }
                } 
            }
        }
    }
    public void actualizar(){
        calcularFitness();
    }
    
    public int[] getGenotipo() {
        return this.genotipo;
    }
    
    public int getFitness() {
        return this.fitness;
    }
    
}
