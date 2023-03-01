import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*
 * Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra precargada, 
 * solicite al usuario un numero entero y elimine la primera ocurrencia de numero en la matriz 
 * (un número igual) si existe. 
 * Para ello tendrá que buscar la posición y si está, realizar un corrimiento a izquierda y no continuar buscando. 
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ejercicio5 {
  public static final int CANT_FILAS = 5;
  public static final int CANT_COLUMNAS = 10;
  public static final int NUM_DEFAULT = 4;
  public static final BufferedReader ENTRADA = new BufferedReader(new InputStreamReader(System.in));
  public static void main(String[] args){
    int[][] matriz = new int[CANT_FILAS][CANT_COLUMNAS];
    int numeroAEliminar = 0;

    cargarMatrizAleatoriamente(matriz);
    imprimirMatriz(matriz);
    numeroAEliminar = pedirNumero();
    eliminarPrimeraOcurrenciaEnMatriz(matriz, numeroAEliminar);
    imprimirMatriz(matriz);
  }

  public static void eliminarPrimeraOcurrenciaEnMatriz(int[][] matriz, int numeroAEliminar){
    int filaActual = 0, indice = -1;

    while((indice == -1) && (filaActual < CANT_FILAS)){
      indice = getPrimerIgualdadEnVector(matriz[filaActual], numeroAEliminar);
      if(indice != -1){
        realizarCorrimientoIzquierda(matriz[filaActual], indice);
      }
      
      filaActual++;
    }
  }

  public static void realizarCorrimientoIzquierda(int[] vector, int posActual){
    while(posActual < (CANT_COLUMNAS - 1)){
      vector[posActual] = vector[++posActual];
    }

    vector[CANT_COLUMNAS-1] = 0;
  }

  public static int getPrimerIgualdadEnVector(int[] vector, int numeroBuscar){
    int posActual = 0;

    while (posActual < CANT_COLUMNAS){
      if(vector[posActual] == numeroBuscar){
        return posActual;
      }

      posActual++;
    }

    return -1;
  }

  public static int pedirNumero(){
    int numDevolver = 0;
    try {
      System.out.print("Ingrese el numero a eliminar: ");
      numDevolver = Integer.valueOf(ENTRADA.readLine());

      return numDevolver;
    } catch (Exception e) {
      System.out.println(e);

      return NUM_DEFAULT;
    }
  }

  public static void imprimirMatriz(int[][] matriz){
    for(int i=0;i<CANT_FILAS;i++){
      imprimirVector(matriz[i]);
    }
    System.out.println();
  }

  public static void imprimirVector(int[] vector){
    for(int i = 0;i<CANT_COLUMNAS;i++){
      System.out.print(vector[i] + " | ");
    }
    System.out.println();
  } 

  public static void cargarMatrizAleatoriamente(int[][] matriz){
    for(int i=0;i<CANT_FILAS;i++){
      cargarVectorAleatoriamente(matriz[i]);
    }
  }

  public static void cargarVectorAleatoriamente(int[] vector){
    Random r = new Random();
    final int MIN = 1;
    final int MAX = 9;
    for(int i = 0;i<CANT_COLUMNAS;i++){
      vector[i] = (r.nextInt(MAX - MIN + 1) + MIN);
    }
  }
}
