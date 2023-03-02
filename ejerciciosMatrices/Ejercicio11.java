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
 * Hacer un programa que dada la matriz de secuencias de enteros definida y precargada permita 
 * encontrar por cada fila la posición de inicio y fin de la secuencia cuya suma de valores sea mayor. 
 */

public class Ejercicio11 {
  public static final int CANT_FILAS = 4;
  public static final int CANT_COLUMNAS = 20;
  public static final int DISCERNIBLE = 0;
  public static void main(String[] args){
    int[][] matriz = {{0, 0, 1, 4, 3, 0, 2, 0, 0, 1, 3, 2, 2, 1, 0, 3, 3, 0, 0, 0},
                      {0, 1, 2, 0, 0, 1, 3, 3, 3, 0, 0, 1, 1, 3, 3, 4, 0, 0, 2, 0},
                      {0, 2, 2, 2, 0, 0, 3, 1, 0, 0, 1, 0, 0, 3, 4, 3, 3, 2, 3, 0},
                      {0, 1, 0, 0, 3, 0, 0, 1, 1, 1, 3, 4, 0, 0, 2, 3, 0, 1, 2, 0}};
    
    imprimirMatriz(matriz);
    imprimirIndicesDeLaMatriz(matriz);
  }

  public static void imprimirIndicesDeLaMatriz(int[][] matriz){
    for(int i = 0;i<CANT_FILAS;i++){
      imprimirIndicesDeLaFila(matriz[i]);
    }
  }

  public static void imprimirIndicesDeLaFila(int[] vector){
    int sumaMaxima = 0, suma = 0, inicio = 0, fin = 0, inicioDeLaMayor = 0, finDeLaMayor = 0;

    while(inicio != -1){
      inicio = encontrarProximoInicio(vector, fin);
      if(inicio != -1){
        fin = encontrarFinSecuencia(vector, inicio);
        suma = sumarIntervalo(vector, inicio, fin);
        if(suma > sumaMaxima){
          inicioDeLaMayor = inicio;
          finDeLaMayor = fin;
          sumaMaxima = suma;
        }
        fin++;
      }
    }

    System.out.println("El inicio es " + inicioDeLaMayor + " y el fin es " + finDeLaMayor + " con una suma de " + sumaMaxima + ".");
  }

  public static int sumarIntervalo(int[] vector, int inicio, int fin){
    int acum = 0;
    
    while(inicio <= fin){
      acum += vector[inicio++];
    }

    return acum;
  }

  public static int encontrarFinSecuencia(int[] vector, int pos){
    while(vector[pos] != DISCERNIBLE){
      pos++;
    }

    return --pos;
  }

  public static int encontrarProximoInicio(int[] vector, int pos){
    while((pos < CANT_COLUMNAS) && (vector[pos] == DISCERNIBLE)){
      pos++;
    }

    return (pos == CANT_COLUMNAS) ? -1 : pos;
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
