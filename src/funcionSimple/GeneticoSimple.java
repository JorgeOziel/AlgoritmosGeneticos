/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcionSimple;

import java.util.ArrayList;
import objetos.Individuo;

/**
 *
 * @author oziel
 */
public class GeneticoSimple {
    private int tamanoPoblacion;
    private int numGeneraciones;
    private double probMuta;
    private ArrayList<Individuo> poblacion;
    
    public GeneticoSimple(int tamanoPoblacion, int numGeneraciones, double probMuta) {
        this.tamanoPoblacion = tamanoPoblacion;
        this.numGeneraciones = numGeneraciones;
        this.probMuta = probMuta;
        this.poblacion = new ArrayList();
        generarPoblacionInicial();
    }
    
    public void evolucionar(){
        // 
    }

    private void generarPoblacionInicial() {
        //se genere de manera aleatoria
        for(int x=0;x<this.tamanoPoblacion;x++){
            this.poblacion.add(new Individuo());
        }
    }
}
