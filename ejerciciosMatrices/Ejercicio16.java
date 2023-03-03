/*
 * Hay dos matrices MAT1 y MAT2 de secuencias de caracteres letras separados por espacios de tamaño MAXF x MAXC 
 * que están precargadas. 
 * Ambas matrices están precargadas y cada fila empieza y termina con caracteres espacios. 
 * Además se tiene el siguiente método:
 * 
 * * – un método (getInicioMayorCantidad()) el cual retorna el índice inicial de la secuencia de mayor tamaño de un
 *  arreglo de secuencias (de caracteres letras minúsculas separados por espacios) de tamaño MAXFIL. 
 * 
 * Se pide realizar un programa que: 
 *  – contenga la definición de los encabezados de los métodos de carga de la matriz y del método mencionado 
 *    en el enunciado (se supone que existen y no se requiere implementarlos).
 *  – para MAT1 y MAT2 elimine de cada secuencia el primer carácter vocal.
 *  – para MAT1 agregue al principio de cada secuencia el primer carácter de la secuencia de mayor 
 *    tamaño de dicha fila.
 *  – en cada fila, si se verifica que la secuencia de mayor tamaño de la fila para MAT1 es mayor que la primer 
 *    secuencia en dicha fila para MAT2, las intercambie (la que está en MAT1 pasa a MAT2 y la que esta en MAT2 
 *    pasa a MAT1) sin usar estructuras auxiliares (otros arreglos o matrices).
 *  – para un valor de fila ingresado por el usuario verifique e imprima si la primera secuencia de MAT1 en 
 *    dicha fila es igual la primera secuencia de MAT2 en dicha fila 
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ejercicio16 {
  public static final int MAXF = 4;
  public static final int MAXC = 10;
  public static final char DISCERNIBLE = ' ';
  public static final char DEFAULT_FILA = 0;
  public static final BufferedReader ENTRADA = new BufferedReader(new InputStreamReader(System.in));
  public static void main(String[] args){
    char[][] MAT1 = new char[MAXF][MAXC];
    char[][] MAT2 = new char[MAXF][MAXC];
    int filaIngresada = 0;
    boolean primerSecuenciaIgual = false;

    // cargarMatriz(MAT1);
    // cargarMatriz(MAT2);
    eliminarPrimerVocalEnCadaSecuenciaDeCadaFila(MAT1);
    eliminarPrimerVocalEnCadaSecuenciaDeCadaFila(MAT2);
    agregarAlInicioDeCadaSecuenciaDeCadaFila(MAT1);
    intercambiarMayoresSecuenciasEnCadaFila(MAT1, MAT2);
    filaIngresada = pedirFila();
    primerSecuenciaIgual = primerSecuenciaIdenticaEnXfila(MAT1[filaIngresada], MAT2[filaIngresada]);

    if(primerSecuenciaIgual){
      System.out.println("La primer secuencia en dicha fila es igual en las 2 matrices");
    }else{
      System.out.println("La primer secuencia en dicha fila NO ES igual en las 2 matrices");
    }
  }

  public static boolean primerSecuenciaIdenticaEnXfila(char[] v1, char[] v2){
    int inicioV1 = getInicioProximaSecuencia(v1, 0);
    int inicioV2 = getInicioProximaSecuencia(v2, 0);
    int finV1 = getFinSecuencia(v1, inicioV1);
    int finV2 = getFinSecuencia(v2, inicioV2);
    
    return (sonSecuenciasIguales(v1, inicioV1, finV1, v2, inicioV2, finV2));
  }

  public static boolean sonSecuenciasIguales(char[] v1, int inicioV1, int finV1, char[] v2, int inicioV2, int finV2){
    int longitudV1 = finV1 - inicioV1 + 1;
    int longitudV2 = finV2 - inicioV2 + 1;

    if(longitudV1 != longitudV2){return false;}

    for(int i =0;i < longitudV1;i++){
      if(!sonCaracteresIguales(v1[inicioV1+i], v2[inicioV2+i])){return false;}
    }

    return true;
  }

  public static boolean sonCaracteresIguales(char a, char b){
    return (a == b);
  }

  public static int pedirFila(){
    int devolver = 0;

    try {
      do {
        System.out.print("Ingrese un indice de fila: ");
        devolver = Integer.valueOf(ENTRADA.readLine());
        if((devolver < 0) || (devolver > MAXF)){
          System.out.println("El indice debe ser mayor/igual a 0 y menor/igual a " + MAXF);
        }
      } while ((devolver < 0) || (devolver > MAXF));

      return devolver;
    } catch (Exception e) {
      System.out.println(e);
      
      return DEFAULT_FILA;
    }
  }

  public static void intercambiarMayoresSecuenciasEnCadaFila(char[][] mat1, char[][] mat2){
    for(int i = 0;i<=MAXF;i++){
      intercambiarMayoresSecuencias(mat1[i], mat2[i]);
    }
  }

  public static void intercambiarMayoresSecuencias(char[] vec1, char[] vec2){
    int inicioV1 = getInicioMayorCantidad(vec1), finV1 = getFinSecuencia(vec1, inicioV1);
    int inicioV2 = getInicioMayorCantidad(vec1), finV2 = getFinSecuencia(vec2, inicioV2);
    int longitudV1 = finV1 - inicioV1 + 1;
    int longitudV2 = finV2 - inicioV2 + 1;
    
    int minLongitud = (longitudV1 < longitudV2) ? longitudV1 : longitudV2;
    
    for(int i = 0;i<minLongitud;i++){
      intercambiarCaracteres(vec1, vec2, (inicioV1 + i), (inicioV2 + i));
    }

    // En caso de que ambas secuencias no tengan la misma cantidad de indices.
    if(longitudV1 != longitudV2){
      if(minLongitud == longitudV1){
        corrimientoEntreLas2secuenciasMasGrandes(vec2, vec1, inicioV2, inicioV1, longitudV2, minLongitud);
      }else{
        corrimientoEntreLas2secuenciasMasGrandes(vec1, vec2, inicioV1, inicioV2, longitudV1, minLongitud);
      }
    }
  }

  public static void corrimientoEntreLas2secuenciasMasGrandes(char[] v1, char[] v2, int inicioV1, int inicioV2, int maxLongitud, int minLongitud){
    for(int i = 1;i<=(maxLongitud-minLongitud);i++){
      realizarCorrimientoDerecha(v1, (inicioV1 + minLongitud + i));
      v2[inicioV2 + minLongitud + i] = v1[inicioV1 + minLongitud + i];
      realizarCorrimientoIzquierda(v1, (inicioV1 + minLongitud + 1));
    }
  }

  public static void intercambiarCaracteres(char[] v1, char[] v2, int indiceV1, int indiceV2){
    char aux = 0;

    aux = v1[indiceV1];
    v2[indiceV2] = v1[indiceV1];
    v1[indiceV1] = aux;
  }

  public static void agregarAlInicioDeCadaSecuencia(char[] vector, char caracter){
    int inicio = 0, fin = 0;
    
    while(inicio != -1){
      inicio = getInicioProximaSecuencia(vector, fin);
      if(inicio != -1){
        realizarCorrimientoDerecha(vector, inicio);
        vector[inicio] = caracter;
        fin = getFinSecuencia(vector, inicio);
        fin++;
      }
    }
  }

  public static void realizarCorrimientoDerecha(char[] vector, int pos){
    int posActual = MAXC;
    while(posActual>pos){
      vector[posActual] = vector[--posActual];
    }
  }

  public static void agregarAlInicioDeCadaSecuenciaDeCadaFila(char[][] matriz){
    for(int i = 0; i<=MAXF;i++){
      agregarAlInicioDeCadaSecuencia(matriz[i], matriz[i][getInicioMayorCantidad(matriz[i])]);
    }
  }

  public static void eliminarPrimerVocalEnCadaSecuenciaDeCadaFila(char[][] matriz){
    for(int i = 0; i<=MAXF;i++){
      eliminarPrimerVocalEnCadaSecuencia(matriz[i]);
    }
  }

  public static void eliminarPrimerVocalEnCadaSecuencia(char[] vector){
    int inicio = 0, fin = 0, indicePrimerVocal = 0;
    
    while(inicio != -1){
      inicio = getInicioProximaSecuencia(vector, fin);
      if(inicio != -1){
        fin = getFinSecuencia(vector, inicio);
        indicePrimerVocal = getIndicePrimerVocal(vector, inicio, fin);
        if(indicePrimerVocal != -1){
          realizarCorrimientoIzquierda(vector, indicePrimerVocal);
        }else{
          fin++;
        }
      }
    }
  }

  public static void realizarCorrimientoIzquierda(char[] vector, int pos){
    while(pos < MAXC){
      vector[pos] = vector[++pos];
    }
  }

  public static int getFinSecuencia(char[] vector, int pos){
    while(vector[pos] != DISCERNIBLE){
      pos++;
    }

    return --pos;
  }

  public static int getInicioProximaSecuencia(char[] vector, int pos){
    while((pos <= MAXC) && (vector[pos] == DISCERNIBLE)){
      pos++;
    }

    return (pos > MAXC)? -1 : pos;
  }

  /*
   * Devuelve el indice de la primer vocal en una secuencia, en caso de que no tenga, devuelve -1.
   */
  public static int getIndicePrimerVocal(char[] vector, int inicio, int fin){
    while(inicio <= fin){
      if(esVocal(vector[inicio])){
        return inicio;
      }
      inicio++;
    }

    return -1;
  }

  public static boolean esVocal(char letra){
    return (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u');
  }
}
