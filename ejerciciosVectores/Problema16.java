/*
 * Hacer un programa que dado el arreglo definido y precargado elimine todas 
 * las secuencias que tienen orden descendente entre sus elementos.
 */

public class Problema16 {
  public static final int CANTIDAD = 19;
  public static final int DISCERNIBLE = 0;
  public static void main(String[] args){
    int[] arregloDefinido = {0, 0, 2, 3, 4, 0, 2, 1, 0, 3, 0, 7, 6, 5, 0, 7, 6, 7, 0};

    imprimirVector(arregloDefinido);
    eliminarSubsecuenciasDescendentes(arregloDefinido);
    imprimirVector(arregloDefinido);
  }

  public static void eliminarSubsecuenciasDescendentes(int[] vector){
    boolean existeOtraSecuencia = true;
    int inicio = 0, fin = 0;

    while(existeOtraSecuencia){
      inicio = encontrarInicioSecuencia(vector, fin);
      if(inicio == -1){
        existeOtraSecuencia = false;
      }else{
        fin = encontrarFinSecuencia(vector, inicio);
        if(subsecuenciaDescendente(vector, inicio, fin)){
          for(int i = 0;i<(fin - (inicio - 1));i++){
            realizarCorrimientoALaIzquierda(vector, (fin + 1 - i));
          }
          fin = inicio;
        }else{
          fin++;
        }
      }
    }
  }

  public static void realizarCorrimientoALaIzquierda(int[] vector, int pos){
    while(pos < CANTIDAD){
      vector[pos-1] = vector[pos];
      pos++;
    }
  }

  public static boolean subsecuenciaDescendente(int[] vector, int inicio, int fin){
    if(fin == inicio){
      return false;
    }

    while(fin > inicio){
      if(vector[fin] > vector[fin-1]){
        return false;
      }
      fin--;
    }

    return true;
  }

  public static int encontrarInicioSecuencia(int[] vector, int pos){
    while((pos<CANTIDAD) && (vector[pos] == DISCERNIBLE)){
      pos++;
    }

    return (pos == CANTIDAD)? -1 : pos;
  }

  public static int encontrarFinSecuencia(int[] vector, int pos){
    while(vector[pos] != DISCERNIBLE){
      pos++;
    }

    return --pos;
  }

  public static void imprimirVector(int[] vector){
    for(int i = 0;i<CANTIDAD;i++){
      System.out.print(vector[i] + " | ");
    }
    System.out.println();
    System.out.println();
  }
}
