/*
 * Hacer un programa que dado una matriz de enteros de tamaño 4*5 que se encuentra precargada, 
 * solicite al usuario el ingreso de una fila y dos números enteros (columnas de la matriz), 
 * y ordene de forma creciente la matriz en la fila indicada entre las dos posiciones columnas ingresadas.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Ejercicio9 {
  public static final int CANT_FILAS = 4;
  public static final int CANT_COLUMNAS = 5;
  public static final int DEFAULT_INDICE_FILA = 0;
  public static final int DEFAULT_INDICE_COLUMNA = 0;
  public static final BufferedReader ENTRADA = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args){
    int[][] matriz = new int[CANT_FILAS][CANT_COLUMNAS];
    int filaElejida = 0, col1 = 0, col2 = 0;

    cargarMatrizAleatoriamente(matriz);
    imprimirMatriz(matriz);
    filaElejida = ingresarIndiceFila();
    col1 = ingresarIndiceColumna(1);
    col2 = ingresarIndiceColumna(2);
    ordenarSeccion(matriz[filaElejida], col1, col2);
    imprimirMatriz(matriz);
  }

  public static void ordenarSeccion(int[] vector, int col1, int col2){
    int min, max;
    
    if(col1 != col2){
      min = (col1 < col2) ? col1 : col2;
      max = (col1 > col2) ? col1 : col2;
      ordenarAscendente(vector, min, max);
    }
  }

  public static void ordenarAscendente(int[] vector, int min, int max){
    int aux, pos;
    
    for(int i = (min + 1);i <= max;i++){
      pos = i;
      aux = vector[i];
      // Para ordenarlos descendentemente hay que cambiar (vector[pos-1] > aux) por (vector[pos-1] < aux).
      while((pos > min) && (vector[pos-1] > aux)){
        vector[pos] = vector[--pos];
      }
      vector[pos] = aux;
    }
  }

  public static int ingresarIndiceColumna(int indice){
    int devolver = 0;

    try {
      do {
        System.out.print("Ingrese el " + indice + " numero: ");
        devolver = Integer.valueOf(ENTRADA.readLine());
      } while ((devolver<0) || (devolver>(CANT_COLUMNAS-1)));
      
      return devolver;
    } catch (Exception e) {
      System.out.println(e);

      return DEFAULT_INDICE_COLUMNA;
    }
  }

  public static int ingresarIndiceFila(){
    int devolver = 0;

    try {
      do {
        System.out.print("Ingrese el indice de la fila a elegir: ");
        devolver = Integer.valueOf(ENTRADA.readLine());
      } while ((devolver < 0) || (devolver > (CANT_FILAS - 1)));

      return devolver;
    } catch (Exception e) {
      System.out.println(e);

      return DEFAULT_INDICE_FILA;
    }
  }

  public static void imprimirMatriz(int[][] matriz){
    for(int i = 0;i<CANT_FILAS;i++){
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
    for(int i = 0;i<CANT_FILAS;i++){
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
