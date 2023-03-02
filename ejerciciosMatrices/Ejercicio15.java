/*
 * Se tiene una matriz de caracteres de tamaño 4*20 de secuencias de caracteres letras minúsculas 
 * entre 'a' y 'z' (por cada fila), separadas por ' ' (espacios). 
 * La matriz esta precargada, y además cada fila empieza y termina con uno o más separadores ' '. 
 * 
 * Hacer un programa que dada la matriz de secuencias de caracteres definida y precargada elimine 
 * todas las secuencias que tienen orden descendente entre sus elementos.
 * 
 * Recordar que 'a' es menor que 'b' => ('a' < 'b') devuelve true, asi que debemos verificar 
 * que (vector[pos+1] <= vector[pos]).
 * 
 * NOTA: La verdad que no se que onda, me toma que las letras que son identicas ej ['s', 's', 'u']
 * esa doble 's' mas 'u' me la toma como que no esta descendente, ya prové de todo. 
 */

 public class Ejercicio15 {
  public static final int CANT_FILAS = 4;
  public static final int CANT_COLUMNAS = 20;
  public static final char DISCERNIBLE = ' ';
  public static void main(String[] args){
    // Matriz de 4 x 20
    char[][] matriz = {{' ', ' ', 'a', 'b', 'c', ' ', 'a', 'f', 'n', 'a', 'b', 'c', 'w', 'x', ' ', 's', 's', 'u', ' ', ' '},
                      {' ', 'a', 's', ' ', ' ', 'a', 'b', 'c', 'd', ' ', ' ', 'a', 'b', 'c', ' ', 'a', ' ', ' ', 'c', ' '},
                      {' ', 'a', 'b', 'c', 'd', ' ', 'a', 'f', ' ', ' ', 'a', 'f', 'd', ' ', ' ', 's', 's', ' ', 'c', ' '},
                      {' ', ' ', ' ', 'c', 'f', 'k', ' ', 'a', 'b', 'c', ' ', 's', 'd', 's', ' ', 's', ' ', 'f', 'f', ' '}};
    imprimirMatriz(matriz);
    eliminarSecuenciasDescendentes(matriz);
    imprimirMatriz(matriz);
  }

  public static void eliminarSecuenciasDescendentes(char[][] matriz){
    for(int i = 0;i<CANT_FILAS;i++){
      eliminarSecuenciasDescendentes(matriz[i]);
    }
  }

  public static void eliminarSecuenciasDescendentes(char[] vector){
    int inicio = 0, fin = 0;

    while(inicio != -1){
      inicio = encontrarInicioSecuencia(vector, fin);
      if(inicio != -1){
        fin = encontrarFinSecuencia(vector, inicio);
        if(esSecuenciaDescendente(vector, inicio, fin)){
          for(int i = 0;i<(fin - inicio + 1);i++){
            realizarCorrimientoIzquierda(vector, inicio);
          }
          fin = inicio;
        }
        fin++;
      }
    }
  }

  public static void realizarCorrimientoIzquierda(char[] vector, int pos){
    while(pos < (CANT_COLUMNAS - 1)){
      vector[pos] = vector[++pos];
    }
  }

  public static boolean esSecuenciaDescendente(char[] vector, int inicio, int fin){
    // En caso de que la secuencia sea de longitud 1.
    if(fin == inicio){return false;}

    while(inicio < fin){
      if(vector[inicio] >= vector[inicio+1]){
        return false;
      }
      inicio++;
    }

    return true;
  }

  public static int encontrarFinSecuencia(char[] vector, int pos){
    while(vector[pos] != DISCERNIBLE){
      pos++;      
    }

    return --pos;
  }

  public static int encontrarInicioSecuencia(char[] vector, int pos){
    while((pos < CANT_COLUMNAS) && (vector[pos] == DISCERNIBLE)){
      pos++;      
    }

    return (pos == CANT_COLUMNAS) ? -1 : pos;
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
