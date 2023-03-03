/*
 *  Se tiene una matriz precargada con secuencias de enteros distintos de cero en sus filas.
 *  Ademas, se tiene un arreglo precargado con algunos numeros de filas. Los numeros de fila 
 *  no se repiten y estan ubicados de forma consecutiva desde desde el principio del arreglo, 
 *  luego se completa con -1.
 *  De dichas filas se pide eliminar la ultima secuencia que cumpla con la condicion de tener 
 *  solo valores pares.
 *  
 *  OBSERVACIONES:
 *    - El tamaño del arreglo es igual a la cantidad de filas de la matriz.
 *    - Las secuencias estan separadas por uno o mas ceros, empieza y termina con uno o mas ceros.
 *    - Realizar el programa completo sin metodos de carga ni impresion de arreglo y matriz, ni 
 *      utilizar estructuras auxiliares.
 */

public class Examen1 {
  public static final int CANT_FILAS = 4;
  public static final int CANT_COLUMNAS = 20;
  public static final int DISCERNIBLE_MATRIZ = 0;
  public static final int DISCERNIBLE_VECTOR = -1;
  public static void main(String[] args){
    int[][] matriz = new int[CANT_FILAS][CANT_COLUMNAS];
    int[] arreglo = new int[CANT_FILAS];
    int inicioSec = 0, finSec = 0;
    
    //cargarMatriz(matriz);
    //cargarArreglo(arreglo);

    int cantFilasEnArreglo = getCantElementosArreglo(arreglo);

    for(int i =0;i<cantFilasEnArreglo;i++){
      finSec = encontrarFinSecuencia(matriz[i], CANT_COLUMNAS-1);
      inicioSec = encontrarProximoInicio(matriz[i], finSec);

      if(secuenciaSoloValoresPares(matriz[i], inicioSec, finSec)){
        for(int j=0;j<(finSec - inicioSec + 1);j++){
          realizarCorrimientoIzquierda(matriz[j], inicioSec);
        }
      }
    }
  }

  public static void realizarCorrimientoIzquierda(int[] vector, int pos){
    while(pos < (CANT_COLUMNAS-1)){
      vector[pos] = vector[++pos];
    }
  }

  public static boolean secuenciaSoloValoresPares(int[] vector, int inicio, int fin){
    while(inicio <= fin){
      if((vector[inicio] %2) == 1){return false;}
    }

    return true;
  }

  public static int encontrarProximoInicio(int[] vector, int pos){
    while(vector[pos] != DISCERNIBLE_MATRIZ){
      pos--;
    }

    return ++pos;
  }

  public static int encontrarFinSecuencia(int[] vector, int pos){
    while(vector[pos] == DISCERNIBLE_MATRIZ){
      pos--;
    }

    return pos;
  }

  public static int getCantElementosArreglo(int[] arreglo){
    int cant = 0;
    
    while(arreglo[cant] != DISCERNIBLE_VECTOR){
      cant++;
    }

    return cant;
  }

}
