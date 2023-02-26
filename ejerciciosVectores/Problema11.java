/*
 * NOTA: El arreglo se trata de un arreglo de secuencias de enteros positivos 
 * separadas por uno o más ceros que empieza y termina con uno o más ceros.
 * 
 * Hacer un programa que dado el arreglo definido y precargado permita encontrar la posición 
 * de inicio de la secuencia cuya suma de valores sea mayor.
 */

import java.util.Random;

public class Problema11 {
  public static final int CANTIDAD = 13;
  public static final int DISCERNIBLE = 0;
  public static void main(String[] args){
    int[] numeros = new int[CANTIDAD];

    cargarVectorAleatoriamente(numeros);
    imprimirVector(numeros);
    encontrarMayorSecuencia(numeros);
  }

  public static void cargarVectorAleatoriamente(int[] vector){
    Random r = new Random();
    final int MIN = 1;
    final int MAX = 5;
    final int PERIODO = 4; // El periodo es "cada cuantos numeros saldra un discernible"
    // Para que el vector comiense y termine con un 0, PERIODO debe ser multiplo de (CANTIDAD - 1)
    for(int pos = 0;pos<CANTIDAD;pos++){
      vector[pos] = (pos % PERIODO == 0)
        ? DISCERNIBLE 
        :  (r.nextInt(MAX - MIN + 1) + MIN);  
    }
  }

  public static void encontrarMayorSecuencia(int[] vector){
    int posActual = 0, inicioSec = 0, finSec = 0;
    int inicioDevolver = 0, finDevolver = 0, acumGanadora = 0;

    while(posActual < CANTIDAD){
      int acum = 0;
      inicioSec = encontrarInicioSecuencia(vector, finSec);
      if(inicioSec == -1){
        posActual = CANTIDAD;
      }else{
        finSec = encontrarFinSecuencia(vector, inicioSec);
        acum = sumarSecuencia(vector, inicioSec, finSec);
        System.out.println("La suma de la actual secuencia es de: " + acum);
        
        if(acum > acumGanadora){
          acumGanadora = acum;
          inicioDevolver = inicioSec;
          finDevolver = encontrarFinSecuencia(vector, inicioSec);
        }

        finSec++;
        posActual = finSec;
      }
    }
    System.out.println("El inicio de la secuencia con mayor suma es " + inicioDevolver + ", y termina en " + finDevolver + ", con una suma de " + acumGanadora);
  }

  public static int sumarSecuencia(int[] vector, int inicio, int fin){
    int acum = 0;
    
    while(inicio <= fin){
      acum+= vector[inicio];
      inicio++;
    }

    return acum;
  }

  public static int encontrarInicioSecuencia(int[] vector, int pos){
    while((pos < CANTIDAD) && (vector[pos] == DISCERNIBLE)){
      pos++;
    }

    return (pos == CANTIDAD)? -1: pos;
  }

  public static int encontrarFinSecuencia(int[] vector, int pos){
    while(vector[pos] != DISCERNIBLE){
      pos++;
    }
    
    return --pos;
  }

  public static void imprimirVector(int[] vector){
    for(int pos = 0;pos<CANTIDAD;pos++){
      System.out.print(vector[pos] + " | ");
    }
    System.out.println();
    System.out.println();
  }
}
