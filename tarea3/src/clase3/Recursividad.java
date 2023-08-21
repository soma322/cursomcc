package clase3;

public class Recursividad {
	public static void main(String [] args) {
		imprimeNumero(1, 10);
		int n = factorial(5);
		System.out.println(n);
	}
	
	public static void imprimeNumero(int actual, int numMaximo) {
		if (actual > numMaximo)
			return;
		System.out.println("El numero es: " + actual);
		imprimeNumero(actual + 1, numMaximo);
	}
	
	public static int factorial(int n) {
		if (n == 0 || n == 1)
			return 1;
		return factorial(n-1) * n; 
	}
}
