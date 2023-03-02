/*
 * Caso de que pidan numeros, usar esta matriz precargada.
 * Se tiene una matriz de enteros de tamaño 4*20 de secuencias de números entre 1 y 9 (por cada fila), separadas por 0. 
 * La matriz esta precargada, y además cada fila empieza y termina con uno o más separadores 0. 
 * 
 * Caso de que pidan caracteres, usar esta matriz precargada.
 * Además, se tiene una matriz de caracteres de tamaño 4*20 de secuencias de caracteres letras minúsculas 
 * entre ‘a’ y ‘z’ (por cada fila), separadas por ‘ ’ (espacios). 
 * La matriz esta precargada, y además cada fila empieza y termina con uno o más separadores ‘ ’. 
 *
 * Considere para los siguientes ejercicios estos tipos de matriz. 
 * 
 * Hacer un programa que, dada la matriz de secuencias de enteros definida y precargada, 
 * permita obtener a través de métodos la posición de inicio y la posición de fin de la secuencia 
 * ubicada a partir de una posición entera y una fila, ambas ingresadas por el usuario. 
 * Finalmente, si existen imprima por pantalla ambas posiciones obtenidas.
 * (En este caso hay que usar la primer matriz precargada)
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ejercicio10 {
  public static final int CANT_FILAS = 4;
  public static final int CANT_COLUMNAS = 20;
  public static final int DISCERNIBLE = 0; // El discernible es el separador de secuencias
  public static final int DEFAULT_INDICE_FILA = 0;
  public static final int DEFAULT_INDICE_COLUMNA = (CANT_COLUMNAS - 2);
  public static final BufferedReader ENTRADA = new BufferedReader(new InputStreamReader(System.in));
  public static void main(String[] args){
    int[][] matriz = {{0, 0, 1, 4, 3, 0, 2, 0, 0, 1, 3, 2, 2, 1, 0, 3, 3, 0, 0, 0},
                      {0, 1, 2, 0, 0, 1, 3, 3, 3, 0, 0, 1, 1, 3, 3, 4, 0, 0, 2, 0},
                      {0, 2, 2, 2, 0, 0, 3, 1, 0, 0, 1, 0, 0, 3, 4, 3, 3, 2, 3, 0},
                      {0, 1, 0, 0, 3, 0, 0, 1, 1, 1, 3, 4, 0, 0, 2, 3, 0, 1, 2, 0}};
    int indiceFilaIngresada = 0, indiceColumnaIngresada = 0;

    /*
     * Suponer que la matriz es cargada manualmente y respeta los parametros 
     * de CANT_FILAS, CANT_COLUMNAS y que el separador es el DISCERNIBLE.
    */
    
    //cargarMatriz(matriz);
    imprimirMatriz(matriz);
    indiceFilaIngresada = pedirFila();
    indiceColumnaIngresada = pedirColumna();

    // Se verifica si en dicha posicion contiene un numero diferente al DISCERNIBLE.
    if(matriz[indiceFilaIngresada][indiceColumnaIngresada] != DISCERNIBLE){
      imprimirPosInicioYfinDeSecuencia(matriz[indiceFilaIngresada], indiceColumnaIngresada);
    }else{
      System.out.println("Esa posicion no esta dentro de los parametros de una secuencia...");
    }
  }

  public static void imprimirPosInicioYfinDeSecuencia(int[] vector, int indiceColumnaIngresada){
    int inicioSec = 0, finSec = 0;

    inicioSec = getInicioSecuencia(vector, indiceColumnaIngresada);
    finSec = getFinSecuencia(vector, indiceColumnaIngresada);
    System.out.println("El inicio de la secuencia es el indice " + inicioSec + " y el fin es " + finSec + ".");
  }

  public static int getFinSecuencia(int[] vector, int pos){
    while(vector[pos] != DISCERNIBLE){
      pos++;
    }

    return (pos-1);
  }

  public static int getInicioSecuencia(int[] vector, int pos){
    while(vector[pos] != DISCERNIBLE){
      pos--;
    }

    return (pos+1);
  }

  public static int pedirColumna(){
    int devolver = 0;

    try {
      do {
        System.out.print("Ingrese un indice de columna: ");
        devolver = Integer.valueOf(ENTRADA.readLine());
      } while ((devolver < 0) || (devolver > (CANT_COLUMNAS-1)));

      return devolver;
    } catch (Exception e) {
      System.out.println(e);

      return DEFAULT_INDICE_COLUMNA;
    }
  }

  public static int pedirFila(){
    int devolver = 0;

    try {
      do {
        System.out.print("Ingrese un indice de fila: ");
        devolver = Integer.valueOf(ENTRADA.readLine());
      } while ((devolver < 0) || (devolver > (CANT_FILAS-1)));

      return devolver;
    } catch (Exception e) {
      System.out.println(e);

      return DEFAULT_INDICE_FILA;
    }
  }

  public static void imprimirMatriz(int[][] matriz){
    for(int i = 0;i < CANT_FILAS;i++){
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
