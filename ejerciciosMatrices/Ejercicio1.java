/*
 * Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra precargada, 
 * invierta el orden del contenido por fila. 
 * Este intercambio no se debe realizar de manera explícita, hay que hacer un método que incluya una 
 * iteración de intercambio. 
 */

 import java.util.Random;

public class Problema1{
  public static final int CANT_FILAS = 5;
  public static final int CANT_COLUMNAS = 9;
  public static void main(String[] args){
    int[][] matriz = new int[CANT_FILAS][CANT_COLUMNAS];

    cargarMatrizAleatoriamente(matriz);
    System.out.println("Matriz original: ");
    imprimirMatriz(matriz);    
    for(int i=0;i<CANT_FILAS;i++){
      invertirVector(matriz[i]);
    }  
    System.out.println("Matriz con las filas invertidas: ");
    imprimirMatriz(matriz);    
  }
  
  public static void imprimirMatriz(int[][] matriz){
    for(int i=0;i<CANT_FILAS;i++){
      imprimirVector(matriz[i]);
    }
    System.out.println();
  }

  public static void imprimirVector(int[] vector){
    for(int i=0;i<CANT_COLUMNAS;i++){
      System.out.print(vector[i] + " | ");
    }
    System.out.println();
  }

  public static void invertirVector(int[] vector){
    int aux;

    for(int i=0;i<(CANT_COLUMNAS/2);i++){
      aux = vector[i];
      vector[i] = vector[CANT_COLUMNAS - 1 - i];
      vector[CANT_COLUMNAS - 1 - i] = aux;
    }
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

    for(int i=0;i<CANT_COLUMNAS;i++){
      vector[i] = (r.nextInt(MAX - MIN + 1) + MIN);
    }
  }
}