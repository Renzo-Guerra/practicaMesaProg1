/**
 * Hacer un programa que dado un arreglo ordenado creciente de enteros de tamaño 10 que se encuentra precargado, 
 * solicite al usuario un numero entero y lo inserte en el arreglo manteniendo su orden. 
 * 
 * Para ello tendrá que realizar un corrimiento a derecha (se pierde el último valor del arreglo)  y colocar el 
 * numero en el arreglo en la posición indicada.
 * 
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Problema6 {
  public static int CANTIDAD = 10;
  public static int DEFAULT_VALUE = 4;
  public static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
  public static void main(String args[]){
    int[] numeros = new int[CANTIDAD];
    int numeroUsuario = 0;

    cargarVectorAleatoriamente(numeros);
    imprimirVector(numeros);
    ordenarPorInsercion(numeros);
    imprimirVector(numeros);
    numeroUsuario = pedirNumero();
    corrimientoHaciaLaDerecha(numeros, numeroUsuario);
    imprimirVector(numeros);
  }

  public static void cargarVectorAleatoriamente(int[] vector){
    Random r = new Random();
    final int MIN = 1;
    final int MAX = 10;

    for(int pos = 0;pos<CANTIDAD;pos++){
      vector[pos] = (r.nextInt(MAX - MIN + 1) + MIN);
    }
  }

  public static void ordenarPorInsercion(int[] vector){
    for(int i = 1;i<CANTIDAD;i++){
      int pos = i;
      int aux = vector[i];
      while((pos > 0) && (vector[pos-1] > aux)){
        vector[pos] = vector[pos-1];
        pos--;
      }
      vector[pos] = aux;
    }
  }

  public static void corrimientoHaciaLaDerecha(int[] vector, int nuevoNumero){
    int posActual = 0;
    
    while((posActual < CANTIDAD)  && (vector[posActual] < nuevoNumero)){
      posActual++;
    }
    int aux = CANTIDAD - 1;
      
    while(aux > posActual){
      vector[aux] = vector[aux-1];
      aux--;
    }
    vector[aux] = nuevoNumero;
  }

  public static void imprimirVector(int[] vector){
    for(int pos = 0;pos<CANTIDAD;pos++){
      System.out.print(vector[pos] + " | ");
    }
    System.out.println("");
    System.out.println("");
  }

  public static int pedirNumero(){
    int aux;
    
    try{
      System.out.print("Ingrese un numero: ");
      aux = Integer.valueOf(entrada.readLine());
      return aux;
    }catch(Exception e){
      return DEFAULT_VALUE;
    }
  }
}