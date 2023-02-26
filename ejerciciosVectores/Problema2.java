/**
 * Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra precargado, 
 * obtenga la cantidad de números pares que tiene y la imprima.
 */
import java.util.Random;

public class Problema2 {
  public static final int CANTIDAD = 10;
  public static void main(String args[]){
    int [] numeros = new int[CANTIDAD];

    cargarVector(numeros);
    mostrarVector(numeros);
    contarPares(numeros);
  }

  public static void cargarVector(int[] vector){
    final int MIN = 1;
    final int MAX = 10;

    Random r = new Random();

    for(int pos = 0; pos < CANTIDAD ; pos++){
      vector[pos] = (r.nextInt(MAX - MIN + 1) + MIN);
    }
  }

  public static void mostrarVector(int[] vector){
    for(int pos = 0; pos<CANTIDAD;pos++){
      System.out.print(vector[pos] + " | ");
    }
    System.out.println("");
  }

  public static void contarPares(int[] vector){
    int res = 0;

    for(int pos = 0;pos<CANTIDAD;pos++){
      if(vector[pos] % 2 == 0){
        res++;
        System.out.print(vector[pos] + " | ");
      }
    }
    System.out.println("");
    System.out.println("Existen " + res + " numeros pares en el vector.");
  }
}
