package basica;
import java.util.*;
public class basica {

	public static void main(String[] args) {
		int menu = 0;
		Scanner sc = new Scanner(System.in);
		String cad;
		boolean numerico = true;
		do {
			System.out.println("Programacion Basica!!");
			System.out.println("Seleccione una opcion del menu: ");
			System.out.println("1) Ejercicio 1 - Suma de numeros");
			System.out.println("2) Ejercicio 2 - Numero positivo/negatio/cero");
			System.out.println("3) Ejercicio 3 - Area de un circulo");
			System.out.println("4) Ejercicio 4 - Factorial");
			System.out.println("5) Ejercicio 5 - Peso a Dolar");
			System.out.print("Escriba un numero de la lista: ");
			cad = sc.nextLine();
			numerico = esNumerico(cad);
			if (numerico) {
				menu = Integer.parseInt(cad);
			}else {
				System.out.println("Favor de escribir solo numeros!!");
				System.out.println("");
				continue;
			}
			
			if (menu > 5 || menu < 1) {
				System.out.println("Favor de seleccionar un numero entre 1 y 5");
				System.out.println("");
				continue;
			}
			
		}while(menu > 5 || menu < 1 || !numerico);
		
		switch(menu) {
			case 1:
				System.out.println(suma());
				break;
			case 2:
				System.out.println(tipoNumero());
				break;
			case 3:
				System.out.println(areaCirculo());
				break;
			case 4:
				System.out.println(factorial());
				break;
			case 5:
				System.out.println(calcularDolares());
				break;
		}
		

	}
	
	public static Double calcularDolares() {
		Scanner sc = new Scanner(System.in);
		Double response = 0.0;
		String cad = "";
		Double valor =  0.0;
		boolean numerico = true;
		System.out.println("Calcular el peso mx a dolar ");
		do {
			System.out.print("Escriba un numero de pesos: ");
			cad = sc.nextLine();
			numerico = esDouble(cad);
			if (numerico) {
				valor = Double.parseDouble(cad);
				response = valor / 17.22;
				response = Math.round(response * 100.0) / 100.0;
				
			}else {
				System.out.println("Favor de escribir solo numeros!!");
				System.out.println("");
				continue;
			}
			
		}while(!numerico);
		return response;
	}
	public static int factorial() {
		Scanner sc = new Scanner(System.in);
		int response = 0;
		String cad = "";
		int valor = 0;
		boolean numerico = true;
		System.out.println("Calcular el factorial de un numero ");
		do {
			System.out.print("Escriba un numero entero: ");
			cad = sc.nextLine();
			numerico = esNumerico(cad);
			if (numerico) {
				valor = Integer.parseInt(cad);
				response = calcularFactorial(valor);
			}else {
				System.out.println("Favor de escribir solo numeros!!");
				System.out.println("");
				continue;
			}
			
		}while(!numerico);
		return response;
		
	}
	
	public static int calcularFactorial(int num){
        if(num == 0){
            return 1;
        }
        else
            return num * calcularFactorial(num-1);
    }
	
	
	public static double areaCirculo() {
		double area = 0;
		Scanner sc = new Scanner(System.in);
		boolean flagFloat = true;
		String cad = "";
		double valor = 0;
		
		System.out.println("Calcular el area de un circulo ");
		do {
			System.out.print("Escriba un numero: ");
			cad = sc.nextLine();
			flagFloat = esDouble(cad);
			if (flagFloat) {
				valor = Double.parseDouble(cad);
				valor = valor * valor;
				area = 3.1416 * valor;
				area = Math.round(area * 100.0) / 100.0;
			}else {
				System.out.println("Favor de escribir solo numeros!!");
				System.out.println("");
				continue;
			}
			
		}while(!flagFloat);
		
		return area;
	}
	public static String tipoNumero() {
		Scanner sc = new Scanner(System.in);
		boolean numerico = true;
		String cad = "";
		String response = "";
		int valor = 0;
		
		System.out.println("Checar si un numero es positivo, negativo o cero: ");
		do {
			System.out.print("Escriba un numero entero: ");
			cad = sc.nextLine();
			numerico = esNumerico(cad);
			if (numerico) {
				valor = Integer.parseInt(cad);
				if(valor < 0 ) {
					response = "El numero es negativo";
				}else if(valor == 0) {
					response = "El numero es cero";
				}else if(valor > 0) {
					response = "El numero es positivo";
				}
			}else {
				System.out.println("Favor de escribir solo numeros!!");
				System.out.println("");
				continue;
			}
			
		}while(!numerico);
		return response;
	}
	public static int suma() {
		Scanner sc = new Scanner(System.in);
		boolean numerico = true;
		String cad = "";
		int valor1 = 0;
		int valor2 = 0;
		System.out.println("Suma de 2 numeros enteros: ");
		do {
			System.out.print("Escriba el primer numero entero: ");
			cad = sc.nextLine();
			numerico = esNumerico(cad);
			if (numerico) {
				valor1 = Integer.parseInt(cad);
			}else {
				System.out.println("Favor de escribir solo numeros!!");
				System.out.println("");
				continue;
			}
			
		}while(!numerico);
			
		do {
			System.out.print("Escriba el segundo numero entero: ");
			cad = sc.nextLine();
			numerico = esNumerico(cad);
			if (numerico) {
				valor2 = Integer.parseInt(cad);
			}else {
				System.out.println("Favor de escribir solo numeros!!");
				System.out.println("");
				continue;
			}
		}while(!numerico);
		return (valor1 + valor2);
	}

	public static boolean esNumerico(String cad) {
		if (cad == null) {
			return false;
		}
		try {
			int numero = Integer.parseInt(cad); 
		}catch (NumberFormatException x) {
			return false;
		}
		return true;
	}
	
	public static boolean esDouble(String cad) {
		if (cad == null) {
			return false;
		}
		try {
			Double numero = Double.parseDouble(cad);
		}catch (NumberFormatException x) {
			return false;
		}
		return true;
	}

}
