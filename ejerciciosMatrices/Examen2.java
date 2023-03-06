/*
 *  Se tiene una matriz precargada de caracteres con secuencias de caracteres minusculas en sus filas.
 *  Se pide eliminar los ultimos dos caracteres consonantes de cada secuencia.
 * 
 *  ACLARACIONES:
 *    - Las secuencias estan separadas por uno o mas espacios, tienen al menos un caracter vocal, empiezan
 *      y terminan con uno o mas espacios.
 *    - Realizar un programa completo sin métodos de carga e impresion de arreglo y matriz, ni utilizar 
 *      estructuras auxiliares.
 * 
 *  NOTA: Yo interpreto que si una secuencia es por ej: ['a', 'f', 'u'], aunque la secuencia solo tenga 1 consonante,
 *        se la va a eliminar, porque no aclara que hacer en ese caso.
 */


public class Examen2{
  public static final int CANT_FILAS = 4;
  public static final int CANT_COLUMNAS = 20;
  public static final char DISCERNIBLE = ' ';
  public static void main(String[] args){
    char[][] matriz = {{' ', ' ', 'a', 'b', 'c', ' ', 'a', 'f', 'n', 'a', 'b', 'c', 'w', 'x', ' ', 's', 's', 'd', ' ', ' '},
                       {' ', 'a', 's', ' ', ' ', 'a', 'b', 'c', 'd', ' ', ' ', 'a', 'b', 'c', ' ', 'a', 'v', ' ', 'c', ' '},
                       {' ', 'a', 'b', 'c', 'd', ' ', 'a', 'f', ' ', ' ', 'a', 'f', 'd', ' ', ' ', 'a', ' ', ' ', 'c', ' '},
                       {' ', ' ', ' ', 'e', 'f', 'k', ' ', 'a', 'b', 'c', ' ', 's', 'd', 's', ' ', 's', 'v', 'c', 'f', ' '}};
    final int CANT_CONSONANTES_ELIMINAR = 2;
    imprimirMatriz(matriz);
    eliminarUltimasXConsonantesDeCadaSecuenciaEnUnaMatriz(matriz, CANT_CONSONANTES_ELIMINAR);
    imprimirMatriz(matriz);
  } 

  public static void eliminarUltimasXConsonantesDeCadaSecuenciaEnUnaMatriz(char[][] matriz, int cantEliminar){
    for(int i = 0;i<CANT_FILAS;i++){
      eliminarUltimasXconsonantesEnCadaSecuenciaDeUnVector(matriz[i], cantEliminar);
    }
  }

  public static void eliminarUltimasXconsonantesEnCadaSecuenciaDeUnVector(char[] vector, int cantEliminar){
    int inicio = 0, fin = 0, posUltimaConsonante = 0, cantEliminadas = 0;

    while(inicio != -1){
      inicio = encontrarProximoInicio(vector, fin);
      if(inicio != -1){
        fin = encontrarFin(vector, inicio);
        posUltimaConsonante = 0;
        cantEliminadas = 0;
        while((posUltimaConsonante != -1) && (cantEliminadas < cantEliminar) && ((fin - inicio + 1) > 0)){
          posUltimaConsonante = getPosicionUltimaConsonanteEnSecuencia(vector, inicio, fin);
          if(posUltimaConsonante != -1){
            realizarCorrimientoIzquierda(vector, posUltimaConsonante);
            cantEliminadas++;
            fin--;
          }
        }
        fin++;
      }
    }
  }

  public static int getPosicionUltimaConsonanteEnSecuencia(char[] vector, int inicio, int fin){
    while(fin >= inicio){
      if(esConsonante(vector[fin])){
        return fin;
      }
      fin--;
    }

    return -1;
  }

  public static int encontrarFin(char[] vector, int pos){
    while(vector[pos] != DISCERNIBLE){
      pos++;
    }

    return --pos;
  }

  public static int encontrarProximoInicio(char[] vector, int pos){
    while((pos < CANT_COLUMNAS) && (vector[pos] == DISCERNIBLE)){
      pos++;
    }

    return(pos == CANT_COLUMNAS) ? -1 : pos;
  }

  public static void realizarCorrimientoIzquierda(char[] vector, int pos){
    while(pos < (CANT_COLUMNAS-1)){
      vector[pos] = vector[++pos];
    }
  }

  public static boolean esConsonante(char caracter){
    return (caracter != 'a' && caracter != 'e' && caracter != 'i' && caracter != 'o' && caracter != 'u');
  }

  public static void imprimirMatriz(char[][] matriz){
    for(int i = 0;i < CANT_FILAS;i++){
      imprimirVector(matriz[i]);
    }
    System.out.println();
  }

  public static void imprimirVector(char[] vector){
    for(int i = 0;i<CANT_COLUMNAS;i++){
      System.out.print(vector[i] + " | ");
    }
    System.out.println();
  }
} 