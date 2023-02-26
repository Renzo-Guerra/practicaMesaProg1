/*
 * Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra precargado, 
 * solicite al usuario el ingreso de dos números enteros (posiciones del arreglo) 
 * y ordene de forma que el arreglo entre dos posiciones correspondientes a los números ingresados.
 */

import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problema8 {
  public static final int CANTIDAD = 10;  // Cantidad de elementos en el vector
  public static final int MIN = 1;        // Valor minimo que puede tener un numero del vector
  public static final int MAX = 10;       // Valor maximo que puede tener un numero del vector
  public static final int NUMERO_DEFAULT = 3;
  public static final BufferedReader ENTRADA = new BufferedReader(new InputStreamReader(System.in));
  public static void main(String[] args){
    int[] numeros = new int[CANTIDAD];
    int pos1, pos2;

    cargarVectorAleatoriamente(numeros);
    imprimirVector(numeros);
    pos1 = pedirPosicion(1);
    pos2 = pedirPosicion(2);
    if(pos1 != pos2){
      int menor = Math.min(pos1, pos2);
      int mayor = Math.max(pos1, pos2);
      ordenarVectorEntreParametros(numeros, menor, mayor);
    }else{
      System.out.println("Las 2 posiciones ingresadas son iguales, el vector permanece intacto");
    }
    imprimirVector(numeros);
  }

  public static void cargarVectorAleatoriamente(int[] vector){
    Random r = new Random();

    for(int pos = 0;pos<CANTIDAD;pos++){
      vector[pos] = (r.nextInt(MAX - MIN + 1) + MIN);
    }
  }

  public static void imprimirVector(int[] vector){
    for(int pos = 0;pos<CANTIDAD;pos++){
      System.out.print(vector[pos] + " | ");
    }
    System.out.println();
    System.out.println();
  }

  public static int pedirPosicion(int pos){
    int numeroDevolver;
    
    try{
      do{
        System.out.println("Ingrese la " + pos + " posicion: ");
        numeroDevolver = Integer.valueOf(ENTRADA.readLine());
        // Mientras que el valor sea menor a la posicion 0, o mayor a la ultima posicion del vector...
      }while((numeroDevolver < 0) || numeroDevolver > (CANTIDAD -1));

      return numeroDevolver;
    }catch(Exception e){
      return NUMERO_DEFAULT;
    }
  }

  /**
   * Mediante el metodo de ordenamiento por insercion, 
   * se ordenan los elemntos entre 2 parametros, dichos extremos tambien se ordenan.
   * @param vector a ordenar.
   * @param menorPos del "arreglo interno" a ordenar.
   * @param mayorPos del "arreglo interno" a ordenar.
   */
  public static void ordenarVectorEntreParametros(int[] vector, int menorPos, int mayorPos){
    for(int i = (menorPos + 1);i <= mayorPos;i++){
      int pos = i;
      int aux = vector[i];
      
      while((pos>menorPos) && (vector[pos-1] > aux)){
        vector[pos] = vector[pos-1];
        pos--;
      }
      vector[pos] = aux;
    }
  }
}
