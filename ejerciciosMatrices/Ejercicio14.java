/*
 * Se tiene una matriz de caracteres de tamaño 4*20 de secuencias de caracteres letras minúsculas 
 * entre 'a' y 'z' (por cada fila), separadas por ' ' (espacios). 
 * La matriz esta precargada, y además cada fila empieza y termina con uno o más separadores ' '. 
 * 
 * Hacer un programa que dada la matriz de secuencias de caracteres definida y precargada, 
 * elimine de cada fila todas las ocurrencias de una secuencia patrón dada por un arreglo 
 * de caracteres de tamaño igual al tamaño de columnas de la matriz 
 * (solo tiene esa secuencia con separadores al inicio y al final). 
 * Al eliminar en cada fila se pierden los valores haciendo los corrimientos.  
*/

public class Ejercicio14 {
  public static final int CANT_FILAS = 4;
  public static final int CANT_COLUMNAS = 20;
  public static final char DISCERNIBLE = ' ';
  public static void main(String[] args){
    // Matriz de 4 x 20
    char[][] matriz = {{' ', ' ', 'a', 'b', 'c', ' ', 'a', 'f', 'n', 'a', 'b', 'c', 'w', 'x', ' ', 's', 's', ' ', ' ', ' '},
                      {' ', 'a', 's', ' ', ' ', 'a', 'b', 'c', 'd', ' ', ' ', 'a', 'b', 'c', ' ', 'a', ' ', ' ', 'c', ' '},
                      {' ', 'a', 'b', 'c', 'd', ' ', 'a', 'f', ' ', ' ', 'a', 'f', 'd', ' ', ' ', 's', 's', ' ', 'c', ' '},
                      {' ', ' ', ' ', 'c', 'f', 'k', ' ', 'a', 'b', 'c', ' ', 's', 'd', 's', ' ', 's', ' ', 'f', 'f', ' '}};
    // Vector de 20 posiciones.
    char[] secuencia = {' ', ' ', ' ', ' ', ' ', ' ', ' ', 'a', 'b', 'c', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    //! NOTA: Las secuencias deben ser idénticas, si una secuencia de la matriz contiene 'a', 'b' y 'c' pero ademas una 'd' por ej, no será eliminada.
    System.out.println("Matriz: ");
    imprimirMatriz(matriz);
    System.out.println("Secuencia: ");
    imprimirVector(secuencia);
    eliminarSecuencias(matriz, secuencia);
    System.out.println("Matriz: ");
    imprimirMatriz(matriz);
  }

  public static void eliminarSecuencias(char[][] matriz, char[] secuencia){
    for(int i = 0;i<CANT_FILAS;i++){
      eliminarSecuencias(matriz[i], secuencia);
    }
  }

  public static void eliminarSecuencias(char[] vector, char[] secuencia){
    int inicio = 0, fin = 0, longitud = 0;
    int inicioSec = 0, finSec = 0, longitudSec = 0;

    inicioSec = getInicioSecuencia(secuencia, 0);
    finSec = getFinSecuencia(secuencia, inicioSec);
    longitudSec = finSec - inicioSec + 1;

    while(inicio != -1){
      inicio = getInicioSecuencia(vector, fin);
      if(inicio != -1){
        fin = getFinSecuencia(vector, inicio);
        longitud = fin - inicio + 1;
        if((longitud == longitudSec) && (mismaSecuencia(vector, inicio, secuencia, inicioSec, longitudSec))){
          for(int i = 0; i<longitudSec;i++){
            realizarCorrimientoIzquierda(vector, inicio);
          }
          fin = inicio;
        }
        fin++;
      }
    }
  }

  public static void realizarCorrimientoIzquierda(char[] vector, int pos){
    while(pos < (CANT_COLUMNAS-1)){
      vector[pos] = vector[++pos];
    }
  }

  /*
   * Devuelve si 2 secciones de secuencias de misma longitud son identicas
   */
  public static boolean mismaSecuencia(char[] vector1, int inicioV1, char[] vector2, int inicioV2, int longitud){
    for(int i = 0;i<longitud;i++){
      if(vector1[inicioV1 + i] != vector2[inicioV2 + i]){
        return false;
      }
    }

    return true;
  }
  public static int getFinSecuencia(char[] vector, int pos){
    while(vector[pos] != DISCERNIBLE){
      pos++;
    }

    return --pos;
  }

  public static int getInicioSecuencia(char[] vector, int pos){
    while((pos < CANT_COLUMNAS) && (vector[pos] == DISCERNIBLE)){
      pos++;
    }

    return (pos == CANT_COLUMNAS) ? -1 : pos;
  }

  public static void imprimirMatriz(char[][] matriz){
    for(int i = 0;i < CANT_FILAS;i++){
      imprimirVector(matriz[i]);
    }
    System.out.println();
  }

  public static void imprimirVector(char[] vector){
    for(int i = 0;i<CANT_COLUMNAS;i++){
      System.out.print(vector[i] + " | ");
    }
    System.out.println();
  }
}
