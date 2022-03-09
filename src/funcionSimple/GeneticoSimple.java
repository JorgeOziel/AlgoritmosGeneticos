/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcionSimple;

import herramientas.Serie;
import java.util.ArrayList;
import objetos.Herramientas;
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
        ArrayList<Individuo> pobAux;
        int [] mascara = Herramientas.generarArreglo(24);
        // someter a la población a un proceso evolutivo
        for(int g=0; g<this.numGeneraciones;g++){
            //crear una población nueva
            pobAux = new ArrayList();
            for(int i = 0; i < this.tamanoPoblacion;i++){
                // muestreo y/o selección
                //torneo
                Individuo madre = Seleccion.seleccionTorneo(this.poblacion);
                Individuo padre = Seleccion.seleccionAleatoria(this.poblacion);
                // cruza
                Individuo hijo = Cruza.cruzaMascara(madre, padre, mascara);
                // evaluar la posibilidad de muta
                if(Muta.evaluarMuta(this.probMuta)){
                    Muta.muta(hijo);
                }
                //agregar al hijo a la población auxiliar
                pobAux.add(hijo);
                
            }
            // se tiene que actualizar la población
            actualizarPoblacion(pobAux);
            Individuo mejor = Seleccion.seleccionTorneo(this.poblacion);
            System.out.println("g:"+g+" f:"+mejor.getFenotipo());//16777215
        }
    }
    public ArrayList<Serie> evolucionarGrafica(){
        ArrayList<Serie> series = new ArrayList();
        ArrayList<Individuo> pobAux;
        int [] mascara = Herramientas.generarArreglo(24);
        // someter a la población a un proceso evolutivo
        for(int g=0; g<this.numGeneraciones;g++){
            //crear una población nueva
            pobAux = new ArrayList();
            for(int i = 0; i < this.tamanoPoblacion;i++){
                // muestreo y/o selección
                //torneo
                Individuo madre = Seleccion.seleccionTorneo(this.poblacion);
                Individuo padre = Seleccion.seleccionAleatoria(this.poblacion);
                // cruza
                Individuo hijo = Cruza.cruzaMascara(madre, padre, mascara);
                // evaluar la posibilidad de muta
                if(Muta.evaluarMuta(this.probMuta)){
                    Muta.muta(hijo);
                }
                //agregar al hijo a la población auxiliar
                pobAux.add(hijo);
                
            }
            // se tiene que actualizar la población
            actualizarPoblacion(pobAux);
            Individuo mejor = Seleccion.seleccionTorneo(this.poblacion);
            System.out.println("g:"+g+" f:"+mejor.getFenotipo());//16777215
            series.add(new Serie(g,mejor.getFenotipo()));
        }
        return series;
    }
    
    private void generarPoblacionInicial() {
        //se genere de manera aleatoria
        for(int x=0;x<this.tamanoPoblacion;x++){
            this.poblacion.add(new Individuo());
        }
    }

    private void actualizarPoblacion(ArrayList<Individuo> pobAux) {
        this.poblacion = new ArrayList();
        for(Individuo i: pobAux){
            this.poblacion.add(new Individuo(i.getGenotipo()));
        }
    }
}
