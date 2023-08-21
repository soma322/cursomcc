package recursividad;

public class imprimirNumeros0n {

	public static void main(String[] args) {
		int numero = 10;
		imprimeNumeros(numero);

	}
	
	public static void imprimeNumeros(int numero) {
		if(numero >= 0) {
			System.out.println(numero);
			imprimeNumeros(numero-1);
			
		}
		
		
	}

}
