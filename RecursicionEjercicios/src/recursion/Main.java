package recursion;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		boolean flagTerminar = true;
		Leer scan = new Leer();
		Recursion recu = new Recursion();
	    do {
	        System.out.println("Bienvenido ejercicios de recursividad! ");
	        System.out.println("Seleccione una opcion:");
	        System.out.println("1.- Sumar números en un arreglo (usar [ ])");
	        System.out.println("2.- Sumar elementos de una lista (usar ArrayList)");
	        System.out.println("3.- Impresión de datos de un arreglo (respetar orden)");
	        System.out.println("4.- Elevar a una potencia un numero");
	        System.out.println("5.- Convertir decimal a binario MCD");
	        System.out.println("6.- Función de Ackerman");
	        System.out.println("7.- Números de Catalán");
	        System.out.println("8.- Búsqueda binaria");
	        System.out.println("9.- Torre de hanoi");
	        System.out.println("10.-Terminar");
	        int n = scan.leerInt();
	        switch(n) {
	            case 1:
		            int[] array = {1,2,3,4,5,6,7,8,9};
		            System.out.println("La suma del arreglo es: "+recu.sumaArreglo(array, 0));
	            
	            break;
	            case 2:
	            	ArrayList<Integer> arrayListInt = new ArrayList<>();
	            	arrayListInt.add(1);
	            	arrayListInt.add(2);
	            	arrayListInt.add(3);
	            	arrayListInt.add(4);
	            	arrayListInt.add(5);
	            	arrayListInt.add(6);
	            	arrayListInt.add(7);
	            	arrayListInt.add(8);
	            	arrayListInt.add(9);
	            	System.out.println("La suma del Array List es: "+recu.sumaArregloLista(arrayListInt, 0));
			        
	            break;
	            case 3:
	            	String[] arrayString = {"manzana","pera","banana","nuez"};
	            	recu.imprimirDatos(arrayString, 0);
		        break;
	            case 4:
	            	int numero = 2;
	            	int exponente = 5;
	            	
	            	System.out.println(numero+" elevado a la "+exponente+" es:"+recu.potencia(numero, exponente));
		        break;
	            case 5:
	            	int num1 = 48;
	                int num2 = 18;
	                int mcd = recu.calcularMCD(num1, num2);
	                String binario = recu.decimalABinario(num1);
	                System.out.println("MCD de " + num1 + " y " + num2 + " es " + mcd);
	                System.out.println(num1 + " en binario es " + binario);
	            break;
	            case 6:
	            	System.out.println(recu.ackermann(1, 3));
	                
	            break;
	            case 7:
	            	long catalan = recu.calcularCatalan(5);
	                System.out.println("El número de Catalán C(" + n + ") es " + catalan);
	            break;
	            case 8:
	            	int[] arreglo = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	                int elemento = 1;
	                int resultado = recu.busquedaBinariaRecursiva(arreglo, elemento, 0, arreglo.length - 1);

	                if (resultado != -1) {
	                    System.out.println("El elemento " + elemento + " se encuentra en la posición " + resultado);
	                } else {
	                    System.out.println("El elemento " + elemento + " no se encuentra en el arreglo.");
	                }
	            break;
	            case 9:
	            	 int numDiscos = 3; // Cambia este valor para el número de discos que deseas mover.
	                 recu.torreDeHanoi(numDiscos, 'A', 'B', 'C');
	            break;
	            case 10:
	            	System.out.println("Vuelva pronto!!");
	            	flagTerminar = false;
	            break;
	            default:
					System.out.println("Favor de seleccionar una opcion valida");
				break;
				

	        }
	    } while (flagTerminar);


	}

}
