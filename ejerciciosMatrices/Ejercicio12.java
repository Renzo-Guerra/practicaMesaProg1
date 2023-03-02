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
 * Hacer un programa que, dada la matriz de secuencias de caracteres definida y precargada, 
 * permita encontrar por cada fila la posición de inicio y fin de la anteúltima secuencia 
 * (considerar comenzar a buscarla a partir de la última posición de la fila). 
 */
public class Ejercicio12 {
  public static final int CANT_FILAS = 4;
  public static final int CANT_COLUMNAS = 20;
  public static final int DISCERNIBLE = 0;
  public static void main(String[] args){
    int[][] matriz = {{0, 0, 1, 4, 3, 0, 2, 0, 0, 1, 3, 2, 2, 1, 0, 3, 3, 0, 0, 0},
                      {0, 1, 2, 0, 0, 1, 3, 3, 3, 0, 0, 1, 1, 3, 3, 4, 0, 0, 2, 0},
                      {0, 2, 2, 2, 0, 0, 3, 1, 0, 0, 1, 0, 0, 3, 4, 3, 3, 2, 3, 0},
                      {0, 1, 0, 0, 3, 0, 0, 1, 1, 1, 3, 4, 0, 0, 2, 3, 0, 1, 2, 0}};

    imprimirMatriz(matriz);
    imprimirIndicesAnteultimaSecuencia(matriz);
  }

  public static void imprimirIndicesAnteultimaSecuencia(int[][] matriz){
    for(int i = 0;i<CANT_FILAS;i++){
      imprimirIndicesAnteultimaSecuencia(matriz[i]);
    }
  }

  public static void imprimirIndicesAnteultimaSecuencia(int[] vector){
    int inicio = CANT_COLUMNAS-1;
    int fin = CANT_COLUMNAS-1;

    // En caso de querer buscar la x ultima secuencia, i deveria ser menor a ese x
    // Ej se quiere buscar la 3ra ultima secuencia, seria (i < 3), solo la ultima secuencia? (i < 1).
    for(int i = 0; i<2;i++){
      fin = encontrarFinSecuencia(vector, inicio);
      inicio = encontrarInicioSecuencia(vector, fin);
      inicio--;
    }

    System.out.println("El inicio de la anteultima secuencia es " + (inicio+1) + " y el fin es " + fin);
  }

  public static int encontrarInicioSecuencia(int[] vector, int posActual){
    while(vector[posActual] != DISCERNIBLE){
      posActual--;
    }

    return ++posActual;
  }

  public static int encontrarFinSecuencia(int[] vector, int posActual){
    while(vector[posActual] == DISCERNIBLE){
      posActual--;
    }

    return posActual;
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
