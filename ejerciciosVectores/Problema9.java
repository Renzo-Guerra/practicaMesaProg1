/*
 * Hacer un programa que dado el arreglo definido y precargado permita obtener 
 * a través de métodos la posición de inicio y la posición de fin de la secuencia
 * ubicada a partir de una posición entera ingresada por el usuario. 
 * Finalmente, si existen imprima por pantalla ambas posiciones obtenidas.
 * 
 * ej: [0, 1, 3, 2, 0, 0, 3, 3, 0, 1, 2, 3, 1, 0],
 * si ingresan la posicion 10, devolveria el 9 y el 11.
 * pero si ingresan una posicion donde vector[pos] == 0, no deveria de devolver nada.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problema9{
  public static final int DISCERNIBLE = 0;
  public static final int DEFAULT_POS = 0;
  public static BufferedReader ENTRADA = new BufferedReader(new InputStreamReader(System.in));
  public static void main(String[] args){
    int[] numeros = {1, 4, 0, 1, 0, 3, 1, 3, 0, 2};
    int posUsuario, inicio, fin;
    
    imprimirVector(numeros);
    posUsuario = pedirPosicion((numeros.length - 1));
    if(numeros[posUsuario] == DISCERNIBLE){
      System.out.println("La posicion dada no está dentro de los parametros de una secuencia.");
    }else{
      inicio = encontrarInicio(numeros, posUsuario);
      fin = encontrarFin(numeros, posUsuario);
      System.out.println("El inicio de la secuencia es la posicion " + inicio + ", y el final es la posicion " + fin + ".");
    }
    imprimirVector(numeros);
  }

  public static int pedirPosicion(int maxPos){
    int posDevolver = -1;
    try {
      do{
        System.out.print("Ingrese un indice: ");
        posDevolver = Integer.valueOf(ENTRADA.readLine());

        return posDevolver;
      }while(posDevolver < 0 || posDevolver > maxPos);
    } catch (Exception e) {
      return DEFAULT_POS;
    }
  }

  public static int encontrarInicio(int[] vector,int posUsuario){
    int posActual = posUsuario;
    while((posActual > 0) && vector[posActual-1] != DISCERNIBLE){
      posActual--;
    }

    return posActual;
  }

  public static int encontrarFin(int[] vector,int posUsuario){
    int posActual = posUsuario;
    while((posActual < (vector.length - 1)) && vector[posActual + 1] != DISCERNIBLE){
      posActual++;
    }

    return posActual;
  }

  public static void imprimirVector(int[] vector){
    for(int pos = 0;pos<vector.length;pos++){
      System.out.print(vector[pos] + " | ");
    }
    System.out.println();
    System.out.println();
  }
}