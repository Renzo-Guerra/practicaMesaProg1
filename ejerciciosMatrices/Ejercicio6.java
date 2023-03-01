import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*
 * Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra precargada, 
 * solicite al usuario un numero entero y elimine todas las ocurrencias de numero en la matriz si existe. 
 * Mientras exista (en cada iteración tiene que buscar la posición fila y columna) tendrá que usar dicha posición 
 * para realizar un corrimiento a izquierda.
 */
public class Ejercicio6 {
  public static final int CANT_FILAS = 5;
  public static final int CANT_COLUMNAS = 10;
  public static final int DEFAULT_NUM = 4;
  public static final int DISCERNIBLE = 0; // NOTA, el numero a eliminar debe ser diferente al del discernible.
  public static final BufferedReader ENTRADA = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args){
    int[][] matriz = new int[CANT_FILAS][CANT_COLUMNAS];
    int numeroAEliminar = 0;

    cargarMatrizAleatoriamente(matriz);
    imprimirMatriz(matriz);
    numeroAEliminar = pedirNumero();
    eliminarNumeroDeMatriz(matriz, numeroAEliminar);
    imprimirMatriz(matriz);
  }

  public static void eliminarNumeroDeMatriz(int[][] matriz, int numeroAEliminar){
    for(int i = 0;i<CANT_FILAS;i++){
      eliminarNumeroDeVector(matriz[i], numeroAEliminar);
    }
  }

  public static void eliminarNumeroDeVector(int[] vector, int numeroAEliminar){
    int posActual = 0;
    int corrimientosRealizados = 0;

    while((posActual < (CANT_COLUMNAS - corrimientosRealizados))){
      if(vector[posActual] == numeroAEliminar){
        realizarCorrimientoIzquierda(vector, posActual);
        corrimientosRealizados++;
        /*
          Al contar los corrimientos, ya sabemos que las x ultimas posiciones van a ser igual al DISCERNIBLE,
          y es al pedo verificar si esas ultimas posiciones son iguales al numero ingresado (CABE RECALCAR que
          el numero ingresado por el usuario NO PUEDE ser igual al DISCERNIBLE, se buguea por obvias razones).
         */
      }else{
        /* 
          Solo se incrementa la posActual cuando no hay corrimiento, ya que si se elimina el numero del indice 3,
          quiere decir que luego del corrimiento, en el indice 3 ahora se encuentra el numero que estaba en el indice 4,
          y no sabemos si dicho numero es igual o diferente al del numero a eliminar.
        */
        posActual++;
      }
    }
  }

  public static void realizarCorrimientoIzquierda(int[] vector, int posInicio){
    while(posInicio < (CANT_COLUMNAS - 1)){
      vector[posInicio] = vector[++posInicio];
    }

    if(vector[(CANT_COLUMNAS-1)] != DISCERNIBLE){
      vector[(CANT_COLUMNAS-1)] = DISCERNIBLE;
    }
  }

  public static int pedirNumero(){
    int numDevolver = 0;
    
    try{
      System.out.print("Ingrese un numero: ");
      numDevolver = Integer.valueOf(ENTRADA.readLine());

      return numDevolver;
    }catch(Exception e){
      System.out.println(e);
    
      return DEFAULT_NUM;
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
    for(int i = 0;i<CANT_FILAS;i++){
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
