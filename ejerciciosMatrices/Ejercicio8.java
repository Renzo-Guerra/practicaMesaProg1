/*
 * Hacer un programa que dado una matriz ordenada creciente por filas de enteros de tamaño 4*5 
 * que se encuentra precargada, solicite al usuario un numero entero y una fila, y elimine la 
 * primera ocurrencia de numero en la fila indicada (un número igual) si existe. 
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Ejercicio8 {
  public static final int CANT_FILAS = 4;
  public static final int CANT_COLUMNAS = 5;
  public static final int DEFAULT_INDICE_FILA = 1;
  public static final int DEFAULT_NUMERO = 3;
  public static final int DISCERNIBLE = 0;
  public static final BufferedReader ENTRADA = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args){
    int[][] matriz = new int[CANT_FILAS][CANT_COLUMNAS];
    int filaIndicada = 0, numeroEliminar = 0;

    cargarMatrizAleatoriamente(matriz);
    imprimirMatriz(matriz);
    filaIndicada = pedirFila();
    numeroEliminar = pedirNumero();
    eliminarPrimerOcurrencia(matriz[filaIndicada], numeroEliminar);
    imprimirMatriz(matriz);
  }

  public static void eliminarPrimerOcurrencia(int[] vector, int numeroEliminar){
    int posActual = 0;
  
    while((posActual < CANT_COLUMNAS) && vector[posActual] != numeroEliminar){
      posActual++;
    }

    if(posActual != CANT_COLUMNAS){
      realizarCorrimientoIzquierda(vector, posActual);
    }
  }

  public static void realizarCorrimientoIzquierda(int[] vector, int pos){
    while(pos < (CANT_COLUMNAS - 1)){
      vector[pos] = vector[++pos];
    }

    vector[CANT_COLUMNAS-1] = DISCERNIBLE;
  }

  public static int pedirNumero(){
    int devolver = 0;
    try {
      System.out.print("Ingrese un numero: ");
      devolver = Integer.valueOf(ENTRADA.readLine());

      return devolver;
    } catch (Exception e) {
      System.out.println(e);

      return DEFAULT_NUMERO;
    }
  }

  public static int pedirFila(){
    int devolver = 0;

    try {
      do {
        System.out.print("Ingrese un indice de fila: ");
        devolver = Integer.valueOf(ENTRADA.readLine());
        if(devolver < 0 || devolver > CANT_FILAS-1){
          System.out.println("Solo se aceptan numeros desde el 0 hasta el " + (CANT_FILAS-1) + ".");
        }
      } while (devolver < 0 || devolver > CANT_FILAS-1);

      return devolver;
    } catch (Exception e) {
      System.out.println(e);
      return DEFAULT_INDICE_FILA;
    }
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
}
