/**
 * Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra precargado, 
 * solicite al usuario un numero entero y lo agregue al principio del arreglo (posición 0). 
 * Para ello tendrá que realizar un corrimiento a derecha (se pierde el último valor del arreglo) 
 * y colocar el numero en el arreglo en la posición indicada
 */
import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problema3A {
  public static final int CANTIDAD = 10;
  public static final int POSICION_INDICADA = 0;
  public static final BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args){
    int [] numeros = new int[CANTIDAD];
    int nuevoNumero = 0;

    cargarVector(numeros);
    imprimirVector(numeros);
    nuevoNumero = pedirNumero();
    insertarNumero(numeros, nuevoNumero);
    imprimirVector(numeros);
  }

  public static void cargarVector(int[] vector){
    Random r = new Random();
    final int MIN = 1;
    final int MAX = 10;

    for(int pos = 0; pos < CANTIDAD;pos++){
      vector[pos] = (r.nextInt(MAX - MIN + 1) + MIN);
    }
  }

  public static void imprimirVector(int[] vector){
    for(int pos = 0; pos<CANTIDAD ; pos++){
      System.out.print(vector[pos] + " | ");
    }
    System.out.println("");
  }

  public static int pedirNumero(){
    int valor = 0;
    
    try {
      System.out.print("Ingrese el nuevo numero: ");
      valor = Integer.valueOf(entrada.readLine());
      if(valor < 0 || valor >= CANTIDAD){
        return 0;
      }
    } catch (Exception e) {
      return 0;
    }

    return valor;
  }

  public static void realizarCorrimientos(int[] numeros){
    int posActual = CANTIDAD - 1;
    while(posActual > POSICION_INDICADA){
      numeros[posActual] = numeros[--posActual];
    }
  }

  public static void insertarNumero(int[] numeros, int nuevoNumero){
    realizarCorrimientos(numeros);
    numeros[POSICION_INDICADA] = nuevoNumero;
  }
}
