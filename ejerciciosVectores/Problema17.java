/*
 * Suponer que se tienen dos arreglos A y B de secuencias (de caracteres separados por uno o más espacio) de tamaño MAX 
 * (arreglo empieza y termina con uno o más caracteres espacio). 
 * A y B que están precargadas, y además se tienen los siguientes métodos (existen y no se tienen que implementar): 
 * 
 * a) Un método que permite obtener el índice inicial de la secuencia que más se repite de un arreglo 
 * de secuencias de tamaño MAX (que empieza y termina con o más caracteres espacios). 
 * 
 * Lo llamaremos: indiceInicialSecuenciaMasRepetida(vector)
 * 
 * b) Un método que retorna el índice inicial de la secuencia que tiene más caracteres repetidos de un arreglo 
 * de secuencias (de caracteres separados por uno o más caracteres espacio) de tamaño MAX 
 * (que empieza y termina con espacio). 
 * 
 * Lo llamaremos: indiceInicialSecuenciaMasCaracteresRepetidos(vector)
 * 
 * Se pide realizar un programa completo que (sin utilizar arreglos auxiliares/extras a los mencionados): 
 * - Reemplace en A la secuencia que más se repite por la secuencia de B con más caracteres repetidos 
 * (la separación previa entre las secuencias de A debe mantenerse). 
 * 
 * En caso de utilizar uno o más de los métodos preexistentes mencionados en el enunciado definir 
 * el o los encabezados de los mismos. 
 * 
 * No se requiere hacer métodos de carga e impresión de arreglos.
 * 
 * NOTA: Como no tengo los metodos dados, no se si mi resolucion está bien (No lo puedo ejecutar)
 */
public class Problema17 {
  public static final int CANTIDAD = 16;
  public static final int DISCERNIBLE = 0; // Separador entre subsecuencias.
  public static void main(String[] args){
    char[] vector1 = new char[CANTIDAD];
    char[] vector2 = new char[CANTIDAD];

    reemplazarSecuencias(vector1, vector2);
  }

  public static void reemplazarSecuencias(char[] vector1, char[] vector2){
    // Inicios de las subsecuencias.
    int inicioSubSecVector1 = indiceInicialSecuenciaMasRepetida(vector1);
    int inicioSubSecVector2 = indiceInicialSecuenciaMasCaracteresRepetidos(vector2);

    // Longitud de ambas subsecuencias
    int longitudSubSecVector1 = (encontrarFinSubsecuencia(vector1, inicioSubSecVector1) - inicioSubSecVector1 + 1);
    int longitudSubSecVector2 = (encontrarFinSubsecuencia(vector2, inicioSubSecVector1) - inicioSubSecVector2 + 1);

    // Se define la menor y mayor longitud.
    int menorLongitud = (longitudSubSecVector1 < longitudSubSecVector2) ? longitudSubSecVector1 : longitudSubSecVector2;
    int mayorLongitud = (longitudSubSecVector1 > longitudSubSecVector2) ? longitudSubSecVector1 : longitudSubSecVector2;

    // Se intercambian los valores de los primeros n elementos de ambas subsecuencias.
    for(int i=0;i<menorLongitud;i++){
      intercambiarValores(vector1, (inicioSubSecVector1 + i), vector2, (inicioSubSecVector2 + i));
    }

    // En caso de que menor y mayor longitud no sean iguales, se procedera a hacer los corrimientos
    if(menorLongitud != mayorLongitud){
      int vuelta = 1;

      while(vuelta <= (mayorLongitud - menorLongitud)){
        if(menorLongitud == longitudSubSecVector1){  
          realizarCorrimientoALaDerecha(vector1, (inicioSubSecVector1 + menorLongitud + vuelta));
          vector1[inicioSubSecVector1 + menorLongitud + vuelta] = vector2[inicioSubSecVector2 + menorLongitud + 1];
          realizarCorrimientoALaIzquierda(vector2, (inicioSubSecVector2 + menorLongitud + 1));
        }else{
          realizarCorrimientoALaDerecha(vector2, (inicioSubSecVector2 + menorLongitud + vuelta));
          vector2[inicioSubSecVector2 + menorLongitud + vuelta] = vector1[inicioSubSecVector1 + menorLongitud + 1];
          realizarCorrimientoALaIzquierda(vector1, (inicioSubSecVector1 + menorLongitud + 1));
        }
        vuelta++;
      }
    }
  }

  public static void intercambiarValores(char[] vector1, int posVector1, char[] vector2, int posVector2){
    char aux = vector1[posVector1];
    vector1[posVector1] = vector2[posVector2];
    vector2[posVector2] = aux;
  }

  public static int encontrarFinSubsecuencia(char[] vector, int posActual){
    while(vector[posActual] != DISCERNIBLE){
      posActual++;
    }

    return --posActual;
  }

  public static void realizarCorrimientoALaIzquierda(char[] vector, int posicionInicio){
    while(posicionInicio < (CANTIDAD-1)){
      vector[posicionInicio] = vector[posicionInicio+1]; 
      posicionInicio++;
    }    
  }

  public static void realizarCorrimientoALaDerecha(char[] vector, int posicionDetenerse){
    int posActual = CANTIDAD-1;
    
    while(posActual > posicionDetenerse){
      vector[posActual] = vector[posActual-1]; 
      posActual--;
    }    
  }
}