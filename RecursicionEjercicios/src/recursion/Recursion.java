package recursion;

import java.util.ArrayList;

public class Recursion {
	
	public int sumaArreglo(int[] arreglo, int indice) {
        if (indice == arreglo.length - 1) {
            return arreglo[indice];
        } else {
            return arreglo[indice] + sumaArreglo(arreglo, indice + 1);
        }
	}
	
	public int sumaArregloLista(ArrayList<Integer> arreglo, int indice) {
        if (indice == arreglo.size() - 1) {
            return arreglo.get(indice);
        } else {
            return arreglo.get(indice) + sumaArregloLista(arreglo, indice + 1);
        }
	}
	
	public void imprimirDatos(String[] arreglo, int indice) {
		if (indice == arreglo.length - 1) {
			System.out.println(indice+".- "+arreglo[indice]);
            return;
        } else {
        	System.out.println(indice+".- "+arreglo[indice]);
            imprimirDatos(arreglo, indice + 1);
            return;
        }
	}
	
	public int potencia(int numero, int exponente) {
		if(exponente == 0) {
			return 1;
		}
		return numero * potencia(numero, exponente-1);
	}
	
	 public int calcularMCD(int numero1, int numero2) {
	        if (numero2 == 0) {
	            return numero1;
	        } else {
	            return calcularMCD(numero2, numero1 % numero2);
	        }
	    }

    public String decimalABinario(int numero) {
        if (numero == 0) {
            return "0";
        } else if (numero == 1) {
            return "1";
        } else {
            return decimalABinario(numero / 2) + (numero % 2);
        }
    }
    
    public int ackermann(int num1, int num2) {
        if (num1 == 0) {
          return num2 + 1;
        } else if (num2 == 0) {
          return ackermann(num1 - 1, 1);
        } else {
          return ackermann(num1 - 1, ackermann(num1, num2 - 1));
        }
    }
    
    public long calcularCatalan(int num) {
        if (num == 0) {
            return 1;
        } else {
            long resultado = 0;
            for (int i = 0; i < num; i++) {
                resultado += calcularCatalan(i) * calcularCatalan(num - i - 1);
            }
            return resultado;
        }
    }
    
    public int busquedaBinariaRecursiva(int[] arreglo, int elemento, int izquierda, int derecha) {
        if (derecha >= izquierda) {
            int medio = izquierda + (derecha - izquierda) / 2;

            if (arreglo[medio] == elemento) {
                return medio; // El elemento se encontró en la posición "medio".
            }

            if (arreglo[medio] > elemento) {
                return busquedaBinariaRecursiva(arreglo, elemento, izquierda, medio - 1);
            }

            return busquedaBinariaRecursiva(arreglo, elemento, medio + 1, derecha);
        }

        return -1; // El elemento no se encontró en el arreglo.
    }
    public void torreDeHanoi(int n, char posteOrigen, char posteAuxiliar, char posteDestino) {
        if (n == 1) {
            System.out.println("Mover disco 1 desde " + posteOrigen + " a " + posteDestino);
            return;
        }
        torreDeHanoi(n - 1, posteOrigen, posteDestino, posteAuxiliar);
        System.out.println("Mover disco " + n + " desde " + posteOrigen + " a " + posteDestino);
        torreDeHanoi(n - 1, posteAuxiliar, posteOrigen, posteDestino);
    }

	
}
