
package lab6p1_carlosespinal;

import java.util.Scanner;
import java.util.Random;

public class Lab6P1_CarlosEspinal {

    static Scanner read = new Scanner(System.in);
    static Random random = new Random();
    
    public static void main(String[] args) {
        int opcion;
        do {
           
            System.out.println("  MENU  ");
            System.out.println();
            System.out.println("Opcion 1: Turing");
            System.out.println("Opcion 2: Kaprekar");
            System.out.println("Opcion 3: SALIDA");
            System.out.println();
            System.out.println("Ingrese la opcion: ");
            opcion = read.nextInt();
            
            
            
            switch (opcion) {
                case 1:
                    System.out.println("Se ha ingresado a la primera opcion  ");
                    System.out.println("Defina el tamaño del arreglo: ");
                    int tama = read.nextInt();
                    int [] numeros = lecturarandom(tama);
                    impresion(numeros);
                    
                    System.out.println("Parametros: ");
                    System.out.println("R: Mover puntero a la derecha");
                    System.out.println("L: Mover puntero a la izquierda");
                    System.out.println("X:Ingresar el numero en el puntero a un arreglo");
                    System.out.println();
                    System.out.print("Ingrese la cadena de parametros con la que desea trabajar: ");
                    String parametro = read.next();
                    int[] x = opcion1(parametro,numeros);
                    impresion(x);
                    System.out.println();
                    
                    break;
                case 2:
                    int numop2;
                    System.out.println("Se ha ingresado la segunda opcion");
                    System.out.println();
                    do {
                        System.out.println("Ingrese un numero de 4 digitos");
                        numop2 = read.nextInt();
                    } while (numop2 < 1000 );
                    Kaprekar(numop2);
                   

                    
                    break;
            }
            
        } while(opcion !=3);

       
        
    }
    
    public static int[] lecturarandom(int size) {
        int [] lec = new int[size];
        
        for (int i = 0; i < lec.length; i++) {
            lec[i] = 1 + random.nextInt(10);
        }
        return lec;
    }
    
    public static void impresion (int[] array) {
        
        for (int i = 0; i < array.length; i++) {
            System.out.print("["+array[i]+"]");
        }

    }
    public static int[] opcion1(String parametros, int[] array1) {
        int tamfin = 0;

        for (int i = 0; i < parametros.length(); i++) {
            char letras = parametros.charAt(i);
            if (letras == 'x' || letras == 'X') {
                tamfin += 1; 
            }
        }
        int[] fin = new int [tamfin];
        int l = 0;
        int posicion = 0;
            for (int j = 0; j < parametros.length(); j++) {
                
                char para = parametros.charAt(j);
                if (para == 'r' || para == 'R') {
                    posicion += 1;
                }
                if (para == 'l' || para == 'L') {
                    posicion -= 1;
                }
                    
                if (para == 'x' || para == 'X') {
                    fin[l] = array1[posicion];
                    l++;
                }
                
            }//fin for para parametros
        
        return fin;
    }//fin metodo opcion1
    public static int[] EnteroToArray(int entero) {
        int[] conversion = new int[4];
        int cont = 3;
        
        for (int i = 0; i < 4; i++) {
            int residuo = entero % 10;
            conversion[cont] = residuo;
            entero /= 10; 
            cont--;
        }

     return conversion;
    }
    public static int ArrayToEntero(int[] array) {
        int conversionn = 0;
        for (int i = 0; i < array.length; i++) {
            conversionn = conversionn * 10 + array[i];
        }
        
        
        return conversionn;
    }
    
    public static int[] Ascendiente(int[] arraydes) {
        for (int i = 0; i < arraydes.length; i++) {
            for (int j = i; j < arraydes.length; j++) {
                if (arraydes[j] < arraydes[i]) {
                    int t = arraydes[i];
                    arraydes[i] = arraydes[j];
                    arraydes[j] = t;
                }

            }

        }
        return arraydes;
        /*
        En este metodo se analiza todo el array
        Si la posicion en la que esta ya esta correcta
        No lo cambia y pasa al otro ciclo para seguir analizandolo
        en el caso de el valor que esta en la posicion j sea menor que el que esta en la posicion i
        El valor de i es reemplazado por el de j, y j, pasa a ser almacenado a un int acumulador
        Este proceso se repite hasta que 
        */
    }
    
    public static int[] Descendiente(int[] arraydes) {
        for (int i = 0; i < arraydes.length; i++) {
            for (int j = i; j < arraydes.length; j++) {
                if (arraydes[i] < arraydes[j]) {
                    int t = arraydes[i];
                    arraydes[i] = arraydes[j];
                    arraydes[j] = t;
                }

            }

        }
        return arraydes; 
        /*
        La misma logica se utiliza en este metodo 
        La diferencia, si el valor de i es menor al de j
        Hara el proceso en base a esto.
        */
    }
   
    public static void Kaprekar(int numero) {
        int cont = 0;
        for (int i = numero; i != 6174 && cont <= 7; cont++) {
            int[] arreglo = EnteroToArray(i);
            int[] descend = Descendiente(arreglo);
            int nd = ArrayToEntero(descend);
            int[] ascend = Ascendiente(arreglo);
            int na = ArrayToEntero(ascend);
            int pr = nd - na;
            System.out.println(nd+" - "+na+" = "+ pr);
            i = pr;
            cont++;
            
        }
        
        
    }

    
    
}
