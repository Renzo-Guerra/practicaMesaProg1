/**
 * Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra precargado, 
 * solicite al usuario un numero entero y elimine la primer ocurrencia de número (un número igual) 
 * en el arreglo si existe. Para ello tendrá que buscar la posición y si está, realizar un 
 * corrimiento a izquierda (queda una copia de la última posición del arreglo en la anteúltima posición).
 */

import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problema4 {
  public static final int CANTIDAD = 10;
  public static final int NUM_DEFAULT = 0;
  public static final BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
  public static void main(String[] args){
    int[] numeros = new int[CANTIDAD];
    int numeroSolicitado = 0;
    
    cargarVector(numeros);
    imprimirVector(numeros);
    numeroSolicitado = pedirNumero();
    eliminarPrimerOcurrencia(numeros, numeroSolicitado);
    imprimirVector(numeros);
  }

  public static void cargarVector(int[] vector){
    Random r = new Random();
    final int MIN = 1;
    final int MAX = 10;

    for(int pos = 0;pos < CANTIDAD;pos++){
      vector[pos] = (r.nextInt(MAX - MIN + 1) + MIN);
    }
  }

  public static void imprimirVector(int[] vector){
    for(int pos = 0;pos < CANTIDAD;pos++){
      System.out.print(vector[pos] + " | ");
    }
    System.out.println("");
    System.out.println("");
  }
  public static int pedirNumero(){
    int aux = 0;
    
    try {
      System.out.print("Ingrese el numero: ");
      aux = Integer.valueOf(entrada.readLine());  
    } catch (Exception e) {
      return NUM_DEFAULT;
    }

    return aux;
  }

  public static void eliminarPrimerOcurrencia(int[] vector, int numeroSolicitado){
    int posActual = 0;
    while((posActual < CANTIDAD) && (vector[posActual] != numeroSolicitado)){
      posActual++;
    }
    if(vector[posActual] == numeroSolicitado){
      realizarCorrimiento(vector, posActual);
    }
  }

  public static void realizarCorrimiento(int[] vector, int posActual){
    /*
     * En caso de que la primer ocurrencia sea el ultimo numero, 
     * la ultima posicion toma el valor de la anteultima posicion
    */
    if(posActual == (CANTIDAD-1)){
      vector[posActual] = vector[posActual-1];
    }else{
      while(posActual < (CANTIDAD - 1)){
        vector[posActual] = vector[++posActual];
      }
    }
  }
}
