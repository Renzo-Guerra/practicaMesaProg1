/*
 * Hacer un programa que dado el arreglo definido y precargado, y un número entero ingresado por el usuario, 
 * elimine las secuencias de tamaño igual al número ingresado.
 * 
 * NOTA: Para que ande, CANTIDAD debe ser el valor de la cantidad de elementos que posee el vector "numeros".
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problema13 {
  public static int CANTIDAD = 17;
  public static int DEFAULT_NUMERO = 3;
  public static int DISCERNIBLE = 0;
  public static BufferedReader ENTRADA = new BufferedReader(new InputStreamReader(System.in));
  public static void main(String[] args){
    int[] numeros = {0, 2, 3, 1, 0, 4, 1, 0, 2, 3, 0, 1, 0, 3, 0, 2, 0};
    int numeroIngresado = 0;

    imprimirVector(numeros);
    numeroIngresado = pedirNumero();
    eliminarSubsecuenciasDeXLongitud(numeros, numeroIngresado);
    imprimirVector(numeros);
  }

  public static int pedirNumero(){
    int valDevolver = 0;

    try {
      do {
        System.out.print("Ingrese un numero, este determinara la longitud de una subsecuencia a eliminar: ");    
        valDevolver = Integer.valueOf(ENTRADA.readLine());

        return valDevolver;
      } while (valDevolver < 1);
    } catch (Exception e) {
      return DEFAULT_NUMERO;
    }
  }

  public static void eliminarSubsecuenciasDeXLongitud(int[] vector, int longitud){
    int inicioSec = 0, finSec = 0, cantElementos = 0;
    boolean existeOtraSecuencia = true;

    while(existeOtraSecuencia){
      cantElementos = 0;
      inicioSec = encontrarInicioProxSec(vector, finSec);
      if(inicioSec == -1){
        existeOtraSecuencia = false;
      }else{
        finSec = encontrarFinSecActual(vector, inicioSec);
        // Calculamos la cantidad de elementos de la secuencia actual
        cantElementos = (finSec - (inicioSec - 1));
        // En caso de que la secuencia actual sea igual a la ingresada por el usuario:
        if(cantElementos == longitud){
          // Se realizan tantos corrimientos a la izquierda como por cantidad de elementos de dicha secuancia
          for(int i = 0; i<cantElementos;i++){
            realizarCorrimientoAIzquierda(vector, (finSec + 1 - i));
          }
          /*
           * Una vez realizados los corrimientos, hay que verificar que los nuevos numeros en las posiciones pasadas
           * no cumplan con la cantidad de elementos solicitados por el usuario
           */
          finSec = inicioSec;
        }else{
          // Caso contrario, se aumenta 1 a finSec, ya que "encontrarFinSecActual" necesita que "inicioSec" sea igual al DISCERNIBLE
          finSec++;
        }
      }
    }
  }

  public static void realizarCorrimientoAIzquierda(int[] vector, int posActual){
    while(posActual < CANTIDAD){
      vector[posActual - 1] = vector[posActual];
      posActual++;
    }
  }


  /*
   * Devuelve el indice del inicio de la proxima secuencia, en caso de no haber una siguiente devuelve -1.
   */
  public static int encontrarInicioProxSec(int[] vector, int posActual){
    while((posActual < CANTIDAD) && (vector[posActual] == DISCERNIBLE)){
      posActual++;
    }

    return(posActual == CANTIDAD)
      ? -1
      : posActual;
  }

  public static int encontrarFinSecActual(int[] vector, int posActual){
    while(vector[posActual] != DISCERNIBLE){
      posActual++;
    }

    return --posActual; // ESTO ES UN COMENTARIO: Yo habia puesto "return vector[--posActual]"
  }

  public static void imprimirVector(int[] vector){
    for(int i = 0; i<CANTIDAD;i++){
      System.out.print(vector[i] + " | ");
    }
    System.out.println();
    System.out.println();
  }
}
