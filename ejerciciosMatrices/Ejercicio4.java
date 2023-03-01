/*
 * Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra precargada, 
 * solicite al usuario un numero entero y una posición fila, columna. Con estos datos tendrá que realizar 
 * un corrimiento a derecha (se pierde el último valor en dicha fila) y colocar el numero en la 
 * matriz en la posición fila, columna indicada.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Ejercicio4 {
  public static final int CANT_FILAS = 5;
  public static final int CANT_COLUMNAS = 10;
  public static final BufferedReader ENTRADA = new BufferedReader(new InputStreamReader(System.in));
  public static void main(String[] args){
    int[][] matriz = new int[CANT_FILAS][CANT_COLUMNAS];
    int posFilaIngresada = 0, posColumnaIngresada = 0, numeroIngresar = 0;

    cargarMatrizAleatoriamente(matriz);
    imprimirMatriz(matriz);
    System.out.print("Ingrese un indice (fila): ");
    posFilaIngresada = pedirIndice(CANT_FILAS - 1);
    System.out.print("Ingrese un indice (columna): ");
    posColumnaIngresada = pedirIndice(CANT_COLUMNAS - 1);
    numeroIngresar = pedirNumero();
    insertarNumeroEnMatriz(matriz[posFilaIngresada], posColumnaIngresada, numeroIngresar);
    imprimirMatriz(matriz);
  }

  public static void insertarNumeroEnMatriz(int[] fila, int pos, int num){
    int posActual = CANT_COLUMNAS-1;
    while(posActual > pos){
      fila[posActual] = fila[--posActual];
    }
    fila[pos] = num; 
  }

  public static int pedirNumero(){
    int numDevolver = 0;

    try {
      System.out.print("Ingrese el nuevo numero a ingresar: ");
      numDevolver = Integer.valueOf(ENTRADA.readLine());
      
      return numDevolver;
    } catch (Exception e) {
      System.out.println(e);
      return 0;
    }
  }

  public static int pedirIndice(int maxPos){
    int devolucion = 0;

    try{
      do{
        devolucion = Integer.valueOf(ENTRADA.readLine());
        if(devolucion < 0 || devolucion > maxPos){
          System.out.println("El indice debe ser mayor o igual a 0 y menor a " +  (maxPos+1));
        }
      }while(devolucion < 0 || devolucion > maxPos);
      
      return devolucion;
    }catch(Exception e){
      System.out.println(e);
      return 0;
    }
  }

  public static void cargarMatrizAleatoriamente(int[][] matriz){
    for(int i = 0;i<CANT_FILAS;i++){
      cargarVectorAleatoriamente(matriz[i]);
    }
  }
  public static void cargarVectorAleatoriamente(int[] vector){
    Random r = new Random();
    final int MIN = 1;
    final int MAX = 9;

    for(int i = 0;i<CANT_COLUMNAS;i++){
      vector[i] = (r.nextInt(MAX - MIN + 1) + MIN);
    }
  }

  public static void imprimirMatriz(int[][] matriz){
    for(int i=0;i<CANT_FILAS;i++){
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
