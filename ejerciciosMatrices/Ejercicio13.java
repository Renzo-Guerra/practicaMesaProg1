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
 * y un número entero ingresado por el usuario, elimine de cada fila las secuencias de 
 * tamaño igual al número ingresado. 
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ejercicio13 {
  public static final int CANT_FILAS = 4;
  public static final int CANT_COLUMNAS = 20;
  public static final int DISCERNIBLE = 0;
  public static final int DEFAULT_NUMERO = 6; // Hay secuencias con sumatoria 6 en la fila 0 y 3.
  public static final BufferedReader ENTRADA = new BufferedReader(new InputStreamReader(System.in));
  public static void main(String[] args){
    int[][] matriz = {{0, 0, 1, 4, 3, 0, 2, 0, 0, 1, 3, 2, 2, 1, 0, 3, 3, 0, 0, 0},
                      {0, 1, 2, 0, 0, 1, 3, 3, 3, 0, 0, 1, 1, 3, 3, 4, 0, 0, 2, 0},
                      {0, 2, 2, 2, 0, 0, 3, 1, 0, 0, 1, 0, 0, 3, 4, 3, 3, 2, 3, 0},
                      {0, 1, 0, 0, 3, 0, 0, 1, 1, 1, 3, 4, 0, 0, 2, 3, 0, 1, 2, 0}};
    int numeroIngresado = 0;

    imprimirMatriz(matriz);
    numeroIngresado = pedirNumero();
    eliminarSecuenciasConSumatoriaX(matriz, numeroIngresado);
    imprimirMatriz(matriz);
  }

  public static void eliminarSecuenciasConSumatoriaX(int[][] matriz, int sumaEliminar){
    for(int i = 0;i<CANT_FILAS;i++){
      eliminarSecuenciasConSumatoriaX(matriz[i], sumaEliminar);
    }
  }

  public static void eliminarSecuenciasConSumatoriaX(int[] vector, int sumaEliminar){
    int inicio = 0, fin = 0, suma = 0;

    while(inicio != -1){
      inicio = encontrarProximaSecuencia(vector, fin);
      if(inicio != -1){
        fin = encontrarFinSecuencia(vector, inicio);
        suma = sumarSecuencia(vector, inicio, fin);
        if(suma == sumaEliminar){
          int longitud = fin - inicio + 1;
          for(int i = 0;i<longitud;i++){
            realizarCorrimientoIzquierda(vector, inicio);
          }
          fin = inicio;
        }else{
          fin++;
        }
      }
    }
  }

  public static void realizarCorrimientoIzquierda(int[] vector, int inicio){
    while(inicio < (CANT_COLUMNAS-1)){
      vector[inicio] = vector[++inicio];
    }
  }

  public static int sumarSecuencia(int[] vector, int inicio, int fin){
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

  public static int encontrarProximaSecuencia(int[] vector, int pos){
    while((pos < CANT_COLUMNAS) && (vector[pos] == DISCERNIBLE)){
      pos++;
    }

    return (pos == CANT_COLUMNAS) ? -1 : pos;
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
