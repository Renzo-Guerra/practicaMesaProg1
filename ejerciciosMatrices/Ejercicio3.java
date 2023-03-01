/*
 * Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra precargada, 
 * solicite al usuario una posición fila, columna y realice un corrimiento a izquierda. 
 * 
 * Nota: Al realizar el corrimiento, se pierde el valor de la posiciones dada, y a su vez, se asignará el valor 
 * DISCERNIBLE (0) a la ultima posicion del vector.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Ejercicio3 {
  public static final int CANT_FILAS = 5;
  public static final int CANT_COLUMNAS = 10;
  public static final int DEFAULT_POS = 0;
  public static final int DISCERNIBLE = 0;

  public static final BufferedReader ENTRADA = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args){
    int[][] matriz = new int[CANT_FILAS][CANT_COLUMNAS];
    int posFilaIngresada = 0, posColumnaIngresada = 0;

    cargarMatrizAleatoriamente(matriz);
    imprimirMatriz(matriz);
    posFilaIngresada = pedirNumeroUsuario(CANT_FILAS-1);
    posColumnaIngresada = pedirNumeroUsuario(CANT_COLUMNAS-1);
    corrimientoIzquierda(matriz[posFilaIngresada], posColumnaIngresada);
    imprimirMatriz(matriz);
  }

  public static void corrimientoIzquierda(int[] vector, int pos){
    while(pos < (CANT_COLUMNAS - 1)){
      vector[pos] = vector[pos+1];
      pos++;
    }
    vector[CANT_COLUMNAS-1] = DISCERNIBLE;

  }

  public static int pedirNumeroUsuario(int MAX){
    int valor = 0;

    try{
      do{
        System.out.print("Ingrese una posicion: ");
        valor = Integer.valueOf(ENTRADA.readLine());
      }while(valor < 0 || valor > MAX);

      return valor;
    }catch(Exception e){
      System.out.println(e);
      return DEFAULT_POS;
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
    final int MAX = 8;

    for(int i=0;i<CANT_COLUMNAS;i++){
      vector[i] = (r.nextInt(MAX - MIN + 1) + MIN);
    }
  }

  public static void imprimirMatriz(int[][] matriz){
    for(int i = 0;i<CANT_FILAS; i++){
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
