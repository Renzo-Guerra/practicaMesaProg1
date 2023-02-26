/*
 * Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra precargado, 
 * solicite al usuario una posición y realice un corrimiento a izquierda o hacia la menor posición del arreglo.
 */

import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problema3 {
  public static final int CANTIDAD = 10;
  public static final int DISCERNIBLE = 0;

  public static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
  public static void main(String args[]){
    int [] numeros = new int[CANTIDAD];
    int posicionDeseada = 0;

    cargarVector(numeros);
    imprimirVector(numeros);
    posicionDeseada = pedirPosicion();
    corrimientoIzquierda(numeros, posicionDeseada);
    imprimirVector(numeros);
  }

  public static void cargarVector(int[] vector){
    Random r = new Random();
    final int MIN = 1;
    final int MAX = 10;

    for(int pos = 0;pos<CANTIDAD;pos++){
      vector[pos] = (r.nextInt(MAX - MIN + 1) + MIN);
    }
  }

  public static void imprimirVector(int[] vector){
    for(int pos = 0;pos<CANTIDAD;pos++){
      System.out.print(vector[pos] + " | ");
    }
    System.out.println("");
  }

  public static int pedirPosicion(){
    int val = 0;

    try {
      System.out.print("Ingrese desde que posicion desea realizar el corrimiento (el valor en dicha posicion se borrara): ");
      val = Integer.valueOf(entrada.readLine());
      System.out.println("");
      if(val >= CANTIDAD || val < 0){
        return 0;
      }
    } catch (Exception e) {
      return 0;
    }

    return val;
  }

  public static void corrimientoIzquierda(int [] vector, int posicionDeseada){
    while(posicionDeseada < (CANTIDAD - 1)){
      vector[posicionDeseada] = vector[++posicionDeseada];
    }
    vector[CANTIDAD-1] = DISCERNIBLE;
  }
}
