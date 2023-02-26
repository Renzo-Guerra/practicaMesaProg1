/**
 * Hacer un programa que dado un arreglo ordenado creciente de enteros de tamaño 10 que se encuentra precargado, 
 * solicite al usuario un numero entero y elimine la primer ocurrencia de número (un número igual) 
 * en el arreglo si existe.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Problema7 {
  public static final int CANTIDAD = 10;
  public static final int NUMERO_DEFAULT = 5;
  public static final BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args){
    int numeros[] = new int[CANTIDAD];
    int numeroEliminar = NUMERO_DEFAULT;

    cargarVectorAleatoriamente(numeros);
    imprimirVector(numeros);
    ordenarPorInsercion(numeros);
    imprimirVector(numeros);
    numeroEliminar = pedirNumero();
    eliminarPrimerOcurrencia(numeros, numeroEliminar);
    imprimirVector(numeros);
  }

  public static void cargarVectorAleatoriamente(int[] vector){
    final int MIN = 1;
    final int MAX = 10;
    final Random r = new Random();

    for(int i=0;i<CANTIDAD;i++){
      vector[i] = (r.nextInt(MAX - MIN + 1) + MIN);
    }
  }

  public static void imprimirVector(int[] vector){
    for(int i = 0;i<CANTIDAD;i++){
      System.out.print(vector[i] + " | ");
    }
    System.out.println();
    System.out.println();
  }

  public static void ordenarPorInsercion(int[] vector){
    for(int i = 1;i < CANTIDAD;i++){
      int pos = i;
      int aux = vector[i];
      while((pos > 0) && (vector[pos-1] > aux)){
        vector[pos] = vector[pos - 1];
        pos--;
      }
      vector[pos] = aux;
    }
  }

  public static int pedirNumero(){
    int devolver = 0;
    try{
      System.out.print("Ingrese un numero a eliminar la primer ocurrencia: ");
      devolver = Integer.valueOf(entrada.readLine());

      return devolver;
    }catch(Exception e){
      return NUMERO_DEFAULT;
    }   
  }

  public static void eliminarPrimerOcurrencia(int[] vector, int numeroEliminar){
    int posActual = 0;

    while((posActual < CANTIDAD) && (vector[posActual] < numeroEliminar)){
      posActual++;
    }

    if(vector[posActual] == numeroEliminar){
      System.out.println("Se detecto una ocurrencia del numero " + numeroEliminar + " dentro del arreglo!");
      System.out.println();
      corrimientoHaciaLaIzquierda(vector, posActual);
    }else{
      System.out.println("El numero " + numeroEliminar + " no se encuentra en el arreglo...");
      System.out.println();
    }
  }

  public static void corrimientoHaciaLaIzquierda(int[] vector, int tarjetPos){
    if(tarjetPos == (CANTIDAD-1)){
      // En caso de que la ocurrencia sea el ultimo numero del vector
      vector[tarjetPos] = vector[tarjetPos-1];
    }else{
      // Caso contrario se recorre y se mueve 1 por 1
      while(tarjetPos < (CANTIDAD-1)){
        vector[tarjetPos] = vector[tarjetPos+1];
        tarjetPos++;
      }
    }
  }
}