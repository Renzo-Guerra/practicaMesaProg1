/*
 * Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra precargada, 
 * obtenga la cantidad de números pares que tiene y la imprima. 
 */

import java.util.Random;

public class Ejercicio2 {
  public static final int CANT_FILAS = 5;
  public static final int CANT_COLUMNAS = 10;
  public static void main(String[] args){
    int[][] matriz = new int[CANT_FILAS][CANT_COLUMNAS];
    int cantidadNumerosPares = 0;

    cargarMatrizAleatoriamente(matriz);
    imprimirMatriz(matriz);
    cantidadNumerosPares = getCantidadNumerosParesMatriz(matriz);
    System.out.println("La matriz cuenta con " + cantidadNumerosPares + " numeros pares.");
  }

  public static void cargarMatrizAleatoriamente(int[][] matriz){
    for(int i=0;i<CANT_FILAS;i++){
      cargarVectorAleatoriamente(matriz[i]);
    }
  }

  public static void cargarVectorAleatoriamente(int[] vector){
    Random r = new Random();
    final int MIN = 0;
    final int MAX = 9;

    for(int i=0;i<CANT_COLUMNAS;i++){
      vector[i] = (r.nextInt(MAX - MIN + 1) + MIN);
    }
  }

  public static int getCantidadNumerosParesMatriz(int[][] matriz){
    int acum = 0;

    for(int i=0;i<CANT_FILAS;i++){
      acum += getCantidadNumerosParesVector(matriz[i]);
    }

    return acum;
  }

  public static int getCantidadNumerosParesVector(int[] vector){
    int acum = 0;

    for(int i=0;i<CANT_COLUMNAS;i++){
      if(vector[i]%2 == 0){
        acum++;
      }
    }

    return acum;
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
}
