/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herramientas;

import funcionSimple.GeneticoSimple;
import java.util.ArrayList;

/**
 *
 * @author oziel
 */
public class crearGrafica {
        GeneticoSimple gs;
        Grafica gr;
        ArrayList<Serie> series;
        public crearGrafica(int tam, int gen, double prob){
            this.gs = new GeneticoSimple(tam,gen,prob);
            this.gr = new Grafica("GeneticoSimple", "Fenotipo", "Generaciones");
            this.series = new ArrayList();
        }
        public long[] crearSerie(){
          long[] serie;
          series =  gs.evolucionarGrafica();
          serie = new long[series.size()];
          for(int i=0; i<series.size();i++){
                serie[i] = series.get(i).fenotipo;
            }  
          return serie;
        }
        
        public void crearGrafica(){
            this.gr.agregarSerie(crearSerie(), "");
            this.gr.creaYmuestraGrafica();
        }
}
