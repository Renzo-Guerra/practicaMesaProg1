/*
 * Hacer un programa que dado una matriz ordenada creciente por filas de enteros 
 * de tamaño 4*5 que se encuentra precargada, solicite al usuario un numero entero y una fila, 
 * y luego inserte el numero en la matriz en la fila indicada manteniendo su orden. 
 * 
 * NOTA: No hay que aplicar un método de ordenamiento cuando indica que la matriz se encuentra ordenada. 
 * Lo hice para practicar (y para de paso ver si anda en si el programa, alta fiaca crear una matriz manualmente).
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Ejercicio7 {
  public static final int CANT_FILAS = 4;
  public static final int CANT_COLUMNAS = 5;
  public static final int DEFAULT_INDICE_FILA = 1;
  public static final int DEFAULT_NUMERO = 4;
  public static final BufferedReader ENTRADA = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args){
    int[][] matriz = new int[CANT_FILAS][CANT_COLUMNAS];
    int filaIndicada = 0, numeroIndicado = 0;

    cargarMatrizAleatoriamente(matriz);
    ordenarMatriz(matriz);
    imprimirMatriz(matriz);
    filaIndicada = pedirFila();
    numeroIndicado = pedirNumero();
    insertarOrdenado(matriz[filaIndicada], numeroIndicado);
    imprimirMatriz(matriz);
  }

  public static void insertarOrdenado(int[] vector, int nuevoNumero){
    int posActual = 0;

    while((posActual < CANT_COLUMNAS) && (vector[posActual] < nuevoNumero)){
      posActual++;
    }

    if(posActual == CANT_COLUMNAS){
      vector[(CANT_COLUMNAS-1)] = nuevoNumero;
    }else{
      realizarCorrimientoDerecha(vector, posActual);
      vector[posActual] = nuevoNumero;
    }
  }

  public static void realizarCorrimientoDerecha(int[] vector, int posLimite){
    int posActual = CANT_COLUMNAS - 1;
    
    while(posActual > posLimite){
      vector[posActual] = vector[--posActual];
    }
  }

  public static int pedirNumero(){
    int elegido;

    try {
      System.out.print("Ingrese un numero: ");
      elegido = Integer.valueOf(ENTRADA.readLine());
      
      return elegido;
    } catch (Exception e) {
      System.out.println(e);

      return DEFAULT_NUMERO;
    }

  }

  public static int pedirFila(){
    int elegido = 0; 

    try {
      do{
        System.out.print("Ingrese el indice de la fila de la matriz: ");
        elegido = Integer.valueOf(ENTRADA.readLine());
        if(elegido < 0 || elegido > (CANT_FILAS - 1)){
          System.out.println("Error: El indice debe estar entre el 0 y el " + (CANT_FILAS-1) + " (ambos incluidos).");
        }
      }while(elegido < 0 || elegido > (CANT_FILAS - 1));
      
      return elegido;
    } catch (Exception e) {
      System.out.println(e);

      return DEFAULT_INDICE_FILA;
    }
  }

  public static void ordenarMatriz(int[][] matriz){
    for(int i = 0;i<CANT_FILAS;i++){
      ordenarVector(matriz[i]);
    }
  }

  public static void ordenarVector(int[] vector){
    int aux, pos;

    for(int i=1;i<CANT_COLUMNAS;i++){
      pos = i;
      aux = vector[i];  
      while((pos > 0) && (vector[pos-1] > aux)){
        vector[pos] = vector[pos-1];
        pos--;
      }
      vector[pos] = aux;
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
