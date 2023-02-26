/*
 * Hacer un programa que dado el arreglo definido y precargado, y un número entero ingresado por el usuario, 
 * copie de forma continua las secuencias de tamaño igual al número ingresado en otro arreglo de iguales 
 * características e inicializado con 0. 
 * La copia en este último arreglo debe comenzar desde el principio del mismo.
 * 
 * NOTA: Asumi que cada copia debia estar separada por un 0.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problema14 {
  public static int CANTIDAD = 17;
  public static int DISCERNIBLE = 0;
  public static int DEFAULT_NUMERO = 4;
  public static BufferedReader ENTRADA = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args){
    int[] numeros = {0, 2, 3, 4, 0, 2, 2, 3, 0, 1, 2, 3, 0, 5, 2, 3, 0};
    int[] copia = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int numeroIngresado;

    imprimirVector(numeros);
    imprimirVector(copia);
    numeroIngresado = pedirNumero();
    copiarSecuenciasDeXLongitud(numeros, copia, numeroIngresado);
    imprimirVector(numeros);
    imprimirVector(copia);
  } 

  public static int pedirNumero(){
    int devolver = 0;

    try{
      do {
        System.out.print("Ingrese una posicion: ");
        devolver = Integer.valueOf(ENTRADA.readLine());
      } while (devolver < 0 && devolver >= CANTIDAD);

      return devolver;
    }catch(Exception e){
      return DEFAULT_NUMERO;
    }
  }

  public static void copiarSecuenciasDeXLongitud(int[] numeros, int[] copia, int numeroIngresado){
    boolean existeOtraSecuencia = true;
    int inicio = 0, fin = 0, cantidadElementos = 0;

    while(existeOtraSecuencia){
      cantidadElementos = 0;
      inicio = encontrarInicioSecuencia(numeros, fin);
      if(inicio == -1){
        existeOtraSecuencia = false;
      }else{
        fin = encontrarFinSecuencia(numeros, inicio);
        cantidadElementos = fin - (inicio - 1);
        if(cantidadElementos == numeroIngresado){
          copiarSecuencia(numeros, copia, inicio, fin);
        }
        fin++;
      }
    }
  }

  public static int encontrarInicioSecuencia(int[] vector, int pos){
    while(pos < CANTIDAD && vector[pos] == DISCERNIBLE){
      pos++;
    }

    return (pos == CANTIDAD) ? -1 : pos;
  }

  public static int encontrarFinSecuencia(int[] vector, int pos){
    while(vector[pos] != DISCERNIBLE){
      pos++;
    }

    return --pos;
  }

  public static void copiarSecuencia(int[] numeros, int[] copia, int inicio, int fin){
    int veces = 0;
    int posActual = CANTIDAD-1;

    if(copia[0] == 0){
      while(veces < (fin - (inicio - 1))){
        copia[veces] = numeros[inicio + veces];
        veces++;
      }
    }else{
      while(copia[posActual] == 0){
        posActual--;
      }
      posActual+=2;
      while(veces < (fin - (inicio - 1))){
        copia[posActual + veces] = numeros[inicio + veces];
        veces++;
      }
    }
  }
  public static void imprimirVector(int[] vector){
    for(int i = 0; i<CANTIDAD;i++){
      System.out.print(vector[i] + " | ");
    }
    System.out.println();
    System.out.println();
  }
}
