/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tsp;

import herramientas.Serie;
import java.util.ArrayList;
import java.util.Random;
import objetos.Herramientas;
import objetos.IndividuoTSP;

/**
 *
 * @author oziel
 */
public class TSPGenetico {
    private int tamanoPoblacion;
    private int numGeneraciones;
    private double probMuta;
    private ArrayList<IndividuoTSP> poblacion;
    
    public TSPGenetico(int tamanoPoblacion, int numGeneraciones, double probMuta) {
        this.tamanoPoblacion = tamanoPoblacion;
        this.numGeneraciones = numGeneraciones;
        this.probMuta = probMuta;
        this.poblacion = new ArrayList();
        generarPoblacionInicial(tamanoPoblacion);
    }
    
    public void evolucionar(){
        System.out.println("Nota3");
        ArrayList<IndividuoTSP> pobAux;
        int [] mascara = Herramientas.generarArreglo(24);
        // someter a la población a un proceso evolutivo
        for(int g=0; g<this.numGeneraciones;g++){
            //crear una población nueva
            pobAux = new ArrayList();
            for(int i = 0; i < this.tamanoPoblacion;i++){
                // muestreo y/o selección
                //torneo
                IndividuoTSP madre = tsp.Seleccion.seleccionTorneo(this.poblacion);
                IndividuoTSP padre = tsp.Seleccion.seleccionAleatoria(this.poblacion);
                // cruza
                IndividuoTSP hijo = tsp.Cruza.cruzaMascara(madre, padre, mascara);
                // evaluar la posibilidad de muta
                if(tsp.Muta.evaluarMuta(this.probMuta)){
                    tsp.Muta.muta(hijo);
                }
                //agregar al hijo a la población auxiliar
                pobAux.add(hijo);
                
            }
            // se tiene que actualizar la población
            actualizarPoblacion(pobAux);
            IndividuoTSP mejor = tsp.Seleccion.seleccionTorneo(this.poblacion);
            System.out.println("g:"+g+" f:"+mejor.getFitness());//16777215
        }
    }
    public ArrayList<Serie> evolucionarGrafica(){
        ArrayList<Serie> series = new ArrayList();
        ArrayList<IndividuoTSP> pobAux;
        int [] mascara = Herramientas.generarArreglo(24);
        // someter a la población a un proceso evolutivo
        for(int g=0; g<this.numGeneraciones;g++){
            //crear una población nueva
            pobAux = new ArrayList();
            for(int i = 0; i < this.tamanoPoblacion;i++){
                // muestreo y/o selección
                //torneo
                IndividuoTSP madre = tsp.Seleccion.seleccionTorneo(this.poblacion);
                IndividuoTSP padre = tsp.Seleccion.seleccionAleatoria(this.poblacion);
                // cruza
                IndividuoTSP hijo = tsp.Cruza.cruzaMascara(madre, padre, mascara);
                // evaluar la posibilidad de muta
                if(tsp.Muta.evaluarMuta(this.probMuta)){
                    tsp.Muta.muta(hijo);
                }
                //agregar al hijo a la población auxiliar
                pobAux.add(hijo);
                
            }
            // se tiene que actualizar la población
            actualizarPoblacion(pobAux);
            IndividuoTSP mejor = tsp.Seleccion.seleccionTorneo(this.poblacion);
            System.out.println("g:"+g+" f:"+mejor.getFitness());//16777215
            series.add(new Serie(g,mejor.getFitness()));
        }
        return series;
    }
    
    private void generarPoblacionInicial(int nc) {
        System.out.println("Nota0.1");
        //se genere de manera aleatoria
        Random r = new Random();
        for(int x=0;x<nc;x++){
            int num = r.nextInt(nc);
            this.poblacion.add(new IndividuoTSP(Herramientas.generarArreglo(x, num)));
        }
        System.out.println("Nota0.2");
    }

    private void actualizarPoblacion(ArrayList<IndividuoTSP> pobAux) {
        this.poblacion = new ArrayList();
        for(IndividuoTSP i: pobAux){
            this.poblacion.add(new IndividuoTSP(i.getGenotipo()));
        }
    }
    
}
