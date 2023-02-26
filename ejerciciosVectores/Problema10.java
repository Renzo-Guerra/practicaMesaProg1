/**
 * Se tiene un arreglo de enteros de tamaño 20 de secuencias de números entre 1 y 9, separadas por 0. 
 * El arreglo esta precargado, y además empieza y termina con uno o más separadores 0. 
 * Hacer un programa que permita obtener a través de métodos la posición de inicio y 
 * la posición de fin de la secuencia ubicada a partir de una posición entera ingresada por el usuario. 
 * Finalmente, si existen imprima por pantalla ambas posiciones obtenidas.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problema10 {
  public static final BufferedReader ENTRADA = new BufferedReader(new InputStreamReader(System.in));
  public static final int CANTIDAD = 20;
  public static final int DEFAULT_POS = 4;
  public static final int DISCERNIBLE = 0;
  // Se supone que cantidad debe coincidir con la longitud del vector, ya que no nos permiten unsar vector.length...
  public static void main(String[] args){
    int[] numeros = {0, 3, 4, 1, 2, 0, 2, 0, 0, 1, 2, 3, 4, 0, 1, 2, 0, 0, 1, 0};
    int posicionDada = 0, inicioSec, finSec;

    imprimirVector(numeros);
    posicionDada = pedirPosicion();
    if(numeros[posicionDada] == DISCERNIBLE){
      System.out.println("La posicion dada no cae dentro de una secuencia...");
    }else{
      inicioSec = encontrarInicio(numeros, posicionDada);
      finSec = encontrarFin(numeros, posicionDada);
      System.out.println("El inicio de la secuencia es la posicion " + inicioSec + " y el fin es " + finSec + ".");
    }
  }

  public static int encontrarInicio(int[] vector, int pos){
    while(vector[pos] != DISCERNIBLE){
      pos--;
    }

    return ++pos;
  }

  public static int encontrarFin(int[] vector, int pos){
    while(vector[pos] != DISCERNIBLE){
      pos++;
    }

    return --pos;
  }

  public static void imprimirVector(int[] vector){
    for(int pos = 0; pos<CANTIDAD;pos++){
      System.out.print(vector[pos] + " | ");
    }
    System.out.println();
    System.out.println();
  }

  public static int pedirPosicion(){
    int valorDevolver = 0;

    try {
      do {
        System.out.print("Ingrese una posicion: ");
        valorDevolver = Integer.valueOf(ENTRADA.readLine());
      } while (valorDevolver < 0 || valorDevolver >= CANTIDAD);

      return valorDevolver;
    } catch (Exception e) {
      System.out.println("Se ingreso una posicion invalida, se asigno la posicion " + DEFAULT_POS + ".");
      System.out.println();
      return DEFAULT_POS;
    }
  }
}
