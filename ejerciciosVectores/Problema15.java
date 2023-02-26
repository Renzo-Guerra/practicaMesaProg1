/**
 * Hacer un programa que dado el arreglo definido y precargado elimine del arreglo 
 * todas las ocurrencias de una secuencia patrón dada por otro arreglo de iguales características 
 * (solo tiene esa secuencia). Al eliminar se pierden los valores haciendo los corrimientos.
 */
public class Problema15 {
  public static final int CANTIDAD = 16;  // CANTIDAD debe coincidir con la cantidad de elementos en "arregloPrecargado[]"
  public static final int CANTIDAD_SECUENCIA = 3; // CANTIDAD_SECUENCIA debe coincidir con la cantidad de elementos en "secuencia[]"
  public static final int DISCERNIBLE = 0; // Separador entre secuencias en "arregloPrecargado[]"
  public static void main(String[] args){
    int[] arregloPrecargado = {0, 2, 3, 4, 0, 0, 2, 3, 0, 2, 3, 4, 0, 2, 3, 0};
    int[] secuencia = {2, 3, 4};

    imprimirVector(arregloPrecargado);
    eliminarSubsecuencias(arregloPrecargado, secuencia);
    imprimirVector(arregloPrecargado);
  }

  public static void eliminarSubsecuencias(int[] vector, int[] secuencia){
    boolean existeOtraSecuencia = true;
    int inicioSub = 0, finalSub = 0;

    while(existeOtraSecuencia){
      inicioSub = encontrarInicioSecuencia(vector, finalSub);
      if(inicioSub == -1){
        System.out.println("termino");
        existeOtraSecuencia = false;
      }else{
        finalSub = encontrarFinalSecuencia(vector, inicioSub);
        if(subsecuenciaIdentica(vector, inicioSub, finalSub, secuencia)){
          for(int i = 0;i< (finalSub - (inicioSub - 1));i++){
            realizarCorrimientoALaIzquierda(vector, (finalSub + 1 - i));
          }
          finalSub = inicioSub;
        }else{
          finalSub++;
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

  public static boolean subsecuenciaIdentica(int[] vector, int inicioSub, int finalSub, int[] secuencia){
    if(finalSub - (inicioSub - 1) != CANTIDAD_SECUENCIA){
      // Primero se valida que tanto la subsecuencia como la secuencia dada tengan la misma cantidad de elementos.
      return false;
    }else{
      for(int pos = 0;pos<CANTIDAD_SECUENCIA;pos++){
        // Se verifica que cada posicion sea identica.
        if(vector[inicioSub + pos] != secuencia[pos]){
          return false;
        }
      }
    }

    // Si se llego hasta aca, es porque son identicas
    return true;
  }

  public static int encontrarInicioSecuencia(int[] vector, int pos){
    while(pos < CANTIDAD && vector[pos] == DISCERNIBLE){
      pos++;
    }

    return (pos == CANTIDAD)? -1 : pos;
  }

  public static int encontrarFinalSecuencia(int[] vector, int pos){
    while(vector[pos] != DISCERNIBLE){
      pos++;
    }

    return --pos;
  }

  public static void imprimirVector(int[] vector){
    for(int i=0; i<CANTIDAD;i++){
      System.out.print(vector[i] + " | ");
    }
    System.out.println();
    System.out.println();
  }
}
