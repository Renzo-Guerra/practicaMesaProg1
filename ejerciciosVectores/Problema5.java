/**
 * Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra precargado, 
 * solicite al usuario un numero entero y elimine todas las ocurrencia de numero en el arreglo si existe. 
 * Mientras exista (en cada iteración tiene que buscar la posición dentro del arreglo) 
 * tendrá que usar la posición para realizar un corrimiento a izquierda (quedarán tantas copias de la última 
 * posición del arreglo como cantidad de ocurrencias del número).
 * 
 * El programa anda (A menos que el numero a eliminar sea el ultimo numero del arreglo)
 */

 import java.util.Random;
 import java.io.BufferedReader;
 import java.io.InputStreamReader;

public class Problema5 {
  public static final int CANTIDAD = 10;
  public static final int DEFAULT_NUM = 3;
  public static final BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
  public static void main(String args[]){
    int[] numeros = new int[CANTIDAD];
    int indeseado = 0;

    cargarVector(numeros);
    imprimirVector(numeros);
    indeseado = pedirNumero();
    eliminarOcurrencias(numeros, indeseado);
    imprimirVector(numeros);
  }

  public static void cargarVector(int[] vector){
    Random r = new Random();
    final int MIN = 1;
    final int MAX = 10;

    for(int pos = 0; pos < CANTIDAD; pos++){
      vector[pos] = (r.nextInt(MAX - MIN + 1) + MIN);
    }
  }

  public static void imprimirVector(int[] vector){
    for(int pos = 0; pos < CANTIDAD; pos++){
      System.out.print(vector[pos] + " | ");
    }
    System.out.println("");
  }

  public static int pedirNumero(){
    int aux = 0;
    try{
      System.out.print("Ingrese el numero a eliminar todas las ocurrencias: ");
      aux = Integer.valueOf(entrada.readLine());
    }catch(Exception e){
      return DEFAULT_NUM;
    }

    return aux;
  }

  public static void eliminarOcurrencias(int[] vector, int indeseado){
    int posActual = 0;

    while(posActual < CANTIDAD){
      if(vector[posActual] == indeseado){
        realizarCorrimiento(vector, posActual);
      }else{
        posActual++;
      }
    }
  }

  public static void realizarCorrimiento(int[] vector, int posActual){
    while(posActual < (CANTIDAD-1)){
      System.out.println("El error");
      vector[posActual] = vector[posActual+1];
      posActual++;
      System.out.println("El valor de posActual es: " + posActual);
    }
  }
}
