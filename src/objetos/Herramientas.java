/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
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
    
    public int[][] crearMatriz(int min, int max, int tam){
        Random random = new Random();
        int matriz[][] = new int[tam][tam];
        for(int i=0; i<tam;i++){
            for(int j=0; j<tam; j++){
                matriz[i][j]= (int) (random.nextInt(max + min) + min);
            }
        }
        return matriz;
    }
    public void guardarMatriz(int[][] matriz) throws IOException{
        System.out.println("AVISO");
        String cadena = "";
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz.length;j++){
            cadena+=matriz[i][j];
            if(j != matriz.length-1) cadena+=",";
            }
            cadena+="\n";
        }
        System.out.println("AVISO");
        String path = "C:\\Users\\oziel\\OneDrive\\Documentos\\NetBeansProjects//Matrices//Hola.txt";
        System.out.println("AVISO");
        Files.write(Paths.get(path), cadena.getBytes());
        System.out.println("AVISO");
    }
    
    public int[][] abrirFile() throws IOException {
     String texto, aux;
     LinkedList<String> lista = new LinkedList();
     int tam;
     ArrayList<int[]> lista3 = new ArrayList();
     int[][] matriz;
        try {
            //llamamos el metodo que permite cargar la ventana
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(file);
            //abrimos el archivo seleccionado
            File abre = file.getSelectedFile();

            //recorremos el archivo y lo leemos
            if (abre != null) {
                
                FileReader archivos = new FileReader(abre);
                BufferedReader lee = new BufferedReader(archivos);
                
                while ((aux = lee.readLine()) != null) {
                    texto = aux;
                    lista.add(texto);
                }
                lee.close();

                ArrayList<String> lista2 = new ArrayList<>();
                String clase = "";
                for (int i = 0; i < (lista.size()); i++) {
                    StringTokenizer st = new StringTokenizer(lista.get(i), ",");

                    while (st.hasMoreTokens()) {
                        lista2.add(st.nextToken());
                    }
                    int[] vector = new int[lista2.size()];
                    for (int x = 0; x < lista2.size(); x++) {
                        vector[x] = Integer.parseInt(lista2.get(x));
                    }
                    lista3.add(vector);
                    lista2.clear();
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        tam = lista3.get(0).length;
        matriz = new int[tam][tam];
        for(int i=0;i<tam;i++){
                for(int j=0;j<tam;j++){
                    matriz[i][j] = lista3.get(i)[j];
            }
        }
        return matriz;
    }
    
    public static void imprimirArreglo(int[] arreglo){
        String cadena="";
        for(int i=0; i<arreglo.length;i++){
            cadena += arreglo[i];
        }
        System.out.println(cadena);
    }
}
