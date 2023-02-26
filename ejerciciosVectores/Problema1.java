/*
 * Hacer un programa que dado un arreglo de enteros de tamaño 10 
 * que se encuentra precargado, invierta el orden del contenido 
 * (por ejemplo: el que está en 0 se intercambia con el que está en 9, 
 * el que está en 1 con el que está en 8...). 
 * Este intercambio no se debe realizar de manera explícita, 
 * hay que hacer un método que incluya una iteración de intercambio.
 */
import java.util.Random;

public class Problema1{
  public static int CANTIDAD = 11;
  public static void main(String[] args){
    int [] numeros = new int[CANTIDAD];
    cargarVector(numeros);
    imprimirVector(numeros);
    invertirVector(numeros);
    imprimirVector(numeros);
  }

  /*
   * Dado un vector de enteros, se carga 
   * aleatoriamente con numeros entre 1 rango
   */
  public static void cargarVector(int[] vector){
    Random r = new Random();
    final int MIN_VAL = 1;
    final int MAX_VAL = 10;
    
    for(int pos = 0; pos < CANTIDAD; pos++){
      vector[pos] = (r.nextInt(MAX_VAL - MIN_VAL + 1) + MIN_VAL);
    }
  }

  public static void imprimirVector(int[] vector){
    for(int pos = 0;pos < CANTIDAD; pos++){
      System.out.print(vector[pos] + " - ");
    }
    System.out.println("");
  }

  public static void invertirVector(int[] vector){
    int pos = 0;
    int aux = 0;

    while(pos < (CANTIDAD / 2)){
      aux = vector[pos];
      vector[pos] = vector[(CANTIDAD - (pos + 1))];
      vector[(CANTIDAD - (pos + 1))] = aux;
      pos++;
    }
  }
}