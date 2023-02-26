/*
 * Hacer un programa que dado el arreglo definido y precargado permita encontrar la posición de inicio 
 * y fin de la anteúltima secuencia (considerar comenzar a buscarla a partir de la última posición del arreglo).
 * 
 * NOTA: Supongo que el arreglo siempre empieza y termina con almenos 1 cero en cada extremo.
 */

public class Problema12 {
  public static final int DISCERNIBLE = 0;
  public static void main(String[] args){
    int[] numeros = {0, 1, 4, 0, 1, 0, 3, 1, 3, 0, 2, 0};
    int finUltimaSecuencia, inicioUltimaSecuencia, finAnteultimaSecuencia, inicioAnteultimaSecuencia;

    imprimirVector(numeros);
    finUltimaSecuencia = encontrarNumeroFinal(numeros, (numeros.length-1));
    inicioUltimaSecuencia = encontrarNumeroInicial(numeros, finUltimaSecuencia);
    finAnteultimaSecuencia = encontrarNumeroFinal(numeros, inicioUltimaSecuencia-1);
    inicioAnteultimaSecuencia = encontrarNumeroInicial(numeros, finAnteultimaSecuencia);

    System.out.println("El inicio de la anteultima secuencia es la posicion " + inicioAnteultimaSecuencia + ", y el final es " + finAnteultimaSecuencia + ".");
  }

  public static int encontrarNumeroFinal(int[] vector,int pos){
    while((pos >= 0) && (vector[pos] == DISCERNIBLE)){
      pos--;
    }
    // En caso de que pos < 0, quiere decir que el inicio de la secuencia es la posicion 0.
    // Es en caso de que en realidad el vector principal no empiece con 1 o mas ceros.
    return (pos < 0) ? 0 : pos;
  }

  public static int encontrarNumeroInicial(int[] vector, int pos){
    while((pos >= 0) && (vector[pos] != DISCERNIBLE)){
      pos--;
    }
    // En caso de que devuelva -1, quiere decir que no hay ninguna otra secuencia.
    return pos+1;
  }

  public static void imprimirVector(int[] vector){
    for(int i=0;i<vector.length;i++){
      System.out.print(vector[i] + " | ");  
    }
    System.out.println();
    System.out.println();
  }
}
