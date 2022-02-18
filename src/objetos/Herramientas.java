/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

import java.util.Random;

/**
 *
 * @author oziel
 */
public class Herramientas {
    //arreglos con datos binarios
    public static int[] generarArreglo(int n){
        int[] aux = new int[n];
        Random r = new Random();
        for(int x=0;x<n;x++){
            aux[x] = r.nextInt(2);
        }
        return aux;
    }
    public static int[] generarMascara1punto (int j, int n){
        
        int[] aux = new int[j];
        for(int x=0;x<n;x++){
            aux[x] = 1;
        }
        for(int x=n; x<j;x++){
            aux[x]=0;
        }
        return aux;
    }
    public static int[] generarMascara2punto (int j,int i,int n){
        int[] aux = new int[j];
        for(int x=0;x<i;x++){
            aux[x] = 1;
        }
        for(int x=i; x<n;x++){
            aux[x]=0;
        }
        for(int x=n; x<j;x++){
            aux[x]=1;
        }
        return aux;
    }
    
    public static void imprimirArreglo(int[] arreglo){
        String cadena="";
        for(int i=0; i<arreglo.length;i++){
            cadena += arreglo[i];
        }
        System.out.println(cadena);
    }
}
